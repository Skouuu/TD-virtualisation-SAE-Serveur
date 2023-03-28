package iut.sae.Model;

import java.io.Serializable;
import java.math.BigInteger;

public class PublicKey implements Serializable {
    private BigInteger p;
    private BigInteger g;
    private BigInteger h;
    private int id;

    public PublicKey(PublicKeyBuilder publicKeyBuilder){
        this.p = publicKeyBuilder.p;
        this.g = publicKeyBuilder.g;
        this.h = publicKeyBuilder.h;
        if(publicKeyBuilder.id != -1) this.id = publicKeyBuilder.id;
    }

    public BigInteger getP() {
        return p;
    }

    public BigInteger getH() {
        return h;
    }

    public BigInteger getG() {
        return g;
    }

    public int getId() {
        return id;
    }

    // ------------------------------------------------

    public static class PublicKeyBuilder{
        private BigInteger p;
        private BigInteger g;
        private BigInteger h;
        private int id = -1;

        public PublicKeyBuilder setId(int id) {
            this.id = id;
            return this;
        }

        public PublicKeyBuilder setH(BigInteger h) {
            this.h = h;
            return this;
        }

        public PublicKeyBuilder setG(BigInteger g) {
            this.g = g;
            return this;
        }

        public PublicKeyBuilder setP(BigInteger p) {
            this.p = p;
            return this;
        }


        public PublicKey build() {
            return new PublicKey(this);
        }
    }
}
