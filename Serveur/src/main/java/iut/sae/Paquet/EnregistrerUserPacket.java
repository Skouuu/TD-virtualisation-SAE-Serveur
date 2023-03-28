package iut.sae.Paquet;

import iut.sae.Model.User;

public class EnregistrerUserPacket extends Paquet {
    private User user;

    public EnregistrerUserPacket(User user){
        super(TYPE.ENREGISTRER_USER);
        this.user = user;
    }

    public User getUser() {
        return user;
    }
}
