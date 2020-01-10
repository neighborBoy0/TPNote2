package service.session;

import entity.Boat;
import entity.Location;

public class sessionLocation<T> extends session<Location> {
    Location l;

    public void editSize(int id, String size){
        em.getTransaction().begin();
        l = super.queryByIndex(Location.class, id);
        l.setSize(size);
        em.getTransaction().commit();
    }

    public void editBoat(int id, Boat boat){
        em.getTransaction().begin();
        l = super.queryByIndex(Location.class, id);
        l.setBoat(boat);
        em.getTransaction().commit();
    }
}
