package iut.sae.Paquet;

import iut.sae.Model.VoteChiffre;

public class VoteChiffrePaquet extends Paquet{

    private VoteChiffre voteChiffre;

    public VoteChiffrePaquet(VoteChiffre voteChiffre) {
        super(TYPE.VOTE_CHIFFRE);
        this.voteChiffre = voteChiffre;
    }

    public VoteChiffre getVoteChiffre() {
        return voteChiffre;
    }
}
