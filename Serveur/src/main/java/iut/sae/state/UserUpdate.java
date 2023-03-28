package iut.sae.state;

import iut.sae.Paquet.Paquet;
import iut.sae.Paquet.UserUpdatePaquet;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class UserUpdate implements Commande{
    private Sock sock;

    public UserUpdate(Sock sock){
        this.sock = sock;
    }

    @Override
    public void execute(Paquet paquet, ObjectInputStream objectInputStream, ObjectOutputStream objectOutputStream) {
        UserUpdatePaquet userUpdatePaquet = (UserUpdatePaquet) paquet;

        if(sock.getLoginService() != null){
            System.out.println("changement de mot de passe --------------------------------");
            sock.getLoginService().update(userUpdatePaquet.getPassword());

            System.out.println("utilisateur courant : " + sock.getUser().getEmail());
            sock.getLoginService().connect();
            sock.getLoginService().sendResult();
            sock.connect();
        } else {
            try {
                objectOutputStream.writeObject("error");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
