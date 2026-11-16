package Hesaplar;

public class BireyselHesap extends Hesap {

    private final String ad;
    private final String soyad;

    /**
     * Bireysel hesap constructor'ı.
     *
     * @param tcKimlikNo Hesap sahibinin TC kimlik numarası.
     * @param bakiye Hesabın başlangıç bakiyesi.
     * @param ad Hesap sahibinin adı.
     * @param soyad Hesap sahibinin soyadı.
     * @param sifre Hesabın şifresi.
     */
    public BireyselHesap(String tcKimlikNo, double bakiye, String ad, String soyad, String sifre) {
        super(tcKimlikNo, bakiye, sifre);
        this.ad = ad;
        this.soyad = soyad;
    }

    /**
     * Hesaptan para çeker.
     *
     * @param miktar Çekilecek miktar.
     */
    @Override
    public void paraCek(double miktar) {
        if (miktar > 0 && miktar <= getBakiye()) {
            setBakiye(getBakiye() - miktar);
            System.out.println(miktar + " TL çekildi. Güncel bakiye: " + getBakiye() + " TL.");
        } else {
            System.out.println("Geçersiz işlem! Yetersiz bakiye veya negatif miktar.");
        }
    }

    /**
     * Hesabın bilgilerini döner.
     *
     * @return Hesap bilgileri.
     */
    @Override
    public String hesapBilgisi() {
        return "Bireysel Hesap - TC Kimlik No: " + getTcKimlikNo() + ", Ad: " + ad + ", Soyad: " + soyad + ", Bakiye: " + getBakiye() + " TL.";
    }
}