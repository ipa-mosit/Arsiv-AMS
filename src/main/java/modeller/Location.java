package modeller;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table
public class Location{
    // @GeneratedValue(strategy=GenerationType.IDENTITY)
    // private Long id;
    @Id
    public String locId;
    public int kabinNo;
    public char kabinKisim;
    public int unit;
    public int shelf;


    @ManyToMany(mappedBy="locations")
    private Set<File>files=new HashSet<>();

    // @OneToMany(mappedBy="location",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
    // private List<File> files=new ArrayList<File>();

    // @ManyToOne
    // @JoinColumn(name="halfcabinet_id")
    // private HalfCabinet halfCabinet;

    public Location(){
    }
    public Location(int kabinNo,char kabinKisim,int unit, int shelf){
        idGenerate();
    }
    public void idGenerate(){
        this.locId=String.valueOf(kabinNo)+String.valueOf(kabinKisim)+String.valueOf(unit)+String.valueOf(shelf);
    }
    @Override
    public int hashCode() {
        return Objects.hash(locId);
    }
    public String toString(){
        String info=String.format("(kabin: %d/%c,unite: %d,raf: %d)",kabinNo,kabinKisim,unit,shelf);
        // for(File file:files){
            // info=info+file;  
        // }
        return info;
    }

    public void setLocId(String locId) {
        this.locId = locId;
    }

    public String getLocId() {
        return locId;
    }

    public void setKabinNo(int kabinNo) {
        this.kabinNo = kabinNo;
    }

    public int getKabinNo() {
        return kabinNo;
    }

    public void setKabinKisim(char kabinKisim) {
        this.kabinKisim = kabinKisim;
    }

    public char getKabinKisim() {
        return kabinKisim;
    }

    public void setUnit(int unit) {
        this.unit = unit;
    }

    public int getUnit() {
        return unit;
    }

    public void setShelf(int shelf) {
        this.shelf = shelf;
    }

    public int getShelf() {
        return shelf;
    }

    public void setFiles(Set<File> files) {
        this.files = files;
    }

    public Set<File> getFiles() {
        return files;
    }
}
