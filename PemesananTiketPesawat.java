import java.util.Scanner;

public class PemesananTiketPesawat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n-----------------------------------------------------");
        System.out.println("| Selamat datang di Program Pemesanan Tiket Pesawat |");
        System.out.println("-----------------------------------------------------");
        System.out.print("Masukkan Maskapai: ");
        String maskapai = scanner.nextLine();
        System.out.print("\nDaftar Tujuan:\n1. Bali\n2. Karimunjawa\n3. Medan\n4. Yogyakarta\n5. Jakarta \nMasukkan Tujuan Anda: ");
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

        System.out.print("\nMasukkan harga tiket: ");
        double harga = scanner.nextDouble();
        System.out.print("Masukkan jumlah tiket: ");
        int jumlahTiket = scanner.nextInt();

        Fasilitas fasilitas;

        System.out.print("\nPilih jenis tiket \n1. Pulang Pergi (PP) \n2. Non-PP \nMasukkan Pilihan: ");
        int pilihan = scanner.nextInt();

        if (pilihan == 1) {
            System.out.print("\nPilih fasilitas: \n\t1. untuk Hotel Bintang 3 \n\t2. untuk Hotel Bintang 5 \nMasukkan Pilihan: ");
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
            System.out.println("\nTotal harga tiket: " + totalHarga);
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
