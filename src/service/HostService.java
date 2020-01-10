package service;

import entity.Boat;
import entity.Host;
import service.session.session;
import service.session.sessionBoat;
import service.session.sessionHost;

import java.util.List;

public class HostService {
    Host host;
    session s = new session();
    List<Boat> boatList;

    public void createHost(String name, String address){
        host = new Host();
        host.setName(name);
        host.setAddress(address);
        s.addT(host);
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
}
