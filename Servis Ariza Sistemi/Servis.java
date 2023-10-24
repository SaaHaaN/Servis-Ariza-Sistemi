/**
 * @file Servis
 * @description Servis - Ariza Sistemi (Bir servisin verdiği hizmetin yani Randevularının ve müşterilerin araçlarını bir
 * tekniker ile onarıp gerekli kontrollerin yapıldığı program)
 * @assignment 2
 * @date 23.01.2022
 * @author Şahan Aytekin - 2021221033
 */

package ProjeÖdevi_2;

public class Servis {

    private String servisAdi;
    private int servisId;
    private Tekniker[] teknikerListesi = new Tekniker[20];
    private Musteri[] musteriListesi = new Musteri[50];
    private Randevu[] randevuListesi = new Randevu[50];
    private Ariza[] arizaListesi = new Ariza[50];

    public Servis(int servisId, String servisAdi) {
        this.servisId = servisId;
        this.servisAdi = servisAdi;
    }

    public String getServisAdi() {
        return servisAdi;
    }

    public int getServisId() {
        return servisId;
    }

    public Tekniker[] getTeknikerListesi() {
        return teknikerListesi;
    }

    public Musteri[] getMusteriListesi() {
        return musteriListesi;
    }

    public Randevu[] getRandevuListesi() {
        return randevuListesi;
    }

    public Ariza[] getArizaListesi() {
        return arizaListesi;
    }

    //------------------------------------------------------------------------------------------------------------------
    public void servisBilgileri() {
        System.out.println("Firma adı=>" + " '" + getServisAdi() + "'" + getServisId());
    }


    public void teknikerEkle(Tekniker tekniker) {  //servise Tekniker Ekleme..
        for (int i = 0; i < teknikerListesi.length; i++) {
            if (teknikerListesi[i] == null) {
                teknikerListesi[i] = tekniker;
                break;
            }
        }
    }


    public void teknikerCikar(Tekniker tekniker) {  //servisten tekniker çıkarma..
        boolean varMi = false; // ariza varmi

        for (int i = 0; i < teknikerListesi.length; i++) {
            if (teknikerListesi[i] == tekniker) {
                teknikerListesi[i] = null;
                varMi = true;
                break;
            }
        }
        if (varMi) {
            System.out.println(tekniker.getAdSoyad() + " adlı Tekniker servisten Çıkarıldı...");
        } else {
            System.out.println(tekniker.getAdSoyad() + " adlı Tekniker zaten yok.");
        }
    }


    public void teknikerListele() { //servisteki teknikerleri listeleme..
        boolean bosMu = false; // listenin doluluğu
        System.out.println("Seviste çalışan Teknikerler...");

        for (int i = 0; i < teknikerListesi.length; i++) {
            if (teknikerListesi[i] != null) {
                teknikerListesi[i].teknikerBilgileri();
                bosMu = true;
            }
        }
        if (!bosMu) {  //boşMu==false;
            System.out.print("Serviste çalışan tekniker bulunmamaktadır..");
        }
    }


    public void musteriEkle(Musteri musteri) {  //servise müşteri ekleme..
        for (int i = 0; i < musteriListesi.length; i++) {
            if (musteriListesi[i] == null) {
                musteriListesi[i] = musteri;
                break;
            }
        }
    }


    public void mustesiCikar(Musteri musteri) {  //servisten müşteri çıkarma..
        boolean varMi = false; // ariza varmi

        for (int i = 0; i < musteriListesi.length; i++) {
            if (musteriListesi[i] == musteri) {
                musteriListesi[i] = null;
                varMi = true;
                break;
            }
        }
        if (varMi) {
            System.out.println(musteri.getAdSoyad() + " adlı Müsteri servisten Çıkarıldı...");
        } else {
            System.out.println(musteri.getAdSoyad() + " adlı Müşteri zaten hizmet almıyor.");
        }
    }


    public void musteriListele() {  // serviste hizmet alan müşteriler..
        boolean bosMu = false; // listenin doluluğu
        System.out.println("Serviste kayıtlı olan müşteriler..");

        for (int i = 0; i < musteriListesi.length; i++) {
            if (musteriListesi[i] != null) {
                musteriListesi[i].musteriBilgileri();
                bosMu = true;
            }
        }
        if (!bosMu) {
            System.out.print("Serviste hizmet alan müşteri bulunmamaktadır..");
        }
    }


