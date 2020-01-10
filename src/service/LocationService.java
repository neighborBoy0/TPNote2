package service;
import entity.Location;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class LocationService {
    //private Location location;
    //private LocationDAO locationDAO = new LocationDAO();

    public Location createLocation(String size){

        Location tempLocation = new Location();
        tempLocation.setSize(size);
        //locationDAO.addLocation(tempLocation);
        return tempLocation;
    }
}
