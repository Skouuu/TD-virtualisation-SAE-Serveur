package iut.sae.state;

import iut.sae.Model.Question;
import iut.sae.Paquet.AgregationPaquet;
import iut.sae.Paquet.Paquet;
import iut.sae.Repository.QuestionRepository;
import iut.sae.state.Commande;
import iut.sae.state.Sock;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.util.List;

public class QuestionDateFinFini implements Commande {
    private Sock sock;

    public QuestionDateFinFini(Sock sock){
        this.sock = sock;
    }

    @Override
    public void execute(Paquet paquet, ObjectInputStream objectInputStream, ObjectOutputStream objectOutputStream) {
        List<Question> list = QuestionRepository.getAllQuestionWithDatePassedAndNoteTraite();
        System.out.println("nombre question traité : " + list.size());
        if(list.size() > 0) {
            for(Question q : list){
                QuestionRepository.traiter(q.getId());
                BigInteger[] agregation = QuestionRepository.recupererAgregation(q.getId());
                AgregationPaquet agregationPaquet = new AgregationPaquet(agregation, q);
                System.out.println("id public key : " + q.getPublicKey().getId());
                try {
                    objectOutputStream.writeObject(agregationPaquet);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
