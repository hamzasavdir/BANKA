package HisseIslemleri;

import Hesaplar.Hesap;

public class HisseAlma {
    private int toplamHisse = 0; // Kullanıcının sahip olduğu toplam hisse

    public void hisseAl(Hesap hesap, int adet, double tutar) {
        double toplamTutar = adet * tutar;

        if (toplamTutar <= hesap.getBakiye()) {
            toplamHisse += adet;
            hesap.setBakiye(hesap.getBakiye() - toplamTutar);
            System.out.println(adet + " adet hisse alındı, Harcanan: " + toplamTutar + " TL.");
            System.out.println("Kalan Bakiye: " + hesap.getBakiye() + " TL");
        } else {
            System.out.println("Yetersiz bakiye! Hisse alımı yapılamadı.");
        }
    }

    public int getToplamHisse() {
        return toplamHisse;
    }
}
