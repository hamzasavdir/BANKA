package Guvenlik;

public class GirdiDogrulama {

    // TC Kimlik No Doğrulama
    public static boolean tcKimlikNoDogrula(String tcKimlikNo) {
        return tcKimlikNo.matches("\\d{11}");
    }

    // Şifre Doğrulama (4 Rakam)
    public static boolean sifreDogrula(String sifre) {
        return sifre.matches("\\d{4}");
    }

    // Ad Soyad ve Kurum Adı Doğrulama (Sadece Harfler ve Türkçe Karakterler)
    public static boolean adSoyadDogrula(String adSoyad) {
        return adSoyad.matches("^[a-zA-ZığüşöçİĞÜŞÖÇ]+$");
    }

    // Seçim Doğrulama (Menü için)
    public static boolean secimDogrula(int secim, int min, int max) {
        return secim >= min && secim <= max;
    }
}
