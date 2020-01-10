package service;
import entity.Location;
import service.session.sessionLocation;

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
}
