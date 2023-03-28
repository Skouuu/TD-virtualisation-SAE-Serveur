package iut.sae.state;

public class StateConnected extends State {


    public StateConnected(Sock sock) {
        super(sock);
    }

    @Override
    public String toString() {
        return "connected";
    }

    @Override
    void close() {
        System.out.println("close");
        this.getSocket().changeState(new StateClosed(getSocket()));
    }

    @Override
    void result() {
        System.out.println("resultat demandé");
    }

    @Override
    void undo() {
        getSocket().changeState(new StateInit(getSocket()));
    }

    @Override
    void questionAll() {
        System.out.println("question All demandé");
    }

    @Override
    public void question() {
        getSocket().changeState(new StateDemandeQuestion(getSocket()));
        System.out.println("question demandé ");
    }

    @Override
    public void questionFini() {
        System.out.println("question fini demandé");
    }
}
