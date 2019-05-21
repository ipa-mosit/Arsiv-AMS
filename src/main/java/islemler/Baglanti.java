package islemler;


import org.hibernate.Session;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import modeller.HalfCabinet;

import org.hibernate.boot.MetadataSources;
// import org.hibernate.boot.registry.StandardServiceRegistry;
// import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
// import java.lang.Object;

public class Baglanti{
    public SessionFactory oturumUretici;
    public Session oturum;
    public Transaction islem;
    public Baglanti(){
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
        .configure()
        .build();
        oturumUretici=new MetadataSources(registry).buildMetadata().buildSessionFactory();
    }
    public void ac(){
        this.oturum=oturumUretici.openSession();
        this.islem=oturum.beginTransaction();
        System.out.println("Oturum Açıldı, İşlem Başladı");
    }
    public void kaydet(Object obj){
        // System.out.println(obj.getLocations().get(0).getFiles().get(0).getName());
        System.out.println("Obje kaydedilecek");
        this.oturum.save(obj);
        System.out.println("Obje kaydedildi");
    }
    public void guncelle(Object obj){
        // System.out.println(obj.getLocations().get(0).getFiles().get(0).getName());
        System.out.println("Obje kaydedilecek");
        this.oturum.update(obj);
        System.out.println("Obje kaydedildi");
    }
    public void kaydetVeyaGuncelle(Object obj){
        // System.out.println(obj.getLocations().get(0).getFiles().get(0).getName());
        System.out.println("Obje kaydedilecek");
        this.oturum.saveOrUpdate(obj);
        System.out.println("Obje kaydedildi");
    }

    public void gonder(){
        this.islem.commit();
        System.out.println("İşlem Gönderildi");
    }
    public void kapat(){
        // this.oturum.flush();
        this.oturum.close();
        System.out.println("Oturum kapatıldı");
    }
    public void kompleKapat(){
        // this.oturum.flush();
        this.oturum.close();
        this.oturumUretici.close();
        System.out.println("Oturum ve Oturum Üretici komple kapatıldı");
    }
}
