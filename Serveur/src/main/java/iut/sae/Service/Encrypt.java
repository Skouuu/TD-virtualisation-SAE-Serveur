package iut.sae.Service;


import iut.sae.Model.PublicKey;

import java.math.BigInteger;
import java.util.Random;

public class Encrypt {

    public static BigInteger[]  encrypt(byte m, PublicKey pk){
        BigInteger r = null;
        BigInteger pPrime = pk.getP().add(new BigInteger("-1")).divide(new BigInteger("2"));
        do{
            r = new BigInteger(pPrime.bitLength(), new Random());
        }while (r.compareTo(pPrime) >= 0 );

        //c1 = g^r mod p
        //c2 = g^m × h^r mod p
        //c = {c1, c2} : c1 = u, c2 = v
        BigInteger c1 = pk.getG().modPow(r, pk.getP()); // u
        BigInteger c2 = pk.getG().pow(m).multiply(pk.getH().modPow(r, pk.getP())).mod(pk.getP()); // v


        return new BigInteger[]{c1, c2}; // c
    }
}
