package iut.sae.state;

public abstract class State {

    private Sock sock;
    public State(Sock sock){
        this.sock = sock;
    }

    public Sock getSocket() {
        return sock;
    }
    void connect(){
        System.out.println("not authorized : connect");
        try {
            throw new Exception("not authorized");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    void accept(){
        System.out.println("not authorized : accept");

        try {
            throw new Exception("not authorized");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    void close(){
        System.out.println("not authorized : close");

        try {
            throw new Exception("not authorized");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    void read(){}
    void undo(){
        System.out.println("not authorized : undo");

        try {
            throw new Exception("not authorized");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    void vote(){
        System.out.println("not authorized : vote");

        try {
            throw new Exception("not authorized");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    void result(){
        System.out.println("not authorized : result");

        try {
            throw new Exception("not authorized");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    void questionAll(){
        System.out.println("not authorized : questionALl");

        try {
            throw new Exception("not authorized");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    public void questionFini() {
        System.out.println("not authorized : questionFini");

        try {
            throw new Exception("not authorized");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void question() {
        System.out.println("not authorized : question");
        try {
            throw new Exception("not authorized");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void connectAdmin() {
        System.out.println("not authorized : connectAdmin");
        try {
            throw new Exception("not authorized");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteUser() {
        System.out.println("not authorized : deleteUser");
        try {
            throw new Exception("not authorized");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void userAll() {
        System.out.println("not authorized : userAll");
        try {
            throw new Exception("not authorized");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void userSave() {
        System.out.println("not authorized : userSave");
        try {
            throw new Exception("not authorized");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void questionFin() {
        System.out.println("not authorized : questionFin");
        try {
            throw new Exception("not authorized");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void questionCreate() {
        System.out.println("not authorized : questionCreate");
        try {
            throw new Exception("not authorized");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void publicKey(){
        System.out.println("not authorized : publicKey");
        try {
            throw new Exception("not authorized");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void publicKeyClient() {
        System.out.println("not authorized : publicKeyClient");
        try {
            throw new Exception("not authorized");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void QUESTION_DATE_FIN_FINI() {
        System.out.println("not authorized : QUESTION_DATE_FIN_FINI");
        try {
            throw new Exception("not authorized");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void userUpdate(){
        System.out.println("not authorized : userUpdate");
        try {
            throw new Exception("not authorized");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
