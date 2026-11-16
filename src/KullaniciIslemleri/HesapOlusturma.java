package KullaniciIslemleri;

import Guvenlik.GirdiDogrulama;
import Hesaplar.BireyselHesap;
import Hesaplar.KurumsalHesap;

import java.util.Scanner;

public class HesapOlusturma {

    private static final Scanner scanner = new Scanner(System.in);

    /**
     * Yeni bireysel kullanıcı oluşturur.
     * @return Oluşturulan bireysel hesap.
     */
    public static BireyselHesap yeniKullaniciOlustur() {
        String tcKimlikNo = alGirdi("TC Kimlik Numaranız (11 rakam): ", GirdiDogrulama::tcKimlikNoDogrula, "Geçersiz TC Kimlik Numarası! 11 rakam olmalıdır.");
        String ad = alGirdi("Adınız: ", GirdiDogrulama::adSoyadDogrula, "Geçersiz ad! Sadece harflerden oluşmalıdır.");
        String soyad = alGirdi("Soyadınız: ", GirdiDogrulama::adSoyadDogrula, "Geçersiz soyad! Sadece harflerden oluşmalıdır.");
        String sifre = alGirdi("Şifreniz (4 rakam): ", GirdiDogrulama::sifreDogrula, "Geçersiz şifre! 4 rakam olmalıdır.");

        System.out.println("Bireysel hesabınız başarıyla oluşturuldu!");
        return new BireyselHesap(tcKimlikNo, 0.0, ad, soyad, sifre);
    }

    /**
     * Yeni kurumsal kullanıcı oluşturur.
     * @return Oluşturulan kurumsal hesap.
     */
   /* public static KurumsalHesap yeniKurumHesabiOlustur() {
        String kurumAdi = alGirdi("Kurum Adı: ", GirdiDogrulama::adSoyadDogrula, "Geçersiz kurum adı! Sadece harflerden oluşmalıdır.");
        String vergiNo = alGirdi("Vergi Numarası (10 rakam): ", GirdiDogrulama::VergiOdeme, "Geçersiz vergi numarası! 10 rakam olmalıdır.");
        String sifre = alGirdi("Şifreniz (4 rakam): ", GirdiDogrulama::sifreDogrula, "Geçersiz şifre! 4 rakam olmalıdır.");

        System.out.println("Kurumsal hesabınız başarıyla oluşturuldu!");
        return new KurumsalHesap(vergiNo, 0.0, kurumAdi, sifre);
    }*/
    public static KurumsalHesap yeniKurumHesabiOlustur() {
        System.out.print("Kurum Adı: ");
        String kurumAdi = scanner.nextLine().trim();

        System.out.print("Vergi Numarası (10 rakam): ");
        String vergiNo = scanner.nextLine().trim();

        System.out.print("Şifreniz (4 rakam): ");
        String sifre = scanner.nextLine().trim();

        return new KurumsalHesap(vergiNo, 0.0, kurumAdi, sifre);
    }


    /**
     * Kullanıcıdan geçerli bir giriş alır.
     * @param mesaj Kullanıcıya gösterilecek mesaj.
     * @param dogrulama Doğrulama işlemini yapan fonksiyon.
     * @param hataMesaji Geçersiz giriş için gösterilecek hata mesajı.
     * @return Geçerli giriş.
     */
    private static String alGirdi(String mesaj, GirdiDogrulamaInterface dogrulama, String hataMesaji) {
        while (true) {
            System.out.print(mesaj);
            String girdi = scanner.nextLine().trim();
            if (dogrulama.dogrula(girdi)) {
                return girdi;
            } else {
                System.out.println(hataMesaji);
            }
        }
    }

    @FunctionalInterface
    interface GirdiDogrulamaInterface {
        boolean dogrula(String girdi);
    }
}
