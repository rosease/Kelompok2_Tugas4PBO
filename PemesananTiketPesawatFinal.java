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
    class TiketPesawatPP extends TiketPesawat {
    private int jumlahTiket;
    private Fasilitas fasilitas;

    public TiketPesawatPP(String maskapai, String tujuan, double harga, int jumlahTiket, Fasilitas fasilitas) {
        super(maskapai, tujuan, harga);
        this.jumlahTiket = jumlahTiket;
        this.fasilitas = fasilitas;
    }

    @Override
    public double hitungTotalHarga() {
        return (getHarga() * jumlahTiket * 2) + fasilitas.getBiaya();
    }
}
    class TiketPesawatNonPP extends TiketPesawat {
    private int jumlahTiket;
    private Fasilitas fasilitas;

    public TiketPesawatNonPP(String maskapai, String tujuan, double harga, int jumlahTiket, Fasilitas fasilitas) {
        super(maskapai, tujuan, harga);
        this.jumlahTiket = jumlahTiket;
        this.fasilitas = fasilitas;
    }

    @Override
    public double hitungTotalHarga() {
        return (getHarga() * jumlahTiket) + fasilitas.getBiaya();
    }
}
    //Membuat kelas fasilitas
class Fasilitas {
    private String jenis;
    private double biaya;

    public Fasilitas(String jenis, double biaya) {
        this.jenis = jenis;
        this.biaya = biaya;
    }
    
    public String getJenis() {
        return jenis;
    }

    public void setJenis(String jenis) {
        this.jenis = jenis;
    }

    public double getBiaya() {
        return biaya;
    }

    public void setBiaya(double biaya) {
        this.biaya = biaya;
    }
}
    // Kelas turunan fasilitas untuk Hotel Bintang 5
class HotelBintang5 extends Fasilitas {
    public HotelBintang5() {
        super("Hotel Bintang 5", 500.0); // Biaya tambahan untuk Hotel Bintang 5
    }
}
    class HotelBintang3 extends Fasilitas {
    public HotelBintang3() {
        super("Hotel Bintang 3", 350.0); // Biaya tambahan untuk Hotel Bintang 3
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
