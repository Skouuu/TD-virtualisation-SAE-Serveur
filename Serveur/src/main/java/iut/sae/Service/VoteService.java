package iut.sae.Service;


import iut.sae.Model.PublicKey;
import iut.sae.Model.Question;
import iut.sae.Model.User;
import iut.sae.Paquet.VoteChiffrePaquet;
import iut.sae.Repository.AVoteRepository;
import iut.sae.Repository.QuestionRepository;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.math.BigInteger;

public class VoteService {

    private User user;
    private Question question;

    private VoteChiffrePaquet voteChiffrePaquet;
    private ObjectOutputStream objectOutputStream;
    private String reponse;

    public VoteService(User user, Question question, VoteChiffrePaquet voteChiffrePaquet, ObjectOutputStream objectOutputStream) {
        this.user = user;
        this.question = question;
        this.voteChiffrePaquet = voteChiffrePaquet;
        this.objectOutputStream = objectOutputStream;
        this.reponse = "";
    }

    public boolean utilisateurADejaVote(){
        if(AVoteRepository.chercher(question.getId(), this.user.getEmail())){
            reponse = "Vous avez deja voté à cette question";
            return true;
        } else reponse = "true";
        return false;
    }

    public void verifierBourage(){
        // g ^^ r
        // pk ^^ r


    }

    public void run(){
        PublicKey p = question.getPublicKey();
        //Encrypt.encrypt((byte) 0, PublicKeyRepository.derniere());

        BigInteger[] agregeBD = QuestionRepository.recupererAgregation(question.getId());
        if(agregeBD == null){
            //BigInteger[] fauxVote = Encrypt.encrypt((byte) 0, p);
            //BigInteger[] newAgrege = Agrege.agrege(fauxVote, voteChiffrePaquet.getVoteChiffre().getVote(), p);
            BigInteger[] agregeSimple = voteChiffrePaquet.getVoteChiffre().getVote();
            QuestionRepository.modifierAgregation(question.getId(), agregeSimple[0], agregeSimple[1]);
        } else {
            BigInteger[] newAgrege = Agrege.agrege(agregeBD, voteChiffrePaquet.getVoteChiffre().getVote(), p);
            QuestionRepository.modifierAgregation(question.getId(), newAgrege[0], newAgrege[1]);
        }
        AVoteRepository.enregistrer(this.user.getEmail(), question.getId());
        reponse = "true";
        System.out.println("A VOTÉ");
    }

    public void envoyerReponse(){
        try {
            objectOutputStream.writeObject(reponse);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
