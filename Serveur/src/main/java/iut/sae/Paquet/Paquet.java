package iut.sae.Paquet;

import java.io.Serial;
import java.io.Serializable;

public abstract class Paquet implements Serializable {

    public enum TYPE {
        USER,
        RESULTAT,
        QUESTION,
        PUBLIC_KEY,
        DEMANDE_PUBLIC_KEY,
        VOTE_CHIFFRE,
        DEMANDE_QUESTION,
        GENERATION_SCRUTATEUR,
        QUESTION_DATE_FIN_FINI,
        AGREGE_ENVOI_VERS_SCRUTATEUR,
        DEMANDE_ALL_QUESTION,
        DEMANDE_QUESTION_FINI,
        DEMANDE_RESULTAT,
        DEMANDE_ALL_USER,
        ENREGISTRER_USER,
        DEMANDE_FIN_VOTE,
        DEMANDE_DELETE_USER,
        USER_UPDATE
    }



    private TYPE type;

    public Paquet(TYPE type){
        this.type = type;
    }

    public TYPE getType() {
        return type;
    }

    public void setType(TYPE type) {
        this.type = type;
    }
}
