package iut.sae.state;

import iut.sae.Service.LoginService;
import iut.sae.Paquet.Paquet;
import iut.sae.Paquet.UserPaquet;
import iut.sae.SSLServer;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Connect implements Undoable{
    private Sock sock;
    private Paquet paquet;

    public Connect(Sock sock){
        this.sock = sock;
    }

    @Override
    public void execute(Paquet paquet, ObjectInputStream objectInputStream, ObjectOutputStream objectOutputStream) {

        UserPaquet user = (UserPaquet) paquet ;
        System.out.println("login en cours");

        System.out.println("----------email recu : " + user.getUser().getEmail());
        System.out.println("---------password recu : " + user.getUser().getMotDePasse());
        sock.setLoginService(new LoginService(user.getUser(), objectInputStream, objectOutputStream));
        //loginService.connect();

        sock.setUser(sock.getLoginService().getUserLogin());
        sock.getLoginService().sendResult();

        if(sock.getLoginService().estConnecte()){
            if(sock.getLoginService().estAdmin()){
                sock.connectAdmin();
            } else {
                sock.connect();
            }
        } else {
            // signin => non connecté => update
        }

    }

    @Override
    public void undo() {
        sock.undo();
    }
}
