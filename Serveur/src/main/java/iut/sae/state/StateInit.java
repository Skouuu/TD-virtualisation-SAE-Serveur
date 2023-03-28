package iut.sae.state;

import iut.sae.Model.Scrutateur;
import iut.sae.Paquet.PublicKeyPaquet;
import iut.sae.Repository.PublicKeyRepository;

public class StateInit extends State {
    public StateInit(Sock sock) {
        super(sock);
    }

    @Override
    void connect() {
        System.out.println("connect");
        this.getSocket().changeState(new StateConnected(getSocket()));
    }

    @Override
    public void connectAdmin() {
        System.out.println("connect Admin");
        this.getSocket().changeState(new StateAdmin(getSocket()));
    }

    @Override
    public String toString() {
        return "init";
    }

    @Override
    public void publicKey() {
        System.out.println("publick key demandé");
    }

    @Override
    public void QUESTION_DATE_FIN_FINI() {
        System.out.println("aaa");
    }

    @Override
    public void userUpdate() {
        System.out.println("user update");
    }

    @Override
    void undo() {
        getSocket().changeState(new StateClosed(getSocket()));
    }
}
