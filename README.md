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

**Insert**  
<img width="300" alt="Insert Form" src="https://github.com/user-attachments/assets/260df51c-6326-47cf-b475-aca28e47b430" />
<img width="300" alt="Insert Validation" src="https://github.com/user-attachments/assets/46b2059a-182f-48b2-bc71-ed12973eefe4" />
<img width="300" alt="Insert Result" src="https://github.com/user-attachments/assets/a9b0ff5a-dc71-4683-a150-17bf5e29cd37" />

**Update**  
<img width="300" alt="Update Form" src="https://github.com/user-attachments/assets/2d1d3fbf-0cb4-4e66-a4c0-ddf9c4d699b4" />
<img width="300" alt="Update Process" src="https://github.com/user-attachments/assets/2096049d-7522-4703-91b7-7cd9aa4b03e7" />
<img width="300" alt="Update Result" src="https://github.com/user-attachments/assets/29e8b6ba-bfd3-419d-b107-95fb81f81c4d" />

**Delete**  
<img width="300" alt="Before Delete" src="https://github.com/user-attachments/assets/414e177a-8bc6-4bb1-9bad-142a787e069a" />
<img width="300" alt="Delete Confirmation" src="https://github.com/user-attachments/assets/c206b62e-c227-429d-8ea2-7a3170beb273" />
<img width="300" alt="After Delete" src="https://github.com/user-attachments/assets/dcb20328-61e7-42ff-bb87-851de2fb5bee" />

**Validasi Error**  
<img width="300" alt="Error 1" src="https://github.com/user-attachments/assets/a0323f8d-ffe0-4c69-99bc-393dc08e2eed" />
<img width="300" alt="Error 2" src="https://github.com/user-attachments/assets/266200e4-4952-48d3-9edd-f766fec7ff0b" />
