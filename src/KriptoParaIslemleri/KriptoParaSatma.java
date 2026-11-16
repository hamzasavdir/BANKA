package KriptoParaIslemleri;

import Hesaplar.Hesap;

public class KriptoParaSatma {
    private int toplamKripto = 0; // Kullanıcının sahip olduğu toplam kripto

    public void kriptoSat(Hesap hesap, int adet, double tutar) {
        if (adet <= toplamKripto) {
            double toplamTutar = adet * tutar;
            toplamKripto -= adet;
            hesap.setBakiye(hesap.getBakiye() + toplamTutar);
            System.out.println(adet + " adet kripto para satıldı, Kazanılan: " + toplamTutar + " TL.");
            System.out.println("Güncel Bakiye: " + hesap.getBakiye() + " TL");
        } else {
            System.out.println("Yeterli kripto para yok! Sadece " + toplamKripto + " adet kripto para satabilirsiniz.");
        }
    }

    public void setToplamKripto(int adet) {
        this.toplamKripto = adet;
    }
}
