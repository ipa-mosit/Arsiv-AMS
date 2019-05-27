package arayuzler;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.BiConsumer;

import org.beryx.textio.CharInputReader;
import org.beryx.textio.InputReader;
import org.beryx.textio.IntInputReader;
import org.beryx.textio.StringInputReader;
import org.beryx.textio.TextIO;
import org.beryx.textio.TextTerminal;
import org.beryx.textio.web.RunnerData;
// import org.beryx.textio.web.TextIoApp;
import arayuzler.textio.AppUtil;
import modeller.File;
import modeller.Location;

public class ShellDialogs  implements BiConsumer<TextIO,RunnerData>{
    @Override
    public void  accept(TextIO textIO,RunnerData runnerData){
        TextTerminal<?> terminal = textIO.getTextTerminal();
        String initData = (runnerData == null) ? null : runnerData.getInitData();
        AppUtil.printGsonMessage(terminal, initData);
        String user=textIO.newStringInputReader()
            .read("isminiz nedir?");
        terminal.printf("Selam %s\n",user);

    InputReader<Integer,IntInputReader> tamsayiGirisi=textIO.newIntInputReader();
    InputReader<String,StringInputReader> sozcukGirisi=textIO.newStringInputReader();
    CharInputReader karakterGirisi=textIO.newCharInputReader();
    // int g=textIO.newIntInputReader()
    karsilama(tamsayiGirisi,sozcukGirisi);
    dosyaKayıt(tamsayiGirisi,sozcukGirisi,karakterGirisi);


        textIO.newStringInputReader().withMinLength(0).read("\nPress enter to terminate...");
        textIO.dispose("User '" + user + "' has left the building.");
    }

    public int karsilama(InputReader<Integer,IntInputReader> tamsayiGirisi,InputReader<String,StringInputReader>sozcukGirisi){

    List<String>tamsayiHataMesaji=new ArrayList<String>();
    tamsayiHataMesaji.add("Lütfen bir tamsayi giriniz");
    InputReader.ErrorMessagesProvider empTamsayi=(n1,n2)->tamsayiHataMesaji;

        int returnValue=tamsayiGirisi.withParseErrorMessagesProvider(empTamsayi)
            .read("IPA Arşiv Yönetim Sistemine Hoşgeldiniz\n"+
                    "Lütfen Yapmak İstediğiniz işlemi seçiniz:\n"+
                    "1-Yeni Kayıt\n"+
                    "2-Dokuman Arama\n"+
                    "3-Güncelleme/Silme\n");
        return returnValue;
    }
    public File dosyaKayıt(InputReader<Integer,IntInputReader> tamsayiGirisi,InputReader<String,StringInputReader>sozcukGirisi,CharInputReader karakterGirisi){

        List<String>tamsayiHataMesaji=new ArrayList<String>();
        tamsayiHataMesaji.add("Lütfen bir tamsayi giriniz");
        InputReader.ErrorMessagesProvider empTamsayi=(n1,n2)->tamsayiHataMesaji;

        // List<String>karakterSiniriHataMesaji=new ArrayList<String>();
        // karakterSiniriHataMesaji.add("Lütfen karakter sınırına riayet ediniz.");
        // InputReader.ErrorMessagesProvider empKarakterSiniri=(n1,n2)->karakterSiniriHataMesaji;//Karakter sınırı hatası error message provider ile verilemiyormuş ya la

        List<String>karakterHataMesaji=new ArrayList<String>();
        karakterHataMesaji.add("Lütfen bir karakter giriniz");
        InputReader.ErrorMessagesProvider empKarakter=(n1,n2)->karakterHataMesaji;

        String dosyaAdi;
        int europaid;
        String notes;

        dosyaAdi=sozcukGirisi
            .read("Dosya ismini giriniz: ");
        europaid=tamsayiGirisi.withParseErrorMessagesProvider(empTamsayi)
            .withMaxVal(999999)
            .withMinVal(100000)
            .read("Varsa EuropeAid Numarası(6 karakter):");
        notes=sozcukGirisi
            .read("Varsa açıklama giriniz: ");
        File file=new File(dosyaAdi,europaid,notes);
        Set<Location>locations=lokasyonGirisleri(true,file,tamsayiGirisi,sozcukGirisi,karakterGirisi);
        file.getLocations().addAll(locations);
        return file;
    }


