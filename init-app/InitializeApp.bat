@echo off
title App InfoFlow

:: VARIABLES DE EJECUCION
set CURRENT_DIR=%cd%
set JAVA_VERSION=21
set JAVA_FOLDER=jdk-%JAVA_VERSION%
set JAVA_ZIP=amazon-corretto-%JAVA_VERSION%-x64-windows-jdk.zip

set DIR_LOG=%CURRENT_DIR%\logs
set DIR_BACKEND=%CURRENT_DIR%\..\backend
set DIR_FRONTEND=%CURRENT_DIR%\..\frontend\front-app

set DIR_CONFIG-SERVER=%DIR_BACKEND%\config-server
set DIR_DISCOVERY-SERVER=%DIR_BACKEND%\discovery-server
set DIR_API-GATEWAY=%DIR_BACKEND%\api-gateway
set DIR_AUTH-SERVICE=%DIR_BACKEND%\auth-service
set DIR_PUBLIC-SERVICE=%DIR_BACKEND%\public-service
set DIR_STORE-SERVICE=%DIR_BACKEND%\store-service
:: FIN VARIABLES DE EJECUCION

echo =================================
echo    INICIO AMBIENTACION PROCESO
echo =================================

for /f "tokens=2 delims=:" %%a in ('ipconfig ^| find "IPv4"') do set IP_ADDRESS=%%a

if exist %DIR_LOG% ( rmdir /s /q "%DIR_LOG%" )
mkdir %DIR_LOG%

::------------------------ DESCARGAR JAVA ------------------------::

if not exist %CURRENT_DIR%\%JAVA_FOLDER% (
	curl -LO https://corretto.aws/downloads/latest/amazon-corretto-%JAVA_VERSION%-x64-windows-jdk.zip
	tar -xf %JAVA_ZIP%
	for /D %%I in (jdk*) do move "%%I" %JAVA_FOLDER%
)
set JAVA_HOME=%CURRENT_DIR%\%JAVA_FOLDER%
set PATH=%JAVA_HOME%\bin;%PATH%

::------------------------ COMPILAR PROYECTOS Y CREACION CONTAINER ------------------------::

docker network create infoflow_network

::----- BASE DE DATOS -----::
echo Configurando e instalando contenedor docker para MySQL
docker run --name infoflow_db --network=infoflow_network -e MYSQL_ROOT_PASSWORD=5Ak9l.ot_si2 -v %CURRENT_DIR%\init.sql:/docker-entrypoint-initdb.d/init.sql -p 3308:3306 -d mysql:latest

::----- CONFIG SERVER-----::
echo COMPILANDO config-server...
cd %DIR_CONFIG-SERVER%
start /B gradlew.bat bootRun > %DIR_LOG%\config-server-log.txt 2>&1

echo Por favor espere 5 segundos...
timeout /t 5 /nobreak > NUL

::----- DISCOVERY SERVER-----::
echo COMPILANDO discovery-server...
cd %DIR_DISCOVERY-SERVER%
start /B gradlew.bat bootRun > %DIR_LOG%\discovery-server-log.txt 2>&1

echo Por favor espere 5 segundos...
timeout /t 5 /nobreak > NUL

::----- API GATEWAY-----::
echo COMPILANDO api-gateway...
cd %DIR_API-GATEWAY%
start /B gradlew.bat bootRun > %DIR_LOG%\api-gateway-log.txt 2>&1

::----- AUTH SERVICE-----::
echo COMPILANDO auth-service...
cd %DIR_AUTH-SERVICE%
start /B gradlew.bat bootRun > %DIR_LOG%\auth-service-log.txt 2>&1

::----- PUBLIC SERVICE-----::
echo COMPILANDO public-service...
cd %DIR_PUBLIC-SERVICE%
start /B gradlew.bat bootRun > %DIR_LOG%\public-service-log.txt 2>&1

::----- STORE SERVICE-----::
echo COMPILANDO store-service...
cd %DIR_STORE-SERVICE%
start /B gradlew.bat bootRun > %DIR_LOG%\store-service-log.txt 2>&1

::----- APP FRONTEND -----::
cd %DIR_FRONTEND%
echo Configurando e instalando contenedor docker para frontend application
docker build --no-cache -t angular-infoflow .
docker run --name infoflow_frontend --network=infoflow_network -p 4200:4200 -d angular-infoflow

echo =================================
echo     FIN AMBIENTACION PROCESO
echo =================================
timeout /t 3 /nobreak > NUL

echo -
echo -
echo -
echo -
echo =================================
echo  IMPORTANTE NO CERRAR LA CONSOLA
echo =================================
echo -
echo Por favor ingrese a la URI
echo http://localhost:4200
echo -
echo Una vez finalizada la evaluacion, presione varias veces la tecla enter para cerrar los procesos
echo -
pause

echo Cerrando procesos java...
taskkill /F /IM java.exe /T

echo -
echo Eliminando contenedores de Docker...
docker rm -f infoflow_db
docker rm -f infoflow_frontend
docker rmi angular-infoflow

echo -
echo Eliminacion de procesos finalizado
echo Gracias por utilizar nuestro software 
echo Atte Quatrosphere
timeout /t 5 /nobreak > NUL