package iut.sae.state;

public class StateClosed extends State {

    public StateClosed(Sock sock) {
        super(sock);
    }

    @Override
    public String toString() {
        return "closed";
    }

    void reset(){
        this.getSocket().changeState(new StateInit(this.getSocket()));
    }
}
