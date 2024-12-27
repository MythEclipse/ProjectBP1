@echo off

REM Check if JREInstaller.bat exists
if not exist "JREInstaller.bat" (
    echo JREInstaller.bat not found, downloading...
    powershell -Command "Invoke-WebRequest -Uri https://raw.githubusercontent.com/MythEclipse/ProjectBP1/refs/heads/main/JREInstaller.bat -OutFile JREInstaller.bat"
)

REM Run the JRE installer
call JREInstaller.bat

REM Set the path to the extracted JRE
set "JRE_PATH=.\PortableJRE\jdk-17.0.13+11-jre"

REM Check if ProjectBP1-1.0-SNAPSHOT.jar exists
if not exist "ProjectBP1-1.0-SNAPSHOT.jar" (
    echo ProjectBP1-1.0-SNAPSHOT.jar not found, downloading...
    powershell -Command "Invoke-WebRequest -Uri https://raw.githubusercontent.com/MythEclipse/ProjectBP1/refs/heads/main/ProjectBP1-1.0-SNAPSHOT.jar -OutFile ProjectBP1-1.0-SNAPSHOT.jar"
)

REM Run the packaged JAR file using the specified JRE
"%JRE_PATH%\bin\java" -jar ".\ProjectBP1-1.0-SNAPSHOT.jar"
