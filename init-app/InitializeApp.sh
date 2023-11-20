#!/bin/bash

# VARIABLES DE EJECUCION
	CURRENT_DIR=$(pwd)
	JAVA_VERSION=21 
	GRADLE_VERSION=8.4
# FIN VARIABLES DE EJECUCION

# Descargar y configurar Java
curl -LO https://corretto.aws/downloads/latest/amazon-corretto-${JAVA_VERSION}-x64-windows-jdk.zip
unzip -q amazon-corretto-${JAVA_VERSION}-x64-windows-jdk.zip
export JAVA_HOME=${CURRENT_DIR}/amazon-corretto-${JAVA_VERSION}-x64-windows-jdk
export PATH=${JAVA_HOME}/bin:${PATH}

# Descargar y configurar Gradle
curl -LO https://services.gradle.org/distributions/gradle-${GRADLE_VERSION}-bin.zip
unzip -q -d gradle gradle-${GRADLE_VERSION}-bin.zip
export GRADLE_HOME=${CURRENT_DIR}/gradle/gradle-${GRADLE_VERSION}
export PATH=${GRADLE_HOME}/bin:${PATH}

# Configurar las variables de entorno para MySQL
docker run --name infoflow_db -e MYSQL_ROOT_PASSWORD=5Ak9l.ot_si2 -v ${CURRENT_DIR}/init.sql:/docker-entrypoint-initdb.d/init.sql -p 3308:3306 -d mysql:latest