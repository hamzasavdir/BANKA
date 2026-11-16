package HataYonetimi;

public class YetersizBakiyeHatasi extends Exception {

    // Constructor
    public YetersizBakiyeHatasi(String mesaj) {
        super(mesaj);
    }

    @Override
    public String getMessage() {
        return "Yetersiz Bakiye Hatası: " + super.getMessage();
    }
}
