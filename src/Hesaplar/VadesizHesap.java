package Hesaplar;

public class VadesizHesap extends Hesap {

    // Constructor
    public VadesizHesap(String tcKimlikNo, double bakiye, String sifre) {
        super(tcKimlikNo, bakiye, sifre);
    }

    @Override
    public void paraCek(double miktar) {
        if (miktar > 0 && miktar <= this.getBakiye()) {
            this.setBakiye(this.getBakiye() - miktar);
            System.out.println(miktar + " TL vadesiz hesabınızdan çekildi.");
        } else {
            System.out.println("Yetersiz bakiye! Lütfen daha düşük bir miktar giriniz.");
        }
        System.out.println("Kalan Bakiye: " + this.getBakiye() + " TL");
    }

    @Override
    public String hesapBilgisi() {
        return "Vadesiz Hesap - Hesap No: " + this.getTcKimlikNo() + ", Bakiye: " + this.getBakiye() + " TL.";
    }
}
