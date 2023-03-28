package iut.sae.Model;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Scrutateur {

    private ObjectOutputStream objectOutputStream;
    private ObjectInputStream objectInputStream;


    private static Scrutateur INSTANCE;

    public Scrutateur(ObjectInputStream objectInputStream, ObjectOutputStream objectOutputStream){
        this.objectInputStream = objectInputStream;
        this.objectOutputStream = objectOutputStream;
        INSTANCE = this;
    }

    public static Scrutateur getINSTANCE() {
        return INSTANCE;
    }

    public void send(Object o) throws IOException {
        objectOutputStream.writeObject(o);
    }
    public Object read(Object o) throws IOException, ClassNotFoundException {
        return objectInputStream.readObject();
    }

}
