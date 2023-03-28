package iut.sae.Service;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Service {
    private ObjectInputStream objectInputStream;
    private ObjectOutputStream objectOutputStream;

    public Service(ObjectOutputStream objectOutputStream, ObjectInputStream objectInputStream){
        this.objectInputStream = objectInputStream;
        this.objectOutputStream = objectOutputStream;
    }

}
