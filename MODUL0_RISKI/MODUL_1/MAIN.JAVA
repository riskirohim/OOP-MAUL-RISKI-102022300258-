import java.util.ArrayList;
import java.util.Scanner;

class Penerbangan {
    private String nomor, keberangkatan, tujuan, waktuBerangkat, waktuDatang;
    private double harga;

    public Penerbangan(String nomor, String keberangkatan, String tujuan, String waktuBerangkat, String waktuDatang, double harga) {
        this.nomor = nomor;
        this.keberangkatan = keberangkatan;
        this.tujuan = tujuan;
        this.waktuBerangkat = waktuBerangkat;
        this.waktuDatang = waktuDatang;
        this.harga = harga;
    }

    public void tampilkanInfo() {
        System.out.printf("Nomor: %s | %s -> %s | %s - %s | Harga: Rp %.2f\n", nomor, keberangkatan, tujuan, waktuBerangkat, waktuDatang, harga);
    }
}

class Penumpang {
    private String NIK, namaDepan, namaBelakang;

    public Penumpang(String NIK, String namaDepan, String namaBelakang) {
        this.NIK = NIK;
        this.namaDepan = namaDepan;
        this.namaBelakang = namaBelakang;
    }

    public void tampilkanInfo() {
        System.out.printf("NIK: %s | Nama: %s %s\n", NIK, namaDepan, namaBelakang);
    }
}

public class Pembelian {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Penerbangan> daftarPenerbangan = new ArrayList<>();
        daftarPenerbangan.add(new Penerbangan("1", "CGK, Jakarta", "DPS, Denpasar", "06:30", "08:15", 1200000));
        daftarPenerbangan.add(new Penerbangan("2", "SUB, Surabaya", "KNO, Medan", "09:00", "11:45", 1350000));

        Penumpang penumpang = null;
        Penerbangan pesananPenerbangan = null;

        while (true) {
            System.out.println("===== EAD Ticket Booking System =====");
            System.out.println("1. Tampilkan Daftar Penerbangan\n2. Beli Tiket\n3. Tampilkan Pesanan Tiket\n4. Exit");
            System.out.print("Pilih menu: ");
            int opsi = scanner.nextInt();
            scanner.nextLine(); // Konsumsi newline

            if (opsi == 1) {
                daftarPenerbangan.forEach(Penerbangan::tampilkanInfo);
            } else if (opsi == 2) {
                System.out.println("Isi data diri Anda:");
                System.out.print("NIK: ");
                String NIK = scanner.nextLine();
                System.out.print("Nama Depan: ");
                String namaDepan = scanner.nextLine();
                System.out.print("Nama Belakang: ");
                String namaBelakang = scanner.nextLine();
                penumpang = new Penumpang(NIK, namaDepan, namaBelakang);

                System.out.print("Pilih nomor penerbangan (1-" + daftarPenerbangan.size() + "): ");
                int pilihan = scanner.nextInt();
                scanner.nextLine(); // Konsumsi newline

                if (pilihan > 0 && pilihan <= daftarPenerbangan.size()) {
                    pesananPenerbangan = daftarPenerbangan.get(pilihan - 1);
                    System.out.println("Pesanan tiket berhasil.");
                } else {
                    System.out.println("Nomor penerbangan tidak valid.");
                }
            } else if (opsi == 3) {
                if (penumpang != null && pesananPenerbangan != null) {
                    penumpang.tampilkanInfo();
                    pesananPenerbangan.tampilkanInfo();
                } else {
                    System.out.println("Belum ada pesanan tiket.");
                }
            } else if (opsi == 4) {
                System.out.println("Terima kasih.");
                break;
            } else {
                System.out.println("Opsi tidak valid.");
            }
        }

        scanner.close();
    }
}
