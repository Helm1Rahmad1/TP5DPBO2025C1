# TP5DPBO2025C1

# Janji
Saya Muhammad Helmi Rahmadi dengan NIM 2311574 mengerjakan Tugas Praktikum 5 dalam mata kuliah Desain dan Pemrograman Berorientasi Objek untuk keberkahanNya maka saya tidak melakukan kecurangan seperti yang telah dispesifikasikan. Aamiin.

# Desain Program
Program Manajemen Data Mahasiswa dibuat dengan pendekatan yang fleksibel dan mudah digunakan. Dengan konsep berbasis OOP, program ini mempermudah pengelolaan data mahasiswa, mulai dari menambahkan, melihat, mengubah, hingga menghapus data. Antarmukanya dibuat dengan Java Swing agar lebih interaktif, sementara MySQL digunakan sebagai tempat penyimpanan data agar tetap rapi dan mudah diakses.

## Struktur Kelas
Program ini terdiri dari tiga kelas utama:

1. **Database.java**
-> Kelas ini bertanggung jawab untuk mengelola koneksi dan komunikasi dengan database MySQL.
- Fungsi utama:
    - Membuat koneksi ke database.
    - Mengeksekusi query SELECT untuk membaca data.
    - Mengeksekusi query INSERT, UPDATE, dan DELETE untuk memodifikasi data.
    - Menangani transaksi database dan error handling.
2. **Mahasiswa.java**
-> Kelas ini berfungsi sebagai representasi dari entitas mahasiswa dalam sistem.
- Atribut:
    - `NIM` (Nomor Induk Mahasiswa)
    - `nama` (Nama lengkap)
    - `jenisKelamin` (L/P)
    - `tempatTinggal` (Domisili)
- Metode:
    - Konstruktor untuk inisialisasi objek mahasiswa.
    - Getter dan setter untuk setiap atribut.

3. **Menu.java**
-> Kelas ini bertanggung jawab untuk mengelola interaksi pengguna menggunakan Java Swing.
- Karakteristik:
    - Menggunakan JFrame sebagai wadah utama.
    - Menampilkan data mahasiswa dalam tabel.
    - Menyediakan input melalui TextField, ComboBox, dan RadioButton.
    - Menyediakan tombol aksi: `Add`, `Update`, `Delete`, `Cancel`.
    - Menghubungkan antarmuka dengan logika bisnis dan database.
      
## Desain Antarmuka
Antarmuka dirancang agar intuitif dan mudah digunakan dengan elemen sebagai berikut:
- Tabel Dinamis: Menampilkan data mahasiswa yang tersimpan dalam database.
- Form Input:
  - TextField untuk input `NIM` dan `Nama`.
  - ComboBox untuk memilih Jenis `Kelamin`.
  - Radio Button untuk memilih `Tempat Tinggal`.
- Tombol Aksi:
  - `Tambah`: Menambahkan data mahasiswa baru.
  - `Ubah`: Memperbarui data mahasiswa yang dipilih.
  - `Hapus`: Menghapus data mahasiswa dari database.
  - `Cancel`: Mengosongkan formulir input.

# Alur Program

## 1. **Inisialisasi**
- Program membuat koneksi ke database MySQL
- Memuat data mahasiswa dari database ke dalam tabel
- Menyiapkan antarmuka pengguna

## 2. **Operasi CRUD**
   
a. **Menambahkan Data Mahasiswa (Create)**
1. Pengguna mengisi formulir input.
2. Sistem melakukan validasi:
   - Memeriksa kelengkapan data.
   - Memastikan NIM belum terdaftar.
4. Jika valid, data disimpan ke database.
5. Tampilan tabel diperbarui secara otomatis.
6. Menampilkan pesan sukses atau gagal.
 
b. **Membaca Data Mahasiswa (Read)**
1. Sistem mengambil data dari database dan menampilkannya dalam tabel.
2. Pengguna dapat melihat informasi mahasiswa tanpa melakukan perubahan.

c. **Mengubah Data Mahasiswa (Update)**
1. Pengguna memilih baris data yang ingin diubah.
2. Data yang dipilih dimuat ke dalam formulir input.
3. Pengguna mengedit informasi dan menekan tombol Update.
4. Sistem memvalidasi perubahan dan memperbarui database.
5. Tampilan tabel diperbarui untuk mencerminkan perubahan.
   
d. **Menghapus Data Mahasiswa (Delete)**
1. Pengguna memilih baris data yang ingin dihapus.
2. Sistem meminta konfirmasi sebelum menghapus.
3. Jika dikonfirmasi, data dihapus dari database.
4. Tampilan tabel diperbarui dan menampilkan pesan sukses.
   
## 3. **Validasi dan Error Handling**

- Validasi Input:
  - Memeriksa apakah NIM hanya berisi angka.
  - Memastikan semua kolom wajib diisi.
  - Mencegah duplikasi NIM.
- Error Handling:
  - Menangani kegagalan koneksi database.
  - Menampilkan pesan kesalahan jika query SQL gagal.


# Dokumentasi 

**Create**

<img width="250" src="https://github.com/user-attachments/assets/cc855462-ec2d-4e11-875e-c72725f5a0c5" /> <img width="250" src="https://github.com/user-attachments/assets/cca0ed99-e41f-42f8-8e2a-ff02e8023f1f" /> <img width="250" src="https://github.com/user-attachments/assets/412656c6-f822-49b2-83db-d6e80f72eca2" />

**Update**

<img width="250" src="https://github.com/user-attachments/assets/3b5ef1ed-7ffa-42fe-b8d1-ef0aa807dcae" /> <img width="250" src="https://github.com/user-attachments/assets/e45c5c5a-7ee8-4b04-a1e8-6903d5a0063b" /> <img width="250" src="https://github.com/user-attachments/assets/a0b7de5e-01e9-4da4-92f7-bb902c5f76e2" />

**Delete**

<img width="250" src="https://github.com/user-attachments/assets/f2a6e441-b749-43ba-b5be-530af5905eb8" /> <img width="250" src="https://github.com/user-attachments/assets/d7208bae-c58a-4ba7-9be1-c3200b66acbf" /> <img width="250" src="https://github.com/user-attachments/assets/a38b20ee-6591-461f-8cda-6668e586b265" />

**Error Handling**

<img width="250" src="https://github.com/user-attachments/assets/3ace480d-98f8-4a34-8f93-7a18a89869c2" /> <img width="250" src="https://github.com/user-attachments/assets/d4e6c34d-da55-4d60-9628-063402cc2175" /> <img width="250" src="https://github.com/user-attachments/assets/05bc68f9-5f57-4aa2-a42d-e18680bbf0b6" />


