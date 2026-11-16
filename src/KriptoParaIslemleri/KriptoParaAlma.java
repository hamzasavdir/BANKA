package KriptoParaIslemleri;

import Hesaplar.Hesap;

public class KriptoParaAlma {
    private int toplamKripto = 0; // Kullanıcının sahip olduğu toplam kripto

    public void kriptoAl(Hesap hesap, int adet, double tutar) {
        double toplamTutar = adet * tutar;

        if (toplamTutar <= hesap.getBakiye()) {
            toplamKripto += adet;
            hesap.setBakiye(hesap.getBakiye() - toplamTutar);
            System.out.println(adet + " adet kripto para alındı, Harcanan: " + toplamTutar + " TL.");
            System.out.println("Kalan Bakiye: " + hesap.getBakiye() + " TL");
        } else {
            System.out.println("Yetersiz bakiye! Kripto para alımı yapılamadı.");
        }
    }

    public int getToplamKripto() {
        return toplamKripto;
    }
}
