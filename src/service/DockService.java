package service;
import entity.Dock;
import entity.Location;
import service.session.session;
import service.session.sessionLocation;

import java.util.ArrayList;
import java.util.List;

public class DockService {
    private Dock dock;
    private List<Location> locations = new ArrayList<Location>();
    private session sl = new session();

    public void addDock(List<Location> locations){
        dock = new Dock();
        dock.setLocations(locations);
        dock.setNbLocation(locations.size());
        sl.addT(dock);
        for(Location location:locations){
            location.setDock(dock);
            sl.addT(location);
        }
    }

    public boolean delDock(int id){
        dock = (Dock)sl.queryByIndex(Dock.class, id);
        if(dock == null){
            return false;
        }
        for (Location location:locations) {
            location.getBoat().setLocation(null);
            sl.removeT(Location.class, location.getId());
        }
        sl.removeT(Dock.class, dock.getId());
        return true;
    }

    public boolean editDock(int id){
        return true;
    }

    public String ResearchDock(int id){
        dock = (Dock)sl.queryByIndex(Dock.class, id);
        String information = "Quai " + id +" a " + dock.getNbLocation() + " emplacements.";
        for (Location location : dock.getLocations()) {
            information = information + "\nEmplacement " + location.getId() + " est dans ce quai.";
            if (location.getBoat() != null){
                information = information + " Et bateau " + location.getBoat().getId() + " (qui s'appelle '" + location.getBoat().getName() + "') s'install ici.";
            }
            else{
                information = information + " Et ce emplacement est disponible";
            }
        }
        return information;
    }
}