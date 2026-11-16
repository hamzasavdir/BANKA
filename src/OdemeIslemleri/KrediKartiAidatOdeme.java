package OdemeIslemleri;

import Hesaplar.Hesap;

public class KrediKartiAidatOdeme {

    public void krediKartiAidatOde(Hesap hesap, double miktar) {
        if (miktar <= hesap.getBakiye()) {
            hesap.setBakiye(hesap.getBakiye() - miktar);
            System.out.println("Kredi kartı aidatı ödendi: " + miktar + " TL.");
        } else {
            System.out.println("Yetersiz bakiye! Kredi kartı aidatı ödenemedi.");
        }
        System.out.println("Kalan Bakiye: " + hesap.getBakiye() + " TL");
    }
}
