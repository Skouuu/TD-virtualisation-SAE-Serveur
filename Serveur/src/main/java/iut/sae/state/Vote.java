package iut.sae.state;

import iut.sae.Paquet.Paquet;
import iut.sae.Paquet.VoteChiffrePaquet;
import iut.sae.Service.VoteService;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Vote implements Commande {
    private Sock sock;

    public Vote(Sock sock){
        this.sock = sock;
    }

    @Override
    public void execute(Paquet paquet, ObjectInputStream objectInputStream, ObjectOutputStream objectOutputStream) {
        System.out.println("execution de execute Vote");

        System.out.println("question demandée id : " + sock.getQuestionDemandee().getId());

        VoteService voteService = new VoteService(sock.getUser(), sock.getQuestionDemandee(), (VoteChiffrePaquet) paquet, objectOutputStream);
        if(!voteService.utilisateurADejaVote()){
            voteService.run();
        }
        voteService.envoyerReponse();

        //sock.vote();

        sock.undo(); // on revient vers l'etat connecté automatiquement
    }

}
