/*
package Hesaplar;

public class KurumsalHesap extends Hesap {
    private String sirketAdi;
    private String vergiNumarasi;

    // Constructor
    public KurumsalHesap(String hesapNo, double bakiye, String sirketAdi, String vergiNumarasi) {
        this.hesapNo = hesapNo;
        this.bakiye = bakiye;
        this.sirketAdi = sirketAdi;
        this.vergiNumarasi = vergiNumarasi;
    }

    // Getter ve Setter
    public String getSirketAdi() {
        return sirketAdi;
    }

    public void setSirketAdi(String sirketAdi) {
        this.sirketAdi = sirketAdi;
    }

    public String getVergiNumarasi() {
        return vergiNumarasi;
    }

    public void setVergiNumarasi(String vergiNumarasi) {
        this.vergiNumarasi = vergiNumarasi;
    }

    @Override
    public void paraCek(double miktar) {
        if (miktar <= this.bakiye) {
            this.bakiye -= miktar;
            System.out.println(miktar + " TL hesabınızdan çekildi.");
        } else {
            System.out.println("Yetersiz bakiye! Lütfen daha düşük bir miktar giriniz.");
        }
        System.out.println("Kalan Bakiye: " + bakiye + " TL");
    }
}
*/
/*package Hesaplar;

public class KurumsalHesap extends Hesap {
    private final String kurumAdi;

    public KurumsalHesap(String tcKimlikNo, double bakiye, String kurumAdi, String sifre) {
        super(tcKimlikNo, bakiye, sifre);
        this.kurumAdi = kurumAdi;
    }

    public String getKurumAdi() {
        return kurumAdi;
    }

    @Override
    public void paraCek(double miktar) {

    }
}*/
package Hesaplar;

public class KurumsalHesap extends Hesap {

    private final String kurumAdi;

    /**
     * Kurumsal hesap constructor'ı.
     *
     * @param tcKimlikNo Hesap sahibinin TC kimlik numarası.
     * @param bakiye Hesabın başlangıç bakiyesi.
     * @param kurumAdi Kurumun adı.
     * @param sifre Hesabın şifresi.
     */
    public KurumsalHesap(String tcKimlikNo, double bakiye, String kurumAdi, String sifre) {
        super(tcKimlikNo, bakiye, sifre);
        this.kurumAdi = kurumAdi;
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
        return "Kurumsal Hesap - TC Kimlik No: " + getTcKimlikNo() + ", Kurum Adı: " + kurumAdi + ", Bakiye: " + getBakiye() + " TL.";
    }
}