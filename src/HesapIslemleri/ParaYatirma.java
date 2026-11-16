package HesapIslemleri;

import Hesaplar.Hesap;

public class ParaYatirma {

    public void paraYatir(Hesap hesap, double miktar) {
        hesap.setBakiye(hesap.getBakiye() + miktar);
        System.out.println(miktar + " TL hesabınıza yatırıldı.");
        System.out.println("Kalan Bakiye: " + hesap.getBakiye() + " TL");
    }
}
