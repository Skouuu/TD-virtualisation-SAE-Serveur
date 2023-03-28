package iut.sae.Paquet;

public class DemandeFinVotePaquet extends Paquet{
    private int idQuestion;
    public DemandeFinVotePaquet(int idQuestion) {
        super(TYPE.DEMANDE_FIN_VOTE);
        this.idQuestion = idQuestion;
    }

    public int getIdQuestion() {
        return idQuestion;
    }
}
