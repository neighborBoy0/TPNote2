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

    public void delLocation(int id){

    }

    public List<Location> getAllLocation(){
        return new session<Location>().findAll(Location.class);
    }
}
