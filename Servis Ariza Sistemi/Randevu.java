/**
 * @file Randevu
 * @description Servis - Ariza Sistemi (Bir servisin verdiği hizmetin yani Randevularının ve müşterilerin araçlarını bir
 * tekniker ile onarıp gerekli kontrollerin yapıldığı program)
 * @assignment 2
 * @date 23.01.2022
 * @author Şahan Aytekin - 2021221033
 */

package ProjeÖdevi_2;

public class Randevu {

    private int randevuId;
    private String tarih;
    private int[] gunler = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};  // 12 ay ve ayların sahip olduğu günler..
    private Tekniker tekniker;

    public Randevu(int randevuId, String tarih) {
        try {
            if (tarih == null) {
                throw new MyException("Tarih boş bırakılamaz");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        this.randevuId = randevuId;
        this.tarih = tarih;
    }

    public int getRandevuId() {
        return randevuId;
    }

    public String getTarih() {
        return tarih;
    }


    //------------------------------------------------------------------------------------------------------------------
    public String randevuBilgisi() {
        return "" + "ID: " + this.getRandevuId() + ",  Tarihi: " + this.getTarih();
    }


    public int[] tarihiIntegerCevirme(String tarih) {    // String olan tarihi int olarak ayırıp incelemek için yapılmış metot..

        int[] date = new int[3];
        int index = 0;

        String parca = "";
        for (int i = 0; i < tarih.length(); i++) {
            if (tarih.charAt(i) == '.') {
                date[index++] = Integer.parseInt(parca);
                parca = "";
            } else {
                parca += tarih.charAt(i);
            }
        }
        date[index] = Integer.parseInt(parca);
        return date;
    }


    public boolean degisiyorMu(String bugunTarihi, Randevu randevu) {   // randevu tarihi değişiyor mu diye kontrol ettiğim yer (1 Gün öncesinde değiştirilmiyor..)

        int[] bugun = tarihiIntegerCevirme(bugunTarihi);
        int[] randevuTarihi = tarihiIntegerCevirme(randevu.getTarih());

        if (randevuTarihi[1] >= bugun[1] && randevuTarihi[2] >= bugun[2]) {
            if (randevuTarihi[2] == bugun[2]) {   // yıl ayni ise
                if (randevuTarihi[1] == bugun[1]) {  // ay aynı ise
                    if (randevuTarihi[0] - bugun[0] > 1) {   // gün 1 önceki gün ise
                        System.out.println("Randevu Tarihi değiştirildi");
                        System.out.println("Yeni randevu tarihi => " + randevu.getTarih());
                        return true;
                    } else {
                        System.out.println("Randevunuz değiştirelemedi..");
                    }
                } else if (randevuTarihi[1] - bugun[1] == 1 && randevuTarihi[0] == 1 && gunler[bugun[1] - 1] > bugun[0]) {
                    System.out.println("Randevu Tarihi değiştirildi");
                    System.out.println("Yeni randevu tarihi => " + randevu.getTarih());
                    return true;
                } else {
                    System.out.println("Randevu Tarihi değiştirildi");
                    System.out.println("Yeni randevu tarihi => " + randevu.getTarih());
                    return true;
                }
            }

        } else {
            System.out.println("Geçmişte Kalmış Randevu...");
        }
        return false;
    }


}