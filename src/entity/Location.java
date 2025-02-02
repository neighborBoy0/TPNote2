package entity;

import javax.persistence.*;

@Entity
public class Location {
    @Id
    @GeneratedValue
    private int id;

    private String size;

    @OneToOne
    private Boat boat;

    @ManyToOne
    private Dock dock;

    public Location(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public Boat getBoat() {
        return boat;
    }

    public void setBoat(Boat boat) {
        this.boat = boat;
    }

    public Dock getDock() {
        return dock;
    }

    public void setDock(Dock dock) {
        this.dock = dock;
    }

    public boolean delBoat(Boat boat){
        this.boat = null;
        return true;
    }
}
