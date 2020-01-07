package entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Dock {

    @Id
    private int id;

    private int nbLocation;

    @OneToMany
    private List<Dock> docks;

    public Dock(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNbLocation() {
        return nbLocation;
    }

    public void setNbLocation(int nbLocation) {
        this.nbLocation = nbLocation;
    }

    public List<Dock> getDocks() {
        return docks;
    }

    public void setDocks(List<Dock> docks) {
        this.docks = docks;
    }
}
