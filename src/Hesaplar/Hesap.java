package Hesaplar;

public abstract class Hesap {

    private final String tcKimlikNo;
    private double bakiye;
    private final String sifre;

    /**
     * Hesap sınıfının constructor'ı.
     *
     * @param tcKimlikNo Hesap sahibinin TC kimlik numarası.
     * @param bakiye Hesabın başlangıç bakiyesi.
     * @param sifre Hesabın şifresi.
     */
    public Hesap(String tcKimlikNo, double bakiye, String sifre) {
        this.tcKimlikNo = tcKimlikNo;
        this.bakiye = bakiye;
        this.sifre = sifre;
    }

    /**
     * Hesabın TC kimlik numarasını döner.
     *
     * @return TC kimlik numarası.
     */
    public String getTcKimlikNo() {
        return tcKimlikNo;
    }

    /**
     * Hesabın mevcut bakiyesini döner.
     *
     * @return Mevcut bakiye.
     */
    public double getBakiye() {
        return bakiye;
    }

    /**
     * Hesap bakiyesini günceller.
     *
     * @param bakiye Yeni bakiye.
     */
    public void setBakiye(double bakiye) {
        this.bakiye = bakiye;
    }

    /**
     * Hesabın şifresini döner. (Not: Güvenlik açısından şifreleme önerilir.)
     *
     * @return Şifre.
     */
    public String getSifre() {
        return sifre;
    }

    /**
     * Hesaba para yatırır.
     *
     * @param miktar Yatırılacak miktar.
     */
    public void paraYatir(double miktar) {
        if (miktar > 0) {
            bakiye += miktar;
            System.out.println(miktar + " TL yatırıldı. Güncel bakiye: " + bakiye + " TL.");
        } else {
            System.out.println("Geçersiz miktar. Pozitif bir değer giriniz.");
        }
    }

    /**
     * Hesaptan para çeker. Alt sınıflar bu metodu özelleştirmelidir.
     *
     * @param miktar Çekilecek miktar.
     */
    public abstract void paraCek(double miktar);

    /**
     * Hesabın bilgilerini döner.
     *
     * @return Hesap bilgileri.
     */
    public abstract String hesapBilgisi();
}
