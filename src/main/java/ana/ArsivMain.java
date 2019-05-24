package ana;



// import java.util.Scanner;

import arayuzler.Shell;
import arayuzler.TextIoUiApp;

import java.util.function.BiConsumer;
// import java.util.function.BiConsumer.*;
import org.beryx.textio.web.RunnerData;
import org.beryx.textio.TextIO;
import org.beryx.textio.TextIoFactory;
import org.beryx.textio.web.SparkTextIoApp;
import org.beryx.textio.web.TextIoApp;
import org.beryx.textio.web.WebTextTerminal;
import arayuzler.*;

// import org.hibernate.Session;
// import org.hibernate.SessionFactory;
// import org.hibernate.Transaction;
// import org.hibernate.boot.MetadataSources;
// import org.hibernate.boot.registry.StandardServiceRegistry;
// import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

// import modeller.File;
// import modeller.HalfCabinet;
// import modeller.Location;
// import islemler.*;
// import java.lang.Object;
// import arayuzler.textio.WebTextIoExecutor;

public class ArsivMain{
    // static SessionFactory factory;
    TextIO textIO = TextIoFactory.getTextIO();
    // SparkTextIoApp webApp=new SparkTextIoApp(null, null);
    public static void main (String[] args) {
        ShellApp sa=new ShellApp(8000);
        sa.basla();
        // ShellApp();
        // setup();
        // Scanner giris = new Scanner(System.in);
        // Baglanti baglanti=new Baglanti();
        // baglanti.ac();
        // Shell arayuz=new Shell();
        // arayuz.kayit(baglanti);

        // TextIO textIo=TextIoFactory().getTextIO();
        // BiConsumer<TextIO,RunnerData>appRunner=new TextIoUiApp();
        // appRunner.accept(textIo,null);

        // WebTextTerminal webTextTerm = new WebTextTerminal();
        // TextIoApp<?>textIoApp=new SparkTextIoApp(appRunner, webTextTerm);
        // WebTextIoExecutor webTextIoExecutor = new WebTextIoExecutor();
        // webTextIoExecutor.withPort(8000);
        // webTextIoExecutor.execute(textIoApp);
        
        
        

        // File file=new File();
        // Location location=new Location();
        // HalfCabinet hc=new HalfCabinet();
        // file.setEuropaid(11111);
        // file.setName("Baglantı Main Dossier Supply");
        // location.setUnit(3);
        // location.setShelf(2);
        // location.getFiles().add(file);
        // hc.getLocations().add(location);
        // System.out.println(hc.getLocations().get(0).getShelf());
        // System.out.println(hc.getLocations());
        // System.out.println(hc.getLocations().get(0).getShelf());
        // System.out.println(hc.getLocations().get(1).getShelf());
        // hc.setNo(3);
        // hc.setDivision("A");
        // location.setHalfCabinet(hc);
        // file.setLocation(location);
        // System.out.println(hc.getLocations().get(0).getFiles().get(0).getName());
        // baglanti.kaydet(hc);
        // baglanti.gonder();
        // baglanti.kapat();

        // try(Session session=factory.openSession()){
        //     Transaction tx = session.beginTransaction();
        //     File file=new File();
        //     Location location=new Location();
        //     HalfCabinet hc=new HalfCabinet();
        //     file.setEuropaid(647538);
        //     file.setName("Main Dossier Supply");
        //     location.setUnit(3);
        //     location.setShelf(2);
        //     location.getFiles().add(file);
        //     hc.getLocations().add(location);
        //     System.out.println(hc.getLocations().get(0).getShelf());
        //     System.out.println(hc.getLocations());
        //     System.out.println(hc.getLocations().get(0).getShelf());
        //     // System.out.println(hc.getLocations().get(1).getShelf());
        //     hc.setNo(3);
        //     hc.setDivision("B");
        //     location.setHalfCabinet(hc);
        //     file.setLocation(location);
        //     session.save(hc);
        //     tx.commit();
        //     session.close();
        // }
        // int sec=karsilama(giris);
        // if (sec==1) {
        //     kayit(giris);
        // }else

        //     System.out.println("secim: "+sec);

        // factory.close();
    // baglanti.kompleKapat();

    }
    // public static void  setup(){
    //     StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
    //         .configure()
    //         .build();
    //     factory=new MetadataSources(registry).buildMetadata().buildSessionFactory();
    // }
	private static void ShellApp(int i) {
	}
}
