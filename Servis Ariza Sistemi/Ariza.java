/**
 * @file Ariza
 * @description Servis - Ariza Sistemi (Bir servisin verdiği hizmetin yani Randevularının ve müşterilerin araçlarını bir
 * tekniker ile onarıp gerekli kontrollerin yapıldığı program)
 * @assignment 2
 * @date 23.01.2022
 * @author Şahan Aytekin - 2021221033
 */

package ProjeÖdevi_2;

public class Ariza {

    private int arizaId;
    private String ad;
    private int tamirSuresi;
    private double fiyat;

    public Ariza(int arizaId, String ad, int tamirSuresi, double fiyat) {
        try {
            if (fiyat == 0){
                throw new MyException("Arizanın bir fiyatı olması gerekiyor.");
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        this.arizaId = arizaId;
        this.ad = ad;
        this.tamirSuresi = tamirSuresi;
        this.fiyat = fiyat;
    }

    public int getArizaId() {
        return arizaId;
    }

    public String getAd() {
        return ad;
    }

    public int getTamirSuresi() {
        return tamirSuresi;
    }

    public double getFiyat() {
        return fiyat;
    }

    //------------------------------------------------------------------------------------------------------------------

    public void arizaBilgisi() {
        System.out.println("Arızanın adı: " + this.getAd() + "\nTahmini tamir süresi: " + getTamirSuresi() + "Saat\nFiyatı: " + this.getFiyat() + "TL");
    }


}