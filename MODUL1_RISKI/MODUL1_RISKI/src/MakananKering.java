// Don't delete any comments below!!!

public class MakananKering {
    // Todo : Create private attribute of MakananKering (nama, jumlah, harga, and brand)
    private String nama;
    private int jumlah;
    private double harga;
    private String bahan;
    // Todo : Create Constructor of MakananKering
    public MakananKering(String bahan, double harga, int jumlah, String nama) {
        this.bahan = bahan;
        this.harga = harga;
        this.jumlah = jumlah;
        this.nama = nama;
    }
    // Todo : Create Getter and Setter
    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getJumlah() {
        return jumlah;
    }

    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }

    public double getHarga() {
        return harga;
    }

    public void setHarga(double harga) {
        this.harga = harga;
    }

    public String getBahan() {
        return bahan;
    }

    public void setBahan(String bahan) {
        this.bahan = bahan;
    }

    // Todo : Create Method ShowData

    public void tampilkanData(){
        System.out.println("Nama Makanan:" + nama);
        System.out.println("Jumlah: " + jumlah);
        System.out.println("Harga: " + harga);
        System.out.println("brand: " + bahan);
    }


   

}
