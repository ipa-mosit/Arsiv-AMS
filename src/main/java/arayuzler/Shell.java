package arayuzler;

import java.util.HashSet;
import java.util.Set;

import java.util.Scanner;

import islemler.Baglanti;
// import islemler.Kayit;
import modeller.File;
// import modeller.HalfCabinet;
import modeller.Location;

public class Shell{
    Scanner giris = new Scanner(System.in);
    public int karsilama(){
        System.out.println("IPA Arşiv Yönetim Sistemine Hoşgeldiniz\n");
        System.out.println("Lütfen Yapmak İstediğiniz işlemi seçiniz:\n"+
                "1-Yeni Kayıt\n"+
                "2-Dokuman Arama\n"+
                "3-Güncelleme/Silme\n");
        int g =giris.nextInt();
        return g;
    }
    public File yeniKayıt(String dosyaAdi){
        System.out.println("Yeni Kayıt");
        System.out.println("Varsa EuropeAid Numarası:");
        int europaid=tamsayi(giris);
        giris.nextLine();
        System.out.println("Varsa açıklama giriniz: ");
        String notes=giris.nextLine();
        File file=new File(dosyaAdi,europaid,notes);
        Set<Location>locations=lokasyonGirisleri(true,file);
        file.getLocations().addAll(locations);
        return file;

    }
    public Location tekilLokasyonGir (Scanner giris,File file){
        Location loc=new Location();
        System.out.println("Lütfen kabin numarası giriniz: ");
        int kabinNo=tamsayi(giris);
        loc.setKabinNo(kabinNo);
        System.out.println("Lütfen kabin kısmını giriniz (A/B) : ");
        giris.nextLine();
        char kabinKisim=giris.next().charAt(0);
        loc.setKabinKisim(kabinKisim);
        System.out.println("lütfen lokasyon icin unit değerini girin: ");
        loc.setUnit(tamsayi(giris));
        System.out.println("lütfen lokasyon icin raf değerini girin: ");
        loc.setShelf(tamsayi(giris));
        loc.idGenerate();
        String printloc;
        printloc=String.format("Lokasyon (%s) başarı ile oluşturuldu",loc.getLocId());
        System.out.println(printloc);
        loc.getFiles().add(file);
        return loc;
    }
    public Set<Location> lokasyonGirisleri(boolean isYeni,File file){

        System.out.println("\n*** DOSYA LOKASYON GİRİŞLERİ ***\n");
        System.out.println("Dosya kabin içi lokasyonları girin");
        giris.useDelimiter(",|;|\\n");
        int c=1;
        int devammi=1;
        Set<Location>locations=new HashSet<Location>();

        while(devammi==1){
            Location loc=new Location();
            loc=tekilLokasyonGir(giris,file); 
            System.out.println("\n 1-KAYDET VE DEVAM"+
                    "\n\n 2-KAYDET ÇIK"+
                    "\n\n 3-DÜZELT"+
                    "\n\n 4-KAYDETMEDEN ÇIK\n");
            System.out.print("SEÇİMİNİZ?: ");
            int secenek=tamsayi(giris);
            if (secenek == 1) {
                locations.add(loc); //yeni giriş eklemiyor, ya burada sorun var ya da loc değerinde 
                System.out.println("\n** Lokasyon "+c+": "+"("+loc.getUnit()+","+loc.getShelf()+") değeri Lokasyon kümesine eklendi.\n");
                c++;
            }
            if (secenek ==2){
                if(isYeni==true) file.setLocations(locations);
                if(isYeni==false) file.getLocations().addAll(locations);
                // locations.add(loc); //yeni giriş eklemiyor, ya burada sorun var ya da loc değerinde 
                // file.setLocations(locations);
                for(Location lc:file.getLocations()) System.out.println("bedo "+lc);
                System.out.println(locations.size());
                for(Location lc:locations) System.out.println("simple ocations"+lc);
                System.out.println(file.getLocations().size());
                // System.out.println(loc);
                System.out.println("Tüm kayıtlar dosya modeline eklendi");
                devammi=0;
                return locations;
            }
            if(secenek ==3){
                continue;
            }
            if(secenek ==4){
                devammi=0;
                continue;
            }
        }
        return locations;
    }



    public File eskiKayıt(File file){
        System.out.println(file);
        System.out.println("Dosya Güncelleme için Yüklendi");
        System.out.println("Lütfen güncellemek istediğiniz bilgileri girin:\n"
                +"1-Dosya ismi\n"+
                "2-Europaid numarası\n"+
                "3-Not Ekle/Düzelt");

        
        return file;
    }
    public void kayit(Baglanti baglanti){

        //****Dosya Girişi***
        File file =new File(); 
        System.out.println("Giriş Yapılacak Dosya Adını giriniz");
        String dosyaAdi=(giris.nextLine());
        try{
            file=baglanti.oturum.load(File.class,dosyaAdi);
            String dummy=file.getName();
            System.out.println("Bu isimde bir dosya sistemde mevcut, lokasyon değişiklikleri için dosya bilgileri yükleniyor");
            file=eskiKayıt(file);

        }catch(Exception e){
            System.out.println("Daha önce yapılmış bir kayıt bulunamadı yeni kayıt oluşturuluyor.");
            file=null;
        }
        if (file==null){
            file=yeniKayıt(dosyaAdi);
        }
        // System.out.println("Dosya Adı: ");
        System.out.println(file);

        baglanti.kaydet(file);
        baglanti.gonder();
    }

    public int tamsayi(Scanner giris){
        while(true){
            try {
                int a=0;
                a =giris.nextInt();
                return a;

            } catch(Exception e){
                // e.printStackTrace();
                String hatalı_giris=giris.next();
                System.out.println("Hatalı giriş:" +hatalı_giris+ "\nTam sayi girilmedi lütfen tekrar giriş yapın");
                continue;
            }
        }
    }
}
