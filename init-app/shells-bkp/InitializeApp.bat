@echo off
title Instalacion App InfoFlow

:: VARIABLES DE EJECUCION
set CURRENT_DIR=%cd%
set JAVA_VERSION=21
set JAVA_FOLDER=jdk-%JAVA_VERSION%
set JAVA_ZIP=amazon-corretto-%JAVA_VERSION%-x64-windows-jdk.zip

set IP_CONTAINER_FILE=container_ip.txt

set DIR_BACKEND=%CURRENT_DIR%\..\backend
set DIR_FRONTEND=%CURRENT_DIR%\..\frontend\front-app

set DIR_CONFIG-SERVER=%DIR_BACKEND%\config-server
set DIR_DISCOVERY-SERVER=%DIR_BACKEND%\discovery-server
set DIR_API-GATEWAY=%DIR_BACKEND%\api-gateway
set DIR_AUTH-SERVICE=%DIR_BACKEND%\auth-service
set DIR_PUBLIC-SERVICE=%DIR_BACKEND%\public-service
set DIR_STORE-SERVICE=%DIR_BACKEND%\store-service
:: FIN VARIABLES DE EJECUCION

::------------------------ DESCARGAR JAVA ------------------------::

:: Descargar y configurar Java
if not exist %CURRENT_DIR%\%JAVA_FOLDER% (
	curl -LO https://corretto.aws/downloads/latest/amazon-corretto-%JAVA_VERSION%-x64-windows-jdk.zip
	tar -xf %JAVA_ZIP%
	for /D %%I in (jdk*) do move "%%I" %JAVA_FOLDER%
)
set JAVA_HOME=%CURRENT_DIR%\%JAVA_FOLDER%
set PATH=%JAVA_HOME%\bin;%PATH%

docker network create infoflow_network

echo Configurando e instalando contenedor docker para MySQL
docker run --name infoflow_db --network=infoflow_network -e MYSQL_ROOT_PASSWORD=5Ak9l.ot_si2 -v %CURRENT_DIR%\init.sql:/docker-entrypoint-initdb.d/init.sql -p 3308:3306 -d mysql:latest

cd %CURRENT_DIR%
call .\FindIPContainer.bat infoflow_db %IP_CONTAINER_FILE%
set /p IP_DATABASE=<%IP_CONTAINER_FILE%

::------------------------ COMPILAR PROYECTOS Y CREACION CONTAINER ------------------------::

::----- CONFIG SERVER-----::
echo COMPILANDO config-server...
cd %DIR_CONFIG-SERVER%
call .\gradlew.bat clean build

echo Configurando e instalando contenedor docker para microservicio config-server
docker run --name infoflow_configserver --network=infoflow_network -p 8888:8888 -v %DIR_CONFIG-SERVER%\build\libs:/app -d openjdk:21-jdk java -jar /app/config-server-0.0.1.jar

cd %CURRENT_DIR%
call .\FindIPContainer.bat infoflow_configserver %IP_CONTAINER_FILE%
set /p IP_CONFIG_SERVER=<%IP_CONTAINER_FILE%

echo Por favor espere 5 segundos...
timeout /t 5 /nobreak > NUL

::----- DISCOVERY SERVER-----::
echo COMPILANDO discovery-server...
cd %DIR_DISCOVERY-SERVER%
call .\gradlew.bat clean build

echo Configurando e instalando contenedor docker para microservicio discovery-server
docker run --name infoflow_discoveryserver --network=infoflow_network -p 8083:8083 -v %DIR_DISCOVERY-SERVER%\build\libs:/app -e IP_CONFIG_SERVER=%IP_CONFIG_SERVER% -d openjdk:21-jdk java -jar /app/discovery-server-0.0.1.jar

cd %CURRENT_DIR%
call .\FindIPContainer.bat infoflow_discoveryserver %IP_CONTAINER_FILE%
set /p IP_DISCOVERY_SERVER=<%IP_CONTAINER_FILE%

echo Por favor espere 5 segundos...
timeout /t 5 /nobreak > NUL

::----- AUTH SERVICE-----::
echo COMPILANDO auth-service...
cd %DIR_AUTH-SERVICE%
call .\gradlew.bat clean build

echo Configurando e instalando contenedor docker para microservicio auth-service
docker run --name infoflow_authservice --network=infoflow_network -p 8098:8098 -v %DIR_AUTH-SERVICE%\build\libs:/app -e IP_CONFIG_SERVER=%IP_CONFIG_SERVER% -e IP_DATABASE=%IP_DATABASE% -e IP_DISCOVERY_SERVER=%IP_DISCOVERY_SERVER% -d openjdk:21-jdk java -jar /app/auth-service-0.0.1.jar

cd %CURRENT_DIR%
call .\FindIPContainer.bat infoflow_authservice %IP_CONTAINER_FILE%
set /p IP_AUTH_SERVICE=<%IP_CONTAINER_FILE%

::----- PUBLIC SERVICE-----::
echo COMPILANDO public-service...
cd %DIR_PUBLIC-SERVICE%
call .\gradlew.bat clean build

echo Configurando e instalando contenedor docker para microservicio public-service
docker run --name infoflow_publicservice --network=infoflow_network -p 8094:8094 -v %DIR_PUBLIC-SERVICE%\build\libs:/app -d openjdk:21-jdk java -jar /app/public-service-0.0.1.jar

cd %CURRENT_DIR%
call .\FindIPContainer.bat infoflow_publicservice %IP_CONTAINER_FILE%
set /p IP_PUBLIC_SERVICE=<%IP_CONTAINER_FILE%

::----- STORE SERVICE-----::
echo COMPILANDO store-service...
cd %DIR_STORE-SERVICE%
call .\gradlew.bat clean build

echo Configurando e instalando contenedor docker para microservicio store-service
docker run --name infoflow_storeservice --network=infoflow_network -p 8090:8090 -v %DIR_STORE-SERVICE%\build\libs:/app -d openjdk:21-jdk java -jar /app/store-service-0.0.1.jar

cd %CURRENT_DIR%
call .\FindIPContainer.bat infoflow_storeservice %IP_CONTAINER_FILE%
set /p IP_STORE_SERVICE=<%IP_CONTAINER_FILE%

::----- APP FRONTEND -----::
echo Configurando e instalando contenedor docker para frontend application
docker run --name infoflow_frontend --network=infoflow_network -p 4200:4200 -v %DIR_FRONTEND%\dist\front-app:/usr/share/nginx/html:ro -d nginx

cd %CURRENT_DIR%
call .\FindIPContainer.bat infoflow_frontend %IP_CONTAINER_FILE%
set /p IP_APP_FRONT=<%IP_CONTAINER_FILE%

::----- API GATEWAY-----::
echo COMPILANDO api-gateway...
cd %DIR_API-GATEWAY%
call .\gradlew.bat clean build

echo Configurando e instalando contenedor docker para microservicio api-gateway
docker run --name infoflow_apigateway --network=infoflow_network -p 8080:8080 -v %DIR_API-GATEWAY%\build\libs:/app -d openjdk:21-jdk java -jar /app/api-gateway-0.0.1.jar

cls
echo FIN AMBIENTACION PROCESO
echo Por favor ingrese a la URI
echo http://localhost:4200
pause