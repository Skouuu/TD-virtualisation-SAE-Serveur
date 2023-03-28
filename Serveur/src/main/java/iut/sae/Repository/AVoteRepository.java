package iut.sae.Repository;



import iut.sae.Model.PublicKey;
import iut.sae.Model.VoteChiffre;

import java.math.BigInteger;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AVoteRepository{

    public static int enregistrer(String email, int idQuestion){
        Mysql mysql = Mysql.getINSTANCE();
        PreparedStatement ps;
        try {
            ps = mysql.getConnection().prepareStatement("INSERT INTO AVote(idUser, idQuestion) VALUES(?, ?)");
            ps.setString(1, email);
            ps.setInt(2, idQuestion);
            ps.execute();
            return 1;

        } catch (SQLException e) {
            return e.getErrorCode();
        }
    }
/*
    public static void modifier(Question question, int id){
        Mysql mysql = Mysql.getINSTANCE();
        PreparedStatement ps;
        try {
            ps = mysql.getConnection().prepareStatement("UPDATE question set nom = ?, dateDebut = ?, dateFin = ? WHERE id = ?");
            ps.setString(1, question.getNom());
            ps.setDate(2, question.getDateDebut());
            ps.setDate(3, question.getDateFin());
            ps.setInt(4, id);
            ps.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

 */

    public static void supprimer(int id){
        Mysql mysql = Mysql.getINSTANCE();
        PreparedStatement ps;
        try {
            ps = mysql.getConnection().prepareStatement("DELETE FROM PublicKey WHERE id = ?");
            ps.setInt(1, id);
            ps.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean chercher(int idQuestion, String email){
        Mysql mysql = Mysql.getINSTANCE();
        PreparedStatement ps;
        ResultSet rs;

        try {
            //ps = mysql.getConnection().prepareStatement("SELECT * FROM PublicKey WHERE id = ?");
            ps = mysql.getConnection().prepareStatement("SELECT * FROM AVote WHERE idQuestion = ? AND idUser=?");
            ps.setInt(1, idQuestion);
            ps.setString(2, email);
            rs = ps.executeQuery();

            if(rs.next()){
                return true;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return false;
    }

    public static List<VoteChiffre> getVoteChiffre(int idQuestion){
        List<VoteChiffre> list = new ArrayList<>();
        Mysql mysql = Mysql.getINSTANCE();
        PreparedStatement ps;
        ResultSet rs;

        try {
            ps = mysql.getConnection().prepareStatement("SELECT * FROM AVote WHERE idQuestion = ?");
            ps.setInt(1, idQuestion);
            rs = ps.executeQuery();
            while (rs.next()){
                VoteChiffre voteChiffre = new VoteChiffre.VoteChiffreBuilder()
                        .setVote(new BigInteger[]{
                                new BigInteger(rs.getString("c1")),
                                new BigInteger(rs.getString("c2"))
                        }).build();

                list.add(voteChiffre);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    public static List<PublicKey> getAllQuestions(){
        List<PublicKey> list = new ArrayList<>();
        Mysql mysql = Mysql.getINSTANCE();
        PreparedStatement ps;
        ResultSet rs;

        try {
            ps = mysql.getConnection().prepareStatement("SELECT * FROM PublicKey");
            rs = ps.executeQuery();
            while (rs.next()){
                PublicKey publicKey = new PublicKey.PublicKeyBuilder()
                        .setP(new BigInteger(rs.getString("p")))
                        .setG(new BigInteger(rs.getString("g")))
                        .setH(new BigInteger(rs.getString("h")))
                        .build();
                list.add(publicKey);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

}
