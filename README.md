# ProjectBP1

## Gambaran Umum
ProjectBP1 adalah sebuah aplikasi manajemen keuangan sederhana yang dirancang untuk membantu pengguna dalam mengelola penyimpanan dan penarikan uang. Aplikasi ini menyediakan antarmuka pengguna grafis (GUI) yang mudah digunakan, memungkinkan pengguna dan admin untuk melakukan operasi CRUD (Create, Read, Update, Delete) dengan mudah. Dengan menggunakan Java Swing untuk GUI dan MySQL sebagai basis data, ProjectBP1 menawarkan solusi yang efisien dan efektif untuk kebutuhan manajemen keuangan.

## Fitur
- Login Pengguna dan Admin
- Operasi CRUD untuk pengguna dan admin
- GUI sederhana menggunakan Java Swing

## Struktur Proyek
```
ProjectBP1/
├── pom.xml
├── README.md
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── kelompok12/
│   │   │   │   ├── database/
│   │   │   │   │   ├── lib/
│   │   │   │   │   │   ├── CrudRepository.java
│   │   │   │   │   │   ├── DatabaseUtil.java
│   │   │   │   │   ├── model/
│   │   │   │   │   ├── repo/
│   │   │   │   ├── layout/
│   │   │   │   │   ├── login/
│   │   │   │   │   │   ├── Login.java
│   │   │   │   │   ├── user/
│   │   │   │   │   │   ├── Edit.form
│   │   │   │   │   │   ├── Tarik.form
│   │   │   │   │   │   ├── User.form
│   │   │   │   ├── projectbp1/
│   │   │   │   │   ├── About.java
│   │   │   │   │   ├── LoadData.java
│   │   │   │   │   ├── ProjectBP1.java
│   │   │   │   │   ├── Utama.java
│   ├── resources/
│   ├── test/
├── target/
├── .gitignore
├── .vscode/
├── .github/
│   ├── workflows/
│   │   ├── maven.yml
```

## Memulai

### Prasyarat
- Java 8 atau lebih tinggi
- Maven
- MySQL

### Instalasi
1. Clone repositori:
    ```sh
    git clone https://github.com/yourusername/ProjectBP1.git
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