package entity;

import javax.persistence.Entity;

@Entity
public class SailBoat extends Boat {
    private float surface;

    public float getSurface() {
        return surface;
    }

    public void setSurface(float surface) {
        this.surface = surface;
    }
}
