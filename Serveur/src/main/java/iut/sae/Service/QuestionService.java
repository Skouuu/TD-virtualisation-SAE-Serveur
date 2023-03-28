package iut.sae.Service;

import iut.sae.Model.Question;
import iut.sae.Model.Resultat;
import iut.sae.Model.Role;
import iut.sae.Model.User;
import iut.sae.Repository.PublicKeyRepository;
import iut.sae.Repository.QuestionRepository;
import iut.sae.Repository.ResultatRepository;


import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class QuestionService {
    private Question question;
    private ObjectOutputStream objectOutputStream;
    private ObjectInputStream objectInputStream;
    private String reponse;

    private User user;

    public QuestionService(Question question,
                           ObjectInputStream objectInputStream,
                           ObjectOutputStream objectOutputStream,
                           User user){
        this.question = question;
        this.objectInputStream = objectInputStream;
        this.objectOutputStream = objectOutputStream;
        this.user = user;
    }

    private void save(){
        int idResultat = ResultatRepository.enregistrer(new Resultat.ResultatBuilder().setReponse2(0).setReponse1(0).build());

        int idQuestion = QuestionRepository.enregistrer(question);
        System.out.println("id question sauvegardée : " + idQuestion);
        QuestionRepository.setIdResultat(idQuestion, idResultat);
        QuestionRepository.setIdPK(PublicKeyRepository.derniere().getId(), idQuestion);
    }

    public void saveAndSendResult(){
        if(user.getRole().equals(Role.ROLE_USER.toString())) reponse = "bien essayé";
        else {
            if(question.getDateDebut().before(question.getDateFin()) || question.getDateDebut().getTime() == question.getDateFin().getTime()){
                save();
                reponse = "true";
            } else {
                reponse = "La date de départ ne doit pas être supérieur à la date de fin";
            }
        }

        try {
            objectOutputStream.writeObject(reponse);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
