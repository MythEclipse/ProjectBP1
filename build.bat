@echo off
REM Build script for Maven project on Windows

REM Run Maven clean and install dependencies
echo Running Maven clean install...
call mvn clean install -DskipTests --file ProjectBP1/pom.xml
echo Maven clean install completed with ERRORLEVEL: %ERRORLEVEL%

REM Check if the clean and install was successful
if %ERRORLEVEL% neq 0 (
    echo Clean and install failed!
    exit /b %ERRORLEVEL%
)

REM Build the project with JDK 8
echo Running Maven package...
call mvn -B package -DskipTests --file ProjectBP1/pom.xml
echo Maven package completed with ERRORLEVEL: %ERRORLEVEL%

REM Check if the build was successful
if %ERRORLEVEL% neq 0 (
    echo Package failed!
    exit /b %ERRORLEVEL%
)

echo Build succeeded! Proceeding with post-build steps...

REM Ensure a brief delay before proceeding
timeout /t 2 >nul

REM Remove the existing JAR file if it exists
if exist ProjectBP1-1.0-SNAPSHOT.jar (
    echo Deleting existing JAR file...
    del ProjectBP1-1.0-SNAPSHOT.jar
)

REM Copy the packaged JAR file to the current directory
if exist ProjectBP1\target\ProjectBP1-1.0-SNAPSHOT.jar (
    echo Copying JAR file to the current directory...
    copy ProjectBP1\target\ProjectBP1-1.0-SNAPSHOT.jar ProjectBP1-1.0-SNAPSHOT.jar
    echo Copy succeeded!
) else (
    echo Packaged JAR file not found! Exiting script.
    exit /b 1
)
echo Script completed successfully!
call Run.bat
