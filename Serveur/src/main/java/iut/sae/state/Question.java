package iut.sae.state;

import iut.sae.Paquet.DemandeQuestionPaquet;
import iut.sae.Paquet.Paquet;
import iut.sae.Paquet.QuestionPaquet;
import iut.sae.Repository.QuestionRepository;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Question implements Commande {
    private Sock sock;

    public Question(Sock sock){
        this.sock = sock;
    }

    @Override
    public void execute(Paquet paquet, ObjectInputStream objectInputStream, ObjectOutputStream objectOutputStream) {
        System.out.println("------------------------------------------------------------------------------------");
        DemandeQuestionPaquet demandeQuestionPaquet = (DemandeQuestionPaquet) paquet;
        sock.setQuestionDemandee(QuestionRepository.chercher(demandeQuestionPaquet.getIdQuestion()));

        QuestionPaquet questionPaquet = new QuestionPaquet(sock.getQuestionDemandee());
        try {
            objectOutputStream.writeObject(questionPaquet);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("la question + " + demandeQuestionPaquet.getIdQuestion() + " a été demandé");
        System.out.println("la question + " + questionPaquet.getQuestion().getId() + " a été demandé");
        System.out.println("pk : " + questionPaquet.getQuestion().getPublicKey().getId() + " a été demandé");



    }
}
