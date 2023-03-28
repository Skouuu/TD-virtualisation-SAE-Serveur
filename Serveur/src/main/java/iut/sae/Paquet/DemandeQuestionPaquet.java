package iut.sae.Paquet;

public class DemandeQuestionPaquet extends Paquet{

    private int idQuestion;

    public int getIdQuestion() {
        return idQuestion;
    }

    public void setIdQuestion(int idQuestion) {
        this.idQuestion = idQuestion;
    }

    public DemandeQuestionPaquet() {
        super(TYPE.DEMANDE_QUESTION);
    }
}
