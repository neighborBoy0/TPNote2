package service;
import entity.Location;

public class LocationService {
    private Location location;

    public Location createLocation(String size){
        Location tempLocation = new Location();
        tempLocation.setSize(size);
        return tempLocation;
    }
}
