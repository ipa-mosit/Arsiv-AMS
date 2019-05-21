package islemler;
import java.util.ArrayList;
import java.util.List;

import modeller.*;
public class Kayit{
    public File file=new File();
    // public List<Location>locs=new ArrayList<Location>();
    public HalfCabinet kabin=new HalfCabinet();
    Baglanti baglanti;
    public Kayit(Baglanti baglanti,File file,List<Location>locs,HalfCabinet hc){
        this.baglanti=baglanti;
        this.file=file;
        // hc.setLocations(locs);
        this.kabin=hc;
    }
    public Kayit(){
    }
    public String toString(){
        String info=String.format("%s",kabin);
        return info;
        // String.format
    }

    public void setFile(File file) {
        this.file = file;
    }

    public File getFile() {
        return file;
    }

    public void setKabin(HalfCabinet kabin) {
        this.kabin = kabin;
    }

    public HalfCabinet getKabin() {
        return kabin;
    }

    public void setBaglanti(Baglanti baglanti) {
        this.baglanti = baglanti;
    }

    public Baglanti getBaglanti() {
        return baglanti;
    }
    public int kayitKontrol(){
        return 0;
        
    }
}
