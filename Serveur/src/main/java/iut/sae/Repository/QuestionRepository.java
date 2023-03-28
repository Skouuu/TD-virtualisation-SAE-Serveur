package iut.sae.Repository;


import iut.sae.Model.PublicKey;
import iut.sae.Model.Question;
import iut.sae.Model.Resultat;

import java.math.BigInteger;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class QuestionRepository {

    public static void traiter(int idQuestion){
        Mysql mysql = Mysql.getINSTANCE();
        PreparedStatement ps;
        try {
            ps = mysql.getConnection().prepareStatement("UPDATE question set traite = 1 WHERE id = ?");
            ps.setInt(1, idQuestion);
            ps.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean estTraite(int idQuestion){
        Mysql mysql = Mysql.getINSTANCE();
        PreparedStatement ps;
        ResultSet rs;
        Question question = null;

        try {
            ps = mysql.getConnection().prepareStatement("SELECT traite FROM question WHERE id = ?");
            ps.setInt(1, idQuestion);
            rs = ps.executeQuery();

            if(rs.next()){
                int res = rs.getInt("traite");
                return res == 1;
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }

    public static void setIdResultat(int idQuestion, int idResultat){
        Mysql mysql = Mysql.getINSTANCE();
        PreparedStatement ps;
        try {
            ps = mysql.getConnection().prepareStatement("UPDATE question set idResultat = ? WHERE id = ?");
            ps.setInt(1, idResultat);
            ps.setInt(2, idQuestion);
            ps.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void setIdPK(int idPK, int id){
        System.out.println("id public key : " + idPK);
        System.out.println("id question : " + id);
        Mysql mysql = Mysql.getINSTANCE();
        PreparedStatement ps;
        try {
            ps = mysql.getConnection().prepareStatement("UPDATE question set idPublicKey = ? WHERE id = ?");
            ps.setInt(1, idPK);
            ps.setInt(2, id);
            ps.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void update(Question question){
        Mysql mysql = Mysql.getINSTANCE();
        PreparedStatement ps;
        try {
            ps = mysql.getConnection().prepareStatement("UPDATE question SET dateFin = ? WHERE id = ?");
            ps.setDate(1, question.getDateFin());
            ps.setInt(2, question.getId());
            ps.execute();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static int enregistrer(Question question){
        Mysql mysql = Mysql.getINSTANCE();
        PreparedStatement ps;
        try {
            ps = mysql.getConnection().prepareStatement("INSERT INTO question(nom, dateDebut, dateFin, reponse1, reponse2) VALUES(?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, question.getNom());
            ps.setDate(2, question.getDateDebut());
            ps.setDate(3, question.getDateFin());
            ps.setString(4, question.getReponse1());
            ps.setString(5, question.getReponse2());
            ps.execute();
            ResultSet rs = ps.getGeneratedKeys();
            int generatedKey = 0;
            if (rs.next()) {
                generatedKey = rs.getInt(1);
            }
            return generatedKey;

        } catch (SQLException e) {
            return e.getErrorCode();
        }
    }

    public static void supprimer(int id){
        Mysql mysql = Mysql.getINSTANCE();
        PreparedStatement ps;
        try {
            ps = mysql.getConnection().prepareStatement("DELETE FROM question WHERE id = ?");
            ps.setInt(1, id);
            ps.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }



    public static Question chercher(int id){
        Mysql mysql = Mysql.getINSTANCE();
        PreparedStatement ps;
        ResultSet rs;
        Question question = null;

        try {
            ps = mysql.getConnection().prepareStatement("SELECT * FROM question WHERE id = ?");
            ps.setInt(1, id);
            rs = ps.executeQuery();

            if(rs.next()){
                Resultat resultat = ResultatRepository.chercher(rs.getInt("idResultat"));
                System.out.println("resultat : " + resultat.getId());
                PublicKey publicKey = PublicKeyRepository.chercher(rs.getInt("idPublicKey"));
                System.out.println("public key : " + publicKey.getId());
                question = new Question.QuestionBuilder()
                        .setId(rs.getInt("id"))
                        .setNom(rs.getString("nom"))
                        .setDateDebut(rs.getDate("dateDebut"))
                        .setDateFin(rs.getDate("dateFin"))
                        .setReponse1(rs.getString("reponse1"))
                        .setReponse2(rs.getString("reponse2"))
                        .setResultat(resultat)
                        .setPublicKey(publicKey)
                        .build();
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return question;
    }

    public static int nbVotant(int idQuestion){
        Mysql mysql = Mysql.getINSTANCE();
        PreparedStatement ps;
        ResultSet rs;
        Question question = null;

        try {
            ps = mysql.getConnection().prepareStatement("SELECT COUNT(*) AS count FROM AVote WHERE idQuestion = ?");
            ps.setInt(1, idQuestion);
            rs = ps.executeQuery();

            rs.next();

            return rs.getInt("count");


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public static Question derniereQuestion(){
        Mysql mysql = Mysql.getINSTANCE();
        PreparedStatement ps;
        ResultSet rs;
        Question question = null;

        try {
            ps = mysql.getConnection().prepareStatement("SELECT * FROM question WHERE id = (SELECT MAX(id) FROM question)");

            rs = ps.executeQuery();

            if(rs.next()){
                question = new Question.QuestionBuilder()
                        .setId(rs.getInt("id"))
                        .setNom(rs.getString("nom"))
                        .setDateDebut(rs.getDate("dateDebut"))
                        .setDateFin(rs.getDate("dateFin"))
                        .setReponse1(rs.getString("reponse1"))
                        .setReponse2(rs.getString("reponse2"))
                        .build();
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return question;
    }

    public static BigInteger[] recupererAgregation(int idQuestion){
        Mysql mysql = Mysql.getINSTANCE();
        PreparedStatement ps;
        try {
            ps = mysql.getConnection().prepareStatement("SELECT * FROM question WHERE id = ?");
            ps.setInt(1, idQuestion);
            ResultSet rs = ps.executeQuery();

            if(rs.next()){
                if(rs.getString("c1") == null && rs.getString("c2") == null) return null;
                return new BigInteger[]{
                        new BigInteger(rs.getString("c1")),
                        new BigInteger(rs.getString("c2"))
                };
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public static void modifierAgregation(int idQuestion, BigInteger c1, BigInteger c2){
        Mysql mysql = Mysql.getINSTANCE();
        PreparedStatement ps;
        try {
            ps = mysql.getConnection().prepareStatement("UPDATE question set c1 = ?, c2 = ? WHERE id = ?");
            ps.setString(1, c1.toString());
            ps.setString(2, c2.toString());
            ps.setInt(3, idQuestion);
            ps.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<Question> getAllQuestionWithDatePassedAndNoteTraite(){
        // sql : SELECT * FROM `question` WHERE DATE(dateFin) < CURRENT_DATE
        List<Question> list = new ArrayList<>();
        Mysql mysql = Mysql.getINSTANCE();
        PreparedStatement ps;
        ResultSet rs;

        try {
            ps = mysql.getConnection().prepareStatement("SELECT * FROM question WHERE DATE(dateFin) < CURRENT_DATE AND traite = 0");
            rs = ps.executeQuery();
            while (rs.next()){
                PublicKey publicKey = PublicKeyRepository.chercher(rs.getInt("idPublicKey"));
                Question question = new Question.QuestionBuilder()
                        .setId(rs.getInt("id"))
                        .setNom(rs.getString("nom"))
                        .setDateDebut(rs.getDate("dateDebut"))
                        .setDateFin(rs.getDate("dateFin"))
                        .setReponse1(rs.getString("reponse1"))
                        .setReponse2(rs.getString("reponse2"))
                        .setPublicKey(publicKey)
                        .build();
                list.add(question);
                System.out.println("public key : " + publicKey.getId());
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;

    }

    public static List<Question> getAllQuestions(){
        List<Question> list = new ArrayList<>();
        Mysql mysql = Mysql.getINSTANCE();
        PreparedStatement ps;
        ResultSet rs;

        try {
            ps = mysql.getConnection().prepareStatement("SELECT * FROM question");
            rs = ps.executeQuery();
            while (rs.next()){
                Question question = new Question.QuestionBuilder()
                        .setId(rs.getInt("id"))
                        .setNom(rs.getString("nom"))
                        .setDateDebut(rs.getDate("dateDebut"))
                        .setDateFin(rs.getDate("dateFin"))
                        .setReponse1(rs.getString("reponse1"))
                        .setReponse2(rs.getString("reponse2"))
                        .build();
                list.add(question);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

}
