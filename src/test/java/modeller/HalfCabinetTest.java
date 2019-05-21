package modeller;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.*;

public class HalfCabinetTest{
    SessionFactory factory;
   @BeforeEach
   public void setup(){
       StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
           .configure()
           .build();
       factory=new MetadataSources(registry).buildMetadata().buildSessionFactory();
   }

           // public List<file>findAllFiles(){
           //     return session.createQuery("select a from a",File.class).getResultList();
           // }
   @Test
   public void testSaveCabinLocation(){
       try(Session session=factory.openSession()){
           Transaction tx =session.beginTransaction();
           
           // Location lc =new Location();
           File file=new File();
           Location location=new Location();
           HalfCabinet hc=new HalfCabinet();
           file.setEuropaid(123456);
           file.setName("Getam Supply");
           location.setUnit(1);
           location.setShelf(1);
           location.getFiles().add(file);
           hc.getLocations().add(location);
           System.out.println(hc.getLocations().get(0).getShelf());
           location.setUnit(1);
           location.setShelf(2);
           location.getFiles().add(file);
           hc.getLocations().add(location);
           System.out.println(hc.getLocations());
           System.out.println(hc.getLocations().get(0).getShelf());
           System.out.println(hc.getLocations().get(1).getShelf());
           hc.setNo(1);
           hc.setDivision("A");
           location.setHalfCabinet(hc);
           file.setLocation(location);

           // Location l=new Location();
           // l.setUnit(1);
           // l.setShelf(1);
           // File f = new File();
           // f.setName("Cagatay Deneme");
           // l.getFiles().add(f);
           // hc.getLocations().add(l);
           System.out.println("hayde bakalım");
           session.save(hc);
           // session.save(location);
           // session.save(file);
           tx.commit();
       }
   }

}
