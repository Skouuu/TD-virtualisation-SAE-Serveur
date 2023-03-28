package iut.sae.state;

public class StateDemandeQuestion extends State{
    public StateDemandeQuestion(Sock sock) {
        super(sock);
    }

    @Override
    void vote() {
        System.out.println("vote");
    }

    @Override
    public void publicKeyClient() {
        System.out.println("public key client");
    }

    @Override
    void undo() {
        getSocket().changeState(new StateConnected(getSocket()));
    }
}
