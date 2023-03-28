package iut.sae.Service;

import iut.sae.Model.PublicKey;
import iut.sae.Model.VoteChiffre;

import java.math.BigInteger;
import java.util.List;

public class Agrege {
    public static BigInteger[] agrege(BigInteger[] c, BigInteger[] c2, PublicKey cp) // clé publique (cp) = (p, g, h)
    {
        BigInteger p = cp.getP();

        BigInteger[] C = new BigInteger[2]; //resultat

        C[0] = (c[0].multiply(c2[0])).mod(p);
        C[1] = (c[1].multiply(c2[1])).mod(p);
        return C;
    }

    public static BigInteger[] agregeUtil(List<VoteChiffre> list, PublicKey cp){

        if(list.size() < 2){
            System.out.println("moins de 2 votes");
            return null;
        }

        BigInteger[] c = list.get(0).getVote();
        BigInteger[] resultat = null;

        for(int i = 1; i < list.size(); i++){
            BigInteger[] c2 = list.get(i).getVote();
            resultat = agrege(c, c2, cp);
            c = resultat;
        }
        return resultat;
    }
}
