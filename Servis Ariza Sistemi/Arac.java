/**
 * @file Arac
 * @description Servis - Ariza Sistemi (Bir servisin verdiği hizmetin yani Randevularının ve müşterilerin araçlarını bir
 * tekniker ile onarıp gerekli kontrollerin yapıldığı program)
 * @assignment 2
 * @date 23.01.2022
 * @author Şahan Aytekin - 2021221033
 */

package ProjeÖdevi_2;

public class Arac {

    private int aracId;
    private String marka;
    private Musteri musteri;
    private Ariza[] arizaListesi = new Ariza[10];

    public Arac(int aracId, String marka, Musteri musteri) {
        try {
            if (musteri == null){
                throw new MyException("Her aracın bir sahibi olması gerekiyor...");
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        this.aracId = aracId;
        this.marka = marka;
        this.musteri = musteri;
    }

    public int getAracId() {
        return aracId;
    }

    public String getMarka() {
        return marka;
    }

    public Musteri getMusteri() {
        return musteri;
    }

    public Ariza[] getArizaListesi() {
        return arizaListesi;
    }

    //------------------------------------------------------------------------------------------------------------------

    public void aracBilgisi() {
        System.out.println("Arabanın sahibi " + getMusteri().getAdSoyad() + " - Aracın Markası: " + getMarka());
    }
}