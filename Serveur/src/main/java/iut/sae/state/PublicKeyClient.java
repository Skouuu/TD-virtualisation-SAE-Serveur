package iut.sae.state;

import iut.sae.Model.PublicKey;
import iut.sae.Paquet.Paquet;
import iut.sae.Service.EnvoiPublicKeyService;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class PublicKeyClient implements Commande{

    private Sock sock;

    public PublicKeyClient(Sock sock){
        this.sock = sock;
    }

    @Override
    public void execute(Paquet paquet, ObjectInputStream objectInputStream, ObjectOutputStream objectOutputStream) {
        PublicKey publicKey =  sock.getQuestionDemandee().getPublicKey();
        EnvoiPublicKeyService envoiPublicKeyService = new EnvoiPublicKeyService(publicKey, objectInputStream, objectOutputStream);
        envoiPublicKeyService.envoyer();
    }
}
