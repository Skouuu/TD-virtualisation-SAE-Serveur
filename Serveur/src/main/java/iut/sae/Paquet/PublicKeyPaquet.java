package iut.sae.Paquet;

import iut.sae.Model.PublicKey;

public class PublicKeyPaquet extends Paquet{

    PublicKey publicKey;

    public PublicKeyPaquet(PublicKey publicKey) {
        super(TYPE.PUBLIC_KEY);
        this.publicKey = publicKey;
    }

    public PublicKey getPublicKey() {
        return publicKey;
    }
}
