package Hesaplar;

public class VadeliHesap extends Hesap {

    private double faizOrani;

    public VadeliHesap(String tcKimlikNo, double bakiye, String sifre, double faizOrani) {
        super(tcKimlikNo, bakiye, sifre);
        this.faizOrani = faizOrani;
    }

    public double getFaizOrani() {
        return faizOrani;
    }

    public void setFaizOrani(double faizOrani) {
        this.faizOrani = faizOrani;
    }

    @Override
    public void paraCek(double miktar) {
        if (miktar > 0 && miktar <= getBakiye()) {
            setBakiye(getBakiye() - miktar);
            System.out.println(miktar + " TL çekildi. Güncel bakiye: " + getBakiye() + " TL.");
        } else {
            System.out.println("Geçersiz işlem! Yetersiz bakiye veya negatif miktar.");
        }
    }

    @Override
    public String hesapBilgisi() {
        return "Vadeli Hesap - Hesap No: " + getTcKimlikNo() + ", Bakiye: " + getBakiye() + " TL, Faiz Oranı: " + faizOrani + "%.";
    }
}
