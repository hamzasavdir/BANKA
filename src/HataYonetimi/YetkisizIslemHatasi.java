package HataYonetimi;

public class YetkisizIslemHatasi extends Exception {

    // Constructor
    public YetkisizIslemHatasi(String mesaj) {
        super(mesaj);
    }

    @Override
    public String getMessage() {
        return "Yetkisiz İşlem Hatası: " + super.getMessage();
    }
}
