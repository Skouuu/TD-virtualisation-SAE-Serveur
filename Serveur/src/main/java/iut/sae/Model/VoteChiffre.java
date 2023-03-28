package iut.sae.Model;

import java.io.Serializable;
import java.math.BigInteger;

public class VoteChiffre implements Serializable {
    private BigInteger[] vote;

    public VoteChiffre(VoteChiffreBuilder voteChiffreBuilder){
        this.vote = voteChiffreBuilder.vote;
    }

    public BigInteger[] getVote() {
        return vote;
    }

    public void setVote(BigInteger[] vote) {
        this.vote = vote;
    }

    public static class VoteChiffreBuilder{

        private BigInteger[] vote;

        public VoteChiffreBuilder(){}

        public VoteChiffreBuilder setVote(BigInteger[] vote) {
            this.vote = vote;
            return this;
        }

        public VoteChiffre build(){
            return new VoteChiffre(this);
        }
    }
}
