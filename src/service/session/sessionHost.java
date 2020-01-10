package service.session;

import entity.Host;

public class sessionHost extends session<Host> {
    private Host host;

    public static final String ADDRESS = "A";
    public static final String NAME = "N";

    public boolean edit(int id, String data, String type){
        host = super.queryByIndex(Host.class, id);
        if (host == null){
            return false;
        }else{
            em.getTransaction().begin();
            if(type == ADDRESS){
                host.setAddress(data);
            }else if(type == NAME){
                host.setName(data);
            }
            em.getTransaction().commit();
            return true;
        }
    }
}
