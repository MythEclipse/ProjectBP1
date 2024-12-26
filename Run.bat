@echo off
REM Build and run ProjectBP1

REM Navigate to project directory
cd /d C:\ProjectBP1

REM Clean and package the project using Maven
mvn clean package

REM Check if the build was successful
IF %ERRORLEVEL% NEQ 0 (
    echo Build failed. Exiting...
    exit /b %ERRORLEVEL%
)

REM Run the packaged JAR file
java -jar target\ProjectBP1-1.0-SNAPSHOT.jar