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