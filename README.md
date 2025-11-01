# TP6

## Desain Program
### 1. Inisialisasi (App.java)
Program dimulai dari method `main()` pada `App.java`.

- Membuat jendela permainan (`JFrame`) berjudul **Flappy Bird**.  
- Menginisialisasi objek `Logic` dan `View`.  
- Menghubungkan `Logic` dengan `View` menggunakan `setView()`.  
- Menambahkan `View` ke dalam frame dan menampilkan jendela permainan.

### 2. Logika Utama (Logic.java)
Kelas ini berfungsi sebagai pusat pengatur permainan.

- Mengatur ukuran layar, posisi awal pemain, dan posisi awal pipa.  
- Membuat objek `Player` dan `ArrayList<Pipe>`.  
- Menggunakan dua timer utama:
  - **gameLoop** → memperbarui tampilan 60 kali per detik.  
  - **pipesCooldown** → menambahkan pipa baru setiap 1,5 detik.  
- Menerapkan gravitasi agar burung jatuh secara alami.  
- Saat tombol **Spasi** ditekan, kecepatan vertikal burung diubah agar burung terbang ke atas.  
- Pipa bergerak ke kiri secara terus-menerus hingga keluar layar.  
- Mengecek tabrakan antara pemain dan pipa untuk menentukan **game over**.

### 3. Objek Burung (Player.java)
Kelas `Player` berfungsi sebagai representasi karakter utama (burung).

- Menyimpan atribut posisi (`posX`, `posY`), ukuran, gambar, dan kecepatan vertikal (`velocityY`).  
- Dilengkapi dengan getter dan setter.  
- Tidak memiliki logika pergerakan, hanya sebagai **wadah data** pemain.

### 4. Objek Pipa (Pipe.java)
Kelas `Pipe` merepresentasikan rintangan pada permainan.

- Menyimpan atribut posisi, ukuran, gambar, kecepatan horizontal, dan status apakah sudah dilewati.  
- Digunakan oleh `Logic` untuk menambahkan, menggerakkan, dan menghapus pipa dari layar.  

### 5. Tampilan Grafis (View.java)
Kelas `View` merupakan turunan dari `JPanel` yang berfungsi untuk menggambar elemen-elemen permainan.

- Mengambil data dari `Logic` untuk menampilkan pemain, pipa, dan skor.  
- Menggambar latar belakang serta objek-objek game di layar.  
- Jika status permainan **game over**, menampilkan teks:
  - `"GAME OVER"`  
  - `"Tekan R untuk restart"`  
  di posisi tengah layar.

---

## Alur Program
1. Program dijalankan melalui `App.java`.  
2. `Logic` mengatur seluruh jalannya permainan (gravitasi, pergerakan, tabrakan, dan skor).  
3. `View` bertugas menggambar semua elemen berdasarkan data dari `Logic`.  
4. Saat pemain menabrak pipa, status menjadi **game over**, dan pemain dapat memulai ulang dengan menekan **R**.

---

## Dokumentasi
