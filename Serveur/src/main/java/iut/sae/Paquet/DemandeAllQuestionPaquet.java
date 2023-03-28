package iut.sae.Paquet;

import iut.sae.Model.Question;

import java.util.List;

public class DemandeAllQuestionPaquet extends Paquet{
    private List<Question> list;

    public List<Question> getList() {
        return list;
    }

    public void setList(List<Question> list) {
        this.list = list;
    }

    public DemandeAllQuestionPaquet() {
        super(TYPE.DEMANDE_ALL_QUESTION);
    }
}
