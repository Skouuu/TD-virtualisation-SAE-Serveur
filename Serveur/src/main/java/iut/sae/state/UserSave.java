package iut.sae.state;

import iut.sae.Paquet.EnregistrerUserPacket;
import iut.sae.Paquet.Paquet;
import iut.sae.Repository.UserRepository;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.SQLException;

public class UserSave implements Commande{
    private Sock sock;

    public UserSave(Sock sock){
        this.sock = sock;
    }

    @Override
    public void execute(Paquet paquet, ObjectInputStream objectInputStream, ObjectOutputStream objectOutputStream) {
        EnregistrerUserPacket n = (EnregistrerUserPacket) paquet;

        try {
            UserRepository.enregistrer(n.getUser());
            objectOutputStream.writeObject(n.getUser().getEmail());
        } catch (SQLException | IOException e) {
            throw new RuntimeException(e);
        }

    }
}
