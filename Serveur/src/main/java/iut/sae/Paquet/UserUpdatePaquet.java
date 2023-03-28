package iut.sae.Paquet;

public class UserUpdatePaquet extends Paquet{

    private String password;

    public UserUpdatePaquet(String password){
        super(TYPE.USER_UPDATE);
        this.password = password;
    }

    public String getPassword() {
        return password;
    }
}
