package service;

import entity.*;
import service.session.session;
import service.session.sessionBoat;

import java.util.List;

public class BoatService<T> {
    private Boat boat;
    public sessionBoat sb = new sessionBoat();
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
        Location location = boat.getLocation();
        if(host != null){
            if(!host.delBoat(boat)) {
                return false;
            }
        }
        if(location != null){
            if(!location.delBoat(boat)) {
                return false;
            }
        }
        return s.removeT(Boat.class, boat.getId());
        //return true;
    }

    public boolean editBoat(int id, String name, String wight, String hostId, String locationId, String data){
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
            sb.editFeature(id, Float.valueOf(data), SailBoat.class);
        }else if(!data.equals("")){
            sb.editFeature(id, Float.valueOf(data), MotorBoat.class);
        }else{
            return false;
        }
        return true;
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

    public String researchBoatByIndex(int id){
        boat = (Boat) s.queryByIndex(Boat.class, id);
        if (boat == null){
            return "Pas du boat!";
        }else{
            String str = "Bateau " + boat.getId() + " s'appelle '" + boat.getName()
                    + "'.\n\tSon poids est " + boat.getWight() + ". Il s'install l'emplacement "
                    + boat.getLocation().getId() + " dans la quai " + boat.getLocation().getDock().getId();
            if(getBoatType(id).equals("SailBoat")){
                str = str + ".\n\tC'est un bateau à voile, sa surface de voile est " + getBoatCharacter(id);
            }else if(getBoatType(id).equals("MotorBoat")){
                str = str + ".\n\tC'est un bateau à moteur, son moteur est " + getBoatCharacter(id);
            }
            str = str + ".\n\tSon propriétaire est '" + boat.getHost().getName() + "' dont id est " + boat.getHost().getId();
            return str;
        }
    }

    public String researchBoatByCon(String type, String con, float n){
        if(type.equals("SailBoat")){
            String str = "SELECT sailBoat.id FROM SailBoat sailBoat WHERE sailBoat.sailArea " + con + ":n";
            List<Integer> sailBoatsIndex = (List<Integer>) s.findByJpaQl(str, n);
            String strResult = "Nous avons trouvé " + sailBoatsIndex.size() + " bateaux correspondant.\n\t";
            for (int i = 0; i < sailBoatsIndex.size(); i++){
                SailBoat boat = (SailBoat) s.queryByIndex(SailBoat.class, sailBoatsIndex.get(i));
                strResult = strResult + (i+1) + ". Bateau " + sailBoatsIndex.get(i)
                        + " s'appelle " + boat.getName() + ". Sa surface de voile est "
                        + boat.getSailArea() + ".\n\t";
                if(boat.getHost()!=null){
                    strResult = strResult + "Son propriétaire est '" + boat.getHost().getName()
                        + "', dont id est " + boat.getHost().getId() + ".\n\t";
                }else{
                    strResult = strResult + "Ce bateau n'a pas propriétaire encore.\n\t";
                }
                if(boat.getLocation() != null) {
                    strResult = strResult + "Et, il s'install à emplacement "
                            + boat.getLocation().getId() + " dans le quai " + boat.getLocation().getDock().getId() + ".\n\t";
                }else{
                    strResult = strResult + "Ce bateau n'a pas emplacement encore.\n\t";
                }
            }
            return strResult;
        }else if(type.equals("MotorBoat")){
            String str = "SELECT motorBoat.id FROM MotorBoat motorBoat WHERE motorBoat.motorArea " + con + ":n";
            List<Integer> motorBoatsIndex = (List<Integer>) s.findByJpaQl(str, n);
            String strResult = "Nous avons trouvé " + motorBoatsIndex.size() + " bateau(x) correspondant.";
            for (int i = 0; i < motorBoatsIndex.size(); i++){
                MotorBoat boat = (MotorBoat) s.queryByIndex(MotorBoat.class, motorBoatsIndex.get(i));
                strResult = strResult + (i+1) + ". Bateau " + motorBoatsIndex.get(i)
                        + " s'appelle " + boat.getName() + ". Sa moteur est "
                        + boat.getHorsePower() + ".\n\t";
                if(boat.getHost() != null){
                    strResult = strResult + "Son propriétaire est '" + boat.getHost().getName()
                            + "', dont id est " + boat.getHost().getId() + ".\n\t";
                }else{
                    strResult = strResult + "Ce bateau n'a pas propriétaire encore.\n\t";
                }
                if(boat.getLocation() != null) {
                    strResult = strResult + "Et, il s'install à emplacement "
                            + boat.getLocation().getId() + " dans le quai " + boat.getLocation().getDock().getId() + ".\n\t";
                }else{
                    strResult = strResult + "Ce bateau n'a pas emplacement encore.\n\t";
                }
            }
            return strResult;
        }else{
            return "Entrer, s'il vous plais.";
        }
    }

    public String researchBoatByWight(String con, float n){
        String jpaQl = "SELECT boat.id FROM Boat boat WHERE boat.wight " + con + ":n";
        List<Integer> boatsIndex = (List<Integer>) s.findByJpaQl(jpaQl, n);
        String strResult = "Nous avons trouvé " + boatsIndex.size() + " bateau(x) correspondant.\n\t";
        for (int i = 0; i < boatsIndex.size(); i++){
            boat = (Boat) s.queryByIndex(Boat.class, boatsIndex.get(i));
            strResult = strResult + (i+1) + ". Bateau " + boatsIndex.get(i) + " s'appelle '"
                    + boat.getName() + "'. Son poids est " + boat.getWight()
                    + ".\n\tEt, il est un ";
            if(getBoatType(boat.getId()).equals("SailBoat")){
                strResult = strResult + "bateau à voile, dont surface de voile est " + getBoatCharacter(boat.getId()) + ".\n\t";
            }else{
                strResult = strResult + "bateau à moteur, dont moteur est " + getBoatCharacter(boat.getId()) + ".\n\t";
            }
            if(boat.getHost() != null){
                strResult = strResult + "Son propriétaire est '" + boat.getHost().getName()
                        + "', dont id est " + boat.getHost().getId() + ".\n\t";
            }else{
                strResult = strResult + "Ce bateau n'a pas propriétaire encore.\n\t";
            }
            if(boat.getLocation() != null) {
                strResult = strResult + "Et, il s'install à emplacement "
                        + boat.getLocation().getId() + " dans le quai " + boat.getLocation().getDock().getId() + ".\n\t";
            }else{
                strResult = strResult + "Ce bateau n'a pas emplacement encore.\n\t";
            }
        }
        return strResult;
    }
}
