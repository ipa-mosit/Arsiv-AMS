package modeller;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table

public class File{
    @Id
    public String name;
    private Integer europaid;
    private String notes;
    
    @ManyToMany(cascade={CascadeType.ALL})
    @JoinTable(
    name="File_Location",
    joinColumns={@JoinColumn(name="file_name")},
    inverseJoinColumns={@JoinColumn(name="locId")}
    )
    public Set<Location>locations=new HashSet<>();

    public File(){
        super();
    }
    public File(String name,int europaid,String notes){
        this.name=name;
        this.europaid=europaid;
        this.notes=notes;
    }

    @Override
public int hashCode() {
    return Objects.hash(name);
}
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setEuropaid(Integer europaid) {
        this.europaid = europaid;
    }

    public Integer getEuropaid() {
        return europaid;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getNotes() {
        return notes;
    }


    public void setLocations(Set<Location> locations) {
        // this.locations = locations;
                for(Location lc:locations) {this.locations.add(lc);
                    // System.out.println("hede "+lc);
                }
    }

    public Set<Location> getLocations() {
        return locations;
    }
    public String toString(){
        String flocs=String.format("isim: %s europaid no:%d Lokasyon:\n",name,europaid);
        for (Location loc:locations){
           flocs=flocs+loc; 
        }
        return flocs;
        // return String.format("isim: %s europaid no:%d",name,europaid);
    }
}
