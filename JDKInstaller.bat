@echo off
:: Cek apakah memiliki hak administrator
net session >nul 2>&1
if %errorlevel% neq 0 (
    echo Script ini memerlukan hak administrator.
    echo Meminta hak administrator...
    powershell -Command "Start-Process '%~f0' -Verb RunAs"
    exit /b
)

:: URL download JDK
set "JDK_URL=https://download.oracle.com/java/21/latest/jdk-21_windows-x64_bin.exe"

:: Nama file installer
set "JDK_INSTALLER=jdk-21_windows-x64_bin.exe"

:: Path sementara untuk menyimpan installer
set "TEMP_PATH=%TEMP%\%JDK_INSTALLER%"

:: Periksa apakah JDK sudah terpasang
java -version >nul 2>&1
if %errorlevel% equ 0 (
    echo Java JDK sudah terinstal.
    goto :END
) else (
    echo Java JDK tidak ditemukan.
)

:: Unduh installer JDK
echo Mengunduh JDK dari %JDK_URL%...
bitsadmin /transfer "JDKDownload" %JDK_URL% "%TEMP_PATH%"
if %errorlevel% neq 0 (
    echo Gagal mengunduh JDK.
    goto :END
)

:: Instal JDK
echo Menginstal JDK...
start /wait "" "%TEMP_PATH%" /s
if %errorlevel% neq 0 (
    echo Gagal menginstal JDK.
    goto :END
)

:: Hapus file installer setelah selesai
if exist "%TEMP_PATH%" del "%TEMP_PATH%"
echo Java JDK 21 berhasil diinstal.

:END
:: Tunggu hingga pengguna menekan tombol sebelum keluar
echo.
echo Tekan tombol apa saja untuk keluar...
pause >nul
exit /b
