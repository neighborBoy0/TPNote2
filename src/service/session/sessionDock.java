package service.session;

import entity.Dock;
import entity.Location;

import java.util.List;

public class sessionDock extends session<Dock> {
    private Dock dock;

    public void addT(List<Location> locations){
        dock = new Dock();
        dock.setLocations(locations);
        dock.setNbLocation(locations.size());
        em.getTransaction().begin();
        em.persist(dock);
        em.getTransaction().commit();
    }
}
