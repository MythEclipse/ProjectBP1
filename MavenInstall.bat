@echo off
:: Cek apakah memiliki hak administrator
net session >nul 2>&1
if %errorlevel% neq 0 (
    echo Script ini memerlukan hak administrator.
    echo Meminta hak administrator...
    powershell -Command "Start-Process '%~f0' -Verb RunAs"
    exit /b
)

:: Periksa apakah Java sudah terpasang
java -version >nul 2>&1
if %errorlevel% neq 0 (
    echo Java JDK tidak ditemukan. Menginstal Java JDK...
    call JDKInstaller.bat
    if %errorlevel% neq 0 (
        echo Gagal menginstal Java JDK.
        goto :END
    )
    :: Periksa kembali apakah Java sudah terpasang
    java -version >nul 2>&1
    if %errorlevel% neq 0 (
        echo Java JDK masih tidak ditemukan setelah instalasi.
        goto :END
    ) else (
        echo Java JDK berhasil diinstal. Menjalankan ulang script...
        powershell -Command "Start-Process '%~f0' -Verb RunAs"
        exit /b
    )
) else (
    echo Java JDK ditemukan.
)

:: URL download Maven
set "MAVEN_URL=https://downloads.apache.org/maven/maven-3/3.8.6/binaries/apache-maven-3.8.6-bin.zip"

:: Nama file installer
set "MAVEN_INSTALLER=apache-maven-3.8.6-bin.zip"

:: Path sementara untuk menyimpan installer
set "TEMP_PATH=%TEMP%\%MAVEN_INSTALLER%"
set "MAVEN_DIR=%ProgramFiles%\apache-maven-3.8.6"

:: Periksa apakah Maven sudah terpasang
mvn -version >nul 2>&1
if %errorlevel% equ 0 (
    echo Apache Maven sudah terinstal.
    goto :END
) else (
    echo Apache Maven tidak ditemukan.
)

:: Unduh installer Maven
echo Mengunduh Maven dari %MAVEN_URL%...
bitsadmin /transfer "MavenDownload" %MAVEN_URL% "%TEMP_PATH%"
if %errorlevel% neq 0 (
    echo Gagal mengunduh Maven.
    goto :END
)

:: Ekstrak installer Maven
echo Mengekstrak Maven...
powershell -Command "Expand-Archive -Path '%TEMP_PATH%' -DestinationPath '%ProgramFiles%'"
if %errorlevel% neq 0 (
    echo Gagal mengekstrak Maven.
    goto :END
)

:: Tambahkan Maven ke PATH
setx PATH "%MAVEN_DIR%\bin;%PATH%"
if %errorlevel% neq 0 (
    echo Gagal menambahkan Maven ke PATH.
    goto :END
)

:: Hapus file installer setelah selesai
if exist "%TEMP_PATH%" del "%TEMP_PATH%"
echo Apache Maven 3.8.6 berhasil diinstal.

:END
:: Tunggu hingga pengguna menekan tombol sebelum keluar
echo.
echo Tekan tombol apa saja untuk keluar...
pause >nul
exit /b
