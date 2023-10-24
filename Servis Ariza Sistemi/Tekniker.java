/**
 * @file Tekniker
 * @description Servis - Ariza Sistemi (Bir servisin verdiği hizmetin yani Randevularının ve müşterilerin araçlarını bir
 * tekniker ile onarıp gerekli kontrollerin yapıldığı program)
 * @assignment 2
 * @date 23.01.2022
 * @author Şahan Aytekin - 2021221033
 */

package ProjeÖdevi_2;

public class Tekniker extends Insan {

    private double ciro;
    private Ariza[] arizaListesi = new Ariza[20];

    public Tekniker(int id, String adSoyad) {
        super(id, adSoyad);
    }

    @Override
    public String getAdSoyad() {
        return super.getAdSoyad();
    }

    @Override
    public int getId() {
        return super.getId();
    }

    public double getCiro() {
        return ciro;
    }


    //------------------------------------------------------------------------------------------------------------------
    public void teknikerBilgileri() {
        System.out.println("Teknikerin Adı: " + this.getAdSoyad());
    }


    public void paraKazan(double para) { // serviste onarım yapmış teknikerin kazandığı net paranın yani cirosunu arttırıan metot..
        ciro += para;
    }


    public void arizaEkle(Ariza ariza) {  // Teknikerin ilgilendiği arızaları ekleme..
        for (int i = 0; i < arizaListesi.length; i++) {
            if (arizaListesi[i] == null) {
                arizaListesi[i] = ariza;
                break;
            }
        }
    }


    public void arizaCikar(Ariza ariza) {  // Teknikerden arıza çıkarma..
        for (int i = 0; i < arizaListesi.length; i++) {
            if (arizaListesi[i] == ariza) {
                arizaListesi[i] = null;
                break;
            }
        }
    }


    public void arizaListele() {  // Teknikerin kendisine ait olan arizaların listelenmesi..
        System.out.println("Teknikerin Aktif Arizalar...");
        for (int i = 0; i < arizaListesi.length; i++) {
            if (arizaListesi[i] != null) {
                arizaListesi[i].arizaBilgisi();

            }
        }
    }
}