    public void randevuEkle(Randevu randevu, Musteri musteri, Tekniker tekniker) {     // serviste olan randevuyu müşteriye verme ve hangi teknikerin ilgileneceğini kesinliştirme..
        for (int i = 0; i < randevuListesi.length; i++) {
            if (randevuListesi[i] == null) {
                randevuListesi[i] = randevu;
                musteri.setRandevuSayisi(musteri.getRandevuSayisi() + 1);
                break;
            }
        }
    }


    public void randevuCikar(Randevu randevu, Musteri musteri, Tekniker tekniker) {   // serviste olan randevuyu müşteriden çıkarma ve ilgilenen teknikeri randevudan çıkarma..
        for (int i = 0; i < randevuListesi.length; i++) {
            if (randevuListesi[i] == randevu) {
                randevuListesi[i] = null;
                musteri.setRandevuSayisi(musteri.getRandevuSayisi() - 1);
                break;
            }
        }
    }


    public void randevuGuncelleme(Musteri musteri, Randevu eskiRandevu, Randevu yeniRandevu) {   // randevu tarihinde değişiklik yapmaya yarayan metot..

        System.out.println("Eski randevu Tarihi => " + eskiRandevu.getTarih());

        if (eskiRandevu.degisiyorMu("24.1.2022", yeniRandevu)) {
            for (int i = 0; i < randevuListesi.length; i++) {
                if (randevuListesi[i].getRandevuId() == eskiRandevu.getRandevuId()) {
                    randevuListesi[i] = yeniRandevu;
                    break;
                }
            }
        }
    }


    public void randevuListele(Musteri musteri) {   // bir müşterinin randevularını listeleme..
        // randevu listesinin doluluğu kontrol ediliyor.
        boolean bosMu = false;

        for (int i = 0; i < this.randevuListesi.length; i++) {
            if (this.randevuListesi[i] != null) {
                System.out.println("Randevu sahibi:" + musteri.getAdSoyad() + "\nRandevu Bilgileri => " + randevuListesi[i].randevuBilgisi());
                bosMu = true;
                break;
            }
        }

        if (!bosMu) {
            System.out.println("Randevu listesi boş..");
        }
    }


    public void arizaEkle(Ariza ariza, Arac arac) {  // Serviste bulunan araca arıza ekleme..
        for (int i = 0; i < arizaListesi.length; i++) {
            if (arizaListesi[i] == null) {
                arizaListesi[i] = ariza;
                arac.getArizaListesi()[i] = ariza;
                break;
            }
        }
    }


    public void arizaCikar(Ariza ariza, Arac arac) {   // serviste bulunan araçtan arıza çıkarma..
        // ariza varmi
        boolean varMi = false;

        for (int i = 0; i < arizaListesi.length; i++) {
            if (arizaListesi[i] == ariza) {
                arizaListesi[i] = null;
                varMi = true;
                break;
            }
        }
        if (varMi) {
            System.out.println("Arizanız Silindi...");
        } else {
            System.out.println("Zaten böyle bir arızanız bulunmamaktadır..");
        }
    }


    public void arizaListele(Arac arac) {   // serviste bulunan bir aracın sahip olduğu arizaları listeleme..
        // listenin doluluğu
        boolean bosMu = false;

        for (int i = 0; i < arizaListesi.length; i++) {
            if (arizaListesi[i] != null) {
                arizaListesi[i].arizaBilgisi();
                bosMu = true;
            }
        }
        if (!bosMu) {
            System.out.println("Aracın arızası bulunmamaktadır");
        }
    }


    public void arizaOnar(Tekniker tekniker, Arac arac) {   // serviste bulunan bir tekniker ile aracın arızasını onarma..
        for (int i = 0; i < arac.getArizaListesi().length; i++) {
            if (arac.getArizaListesi()[i] != null) {
                if (arac.getArizaListesi()[i].getFiyat() <= arac.getMusteri().getBakiye()) {
                    System.out.println("---------");
                    System.out.println(arac.getMarka() + " markalı aracın");
                    System.out.println(arac.getArizaListesi()[i].getAd() + " olan Arizanız onarılmıştır...\nÖdenecek Miktar=>" + arac.getArizaListesi()[i].getFiyat() + "TL");
                    arac.getMusteri().paraHarca(arac.getArizaListesi()[i].getFiyat());
                    tekniker.paraKazan(arac.getArizaListesi()[i].getFiyat());

                } else {
                    System.out.println("---------");
                    System.out.println(arac.getMarka() + " markalı aracın");
                    System.out.println(arac.getArizaListesi()[i].getAd() + " olan Arizanız onarılmamıştır...");
                    System.out.println("Arizanız 'Yetersiz Bakiye' sebebiyle onarılmamıştır...");
                    System.out.println("Ariza tutarı =>" + arac.getArizaListesi()[i].getFiyat());
                    System.out.println("Müştersinin mevcut bakiyesi =>" + arac.getMusteri().getBakiye());
                }
            }
        }
    }


