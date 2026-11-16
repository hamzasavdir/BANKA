package Guvenlik;

import java.util.Scanner;

public class GirisCikisKontrolu {

    private static final Scanner scanner = new Scanner(System.in);

    /**
     * Kullanıcıdan belirtilen aralıkta geçerli bir seçim alır.
     *
     * @param min Minimum değer.
     * @param max Maksimum değer.
     * @return Geçerli seçim.
     */
    public static int gecerliSecimAl(int min, int max) {
        int secim = -1;
        boolean gecerli = false;

        while (!gecerli) {
            try {
                System.out.print("Seçiminizi yapınız (" + min + "-" + max + "): ");
                secim = Integer.parseInt(scanner.nextLine());

                if (secim >= min && secim <= max) {
                    gecerli = true;
                } else {
                    System.out.println("Geçersiz giriş! Lütfen " + min + " ile " + max + " arasında bir değer giriniz.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Geçersiz giriş! Lütfen bir sayı giriniz.");
            }
        }
        return secim;
    }

    /**
     * Kullanıcıya devam etmek isteyip istemediğini sorar.
     *
     * @return Evet ise true, hayır ise false.
     */
    public static boolean devamEtmekIstiyorMusunuz() {
        while (true) {
            System.out.print("Başka bir işlem yapmak istiyor musunuz? (E/H): ");
            String cevap = scanner.nextLine().trim().toUpperCase();

            if (cevap.equals("E")) {
                return true;
            } else if (cevap.equals("H")) {
                return false;
            } else {
                System.out.println("Geçersiz giriş! Lütfen 'E' veya 'H' giriniz.");
            }
        }
    }
}
