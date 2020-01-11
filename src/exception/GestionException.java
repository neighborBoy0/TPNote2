package exception;

import javax.persistence.GeneratedValue;

public class GestionException extends Exception{

    public GestionException(String ss){
        super(ss);
    }
}
