package iut.sae.state;

import iut.sae.Model.Question;
import iut.sae.Paquet.DemandeFinVotePaquet;
import iut.sae.Paquet.Paquet;
import iut.sae.Repository.QuestionRepository;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Date;

public class QuestionFin implements Commande{
    private Sock sock;

    public QuestionFin(Sock sock){
        this.sock = sock;
    }

    @Override
    public void execute(Paquet paquet, ObjectInputStream objectInputStream, ObjectOutputStream objectOutputStream) {
        DemandeFinVotePaquet d = (DemandeFinVotePaquet) paquet;
        Question qu = QuestionRepository.chercher(d.getIdQuestion());
        qu.setDateFin(new Date(10));
        QuestionRepository.update(qu);

        try {
            objectOutputStream.writeObject("ok");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
