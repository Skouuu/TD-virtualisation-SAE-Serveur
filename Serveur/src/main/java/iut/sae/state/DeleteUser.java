package iut.sae.state;

import iut.sae.Paquet.DeleteUserPaquet;
import iut.sae.Paquet.Paquet;
import iut.sae.Repository.UserRepository;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class DeleteUser implements Commande {

    private Sock sock;

    public DeleteUser(Sock sock){
        this.sock = sock;
    }

    @Override
    public void execute(Paquet paquet, ObjectInputStream objectInputStream, ObjectOutputStream objectOutputStream) {
        DeleteUserPaquet deleteUserPaquet = (DeleteUserPaquet) paquet;
        UserRepository.supprimer(deleteUserPaquet.getEmail());
        try {
            objectOutputStream.writeObject("ok");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
