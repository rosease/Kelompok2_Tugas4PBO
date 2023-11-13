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