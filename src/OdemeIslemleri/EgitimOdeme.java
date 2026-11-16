package OdemeIslemleri;

import Hesaplar.Hesap;

public class EgitimOdeme {

    public void egitimOde(Hesap hesap, double miktar) {
        if (miktar <= hesap.getBakiye()) {
            hesap.setBakiye(hesap.getBakiye() - miktar);
            System.out.println("Eğitim ödemesi yapıldı: " + miktar + " TL.");
        } else {
            System.out.println("Yetersiz bakiye! Eğitim ödemesi yapılamadı.");
        }
        System.out.println("Kalan Bakiye: " + hesap.getBakiye() + " TL");
    }
}
