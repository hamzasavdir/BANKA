package Yonetim;

import HesapOzeti.HesapOzetiHazirlama;
import Hesaplar.BireyselHesap;
import Hesaplar.Hesap;
import Hesaplar.KurumsalHesap;
import KullaniciIslemleri.HesapOlusturma;
import Musteri.MusteriMemnuniyeti;
import Guvenlik.GirisCikisKontrolu;

import java.util.HashMap;
import java.util.Scanner;

public class Main {

    private static final HashMap<String, Hesap> hesaplar = new HashMap<>();
    private static final HesapOzetiHazirlama hesapOzeti = new HesapOzetiHazirlama();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("--- Banka Sistemine Hoş Geldiniz ---");

        boolean devam = true;
        while (devam) {
            System.out.println("Lütfen bir işlem seçiniz:");
            System.out.println("1: Hesap Oluştur");
            System.out.println("2: Giriş Yap");
            System.out.println("3: Çıkış");

            int secim = GirisCikisKontrolu.gecerliSecimAl(1, 3);

            switch (secim) {
                case 1 -> hesapOlustur();
                case 2 -> girisYap();
                case 3 -> {
                    System.out.println("Çıkış yapılıyor. İyi günler!");
                    devam = false;
                }
            }
        }
    }

    private static void hesapOlustur() {
        System.out.println("--- Hesap Türünüzü Seçiniz ---");
        System.out.println("1: Bireysel Hesap");
        System.out.println("2: Kurumsal Hesap");

        int hesapTuru = GirisCikisKontrolu.gecerliSecimAl(1, 2);

        if (hesapTuru == 1) {
            BireyselHesap bireyselHesap = HesapOlusturma.yeniKullaniciOlustur();
            hesaplar.put(bireyselHesap.getTcKimlikNo(), bireyselHesap);
        } else if (hesapTuru == 2) {
            KurumsalHesap kurumsalHesap = HesapOlusturma.yeniKurumHesabiOlustur();
            hesaplar.put(kurumsalHesap.getTcKimlikNo(), kurumsalHesap);
        }

        System.out.println("Hesabınız başarıyla oluşturuldu.");
    }

    private static void girisYap() {
        System.out.print("Lütfen TC Kimlik Numaranızı giriniz: ");
        String tcKimlikNo = scanner.nextLine().trim();

        System.out.print("Lütfen şifrenizi giriniz: ");
        String sifre = scanner.nextLine().trim();

        Hesap hesap = hesaplar.get(tcKimlikNo);

        if (hesap != null && hesap.getSifre().equals(sifre)) {
            System.out.println("Giriş başarılı! Hoş geldiniz, " + tcKimlikNo);
            islemMenusu(hesap);
        } else {
            System.out.println("Hatalı giriş! Lütfen tekrar deneyiniz.");
        }
    }

    private static void islemMenusu(Hesap hesap) {
        boolean devam = true;

        while (devam) {
            System.out.println("--- İşlem Menüsü ---");
            System.out.println("1: Para Çekme");
            System.out.println("2: Para Yatırma");
            System.out.println("3: Altın İşlemleri");
            System.out.println("4: Kripto Para İşlemleri");
            System.out.println("5: Ödeme İşlemleri");
            System.out.println("6: Fon İşlemleri");
            System.out.println("7: Hisse İşlemleri");
            System.out.println("8: Havale İşlemleri");
            System.out.println("9: Hesap Özeti Görüntüleme");
            System.out.println("10: Çıkış");

            int secim = GirisCikisKontrolu.gecerliSecimAl(1, 10);

            switch (secim) {
                case 1 -> paraCek(hesap);
                case 2 -> paraYatir(hesap);
                case 3 -> altinIslemleri(hesap);
                case 4 -> kriptoParaIslemleri(hesap);
                case 5 -> odemeIslemleri(hesap);
                case 6 -> fonIslemleri(hesap);
                case 7 -> hisseIslemleri(hesap);
                case 8 -> havaleIslemleri(hesap);
                case 9 -> hesapOzeti.hesapOzetiGoster();
                case 10 -> {
                    System.out.println("Çıkış yapılıyor.");
                    MusteriMemnuniyeti memnuniyet = new MusteriMemnuniyeti();
                    memnuniyet.oylamaBaslat();
                    devam = false;
                }
            }
        }
    }

    private static void paraCek(Hesap hesap) {
        System.out.print("Çekmek istediğiniz miktarı giriniz: ");
        double miktar = scanner.nextDouble();
        scanner.nextLine();

        hesap.paraCek(miktar);
        hesapOzeti.islemEkle("Para çekildi: " + miktar + " TL.");
    }

    private static void paraYatir(Hesap hesap) {
        System.out.print("Yatırmak istediğiniz miktarı giriniz: ");
        double miktar = scanner.nextDouble();
        scanner.nextLine();

        hesap.paraYatir(miktar);
        hesapOzeti.islemEkle("Para yatırıldı: " + miktar + " TL.");
    }

    private static void altinIslemleri(Hesap hesap) {
        System.out.println("--- Altın İşlemleri ---");
        System.out.println("1: Altın Alımı");
        System.out.println("2: Altın Satımı");

        int secim = GirisCikisKontrolu.gecerliSecimAl(1, 2);

        switch (secim) {
            case 1 -> {
                System.out.print("Almak istediğiniz altın miktarını gram cinsinden giriniz: ");
                double miktar = scanner.nextDouble();
                scanner.nextLine();
                hesap.paraCek(miktar * 3000); // Altın birim fiyatı
                hesapOzeti.islemEkle("Altın alındı: " + miktar + " gram.");
            }
            case 2 -> {
                System.out.print("Satmak istediğiniz altın miktarını gram cinsinden giriniz: ");
                double miktar = scanner.nextDouble();
                scanner.nextLine();
                hesap.paraYatir(miktar * 3000);
                hesapOzeti.islemEkle("Altın satıldı: " + miktar + " gram.");
            }
        }
    }

    private static void kriptoParaIslemleri(Hesap hesap) {
        System.out.println("--- Kripto Para İşlemleri ---");
        System.out.println("1: Kripto Para Alımı");
        System.out.println("2: Kripto Para Satımı");

        int secim = GirisCikisKontrolu.gecerliSecimAl(1, 2);

        switch (secim) {
            case 1 -> {
                System.out.print("Almak istediğiniz tutarı giriniz: ");
                double tutar = scanner.nextDouble();
                scanner.nextLine();
                hesap.paraCek(tutar);
                hesapOzeti.islemEkle("Kripto para alındı: " + tutar + " TL.");
            }
            case 2 -> {
                System.out.print("Satmak istediğiniz tutarı giriniz: ");
                double tutar = scanner.nextDouble();
                scanner.nextLine();
                hesap.paraYatir(tutar);
                hesapOzeti.islemEkle("Kripto para satıldı: " + tutar + " TL.");
            }
        }
    }

    private static void odemeIslemleri(Hesap hesap) {
        System.out.println("--- Ödeme İşlemleri ---");
        System.out.println("1: Fatura Ödeme");
        if (hesap instanceof KurumsalHesap) {
            System.out.println("2: Vergi Ödeme");
        }
        System.out.println("3: Eğitim Ödemesi");
        System.out.println("4: Kredi Kartı Aidatı Ödemesi");
        System.out.println("5: Çıkış");

        int secim = hesap instanceof KurumsalHesap
                ? GirisCikisKontrolu.gecerliSecimAl(1, 5)
                : GirisCikisKontrolu.gecerliSecimAl(1, 4);

        switch (secim) {
            case 1 -> faturaOdeme(hesap);
            case 2 -> {
                if (hesap instanceof KurumsalHesap) {
                    vergiOdeme((KurumsalHesap) hesap);
                } else {
                    System.out.println("Bu işlem sadece kurumsal hesaplar için geçerlidir.");
                }
            }
            case 3 -> egitimOdeme(hesap);
            case 4 -> krediKartAidatiOdeme(hesap);
            case 5 -> System.out.println("Ödeme işlemleri menüsünden çıkılıyor...");
        }
    }

    private static void faturaOdeme(Hesap hesap) {
        System.out.print("Ödenecek fatura tutarını giriniz: ");
        double tutar = scanner.nextDouble();
        scanner.nextLine();

        hesap.paraCek(tutar);
        hesapOzeti.islemEkle("Fatura ödendi: " + tutar + " TL.");
    }

    private static void vergiOdeme(KurumsalHesap hesap) {
        System.out.print("Ödenecek vergi tutarını giriniz: ");
        double tutar = scanner.nextDouble();
        scanner.nextLine();

        if (hesap.getBakiye() >= tutar) {
            hesap.paraCek(tutar);
            hesapOzeti.islemEkle("Vergi ödendi: " + tutar + " TL.");
            System.out.println("Vergi ödeme işlemi başarılı. Güncel bakiye: " + hesap.getBakiye() + " TL.");
        } else {
            System.out.println("Yetersiz bakiye! Vergi ödeme işlemi gerçekleştirilemedi.");
        }
    }

    private static void egitimOdeme(Hesap hesap) {
        System.out.print("Ödenecek eğitim tutarını giriniz: ");
        double tutar = scanner.nextDouble();
        scanner.nextLine();

        if (hesap.getBakiye() >= tutar) {
            hesap.paraCek(tutar);
            hesapOzeti.islemEkle("Eğitim ödemesi yapıldı: " + tutar + " TL.");
            System.out.println("Eğitim ödeme işlemi başarılı. Güncel bakiye: " + hesap.getBakiye() + " TL.");
        } else {
            System.out.println("Yetersiz bakiye! Eğitim ödeme işlemi gerçekleştirilemedi.");
        }
    }

    private static void krediKartAidatiOdeme(Hesap hesap) {
        System.out.print("Kredi kartı aidat tutarını giriniz: ");
        double tutar = scanner.nextDouble();
        scanner.nextLine();

        if (hesap.getBakiye() >= tutar) {
            hesap.paraCek(tutar);
            hesapOzeti.islemEkle("Kredi kartı aidatı ödendi: " + tutar + " TL.");
            System.out.println("Kredi kartı aidatı ödeme işlemi başarılı. Güncel bakiye: " + hesap.getBakiye() + " TL.");
        } else {
            System.out.println("Yetersiz bakiye! Kredi kartı aidatı ödeme işlemi gerçekleştirilemedi.");
        }
    }

    private static void fonIslemleri(Hesap hesap) {
        System.out.println("--- Fon İşlemleri ---");
        System.out.println("1: Fon Alımı");
        System.out.println("2: Fon Satımı");

        int secim = GirisCikisKontrolu.gecerliSecimAl(1, 2);

        switch (secim) {
            case 1 -> fonAl(hesap);
            case 2 -> fonSat(hesap);
        }
    }

    private static void fonAl(Hesap hesap) {
        System.out.print("Almak istediğiniz fon miktarını giriniz: ");
        double miktar = scanner.nextDouble();
        scanner.nextLine();

        if (hesap.getBakiye() >= miktar) {
            hesap.paraCek(miktar);
            hesapOzeti.islemEkle("Fon alındı: " + miktar + " TL.");
            System.out.println("Fon alım işlemi başarılı. Güncel bakiye: " + hesap.getBakiye() + " TL.");
        } else {
            System.out.println("Yetersiz bakiye! Fon alım işlemi gerçekleştirilemedi.");
        }
    }

    private static void fonSat(Hesap hesap) {
        System.out.print("Satmak istediğiniz fon miktarını giriniz: ");
        double miktar = scanner.nextDouble();
        scanner.nextLine();

        hesap.paraYatir(miktar);
        hesapOzeti.islemEkle("Fon satıldı: " + miktar + " TL.");
        System.out.println("Fon satış işlemi başarılı. Güncel bakiye: " + hesap.getBakiye() + " TL.");
    }

    private static void hisseIslemleri(Hesap hesap) {
        System.out.println("--- Hisse İşlemleri ---");
        System.out.println("1: Hisse Alımı");
        System.out.println("2: Hisse Satımı");

        int secim = GirisCikisKontrolu.gecerliSecimAl(1, 2);

        switch (secim) {
            case 1 -> hisseAl(hesap);
            case 2 -> hisseSat(hesap);
        }
    }

    private static void hisseAl(Hesap hesap) {
        System.out.print("Almak istediğiniz hisse miktarını giriniz: ");
        int miktar = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Hissenin birim fiyatını giriniz: ");
        double birimFiyat = scanner.nextDouble();
        scanner.nextLine();

        double toplamTutar = miktar * birimFiyat;

        if (hesap.getBakiye() >= toplamTutar) {
            hesap.paraCek(toplamTutar);
            hesapOzeti.islemEkle("Hisse alındı: " + miktar + " adet, toplam " + toplamTutar + " TL.");
            System.out.println("Hisse alım işlemi başarılı. Güncel bakiye: " + hesap.getBakiye() + " TL.");
        } else {
            System.out.println("Yetersiz bakiye! Hisse alım işlemi gerçekleştirilemedi.");
        }
    }

    private static void hisseSat(Hesap hesap) {
        System.out.print("Satmak istediğiniz hisse miktarını giriniz: ");
        int miktar = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Hissenin birim fiyatını giriniz: ");
        double birimFiyat = scanner.nextDouble();
        scanner.nextLine();

        double toplamTutar = miktar * birimFiyat;

        hesap.paraYatir(toplamTutar);
        hesapOzeti.islemEkle("Hisse satıldı: " + miktar + " adet, toplam " + toplamTutar + " TL.");
        System.out.println("Hisse satış işlemi başarılı. Güncel bakiye: " + hesap.getBakiye() + " TL.");
    }

    private static void havaleIslemleri(Hesap hesap) {
        System.out.println("--- Havale İşlemleri ---");
        System.out.print("Havale yapmak istediğiniz hesap numarasını giriniz: ");
        String hedefHesapNo = scanner.nextLine();

        Hesap hedefHesap = hesaplar.get(hedefHesapNo);

        if (hedefHesap == null) {
            System.out.println("Hedef hesap bulunamadı! Lütfen doğru hesap numarasını giriniz.");
            return;
        }

        System.out.print("Havale tutarını giriniz: ");
        double tutar = scanner.nextDouble();
        scanner.nextLine();

        if (hesap.getBakiye() >= tutar) {
            hesap.paraCek(tutar);
            hedefHesap.paraYatir(tutar);
            hesapOzeti.islemEkle("Havale yapıldı: " + tutar + " TL. Hedef hesap: " + hedefHesapNo);
            System.out.println("Havale işlemi başarılı. Güncel bakiye: " + hesap.getBakiye() + " TL.");
        } else {
            System.out.println("Yetersiz bakiye! Havale işlemi gerçekleştirilemedi.");
        }
    }
}