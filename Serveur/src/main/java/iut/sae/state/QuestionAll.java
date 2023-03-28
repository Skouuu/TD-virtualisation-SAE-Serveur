package iut.sae.state;

import iut.sae.Paquet.DemandeAllQuestionPaquet;
import iut.sae.Paquet.Paquet;
import iut.sae.Repository.QuestionRepository;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

public class QuestionAll implements Commande {

    private Sock sock;

    public QuestionAll(Sock sock){
        this.sock = sock;
    }

    @Override
    public void execute(Paquet paquet, ObjectInputStream objectInputStream, ObjectOutputStream objectOutputStream) {
        System.out.println("demande all questions");
        List<iut.sae.Model.Question> l = QuestionRepository.getAllQuestions();
        DemandeAllQuestionPaquet demandeAllQuestionPaquet = new DemandeAllQuestionPaquet();
        demandeAllQuestionPaquet.setList(l);
        try {
            objectOutputStream.writeObject(demandeAllQuestionPaquet);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