	public Location tekilLokasyonGir (InputReader<Integer,IntInputReader> tamsayiGirisi,CharInputReader karakterGirisi,File file){

        List<String>tamsayiHataMesaji=new ArrayList<String>();
        tamsayiHataMesaji.add("Lütfen bir tamsayi giriniz");
        InputReader.ErrorMessagesProvider empTamsayi=(n1,n2)->tamsayiHataMesaji;

        List<String>karakterHataMesaji=new ArrayList<String>();
        karakterHataMesaji.add("Lütfen bir karakter giriniz");
        InputReader.ErrorMessagesProvider empKarakter=(n1,n2)->karakterHataMesaji;

        int kabinNo;
        char kabinKisim;
        int unit;
        int raf;


        Location loc=new Location();

        kabinNo=tamsayiGirisi.withParseErrorMessagesProvider(empTamsayi)
            .withMinVal(0)
            .read("Lütfen kabin numarası giriniz: ");

        loc.setKabinNo(kabinNo);

        kabinKisim=karakterGirisi.withParseErrorMessagesProvider(empKarakter)
            .withNumberedPossibleValues('A','B')
            .read("Lütfen kabin kısmını giriniz (A/B) : ");

        loc.setKabinKisim(kabinKisim);

        unit=tamsayiGirisi.withParseErrorMessagesProvider(empTamsayi)
            .withMinVal(1)
            .withMaxVal(3)
            .read("lütfen lokasyon icin unit değerini girin (1-3): ");

        loc.setUnit(unit);

        raf=tamsayiGirisi.withParseErrorMessagesProvider(empTamsayi)
            .withMinVal(1)
            .withMaxVal(5)
            .read("lütfen lokasyon icin raf değerini girin (1-5): ");
        loc.setShelf(raf);

        loc.idGenerate();
        String printloc;
        printloc=String.format("Lokasyon (%s) başarı ile oluşturuldu",loc.getLocId());
        System.out.println(printloc);
        loc.getFiles().add(file);
        return loc;
    }

   public Set<Location> lokasyonGirisleri(boolean isYeni,File file,InputReader<Integer,IntInputReader> tamsayiGirisi,InputReader<String,StringInputReader>sozcukGirisi,CharInputReader karakterGirisi){


        List<String>tamsayiHataMesaji=new ArrayList<String>();
        tamsayiHataMesaji.add("Lütfen bir tamsayi giriniz");
        InputReader.ErrorMessagesProvider empTamsayi=(n1,n2)->tamsayiHataMesaji;

        List<String>sozcukHataMesaji=new ArrayList<String>();
        sozcukHataMesaji.add("Lütfen karakter sınırına riayet ediniz.");
        InputReader.ErrorMessagesProvider empKarakterSiniri=(n1,n2)->sozcukHataMesaji;//Karakter sınırı hatası error message provider ile verilemiyormuş ya la

        System.out.println("\n*** DOSYA LOKASYON GİRİŞLERİ ***\n");
        System.out.println("Dosya kabin içi lokasyonları girin");
        // giris.useDelimiter(",|;|\\n");
        int c=1;
        int devammi=1;
        Set<Location>locations=new HashSet<Location>();

        while(devammi==1){
            Location loc=new Location();
            loc=tekilLokasyonGir(tamsayiGirisi,karakterGirisi,file); 
            String secenek = sozcukGirisi.withParseErrorMessagesProvider(empTamsayi)
                .withDefaultValue("Kaydet ve Devam")
                .withNumberedPossibleValues("Kaydet ve Devam","Kaydet ve Çık","Düzelt","Kaydetmeden Çık")
                .withItemName("secenek")
                .read("Seçiminiz?");
            if (secenek =="Kaydet ve Devam") {
                locations.add(loc); //yeni giriş eklemiyor, ya burada sorun var ya da loc değerinde 
                System.out.println("\n** Lokasyon "+c+": "+"("+loc.getUnit()+","+loc.getShelf()+") değeri Lokasyon kümesine eklendi.\n");
                c++;
            }
            if (secenek =="Kaydet ve Çık"){
                if(isYeni==true) file.setLocations(locations);
                if(isYeni==false) file.getLocations().addAll(locations);
                locations.add(loc); //yeni giriş eklemiyor, ya burada sorun var ya da loc değerinde 
                file.setLocations(locations);
                for(Location lc:file.getLocations()) System.out.println("bedo "+lc);
                System.out.println(locations.size());
                for(Location lc:locations) System.out.println("simple ocations"+lc);
                System.out.println(file.getLocations().size());
                // System.out.println(loc);
                System.out.println("Tüm kayıtlar dosya modeline eklendi");
                devammi=0;
                return locations;
            }
            if(secenek =="Düzelt"){
                continue;
            }
            if(secenek =="Kaydetmeden Çık"){
                devammi=0;
                continue;
            }
        }
        return locations;
    }
}
