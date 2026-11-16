package Musteri;

import java.util.Scanner;

public class MusteriMemnuniyeti {

    private int memnuniyetPuani;

    /**
     * Kullanıcıdan memnuniyet puanı toplar.
     */
    public void oylamaBaslat() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Lütfen müşteri memnuniyetinizi 1 ile 5 arasında bir puanla oylayın:");
        System.out.println("1: Çok Kötü, 2: Kötü, 3: Orta, 4: İyi, 5: Çok İyi");

        while (true) {
            try {
                int puan = Integer.parseInt(scanner.nextLine());
                if (puan >= 1 && puan <= 5) {
                    this.memnuniyetPuani = puan;
                    System.out.println("Oylamanız için teşekkür ederiz!");
                    System.out.println("Bizi tercih ettiğiniz için teşekkürler!");
                    break;
                } else {
                    System.out.println("Geçersiz puan! Lütfen 1 ile 5 arasında bir değer giriniz:");
                }
            } catch (NumberFormatException e) {
                System.out.println("Lütfen geçerli bir sayı giriniz!");
            }
        }
    }

    /**
     * Müşteri memnuniyet puanını döner.
     *
     * @return Memnuniyet puanı.
     */
    public int getMemnuniyetPuani() {
        return memnuniyetPuani;
    }

    /**
     * Müşteri memnuniyet anketi hakkında daha fazla bilgi sağlayabilir.
     */
    public void memnuniyetAnketi() {
        System.out.println("Memnuniyet anketimiz, sizlere daha iyi hizmet verebilmek adına düzenlenmiştir.");
        System.out.println("Değerli görüşleriniz için teşekkür ederiz!");
    }
}
