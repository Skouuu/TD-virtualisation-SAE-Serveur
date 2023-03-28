package iut.sae.Service;

import iut.sae.Model.PublicKey;
import iut.sae.Paquet.PublicKeyPaquet;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class EnvoiPublicKeyService {

    private PublicKey publicKey;
    private ObjectOutputStream objectOutputStream;
    private ObjectInputStream objectInputStream;

    public EnvoiPublicKeyService(PublicKey publicKey, ObjectInputStream objectInputStream, ObjectOutputStream objectOutputStream){
        this.publicKey = publicKey;
        this.objectOutputStream = objectOutputStream;
        this.objectInputStream = objectInputStream;
    }

    public void envoyer(){
        PublicKeyPaquet publicKeyPaquet = new PublicKeyPaquet(publicKey);
        String res = "";

        try {
            objectOutputStream.writeObject(publicKeyPaquet);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
