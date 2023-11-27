@echo off
title Obtener IP de Contenedor

set CONTAINER_NAME=%1
set OUTPUT_FILE=%2

:: Obtener el ID del contenedor
set CONTAINER_ID=
for /f "tokens=*" %%i in ('docker inspect --format "{{.Id}}" %CONTAINER_NAME%') do set CONTAINER_ID=%%i

:: Obtener la dirección IP del contenedor usando PowerShell
for /f "tokens=*" %%i in ('powershell -Command "(docker inspect --format '{{range .NetworkSettings.Networks}}{{.IPAddress}}{{end}}' %CONTAINER_ID%)"') do set CONTAINER_IP=%%i

echo %CONTAINER_IP% > %OUTPUT_FILE%