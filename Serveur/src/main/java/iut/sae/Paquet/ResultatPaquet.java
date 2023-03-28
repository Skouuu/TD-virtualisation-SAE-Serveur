package iut.sae.Paquet;

import iut.sae.Model.Question;
import iut.sae.Model.Resultat;

public class ResultatPaquet extends Paquet{
    private int idQuestion;
    private Question question;
    private Resultat resultat;

    public ResultatPaquet() {
        super(TYPE.DEMANDE_RESULTAT);
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public void setIdQuestion(int idQuestion) {
        this.idQuestion = idQuestion;
    }

    public int getIdQuestion() {
        return idQuestion;
    }


    public void setResultat(Resultat resultat) {
        this.resultat = resultat;
    }

    public Resultat getResultat() {
        return resultat;
    }
}
