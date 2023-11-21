@echo off
title Instalacion Aplicacion InfoFlow

:: VARIABLES DE EJECUCION
set CURRENT_DIR=%cd%
set JAVA_VERSION=21
set GRADLE_VERSION=8.4
:: FIN VARIABLES DE EJECUCION

:: Descargar y configurar Java
curl -LO https://corretto.aws/downloads/latest/amazon-corretto-%JAVA_VERSION%-x64-windows-jdk.zip
tar -xf amazon-corretto-%JAVA_VERSION%-x64-windows-jdk.zip
for /D %%I in (jdk*) do move "%%I" jdk-%JAVA_VERSION%
set JAVA_HOME=%CURRENT_DIR%\jdk-%JAVA_VERSION%
set PATH=%JAVA_HOME%\bin;%PATH%

:: Descargar y configurar Gradle
curl -LO https://services.gradle.org/distributions/gradle-%GRADLE_VERSION%-bin.zip
tar -xf gradle-%GRADLE_VERSION%-bin.zip
set GRADLE_HOME=%CURRENT_DIR%\gradle-%GRADLE_VERSION%
set PATH=%GRADLE_HOME%\bin;%PATH%

:: Configurar e instalar contenedor docker para MySQL
docker run --name infoflow_db -e MYSQL_ROOT_PASSWORD=5Ak9l.ot_si2 -v %CURRENT_DIR%\init.sql:/docker-entrypoint-initdb.d/init.sql -p 3308:3306 -d mysql:latest

pause