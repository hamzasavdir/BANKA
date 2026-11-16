package HesapIslemleri;

import Hesaplar.Hesap;

public class HavaleYapma {

    public void havaleYap(Hesap gonderenHesap, Hesap aliciHesap, double miktar) {
        if (miktar <= gonderenHesap.getBakiye()) {
            gonderenHesap.setBakiye(gonderenHesap.getBakiye() - miktar);
            aliciHesap.setBakiye(aliciHesap.getBakiye() + miktar);
            System.out.println(miktar + " TL havale yapıldı.");
        } else {
            System.out.println("Yetersiz bakiye! Havale yapılamadı.");
        }
        System.out.println("Gönderen Kalan Bakiye: " + gonderenHesap.getBakiye() + " TL");
        System.out.println("Alıcı Kalan Bakiye: " + aliciHesap.getBakiye() + " TL");
    }
}
