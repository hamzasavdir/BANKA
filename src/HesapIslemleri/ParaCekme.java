package HesapIslemleri;

import Hesaplar.Hesap;

public class ParaCekme {

    public void paraCek(Hesap hesap, double miktar) {
        if (miktar <= hesap.getBakiye()) {
            hesap.setBakiye(hesap.getBakiye() - miktar);
            System.out.println(miktar + " TL hesabınızdan çekildi.");
        } else {
            System.out.println("Yetersiz bakiye! Lütfen daha düşük bir miktar giriniz.");
        }
        System.out.println("Kalan Bakiye: " + hesap.getBakiye() + " TL");
    }
}