    public void farkliArizalariListele() {  // serviste bulunan farklı ariza türlerinin listelenmesi..
        System.out.println("Serviste Bulunan Farkli Arizalar");
        for (int i = 0; i < arizaListesi.length; i++) {
            for (int j = 0; j < arizaListesi.length; j++) {
                if (arizaListesi[i] != null && arizaListesi[j] != null) {
                    if (arizaListesi[i].getArizaId() != arizaListesi[j].getArizaId()) {
                        arizaListesi[i].arizaBilgisi();
                        break;
                    }
                }
            }
        }
    }


    public void enCokRandevusuOlan() {  // serviste en çok randevusu olan müşterinin randevularını listeleme..
        Musteri enCokRandevusuOlanMusteri = musteriListesi[0];
        int enCokRandevu = musteriListesi[0].getRandevuSayisi();

        for (int i = 1; i < musteriListesi.length; i++) {
            if (musteriListesi[i] != null) {
                if (musteriListesi[i].getRandevuSayisi() > enCokRandevu) {
                    enCokRandevu = musteriListesi[i].getRandevuSayisi();
                    enCokRandevusuOlanMusteri = musteriListesi[i];
                }
            }
        }
        System.out.println("Randevu adeti=>" + enCokRandevusuOlanMusteri.getRandevuSayisi());
        enCokRandevusuOlanMusteri.musteriBilgileri();
        randevuListele(enCokRandevusuOlanMusteri);
    }


    public void enCokParaKazananTekniker() {  // serviste onarım yaptıktan sonra en çok para kazanan tekniker..
        double maxKazanilanPara = 0;

        for (int i = 0; i < teknikerListesi.length; i++) {
            if (teknikerListesi[i] != null) {
                if (teknikerListesi[i].getCiro() > maxKazanilanPara) {
                    maxKazanilanPara = teknikerListesi[i].getCiro();
                }
            }
        }

        for (int i = 0; i < teknikerListesi.length; i++) {
            if (teknikerListesi[i] != null) {
                if (maxKazanilanPara != 0) {
                    if (teknikerListesi[i].getCiro() == maxKazanilanPara) {
                        System.out.println("En çok kazanan Tekniker");
                        teknikerListesi[i].teknikerBilgileri();
                    }
                } else {
                    System.out.println("Onarılmış arıza olmadığı için teknikerler para kazanamadı");
                    break;
                }
            }
        }
    }


    public void enCokOdemeYapanMusteri() {  // serviste onarım yaptıktan sonra en çok para ödeyen müşteri..
        double maxOdenenMiktar = 0;

        for (int i = 0; i < musteriListesi.length; i++) {
            if (musteriListesi[i] != null) {
                if (musteriListesi[i].getHarcananMiktar() > maxOdenenMiktar) {
                    maxOdenenMiktar = musteriListesi[i].getHarcananMiktar();
                }
            }
        }

        for (int i = 0; i < musteriListesi.length; i++) {
            if (musteriListesi[i] != null) {
                if (maxOdenenMiktar != 0) {
                    if (musteriListesi[i].getHarcananMiktar() == maxOdenenMiktar) {
                        System.out.println("En çok ödeme yapan müşteri");
                        musteriListesi[i].musteriBilgileri();
                        randevuListele(musteriListesi[i]);
                    }
                } else {
                    System.out.println("Ödeme yapan müşteri yok...");
                    break;
                }
            }
        }
    }


