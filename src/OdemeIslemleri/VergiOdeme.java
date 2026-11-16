package OdemeIslemleri;

import Hesaplar.Hesap;

public class VergiOdeme {

    public void vergiOde(Hesap hesap, double miktar) {
        if (miktar <= hesap.getBakiye()) {
            hesap.setBakiye(hesap.getBakiye() - miktar);
            System.out.println("Vergi ödendi: " + miktar + " TL.");
        } else {
            System.out.println("Yetersiz bakiye! Vergi ödemesi yapılamadı.");
        }
        System.out.println("Kalan Bakiye: " + hesap.getBakiye() + " TL");
    }
}
