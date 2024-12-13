# ProjectBP1

## Gambaran Umum
ProjectBP1 adalah aplikasi perbankan sederhana yang dikembangkan oleh Kelompok 12. Aplikasi ini mencakup fungsionalitas untuk login pengguna dan admin, serta operasi CRUD dasar untuk mengelola pengguna dan admin dalam database MySQL.

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
│   │   │   │   │   ├── model/
│   │   │   │   │   ├── repo/
│   │   │   │   ├── projectbp1/
│   │   │   │   │   ├── About.java
│   │   │   │   │   ├── LoadData.java
│   │   │   │   │   ├── Login.java
│   │   │   │   │   ├── ProjectBP1.java
│   │   │   │   │   ├── Utama.java
│   │   ├── resources/
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
- Dika Ramdhani
