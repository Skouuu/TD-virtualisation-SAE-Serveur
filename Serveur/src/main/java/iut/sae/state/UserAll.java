package iut.sae.state;

import iut.sae.Model.User;
import iut.sae.Paquet.AllUserPaquet;
import iut.sae.Paquet.Paquet;
import iut.sae.Repository.UserRepository;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

public class UserAll implements Commande{

    private Sock sock;

    public UserAll(Sock sock){
        this.sock = sock;
    }

    @Override
    public void execute(Paquet paquet, ObjectInputStream objectInputStream, ObjectOutputStream objectOutputStream) {
        System.out.println("user");


        if(sock.getUser().getRole().equals("ROLE_ADMIN")){
            System.out.println("admin");
            List<User> list1 = UserRepository.getAllUsers();
            AllUserPaquet allUserPaquet = new AllUserPaquet(list1);
            try {
                objectOutputStream.writeObject(allUserPaquet);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            try {
                objectOutputStream.writeObject("erreur");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
