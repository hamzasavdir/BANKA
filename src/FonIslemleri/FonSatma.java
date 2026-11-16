package FonIslemleri;

import Hesaplar.Hesap;

public class FonSatma {
    private int toplamFon = 0; // Kullanıcının sahip olduğu toplam fon

    public void fonSat(Hesap hesap, int adet, double tutar) {
        if (adet <= toplamFon) {
            double toplamTutar = adet * tutar;
            toplamFon -= adet;
            hesap.setBakiye(hesap.getBakiye() + toplamTutar);
            System.out.println(adet + " adet fon satıldı, Kazanılan: " + toplamTutar + " TL.");
            System.out.println("Güncel Bakiye: " + hesap.getBakiye() + " TL");
        } else {
            System.out.println("Yeterli fon yok! Sadece " + toplamFon + " adet fon satabilirsiniz.");
        }
    }

    public void setToplamFon(int adet) {
        this.toplamFon = adet;
    }
}
