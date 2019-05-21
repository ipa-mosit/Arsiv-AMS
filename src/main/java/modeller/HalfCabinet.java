package modeller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;


@Entity
@Table
public class HalfCabinet{
    // @GeneratedValue(strategy=GenerationType.IDENTITY)
    // @Column(name="id",updatable=false,nullable=false)
    // private Long id;
    @Id
    // private Integer no;
    // private char division;
    String Id;

    // @OneToMany(mappedBy="halfCabinet",fetch=FetchType.LAZY,cascade=CascadeType.ALL)
    // private List<Location> locations = new ArrayList<Location>();

    public HalfCabinet(){
        super();
    }

    // public void setNo(Integer no) {
    //     this.no = no;
    // }

    // public Integer getNo() {
    //     return no;
    // }

    // public void setId(Long id) {
    //     this.id = id;
    // }

    // public Long getId() {
    //     return id;
    // }

    // public void setDivision(char division) {
    //     this.division = division;
    // }

    // public char getDivision() {
    //     return division;
    // }

    // public void setLocations(List<Location> locations) {
    //     this.locations = locations;
    // }

    // public List<Location> getLocations() {
    //     return locations;
    // }
    public String toString(){
        // String info1=String.format("Kabin: %s\nLokasyonlar:\n",Id);
        // // ArrayList<String>locas=new ArrayList<String>();
        // for(Location loc:locations){
        //     // locas.add(loc.toString()); 
        //     info1=info1+"\n"+loc;
        // }
        return "hede";
    }
}

