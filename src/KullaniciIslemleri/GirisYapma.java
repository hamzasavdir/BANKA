package KullaniciIslemleri;

import java.util.Scanner;

public class GirisYapma {
    public boolean kullaniciGirisi(Kullanici kullanici) {
        if (kullanici == null) {
            System.out.println("Hesap bulunamadı!");
            return false;
        }

        Scanner scanner = new Scanner(System.in);
        System.out.print("TC Kimlik Numaranızı giriniz: ");
        String girilenTc = scanner.nextLine();

        System.out.print("Şifrenizi giriniz: ");
        String girilenSifre = scanner.nextLine();

        if (kullanici.getTcKimlikNo().equals(girilenTc) && kullanici.getSifre().equals(girilenSifre)) {
            System.out.println("Başarıyla giriş yaptınız. Hoş geldiniz, " + kullanici.getAd() + "!");
            return true;
        } else {
            System.out.println("Hatalı giriş! TC Kimlik Numaranız veya şifreniz yanlış.");
            return false;
        }
    }
}

