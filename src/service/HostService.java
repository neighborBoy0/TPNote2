package service;

import entity.Boat;
import entity.Host;
import service.session.session;
import service.session.sessionBoat;
import service.session.sessionHost;

import java.util.List;

public class HostService {
    Host host;
    public session s = new session();
    BoatService bs = new BoatService();
    List<Boat> boatList;

    public boolean createHost(String name, String address){
        host = new Host();
        host.setName(name);
        host.setAddress(address);
        s.addT(host);
        return true;
    }

    public boolean delHost(int id){
        host = (Host)s.queryByIndex(Host.class, id);
        if(host == null){
            return false;
        }else{
            for (Boat boat:host.getBoats()) {
                sessionBoat sb = new sessionBoat();
                sb.editForeignKey(boat.getId(),0,Host.class);
            }
            s.removeT(Host.class, id);
            return true;
        }
    }

    public boolean editHost(int id, String name, String address){
        host = (Host) s.queryByIndex(Host.class, id);
        sessionHost sh = new sessionHost();
        if(host == null){
            return false;// not find in db
        }else{
            if(!name.equals("")){
                sh.edit(id, name, "N");
            }
            if(!address.equals("")){
                sh.edit(id, address, "A");
            }
            return true;
        }
    }

    public String rearchHost(int id){
        Host host = (Host) (s.queryByIndex(Host.class, id));
        if(host == null){
            return "Pas de cette personne!";
        }else {
            String str = "Propriétaire " + id + " s'appelle '";
            str = str + host.getName() + "'.\nIl/Elle habite " + host.getAddress() + ".\nIl/Elle a " + host.getBoats().size() + " bateau(x).\n";
            for (int i = 0; i < host.getBoats().size(); i++) {
                str = str + (i + 1) + ". Bateau " + host.getBoats().get(i).getId()
                        + " s'appelle '" + host.getBoats().get(i).getName()
                        + "'. Son poids est " + host.getBoats().get(i).getWight();
                String t = bs.getBoatType(host.getBoats().get(i).getId());
                if (t.equals("SailBoat")) {
                    str = str + ".\n\tC'est un bateau à voiles, et sa surface voile est " + bs.getBoatCharacter(host.getBoats().get(i).getId()) + "m^2.\n";
                } else if (t.equals("MotorBoat")) {
                    str = str + ".\n\tC'est un bateau , et son moteur est " + bs.getBoatCharacter(host.getBoats().get(i).getId()) + "W.\n";
                }
            }
            return str;
        }
    }

    public List<Host> getAllHost(){
        return (List<Host>) s.findAll(Host.class);
    }
}
