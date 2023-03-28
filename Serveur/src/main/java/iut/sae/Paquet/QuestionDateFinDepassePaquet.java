package iut.sae.Paquet;

import iut.sae.Model.Question;

public class QuestionDateFinDepassePaquet extends Paquet{

    private Question question;

    public QuestionDateFinDepassePaquet(Question question) {
        super(TYPE.QUESTION_DATE_FIN_FINI);
        this.question = question;
    }
}
