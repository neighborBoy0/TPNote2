package entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("S")
public class SailBoat extends Boat {

    private float sailArea;

    public SailBoat(){
    }

    public SailBoat(Boat boat){
        super(boat);
    }

    public SailBoat(String name, float wight, float sailArea) {
        super();
        super.setName(name);
        super.setWight(wight);
        this.sailArea = sailArea;
    }

    public float getSailArea() {
        return sailArea;
    }

    public void setSailArea(float sailArea) {
        this.sailArea = sailArea;
    }
}
