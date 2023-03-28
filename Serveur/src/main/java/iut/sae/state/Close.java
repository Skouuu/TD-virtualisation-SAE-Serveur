package iut.sae.state;

import iut.sae.Paquet.Paquet;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Close implements Undoable{

    private Sock sock;
    public Close(Sock sock){
        this.sock = sock;
    }
    @Override
    public void execute(Paquet paquet, ObjectInputStream objectInputStream, ObjectOutputStream objectOutputStream) {
        sock.close();
    }

    @Override
    public void undo() {
        sock.undo();
    }

}
