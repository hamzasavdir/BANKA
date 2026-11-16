package OdemeIslemleri;

import Hesaplar.Hesap;
import Ortak.OdemeIslemi;

public class FaturaOdeme implements OdemeIslemi {

    @Override
    public void odenebilirMi(double bakiye, double tutar) {
        if (bakiye >= tutar) {
            System.out.println("Fatura ödendi: " + tutar + " TL.");
        } else {
            System.out.println("Yetersiz bakiye! Fatura ödenemedi.");
        }
    }

    @Override
    public void islemiGerceklestir() {
        // İşlem detayları buraya eklenecek.
    }
}

