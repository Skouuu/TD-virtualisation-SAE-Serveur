package iut.sae.Model;

import java.math.BigInteger;

public class AVote {

    private String email;
    private int idQuestion;

    private BigInteger c1;

    private BigInteger c2;

    public AVote(AVoteBuilder aVote){
        this.email = aVote.email;
        this.idQuestion = aVote.idQuestion;
        this.c1 = aVote.c1;
        this.c2 = aVote.c2;

    }

    public String getEmail() {
        return email;
    }

    public int getIdQuestion() {
        return idQuestion;
    }

    public BigInteger[] Vote() {
        return new BigInteger[]{c1, c2};
    }

    public BigInteger getC1() {
        return c1;
    }

    public BigInteger getC2() {
        return c2;
    }

    // ------------------------------------------------

    public static class AVoteBuilder{
        private String email;
        private int idQuestion;
        private BigInteger c1;

        private BigInteger c2;

        public AVoteBuilder setEmail(String email) {
            this.email = email;
            return this;
        }

        public AVoteBuilder setIdQuestion(int idQuestion) {
            this.idQuestion = idQuestion;
            return this;
        }

        public AVoteBuilder setC1(BigInteger c1) {
            this.c1 = c1;
            return this;
        }

        public AVoteBuilder setC2(BigInteger c2) {
            this.c2 = c2;
            return this;
        }

        public AVote build() {
            return new AVote(this);
        }
    }

}
