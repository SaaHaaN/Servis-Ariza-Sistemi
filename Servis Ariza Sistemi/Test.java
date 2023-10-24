/**
 * @file Test (Main)
 * @description Servis - Ariza Sistemi (Bir servisin verdiği hizmetin yani Randevularının ve müşterilerin araçlarını bir
 * tekniker ile onarıp gerekli kontrollerin yapıldığı program)
 * @assignment 2
 * @date 23.01.2022
 * @author Şahan Aytekin - 2021221033
 */

package ProjeÖdevi_2;

public class Test {
    public static void main(String[] args) {

        Servis servis = new Servis(2021221033, "Aytekin Servis");

        Tekniker tekniker1 = new Tekniker(11, "Sami Usta");
        Tekniker tekniker2 = new Tekniker(12, "Ali Usta");
        Tekniker tekniker3 = new Tekniker(13, "Mehmet Usta");
        Tekniker tekniker4 = new Tekniker(14, "Ahmet Usta");
        Tekniker tekniker5 = new Tekniker(15, "Cemil Usta");


        // Her müşterinin arabası constructor da bulunuyor...
        Musteri m1 = new Musteri(21, "Şahan Aytekin", 5000);
        Arac c1 = new Arac(61, "Audi", m1);

        Musteri m2 = new Musteri(22, "Levent Yılmaz", 4500);
        Arac c2 = new Arac(62, "Honda", m2);

        Musteri m3 = new Musteri(23, "Nagihan Eser", 3000);
        Arac c3 = new Arac(63, "BMW", m3);

        Musteri m4 = new Musteri(24, "Arhan Ak", 2500);
        Arac c4 = new Arac(64, "Mercedes", m4);

        Musteri m5 = new Musteri(25, "Bülent Kaya", 200);
        Arac c5 = new Arac(65, "Renault", m5);


        Ariza ariza1 = new Ariza(41, "Motor", 1, 700);
        Ariza ariza2 = new Ariza(42, "Balata", 2, 250);
        Ariza ariza3 = new Ariza(43, "Egzoz", 2, 500);
        Ariza ariza4 = new Ariza(44, "Far", 3, 350);
        Ariza ariza5 = new Ariza(45, "Hava Filtresi", 1, 150);
        Ariza ariza6 = new Ariza(46, "Kaporta", 2, 400);
        Ariza ariza7 = new Ariza(47, "Boyama/Cila", 2, 500);
        Ariza ariza8 = new Ariza(48, "Cam Değiştirme", 1, 400);
        Ariza ariza9 = new Ariza(49, "Akü", 4, 250);


        Randevu r1 = new Randevu(151, "28.1.2022");
        Randevu r2 = new Randevu(152, "29.2.2022");
        Randevu r3 = new Randevu(153, "15.2.2022");
        Randevu r4 = new Randevu(154, "18.4.2022");
        Randevu r5 = new Randevu(155, "27.6.2022");
        Randevu r6 = new Randevu(156, "19.8.2022");
        Randevu r7 = new Randevu(157, "16.9.2022");
        Randevu r8 = new Randevu(158, "9.11.2022");
        Randevu r9 = new Randevu(159, "2.12.2022");

        Randevu r10 = new Randevu(160, "25.1.2022");
        Randevu r11 = new Randevu(161, "29.1.2022");


        //Servis Bilgilerini ekrana yazdırma
//        servis.servisBilgileri();


        //-----------------------------------------------------------------------------


        //Servise Tekniker ekleme (Serviste bulunan teknikerler) ve ekrana yazdırma...
        servis.teknikerEkle(tekniker1);
        servis.teknikerEkle(tekniker2);
        servis.teknikerEkle(tekniker3);
        servis.teknikerEkle(tekniker4);
        servis.teknikerEkle(tekniker5);
//       servis.teknikerListele();


        //-----------------------------------------------------------------------------


        //Servise Müşteri ekleme (Serviste bulunan müşteriler) ve ekrana yazdırma...
        servis.musteriEkle(m1);
        servis.musteriEkle(m2);
        servis.musteriEkle(m3);
        servis.musteriEkle(m4);
        servis.musteriEkle(m5);
//       servis.musteriListele();


        //-----------------------------------------------------------------------------


        //Araba bilgileri (sahibi ve markası) ve arabalarda bulunan arizalar ve ekrana yazdırma...

        //1.Araba
//        c1.aracBilgisi();
        servis.arizaEkle(ariza1, c1);
        servis.arizaEkle(ariza2, c1);
        servis.arizaEkle(ariza3, c1);
//        servis.arizaListele(c1);

        //2.Araba
//        c2.aracBilgisi();
        servis.arizaEkle(ariza4, c2);
        servis.arizaEkle(ariza5, c2);
//        servis.arizaListele(c2);

        //3.Araba
//        c3.aracBilgisi();
        servis.arizaEkle(ariza6, c3);
        servis.arizaEkle(ariza7, c3);
//        servis.arizaListele(c3);

        //4.Araba
//        c4.aracBilgisi();
        servis.arizaEkle(ariza8, c4);
//        servis.arizaListele(c4);

        //5.Araba
//        c5.aracBilgisi();
        servis.arizaEkle(ariza9, c5);
//        servis.arizaListele(c5);


        //-----------------------------------------------------------------------------


        //Müşterile randevu verme
        m1.randevuEkle(r1);
        m1.randevuEkle(r6);
        m1.randevuEkle(r7);
        m2.randevuEkle(r2);
        m2.randevuEkle(r8);
        m3.randevuEkle(r3);
        m4.randevuEkle(r4);
        m5.randevuEkle(r5);


        //-----------------------------------------------------------------------------


        //Serviste bulunan teknikerlerin ilgileneceğe müşterilerin randevuları ekleme
        servis.randevuEkle(r1, m1, tekniker1);
        servis.randevuEkle(r6, m1, tekniker1);
        servis.randevuEkle(r7, m1, tekniker1);

        servis.randevuEkle(r2, m2, tekniker2);
        servis.randevuEkle(r8, m2, tekniker2);

        servis.randevuEkle(r3, m3, tekniker3);

        servis.randevuEkle(r4, m4, tekniker4);

        servis.randevuEkle(r5, m5, tekniker5);


        //-----------------------------------------------------------------------------


        //Tamir öncesi Müşteri Bakiyeleri görmek için yapıldı...
//        m1.musteriBilgileri();
//        m2.musteriBilgileri();
//        m3.musteriBilgileri();
//        m4.musteriBilgileri();
//        m5.musteriBilgileri();


        //Tamir işlemleri..
//        servis.arizaOnar(tekniker1, c1);
//        servis.arizaOnar(tekniker2, c2);
//        servis.arizaOnar(tekniker3, c3);
//        servis.arizaOnar(tekniker4, c4);
//        servis.arizaOnar(tekniker5, c5);


        //Tamir sonrası Müşteri Bakiyelerileri görmek için yapıldı...
//        m1.musteriBilgileri();
//        m2.musteriBilgileri();
//        m3.musteriBilgileri();
//        m4.musteriBilgileri();
//        m5.musteriBilgileri();


        //-----------------------------------------------------------------------------


        //1. Adı girilen teknikerin/teknikerlerin ilgilendiği aktif arızaların listelenmesi.
//        tekniker1.teknikerBilgileri();
//        tekniker1.arizaEkle(ariza1);
//        tekniker1.arizaListele();
//        System.out.println("---------------");
//        tekniker2.teknikerBilgileri();
//        tekniker2.arizaEkle(ariza4);
//        tekniker2.arizaListele();
//        System.out.println("---------------");
//        tekniker3.teknikerBilgileri();
//        tekniker3.arizaEkle(ariza6);
//        tekniker3.arizaListele();
//        System.out.println("---------------");
//        tekniker4.teknikerBilgileri();
//        tekniker4.arizaEkle(ariza8);
//        tekniker4.arizaListele();
//        System.out.println("---------------");
//        tekniker5.teknikerBilgileri();
//        tekniker5.arizaEkle(ariza9);
//        tekniker5.arizaListele();


        //-----------------------------------------------------------------------------


        //2. Şimdiye kadar alınmış farklı arıza türlerinin listelenmesi.
//        servis.farkliArizalariListele();


        //-----------------------------------------------------------------------------


        //3. En çok randevusu olan müşterinin tüm randevu bilgilerinin listelenmesi(müşteri bilgileri, araç bilgisi, arıza bilgisi, randevu tarihi vb. bilgiler)
//       servis.enCokRandevusuOlan();


        //-----------------------------------------------------------------------------


        //4. Adı girilen müşterinin geçmişteki ve gelecekteki randevularının listelenmesi
//        m1.randevuListele();
//        m2.randevuListele();
//        m3.randevuListele();
//        m4.randevuListele();
//        m5.randevuListele();


        //-----------------------------------------------------------------------------


        //5. Müşteri, randevu tarihinden en geç 1 gün önce randevusunu iptal edebilir.1 günden daha az bir süre kaldıysa randevu iptal edilemez veya değişiklikyapılamaz. 1 günden daha fazla bir süre varsa almış olduğu randevuyu güncelleyebilir.
//        servis.randevuGuncelleme(m1, r1, r9); // değişebiliyor..
//        servis.randevuGuncelleme(m1, r1, r10); //1gün öncesi için ayarlı..
//        servis.randevuGuncelleme(m2, r2, r11);


        //-----------------------------------------------------------------------------


        //6. Karmaşık String araması yapılabilir. Adı A** ile başlayan ve adınıniçerisinde h-H veya m-M geçen ve adı ****e veya t ile biten müşterinin ya damüşterilerin randevu bilgisini (geçmişte ve gelecekte bulunan randevular)ekrana yazar


        //-----------------------------------------------------------------------------


        //7. Müşteri silebilme
//        servis.mustesiCikar(m1);
//        servis.mustesiCikar(m2);
//        servis.mustesiCikar(m3);
//        servis.mustesiCikar(m4);
//        servis.mustesiCikar(m5);


        //-----------------------------------------------------------------------------


        //8. Tekniker silebilme
//        servis.teknikerCikar(tekniker1);
//        servis.teknikerCikar(tekniker2);
//        servis.teknikerCikar(tekniker3);
//        servis.teknikerCikar(tekniker4);
//        servis.teknikerCikar(tekniker5);


        //-----------------------------------------------------------------------------


        //9. Kendisine alınan randevulardan en çok hasılatı (arızalardan toplamaldığı ücret) elde eden teknikerin/teknikerlerin listelenmesi
        //   bunu metot kullanılırken arizOnar metotları açık olursa daha verilimli çalışır.
//
//        System.out.println("----------------");
//        servis.enCokParaKazananTekniker();


        //-----------------------------------------------------------------------------


        //10. En çok ödeme yapan müşterinin bilgilerinin ve randevularının listelenmesi
        //    bunu metot kullanılırken arizOnar metotları açık olursa daha verilimli çalışır.
//        System.out.println("----------------");
//        servis.enCokOdemeYapanMusteri();


        //-----------------------------------------------------------------------------


        //11. Elde edilen ortalama kazanç ve ortalama arıza tamir süresi bilgilerinin gösterilmesi (Genel)
//        servis.toplamParaveGecenSure();


        //-----------------------------------------------------------------------------


        //12.Verilen tarihler arasındaki bütün çözümlenmiş randevuların listelenmesi


        //-----------------------------------------------------------------------------


        //13. Verilen tarihler arasındaki bütün çözümlenmemiş/gelecektekirandevuların listelenmesi. İlgili randevuyu alan müşteri bilgileri, araçbilgisi, arıza bilgisi, randevu tarihi vb. bilgiler listelenmeli.
    }
}