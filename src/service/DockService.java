package service;
import entity.Dock;
import entity.Location;

import java.util.ArrayList;
import java.util.List;

public class DockService {
    private Dock dock;
    private List<Location> locations = new ArrayList<Location>();

    public void addDock(List<Location> locations){
        dock = new Dock();

    }

    public void addLocations(Dock dock, List<Location> locations){
        dock.setLocations(locations);
        dock.setNbLocation(locations.size());
    }

    public void delLocation(int id){

    }
}