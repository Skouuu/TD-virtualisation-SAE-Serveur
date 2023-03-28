package iut.sae.state;

import iut.sae.Model.PublicKey;
import iut.sae.Model.Question;
import iut.sae.Model.User;
import iut.sae.Service.LoginService;

public class Sock {
    private State state;
    private static Sock INSTANCE;


    /**
     * données liées à la session courante :
     */

    private Question questionDemandee = null;
    private PublicKey dernierePublicKey = null;

    private LoginService loginService = null;
    private User user;


    public void setDernierePublicKey(PublicKey dernierePublicKey) {
        this.dernierePublicKey = dernierePublicKey;
    }

    public PublicKey getDernierePublicKey() {
        return dernierePublicKey;
    }

    public LoginService getLoginService() {
        return loginService;
    }

    public Question getQuestionDemandee() {
        return questionDemandee;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setLoginService(LoginService loginService) {
        this.loginService = loginService;
    }

    public void setQuestionDemandee(Question questionDemandee) {
        this.questionDemandee = questionDemandee;
    }

    public Sock(){
        state = new StateInit(this);
    }

    public State getState() {
        return state;
    }

    public static Sock getInstance(){
        if(INSTANCE == null) INSTANCE = new Sock();
        return INSTANCE;
    }

    void changeState(State state){
        this.state = state;
    }

    protected void accept(){
        state.accept();
    }
    protected void close(){
        state.close();
    }

    protected void connect(){state.connect();}
    protected void connectAdmin(){state.connectAdmin();}

    protected void undo(){state.undo();}

    protected void vote(){state.vote();}

    protected void result(){state.result();}

    protected void questionAll(){state.questionAll();}
    protected void questionFini(){state.questionFini();}

    public void question() {
        state.question();
    }

    public void deleteUser(){
        state.deleteUser();
    }

    public void userAll(){
        state.userAll();
    }

    public void userSave(){
        state.userSave();
    }

    public void questionFin(){
        state.questionFin();
    }

    public void questionCreate(){
        state.questionCreate();
    }

    public void publicKey(){
        state.publicKey();
    }

    public void publicKeyClient(){
        state.publicKeyClient();
    }

    public void QUESTION_DATE_FIN_FINI(){
        state.QUESTION_DATE_FIN_FINI();
    }

    public void userUpdate(){
        state.userUpdate();
    }
}
