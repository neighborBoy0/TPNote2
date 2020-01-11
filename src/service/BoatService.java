package service;

import entity.*;
import service.session.session;
import service.session.sessionBoat;

import java.util.List;

public class BoatService<T> {
    private Boat boat;
    private sessionBoat sb = new sessionBoat();
    private session s = new session();

    public boolean addBoat(String name, String type, String wight, String hostId, String locationId,String character){
        if (type.equals("SailBoat") || type.equals("Sailboat") || type.equals("sailBoat") || type.equals("S") || type.equals("s")){
            SailBoat newBoat = new SailBoat();
            newBoat.setName(name);
            newBoat.setWight(Float.valueOf(wight));
            newBoat.setSailArea(Float.valueOf(character));
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
            newBoat.setHorsePower(Float.valueOf(character));
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

    public void editBoat(int id, String name, String wight, String hostId, String locationId, String data){
        if(!name.equals("")){
            sb.edit(id,name);
        }
        if(!wight.equals("")){
            sb.edit(id,Float.valueOf(wight));
        }
        if(!hostId.equals("")){
            sb.editForeignKey(id,Integer.valueOf(hostId),Host.class);
        }
        if(!locationId.equals("")) {
            sb.editForeignKey(id, Integer.valueOf(locationId), Location.class);
        }
        SailBoat sailBoat = (SailBoat) s.queryByIndex(SailBoat.class, id);
        if(sailBoat != null && !data.equals("")){
            sb.editFeature(id,Float.valueOf(data),SailBoat.class);
        }else if(!data.equals("")){
            sb.editFeature(id,Float.valueOf(data),MotorBoat.class);
        }
    }

    public String getBoatType(int id){
        return sb.getBoatType(id);
    }

    public float getBoatCharacter(int id){
        return sb.getCharacter(id);
    }

    public List<Boat> getAllBoat(){
        return new session<Boat>().findAll(Boat.class);
    }
}
