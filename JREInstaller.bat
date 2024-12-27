@echo off
setlocal

:: Define variables
set "JRE_INSTALLER=OpenJDK17U-jre_x64_windows_hotspot_17.0.13_11.zip"
if not exist "%JRE_INSTALLER%" (
    echo File %JRE_INSTALLER% tidak ditemukan, mendownload...
    powershell -Command "Invoke-WebRequest -Uri 'https://raw.githubusercontent.com/MythEclipse/ProjectBP1/refs/heads/main/OpenJDK17U-jre_x64_windows_hotspot_17.0.13_11.zip' -OutFile '%JRE_INSTALLER%'"
    if %errorlevel% neq 0 (
        echo Gagal mendownload JRE.
        goto :END
    )
)
set "JRE_EXTRACT_PATH=PortableJRE"

:: Check if PortableJRE already exists
if exist "%JRE_EXTRACT_PATH%" (
    echo Directory %JRE_EXTRACT_PATH% already exists.
    goto :END
)

:: Ekstrak JRE
echo Mengekstrak JRE...
echo Checking if the JRE installer file exists at: %JRE_INSTALLER%
if not exist "%JRE_INSTALLER%" (
    echo File %JRE_INSTALLER% tidak ditemukan.
    goto :END
)

powershell -Command "Expand-Archive -Path '%JRE_INSTALLER%' -DestinationPath '%JRE_EXTRACT_PATH%' -Force"
if %errorlevel% neq 0 (
    echo Gagal mengekstrak JRE.
    goto :END
)

echo Java JRE telah berhasil diekstrak.
:END
endlocal