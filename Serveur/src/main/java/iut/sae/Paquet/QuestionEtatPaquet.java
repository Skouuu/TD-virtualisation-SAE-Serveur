package iut.sae.Paquet;

public class QuestionEtatPaquet extends Paquet{
    private int fini;
    private int id;
    public QuestionEtatPaquet() {
        super(TYPE.DEMANDE_QUESTION_FINI);
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFini(int fini) {
        this.fini = fini;
    }

    public int getFini(){
        return fini;
    }
}
