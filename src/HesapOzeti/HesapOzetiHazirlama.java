package HesapOzeti;

import java.util.ArrayList;
import java.util.List;

public class HesapOzetiHazirlama {

    private final List<String> islemler; // İşlem geçmişini tutar

    /**
     * Hesap özeti sınıfının constructor'ı.
     */
    public HesapOzetiHazirlama() {
        this.islemler = new ArrayList<>();
    }

    /**
     * Yeni bir işlem ekler.
     *
     * @param islem İşlem bilgisi.
     */
    public void islemEkle(String islem) {
        islemler.add(islem);
    }

    /**
     * Hesap özetini gösterir.
     */
    public void hesapOzetiGoster() {
        if (islemler.isEmpty()) {
            System.out.println("Henüz bir işlem yapılmadı.");
        } else {
            System.out.println("Hesap Özeti:");
            for (int i = 0; i < islemler.size(); i++) {
                System.out.println((i + 1) + ". " + islemler.get(i));
            }
        }
    }

    /**
     * İşlem geçmişini temizler.
     */
    public void islemGecmisiTemizle() {
        islemler.clear();
        System.out.println("İşlem geçmişi temizlendi.");
    }
}