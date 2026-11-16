package FonIslemleri;

import Hesaplar.Hesap;

public class FonAlma {
    private int toplamFon = 0; // Kullanıcının sahip olduğu toplam fon

    public void fonAl(Hesap hesap, int adet, double tutar) {
        double toplamTutar = adet * tutar;

        if (toplamTutar <= hesap.getBakiye()) {
            toplamFon += adet;
            hesap.setBakiye(hesap.getBakiye() - toplamTutar);
            System.out.println(adet + " adet fon alındı, Harcanan: " + toplamTutar + " TL.");
            System.out.println("Kalan Bakiye: " + hesap.getBakiye() + " TL");
        } else {
            System.out.println("Yetersiz bakiye! Fon alımı yapılamadı.");
        }
    }

    public int getToplamFon() {
        return toplamFon;
    }
}
