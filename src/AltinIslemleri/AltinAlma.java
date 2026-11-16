package AltinIslemleri;

import Hesaplar.Hesap;

public class AltinAlma {
    private static final double ALTIN_FIYATI = 3000.0; // Sabit altın fiyatı
    private double toplamAltin = 0.0; // Kullanıcının toplam altın miktarı

    public void altinAl(Hesap hesap, double miktarTL) {
        if (miktarTL <= hesap.getBakiye()) {
            double gramAltin = miktarTL / ALTIN_FIYATI;
            toplamAltin += gramAltin;
            hesap.setBakiye(hesap.getBakiye() - miktarTL);
            System.out.println(miktarTL + " TL ile " + gramAltin + " gram altın alındı.");
            System.out.println("Kalan Bakiye: " + hesap.getBakiye() + " TL");
        } else {
            System.out.println("Yetersiz bakiye! Altın alımı yapılamadı.");
        }
    }

    public double getToplamAltin() {
        return toplamAltin;
    }
}
