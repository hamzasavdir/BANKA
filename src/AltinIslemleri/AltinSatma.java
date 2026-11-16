package AltinIslemleri;

import Hesaplar.Hesap;

public class AltinSatma {
    private static final double ALTIN_FIYATI = 3000.0; // Sabit altın fiyatı
    private double toplamAltin = 0.0; // Kullanıcının toplam altın miktarı (aynı nesneden bağlanmalı)

    public void altinSat(Hesap hesap, double gramAltin) {
        if (gramAltin <= toplamAltin) {
            double miktarTL = gramAltin * ALTIN_FIYATI;
            toplamAltin -= gramAltin;
            hesap.setBakiye(hesap.getBakiye() + miktarTL);
            System.out.println(gramAltin + " gram altın satıldı, Kazanılan: " + miktarTL + " TL.");
            System.out.println("Güncel Bakiye: " + hesap.getBakiye() + " TL");
        } else {
            System.out.println("Yeterli altın yok! Sadece " + toplamAltin + " gram altın satabilirsiniz.");
        }
    }

    public void setToplamAltin(double miktar) {
        this.toplamAltin = miktar;
    }
}
