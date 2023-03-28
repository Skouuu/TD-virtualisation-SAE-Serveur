package iut.sae.Model;


import java.io.Serializable;
import java.math.BigInteger;
import java.sql.Date;

public class Question implements Serializable {
    private String nom;
    private int id;

    private Date dateDebut;

    private Date dateFin;

    private Resultat resultat;

    private PublicKey publicKey;

    private BigInteger c1;
    private BigInteger c2;

    private String reponse1;
    private String reponse2;

    private Question(QuestionBuilder questionBuilder){
        this.nom = questionBuilder.nom;
        this.id = questionBuilder.id;
        this.dateDebut = questionBuilder.dateDebut;
        this.dateFin = questionBuilder.dateFin;
        this.publicKey = questionBuilder.publicKey;
        this.c1 = questionBuilder.c1;
        this.c2 = questionBuilder.c2;
        this.reponse1 = questionBuilder.reponse1;
        this.reponse2 = questionBuilder.reponse2;
        this.resultat = questionBuilder.resultat;
    }

    public BigInteger getC1() {
        return c1;
    }

    public BigInteger getC2() {
        return c2;
    }

    public int getId() {
        return id;
    }

    public Resultat getResultat() {
        return resultat;
    }

    public String getNom() {
        return nom;
    }

    public PublicKey getPublicKey() {
        return publicKey;
    }
    public Date getDateDebut() {
        return dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public String getReponse1() {
        return reponse1;
    }

    public String getReponse2() {
        return reponse2;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setResultat(Resultat resultat) {
        this.resultat = resultat;
    }

    public void setPublicKey(PublicKey publicKey) {
        this.publicKey = publicKey;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    @Override
    public String toString() {

        return "nom : " + nom + " || id : " + id + " || dateDebut : " + dateDebut.toString() + " || dateFin : " + dateFin.toString();
    }

    // ------------------------------------------------

    public static class QuestionBuilder{
        private String nom;
        private int id;
        private Date dateDebut;
        private Date dateFin;
        private PublicKey publicKey;
        private String reponse1;
        private String reponse2;

        private BigInteger c1;
        private BigInteger c2;
        private Resultat resultat;

        public QuestionBuilder setNom(String nom){
            this.nom = nom;
            return this;
        }

        public QuestionBuilder setReponse1(String reponse1) {
            this.reponse1 = reponse1;
            return this;
        }

        public QuestionBuilder setResultat(Resultat resultat) {
            this.resultat = resultat;
            return this;
        }

        public QuestionBuilder setReponse2(String reponse2) {
            this.reponse2 = reponse2;
            return this;
        }

        public QuestionBuilder setC1(BigInteger c1) {
            this.c1 = c1;
            return this;
        }

        public QuestionBuilder setC2(BigInteger c2) {
            this.c2 = c2;
            return this;
        }

        public QuestionBuilder setDateDebut(Date dateDebut) {
            this.dateDebut = dateDebut;
            return this;
        }

        public QuestionBuilder setDateFin(Date dateFin) {
            this.dateFin = dateFin;
            return this;
        }

        public QuestionBuilder setPublicKey(PublicKey publicKey) {
            this.publicKey = publicKey;
            return this;
        }

        public QuestionBuilder setId(int id){
            this.id = id;
            return this;
        }

        public Question build() {
            return new Question(this);
        }
    }


}