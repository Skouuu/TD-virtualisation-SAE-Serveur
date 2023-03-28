package iut.sae.state;

import iut.sae.Model.Scrutateur;
import iut.sae.Paquet.Paquet;
import iut.sae.Paquet.PublicKeyPaquet;
import iut.sae.Repository.PublicKeyRepository;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class PublicKeyAction implements Commande{
    private Sock sock;

    public PublicKeyAction(Sock sock){
        this.sock = sock;
    }

    @Override
    public void execute(Paquet paquet, ObjectInputStream objectInputStream, ObjectOutputStream objectOutputStream) {
        PublicKeyPaquet publicKeyPaquet = (PublicKeyPaquet) paquet;
        // sauvegarde la clé publique pour la transmettre au client quand il demandera
        sock.setDernierePublicKey(PublicKeyRepository.chercher(publicKeyPaquet.getPublicKey().getId()));
        System.out.println("publick key reçu");
        if(Scrutateur.getINSTANCE() == null){
            new Scrutateur(objectInputStream, objectOutputStream);
           // scrutateur = new Scrutateur(objectInputStream, objectOutputStream);
        }

    }
}