    public void toplamParaveGecenSure() {  // serviste bulunan arizaların toplam ücret tutarı ve ne kadar vakit alacağını ekrana yazdıran metot..

        int toplamKazanc = 0;
        int toplamSure = 0;

        for (int i = 0; i < arizaListesi.length; i++) {
            if (arizaListesi[i] != null) {
                toplamKazanc += arizaListesi[i].getFiyat();
                toplamSure += arizaListesi[i].getTamirSuresi();
            }
        }
        System.out.println("Toplam biriken Para => " + toplamKazanc + "TL");
        System.out.println("Toplam Onarım Süresi => ortalama " + toplamSure + " Saat");
    }


}


//----------------------------------------------------------------------------------------------------------------------
// Yapmaya çalıştığım ama olumlu çıktı alamadığım bazı metotlarım burada...
// Değerlendirmek istersiniz diye burada bırakıyorum
// Saygılarımla.

//----------------------------------------------------------------------------------------------------------------------
// Müşteri arama metotdu bir tane harf girip o ahrfin geçtiği müşterinin adı soyadını ekrana yazdırma..

//    public Musteri[] musteriArama(char harf) {
//
//        Musteri[] harfTutanMusteri = new Musteri[20];
//        int isimIndex = 0;
//
//        for (int i = 0; i < musteriListesi.length; i++) {
//            for (int j = 0; j < musteriListesi[i].getAdSoyad().length(); j++) {
//
//                if (musteriListesi[i].getAdSoyad().charAt(j) == musteriListesi[i].getAdSoyad().charAt(harf)) {
//                    harfTutanMusteri[isimIndex] = musteriListesi[i];
//                    isimIndex++;
//                }
//            }
//        }
//        return harfTutanMusteri;
//    }


//----------------------------------------------------------------------------------------------------------------------
//Verilen iki tarih arasında olan randevuşarı ekrana yazdıran metot

//    public void verilenTarihlarArasindakiRandevular(String ilkTarih, String ikinciTarih) {
//
//        int[] ilk = getRandevu().tarihiIntegerCevirme(ilkTarih);
//        int[] ikinci = getRandevu().tarihiIntegerCevirme(ikinciTarih);
//
//        int[] randevuGunu = new int[20];
//        for (int i = 0; i < randevuListesi.length; i++) {
//            randevuGunu = getRandevu().tarihiIntegerCevirme(randevuListesi[i].getTarih());
//        }
//
//
//        for (int i = 0; i < randevuListesi.length; i++) {
//            if (randevuListesi[i] != null) {
//                for (int j = 0; j < randevuGunu.length; j++) {
//                    if (ilk[i] > randevuGunu[j] && ikinci[i] < randevuGunu[j]) {
//                        randevuListesi[i].randevuBilgisi();
//                    }
//
//                }
//            }
//        }
//
//    }


//----------------------------------------------------------------------------------------------------------------------
//Yapmaya çalıştığım teknikerÇıkar metodunda farklı teknikere randevuyu aktırma metodum... Gerekli tüm satırlara debug
// yaptım ama olumlu bir sonuç alamadım

//    public void teknikerCikar(Tekniker tekniker) { //serviseten Tekniker çıkarma
//        // ariza varmi
//        boolean varMi = false;
//
//        for (Ariza a : tekniker.getArizaListesi()) {
//            if (a != null) {
//                varMi = true;
//            }
//        }
//        Randevu[] teknikerRandevulari = new Randevu[20];
//        int tr = 0;
//        for (Randevu a : randevuListesi) {
//            if (a != null && a.getTekniker().getId() == tekniker.getId()) {
//                teknikerRandevulari[tr++] = a;
//            }
//        }
//        for (Randevu a : teknikerRandevulari) {
//            if (a != null) {
//                varMi = true;
//            }
//        }
//
//        if (!varMi) {
//            for (int i = 0; i < teknikerListesi.length; i++) {
//                if (teknikerListesi[i] == tekniker) {
//                    teknikerListesi[i] = null;
//                    break;
//                }
//            }
//            System.out.println("Tekniker servisten Silindi...");
//
//        } else {
//            int ti = (int) (Math.random() * 5);
//            if (teknikerListesi[ti] != tekniker) {
//                for (Randevu r : teknikerRandevulari) {
//                    r.setTekniker(teknikerListesi[ti]);
//                }
//            } else {
//                for (Randevu r : teknikerRandevulari) {
//                    r.setTekniker(teknikerListesi[ti < 4 ? ++ti : --ti]);    // if else kısa yazılımınu kullandım...
//                }
//            }
//            System.out.println("Tekniker zaten servisde bulunmamaktadır..");
//        }
//    }