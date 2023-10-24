/**
 * @file Musteri
 * @description Servis - Ariza Sistemi (Bir servisin verdiği hizmetin yani Randevularının ve müşterilerin araçlarını bir
 * tekniker ile onarıp gerekli kontrollerin yapıldığı program)
 * @assignment 2
 * @date 23.01.2022
 * @author Şahan Aytekin - 2021221033
 */

package ProjeÖdevi_2;

public class Musteri extends Insan {

    private double bakiye;
    private int randevuSayisi;
    private double harcananMiktar;
    private Randevu[] randevuListesi = new Randevu[10];

    public Musteri(int id, String adSoyad, double bakiye) {
        super(id, adSoyad);
        this.bakiye = bakiye;
    }

    @Override
    public String getAdSoyad() {
        return super.getAdSoyad();
    }

    @Override
    public int getId() {
        return super.getId();
    }

    public double getBakiye() {
        return bakiye;
    }

    public int getRandevuSayisi() {
        return randevuSayisi;
    }

    public void setRandevuSayisi(int randevuSayisi) {
        this.randevuSayisi = randevuSayisi;
    }

    public double getHarcananMiktar() {
        return harcananMiktar;
    }


    //------------------------------------------------------------------------------------------------------------------

    public void musteriBilgileri() {
        System.out.println("Müşterinin Adı: " + this.getAdSoyad() + "\nMüşteri Bakiyesi : " + this.getBakiye());
    }


    public void paraHarca(double para) {   // bir müşterinin para harcaması ile eksilen bakiyesi ve harcadığı miktarın artmasını sağlayan metot..
        bakiye -= para;
        harcananMiktar += para;
    }

    public void randevuEkle(Randevu randevu) {   // müşteriye randevu ekeleme..
        for (int i = 0; i < randevuListesi.length; i++) {
            if (randevuListesi[i] == null) {
                randevuListesi[i] = randevu;
                break;
            }
        }
    }


    public void randevuCikar(Randevu randevu) {   // müşteriden randevu çıkarma..
        for (int i = 0; i < randevuListesi.length; i++) {
            if (randevuListesi[i] == randevu) {
                randevuListesi[i] = null;
                break;
            }
        }
    }

    public void randevuListele() {  // musterinin randevularını listeleyen metot..
        // randevu listesinin doluluğu kontrol ediliyor.
        boolean bosMu = false;

        for (int i = 0; i < this.randevuListesi.length; i++) {
            if (this.randevuListesi[i] != null) {
                System.out.println("Randevu sahibi:" + this.getAdSoyad() + "\nRandevu Bilgileri => " + this.randevuListesi[i].randevuBilgisi());
                bosMu = true;
            }
        }

        if (!bosMu) {
            System.out.println("Randevu listesi boş..");
        }
    }


}