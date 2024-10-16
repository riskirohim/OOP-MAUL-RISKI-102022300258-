// Don't delete any comments below!!!
// Todo: Import Scanner

public class Main {
    public static void main(String[] args) {
        // Todo : Create ManajemenInventaris Object and Scanner
        ManajemenInventaris manajemenInventaris = new ManajemenInventaris();
        Scanner scanner = new Scanner(System.in);
        int pilihan;

        // Todo : Create Loop list menu
        while (true) {
            System.out.println("===== Menu Inventaris Makanan EAD =====");
            System.out.println("1. Tambah Makanan Kering");
            System.out.println("2. Tambah Makanan Basah");
            System.out.println("3. Tampilkan Semua Makanan");
            System.out.println("4. Keluar");
            System.out.print("Pilih Menu: ");
            pilihan = scanner.nextInt();
            scanner.nextLine();

            switch (pilihan){
                case 1:
                manajemenInventaris.tambahMakananKering();
                break;
                case 2:
                manajemenInventaris.tambahMakananBasah();
                break;
                case 3:
                manajemenInventaris.tampilkanSemuaMakanan();
                case 4:
                System.out.println("Keluar dari program.");
                break;
                default:
                System.out.println("Tidak ada pilihan!");

            }
        } 
    }
}

