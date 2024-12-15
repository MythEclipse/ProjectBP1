@echo off
:: Script untuk auto commit dan push Git di Windows dengan pesan default

:: Menampilkan status git
git status

:: Menambahkan semua perubahan
git add .

:: Menggunakan pesan commit default
git commit -m "Malas Mengetik"

:: Melakukan push ke branch default
git push origin HEAD

:: Selesai
echo Proses commit dan push selesai!
pause
