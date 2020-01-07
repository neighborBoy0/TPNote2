package entity;

import javax.persistence.*;

@Entity
public class Boat {
    @Id
    @GeneratedValue
    private int id;
    @Column(nullable = false, unique = true)
    private String name;

    private float wight;

    @OneToOne
    private Location location;

    @ManyToOne
    private Host host;

    public Boat(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getWight() {
        return wight;
    }

    public void setWight(float wight) {
        this.wight = wight;
    }

    public Host getHost() {
        return host;
    }

    public void setHost(Host host) {
        this.host = host;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
