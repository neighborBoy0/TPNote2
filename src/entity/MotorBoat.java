package entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("M")
public class MotorBoat extends Boat{
    private float horsePower;

    public MotorBoat(){}

    public MotorBoat(Boat boat){
        super(boat);
    }

    public float getHorsePower() {
        return horsePower;
    }

    public void setHorsePower(float horsePower) {
        this.horsePower = horsePower;
    }
}
