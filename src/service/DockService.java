package service;
import entity.Dock;
import entity.Location;

import java.util.List;

public class DockService {
    private List<Location> locations;
    private Dock dock;

    public Dock createDock(){
        dock = new Dock();
        dock.setNbLocation(locations.size());
        locations.clear();
        return dock;
    }

    public void addLocation(Location location){
        location.setDock(dock);
        locations.add(location);
    }

    public void delLocation(int id){

    }
}