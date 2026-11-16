package Guvenlik;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class KayitTutucu {
    private static final String LOG_DOSYASI = "log.txt";

    // İşlem Kaydet
    public static void islemKaydet(String islem) {
        try (FileWriter writer = new FileWriter(LOG_DOSYASI, true)) {
            String zamanDamgasi = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            writer.write(zamanDamgasi + " - " + islem + "\n");
        } catch (IOException e) {
            System.out.println("Log kaydedilemedi: " + e.getMessage());
        }
    }

    // Kayıt Bilgilendirmesi
    public static void kayitBilgilendirme(String mesaj) {
        System.out.println("LOG: " + mesaj);
    }
}
