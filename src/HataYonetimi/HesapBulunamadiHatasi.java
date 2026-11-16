package HataYonetimi;

public class HesapBulunamadiHatasi extends Exception {

    // Constructor
    public HesapBulunamadiHatasi(String mesaj) {
        super(mesaj);
    }

    @Override
    public String getMessage() {
        return "Hesap Bulunamadı Hatası: " + super.getMessage();
    }
}
