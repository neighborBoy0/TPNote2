package entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Dock {

    @Id
    @GeneratedValue
    private int id;

    private int nbLocation;

    @OneToMany(mappedBy = "dock")
    private List<Location> locations;

    public Dock() {
    }

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

    public List<Location> getLocations() {
        return locations;
    }

    public void setLocations(List<Location> locations) {
        this.locations = locations;
    }

    public boolean delLocation(Location location){
        nbLocation -= 1;
        return this.locations.remove(location);
    }

    public boolean addLocation(Location location){
        nbLocation += 1;
        return this.locations.add(location);
    }
}