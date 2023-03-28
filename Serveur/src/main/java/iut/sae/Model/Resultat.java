package iut.sae.Model;

import java.io.Serializable;

public class Resultat implements Serializable {
    private int reponse1;
    private int reponse2;

    private int id;

    public Resultat(ResultatBuilder resultatBuilder){
        this.reponse1 = resultatBuilder.reponse1;
        this.reponse2 = resultatBuilder.reponse2;
        this.id = resultatBuilder.id;
    }

    public int getId() {
        return id;
    }

    public int getReponse2() {
        return reponse2;
    }

    public int getReponse1() {
        return reponse1;
    }

    public int getNbVotes(){return reponse1 + reponse2;}

    public static class ResultatBuilder{
        private int reponse1;
        private int reponse2;
        private int id;

        public ResultatBuilder setReponse1(int reponse1){
            this.reponse1 = reponse1;
            return this;
        }
        public ResultatBuilder setReponse2(int reponse2){
            this.reponse2 = reponse2;
            return this;
        }

        public ResultatBuilder setId(int id) {
            this.id = id;
            return this;
        }

        public Resultat build(){
            return new Resultat(this);
        }
    }
}
