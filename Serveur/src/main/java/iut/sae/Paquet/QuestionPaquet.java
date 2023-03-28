package iut.sae.Paquet;

import iut.sae.Model.Question;

public class QuestionPaquet extends Paquet{
    private Question question;
    public QuestionPaquet(Question question) {
        super(TYPE.QUESTION);
        this.question = question;
    }

    public Question getQuestion() {
        return question;
    }
}
