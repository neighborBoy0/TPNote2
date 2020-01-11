package service.session;

import entity.*;

import java.util.List;

public class sessionBoat<T> extends session<Boat> {
    private  Boat b;

    public void edit(int id, String name){
        em.getTransaction().begin();
        b = super.queryByIndex(Boat.class, id);
        b.setName(name);
        em.getTransaction().commit();
    }

    public void edit(int id, float data){
        em.getTransaction().begin();
        b = super.queryByIndex(Boat.class, id);
        b.setWight(data);
        em.getTransaction().commit();
    }


    /**
     *
     * @param id id of Boat(SailBoat / MotorBoat)
     * @param idFK id of Foreign Key, it is the new host id or location id
     * @param classT class type(Location & Host)
     * @return boolean, true - it is success, false - failure
     */
    public boolean editForeignKey(int id, int idFK, Class<? extends T> classT){
        T t = super.queryByIndex(classT, idFK);
        b = super.queryByIndex(Boat.class, id);
        if(t == null || b == null){
            return false;
        }
        else{
            em.getTransaction().begin();
            if(classT.getSimpleName().equals("Location")){
                b.getLocation().setBoat(null);
                ((Location)t).setBoat(b);
                b.setLocation((Location)t);
            }
            else if(classT.getSimpleName().equals("Host")){
                List<Boat> boats = b.getHost().getBoats();
                boats.remove(b);
                ((Host)t).addBoats(b);
                b.setHost((Host)t);
            }
            else{
                return false;
            }
            em.getTransaction().commit();
            return true;
        }
    }

    /**
     *
     * @param id boat id (SailBoat or MotorBoat)
     * @param data SailBoat SailArea or MotorBoat HorsePower
     * @param classT class type(SailBoat or MotorBoat)
     * @return boolean, true - it is success, false - failure
     */
    public boolean editFeature(int id, float data, Class<? extends Boat> classT){
        Boat t = super.queryByIndex(classT, id);
        if(t == null){
            return false;
        }else{
            em.getTransaction().begin();
            if (classT.getSimpleName().equals("SailBoat")) {
                SailBoat s = (SailBoat) t;
                s.setSailArea(data);
            }else if(classT.getSimpleName().equals("MotorBoat")){
                MotorBoat m = (MotorBoat) t;
                m.setHorsePower(data);
            }
            em.getTransaction().commit();
            return true;
        }
    }

    public String getBoatType(int id){
        SailBoat sailBoat = em.find(SailBoat.class, id);
        if (sailBoat != null){
            return "SailBoat";
        }else{
            return "MotorBoat";
        }
    }

    public float getCharacter(int id){
        if (getBoatType(id).equals("SailBoat")){
            SailBoat sailBoat = em.find(SailBoat.class, id);
            return sailBoat.getSailArea();
        }else{
            MotorBoat motorBoat = em.find(MotorBoat.class, id);
            return motorBoat.getHorsePower();
        }
    }
}
