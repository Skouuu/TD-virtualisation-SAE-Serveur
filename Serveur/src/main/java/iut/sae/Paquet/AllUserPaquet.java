package iut.sae.Paquet;

import iut.sae.Model.User;


import java.util.List;

public class AllUserPaquet extends Paquet{

    private List<User> user;

    public AllUserPaquet(List<User> user){
        super(TYPE.DEMANDE_ALL_USER);
        this.user = user;
    }

    public List<User> getUser() {
        return user;
    }
}
