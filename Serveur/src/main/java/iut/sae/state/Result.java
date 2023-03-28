package iut.sae.state;

import iut.sae.Model.Question;
import iut.sae.Paquet.Paquet;
import iut.sae.Paquet.ResultatPaquet;
import iut.sae.Repository.QuestionRepository;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Result implements Commande {
    private Sock sock;

    public Result(Sock sock){
        this.sock = sock;
    }


    @Override
    public void execute(Paquet paquet, ObjectInputStream objectInputStream, ObjectOutputStream objectOutputStream) {
        ResultatPaquet resultatPaquet = (ResultatPaquet) paquet;
        if(QuestionRepository.estTraite(resultatPaquet.getIdQuestion())){
            Question question1 = QuestionRepository.chercher(resultatPaquet.getIdQuestion());
            resultatPaquet.setResultat(question1.getResultat());
            resultatPaquet.setQuestion(question1);

            try {
                objectOutputStream.writeObject(resultatPaquet);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            try {
                objectOutputStream.writeObject(null);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        //sock.result();
    }

}
