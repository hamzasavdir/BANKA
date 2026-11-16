package HataYonetimi;

public class GecersizGirisHatasi extends Exception {

    // Constructor
    public GecersizGirisHatasi(String mesaj) {
        super(mesaj);
    }

    @Override
    public String getMessage() {
        return "Geçersiz Giriş Hatası: " + super.getMessage();
    }
}
