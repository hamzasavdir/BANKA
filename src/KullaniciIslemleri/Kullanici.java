package KullaniciIslemleri;

public class Kullanici {
    private String tcKimlikNo;
    private String ad;
    private String soyad;
    private String sifre;

    // Constructor
    public Kullanici(String tcKimlikNo, String ad, String soyad, String sifre) {
        this.tcKimlikNo = tcKimlikNo;
        this.ad = ad;
        this.soyad = soyad;
        this.sifre = sifre;
    }

    // Getter ve Setter
    public String getTcKimlikNo() {
        return tcKimlikNo;
    }

    public void setTcKimlikNo(String tcKimlikNo) {
        this.tcKimlikNo = tcKimlikNo;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getSoyad() {
        return soyad;
    }

    public void setSoyad(String soyad) {
        this.soyad = soyad;
    }

    public String getSifre() {
        return sifre;
    }

    public void setSifre(String sifre) {
        this.sifre = sifre;
    }
}
