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
    public LocationService ls = new LocationService();

    public boolean addDock(List<Location> locations){
        dock = new Dock();
        dock.setLocations(locations);
        dock.setNbLocation(locations.size());
        sl.addT(dock);
        for(Location location:locations){
            location.setDock(dock);
            sl.addT(location);
        }
        return true;
    }

    public boolean delDock(int id){
        dock = (Dock)sl.queryByIndex(Dock.class, id);
        if(dock == null){
            return false;
        }
        for (Location location : dock.getLocations()) {
            if(location.getBoat()!=null) {
                location.getBoat().setLocation(null);
            }
            dock.delLocation(location);
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
        if (dock == null){
            return "Quai " + id + " n'exsite pas!";
        }else {
            String information = "Quai " + id + " a " + dock.getNbLocation() + " emplacements.";
            for (Location location : dock.getLocations()) {
                information = information + "\nEmplacement " + location.getId() + " est dans ce quai.";
                if (location.getBoat() != null) {
                    information = information + " Et bateau " + location.getBoat().getId() + " (qui s'appelle '" + location.getBoat().getName() + "') s'install ici.";
                } else {
                    information = information + " Et ce emplacement est disponible";
                }
            }
            return information;
        }
    }

    public List<Dock> getAllDock(){
        return new session<Dock>().findAll(Dock.class);
    }

    public String addLoucation(int idDock, String size){
        Location location = new Location();
        dock = (Dock) sl.queryByIndex(Dock.class, idDock);
        location.setDock(dock);
        //int t = dock.getNbLocation();
        //dock.setNbLocation(t+1);
        location.setSize(size);
        dock.addLocation(location);
        sl.addT(location);
        String str = "Vous avez ajouté un emplacement dans le quai " + dock.getId()
                + " qui a " + dock.getNbLocation() + " emplacements, et ils sont:\n\t";
        for(int i = 0; i < dock.getNbLocation(); i++){
            str = str + (i+1) + ". Emplacement " + dock.getLocations().get(i).getId()
                    + ", sa taille est " + dock.getLocations().get(i).getSize() + ".\n\t";
            if(dock.getLocations().get(i).getBoat() != null){
                str = str + "Bateau " + dock.getLocations().get(i).getBoat().getId()
                        + " s'inatlle ici.\n\t";
            }else{
                str = str + "Pas de bateau s'intalle ici.\n\t";
            }
        }
        return str;
    }

    public int getNbBoat(int idDock){
            dock = (Dock) sl.queryByIndex(Dock.class, idDock);
            locations = dock.getLocations();
            int nb = 0;
        for (Location location: locations) {
            if (location.getBoat() != null){
                nb+=1;
            }
        }
        return nb;
    }
}