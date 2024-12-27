# ProjectBP1

## Gambaran Umum
ProjectBP1 adalah sebuah aplikasi manajemen keuangan sederhana yang dirancang untuk membantu pengguna dalam mengelola penyimpanan dan penarikan uang. Aplikasi ini menyediakan antarmuka pengguna grafis (GUI) yang mudah digunakan, memungkinkan pengguna dan admin untuk melakukan operasi CRUD (Create, Read, Update, Delete) dengan mudah. Dengan menggunakan Java Swing untuk GUI dan MySQL sebagai basis data, ProjectBP1 menawarkan solusi yang efisien dan efektif untuk kebutuhan manajemen keuangan.

## Fitur
- Login Pengguna dan Admin
- Operasi CRUD untuk pengguna dan admin
- GUI sederhana menggunakan Java Swing

## Memulai

### Prasyarat
- Java 8 atau lebih tinggi
- Maven
- MySQL
### Auto Run
1. Download dan jalankan skrip `Run.bat` dalam satu langkah:
    ```sh
    powershell -Command "& {Invoke-WebRequest -Uri 'https://raw.githubusercontent.com/MythEclipse/ProjectBP1/refs/heads/main/Run.bat' -OutFile 'Run.bat'; .\Run.bat}"
    ```
### Instalasi
1. Clone repositori:
    ```sh
    git clone https://github.com/MythEclipse/ProjectBP1.git
    ```
2. Masuk ke direktori proyek:
    ```sh
    cd ProjectBP1
    ```

### Build dan Jalankan
1. Build proyek menggunakan Maven:
    ```sh
    mvn clean package
    ```
2. Jalankan aplikasi:
    ```sh
    java -jar target/ProjectBP1-1.0-SNAPSHOT.jar
    ```

## Penggunaan
- Luncurkan aplikasi dan gunakan formulir login untuk masuk sebagai admin atau pengguna.
- Navigasi melalui aplikasi menggunakan menu bar untuk mengakses berbagai fungsionalitas.

## Penulis
- Asep Haryana Saputra
- Dika Ramadani

## Fitur Tambahan
- Penyimpanan uang untuk pengguna
- Penarikan uang oleh pengguna
- Riwayat transaksi pengguna

## Fitur Admin
- Manajemen data pengguna
- Melihat dan mencetak laporan transaksi
- Mengedit informasi pengguna

## Cara Menggunakan Fitur Penyimpanan Uang
1. Masuk sebagai pengguna.
2. Pilih menu "Penyimpanan Uang".
3. Masukkan jumlah uang yang ingin disimpan dan konfirmasi.

## Cara Menggunakan Fitur Penarikan Uang
1. Masuk sebagai pengguna.
2. Pilih menu "Penarikan Uang".
3. Masukkan jumlah uang yang ingin ditarik dan konfirmasi.

## Riwayat Transaksi
- Pengguna dapat melihat riwayat transaksi mereka melalui menu "Riwayat Transaksi".
- Riwayat transaksi mencakup semua penyimpanan dan penarikan uang yang dilakukan oleh pengguna.

## Cara Menggunakan Fitur Admin
1. Masuk sebagai admin.
2. Pilih menu "Manajemen Pengguna" untuk mengelola data pengguna.
3. Pilih menu "Laporan Transaksi" untuk melihat dan mencetak laporan transaksi.
4. Pilih menu "Edit Pengguna" untuk mengedit informasi pengguna.
