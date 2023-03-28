package iut.sae.Paquet;

import iut.sae.Model.User;

import java.io.Serial;

public class UserPaquet extends Paquet{


    private User user;

    public UserPaquet(User user){
        super(TYPE.USER);
        this.user = user;
    }

    public User getUser() {
        return user;
    }
}
