import java.util.Scanner;

public class PemesananTiketPesawat {
    //kelas abstract tiket pesawat
    abstract class TiketPesawat {
    private String maskapai;
    private String tujuan;
    private double harga;

    public TiketPesawat(String maskapai, String tujuan, double harga) {
        this.maskapai = maskapai;
        this.tujuan = tujuan;
        this.harga = harga;
    }
    //abstract method
    public abstract double hitungTotalHarga();
        public String getMaskapai() {
        return maskapai;
    }

    //method setter getter
    public void setMaskapai(String maskapai) {
        this.maskapai = maskapai;
    }

    public String getTujuan() {
        return tujuan;
    }
    public void setTujuan(String tujuan) {
        this.tujuan = tujuan;
    }

    public double getHarga() {
        return harga;
    }

    public void setHarga(double harga) {
        this.harga = harga;
    }

}
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Selamat datang di Program Pemesanan Tiket Pesawat");
        System.out.print("Masukkan maskapai: ");
        String maskapai = scanner.nextLine();
        System.out.print("Masukkan tujuan: 1 Bali, 2 Karimunjawa, 3 Medan, 4 Yogyakarta, 5 Jakarta : ");
        int destinasi = scanner.nextInt();
        String tujuan;
        switch (destinasi) {
            case 1:
                tujuan = "Bali";
                break;
            case 2:
                tujuan = "Karimunjawa";
                break;
            case 3:
                tujuan = "Medan";
                break;
            case 4:
                tujuan = "Yogyakarta";
                break;
            case 5:
                tujuan = "Jakarta";
                break;
            default:
                System.out.println("Destinasi tidak valid.");
                return;
        }

        System.out.print("Masukkan harga tiket: ");
        double harga = scanner.nextDouble();
        System.out.print("Masukkan jumlah tiket: ");
        int jumlahTiket = scanner.nextInt();

        Fasilitas fasilitas;

        System.out.print("Pilih jenis tiket (1 untuk PP, 2 untuk Non-PP): ");
        int pilihan = scanner.nextInt();

        if (pilihan == 1) {
            System.out.print("Pilih fasilitas (1 untuk Hotel Bintang 3, 2 untuk Hotel Bintang 5): ");
            int pilihanFasilitas = scanner.nextInt();
            if (pilihanFasilitas == 1) {
                fasilitas = new HotelBintang3();
            } else if (pilihanFasilitas == 2) {
                fasilitas = new HotelBintang5();
            } else {
                System.out.println("Pilihan fasilitas tidak valid.");
                return;
            }
            TiketPesawat tiket = new TiketPesawatPP(maskapai, tujuan, harga, jumlahTiket, fasilitas);
            System.out.println("Fasilitas: " + fasilitas.getJenis());
            System.out.println("Biaya Fasilitas: " + fasilitas.getBiaya());
            double totalHarga = tiket.hitungTotalHarga();
            System.out.println("Total harga tiket: " + totalHarga);
        } else if (pilihan == 2) {
            fasilitas = new Fasilitas("Wisata", 50.0); // Contoh fasilitas wisata dengan biaya tambahan
            TiketPesawat tiket = new TiketPesawatNonPP(maskapai, tujuan, harga, jumlahTiket, fasilitas);
            double totalHarga = tiket.hitungTotalHarga();
            System.out.println("Total harga tiket: " + totalHarga);
        } else {
            System.out.println("Pilihan tidak valid.");
            return;
        }
    }
}
