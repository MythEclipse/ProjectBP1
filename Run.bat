@echo off

REM Run the JRE installer
call JREInstaller.bat

REM Set the path to the extracted JRE
set "JRE_PATH=.\PortableJRE\jdk-17.0.13+11-jre"

REM Run the packaged JAR file using the specified JRE
"%JRE_PATH%\bin\java" -jar ".\ProjectBP1\target\ProjectBP1-1.0-SNAPSHOT.jar"
