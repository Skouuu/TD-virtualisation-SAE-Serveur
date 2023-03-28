package iut.sae.Paquet;

import iut.sae.Model.Question;

import java.math.BigInteger;

public class AgregationPaquet extends Paquet {
    private BigInteger[] bigIntegers;
    private Question question;

    public AgregationPaquet(BigInteger[] bigIntegers, Question question) {
        super(TYPE.AGREGE_ENVOI_VERS_SCRUTATEUR);
        this.bigIntegers = bigIntegers;
        this.question = question;

    }

    public BigInteger[] getBigIntegers() {
        return bigIntegers;
    }

    public Question getQuestion() {
        return question;
    }
}
