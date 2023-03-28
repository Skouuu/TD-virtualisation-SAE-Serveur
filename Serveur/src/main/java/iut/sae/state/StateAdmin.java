package iut.sae.state;

public class StateAdmin extends StateConnected{


    public StateAdmin(Sock sock) {
        super(sock);
    }

    @Override
    void result() {
        System.out.println("result");
    }

    @Override
    void undo() {
        getSocket().changeState(new StateInit(getSocket()));
    }

    @Override
    public void deleteUser() {
        System.out.println("delete user");
    }

    @Override
    public void userAll() {
        System.out.println("user all");
    }

    @Override
    public void userSave() {
        System.out.println("user save");
    }

    @Override
    public void questionFin() {
        System.out.println("question fini");
    }

    @Override
    public void questionCreate() {
        System.out.println("question create");
    }


    @Override
    public void questionFini() {
        System.out.println("question fini demandé");
    }
}
