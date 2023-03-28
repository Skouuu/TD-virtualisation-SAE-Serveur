package iut.sae.state;

import iut.sae.Paquet.Paquet;
import iut.sae.Paquet.QuestionPaquet;
import iut.sae.Service.QuestionService;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class QuestionCreate implements Commande {
    private Sock sock;

    public QuestionCreate(Sock sock){
        this.sock = sock;
    }

    @Override
    public void execute(Paquet paquet, ObjectInputStream objectInputStream, ObjectOutputStream objectOutputStream) {
        System.out.println("creation de la question en cours");
        QuestionPaquet question = (QuestionPaquet) paquet;
        QuestionService questionService = new QuestionService(question.getQuestion(), objectInputStream, objectOutputStream, sock.getUser());
        questionService.saveAndSendResult();
    }
}
