package iut.sae.state;

import iut.sae.Paquet.Paquet;
import iut.sae.Paquet.QuestionEtatPaquet;
import iut.sae.Repository.AVoteRepository;
import iut.sae.Repository.QuestionRepository;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class QuestionFini implements Commande {
    private Sock sock;

    public QuestionFini(Sock sock){
        this.sock = sock;
    }


    @Override
    public void execute(Paquet paquet, ObjectInputStream objectInputStream, ObjectOutputStream objectOutputStream) {
        QuestionEtatPaquet questionEtatPaquet = (QuestionEtatPaquet) paquet;
        int res = 0;
        if(QuestionRepository.estTraite(questionEtatPaquet.getId())){
            res =1;
        }
        else if(AVoteRepository.chercher(questionEtatPaquet.getId(), sock.getUser().getEmail())){
            res = 2;
        }

        questionEtatPaquet.setFini(res);
        try {
            objectOutputStream.writeObject(questionEtatPaquet);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
