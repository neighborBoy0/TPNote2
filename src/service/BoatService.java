package service;

import entity.*;
import service.session.session;
import service.session.sessionBoat;

public class BoatService<T> {
    private Boat boat;
    private sessionBoat sb = new sessionBoat();
    private session s = new session();

    public boolean addBoat(String name, String type, String wight, String hostId, String locationId){
        if (type.equals("SailBoat") || type.equals("Sailboat") || type.equals("sailBoat") || type.equals("S") || type.equals("s")){
            SailBoat newBoat = new SailBoat();
            newBoat.setName(name);
            newBoat.setWight(Float.valueOf(wight));
            if(!hostId.equals("")){
                Host host = (Host)s.queryByIndex(Host.class, Integer.valueOf(hostId));
                newBoat.setHost(host);
                host.addBoats(newBoat);
            }else{
                newBoat.setHost(null);
            }
            if(!locationId.equals("")){
                Location location = (Location)s.queryByIndex(Location.class, Integer.valueOf(locationId));
                newBoat.setLocation(location);
                location.setBoat(newBoat);
            }else{
                newBoat.setLocation(null);
            }
            s.addT(newBoat);
        }else if(type.equals("MotorBoat") || type.equals("Motorboat") || type.equals("motorBoat") || type.equals("M") || type.equals("m")){
            MotorBoat newBoat = new MotorBoat();
            newBoat.setName(name);
            newBoat.setWight(Float.valueOf(wight));
            if(!hostId.equals("")){
                Host host = (Host)s.queryByIndex(Host.class, Integer.valueOf(hostId));
                newBoat.setHost(host);
                host.addBoats(newBoat);
            }else{
                newBoat.setHost(null);
            }
            if(!locationId.equals("")){
                Location location = (Location)s.queryByIndex(Location.class, Integer.valueOf(locationId));
                newBoat.setLocation(location);
                location.setBoat(newBoat);
            }else{
                newBoat.setLocation(null);
            }
            s.addT(newBoat);
        }else{
            return false;
        }
        return true;
    }

    public boolean delBoat(int id){
        boat = (Boat)s.queryByIndex(Boat.class, id);
        Host host = boat.getHost();
        if(host.delBoat(boat)) {
            return s.removeT(Boat.class, id);
        }else{
            return false;
        }
    }
}
