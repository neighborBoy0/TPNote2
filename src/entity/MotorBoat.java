package entity;

import javax.persistence.Entity;

@Entity
public class MotorBoat extends Boat{
    private float horsePower;

    public float getHorsePower() {
        return horsePower;
    }

    public void setHorsePower(float horsePower) {
        this.horsePower = horsePower;
    }
}
