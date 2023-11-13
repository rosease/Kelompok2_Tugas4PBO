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