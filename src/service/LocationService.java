package service;
import entity.Location;
import service.session.session;
import service.session.sessionLocation;

import java.util.List;

public class LocationService {
    private Location location;
    private sessionLocation sl = new sessionLocation();

    public Location createLocation(String size){
        location = new Location();
        location.setSize(size);
        return location;
    }

    public boolean delLocation(int id){
        Location location = (Location) sl.queryByIndex(Location.class, id);
        if(location == null){
            return false;
        }else{
            if(location.getBoat()!=null){
                location.getBoat().setLocation(null);
            }
            int n = location.getDock().getNbLocation();
            location.getDock().setNbLocation(n-1);
            location.getDock().getLocations().remove(location);
            return sl.removeT(Location.class,id);
        }
    }

    public List<Location> getAllLocation(){
        return new session<Location>().findAll(Location.class);
    }
}
