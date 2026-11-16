package HisseIslemleri;

import Hesaplar.Hesap;

public class HisseSatma {
    private int toplamHisse = 0; // Kullanıcının sahip olduğu toplam hisse

    public void hisseSat(Hesap hesap, int adet, double tutar) {
        if (adet <= toplamHisse) {
            double toplamTutar = adet * tutar;
            toplamHisse -= adet;
            hesap.setBakiye(hesap.getBakiye() + toplamTutar);
            System.out.println(adet + " adet hisse satıldı, Kazanılan: " + toplamTutar + " TL.");
            System.out.println("Güncel Bakiye: " + hesap.getBakiye() + " TL");
        } else {
            System.out.println("Yeterli hisse yok! Sadece " + toplamHisse + " adet hisse satabilirsiniz.");
        }
    }

    public void setToplamHisse(int adet) {
        this.toplamHisse = adet;
    }
}
