package iut.sae.Repository;

import iut.sae.Model.PublicKey;


import java.math.BigInteger;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PublicKeyRepository {

    public static int enregistrer(PublicKey publicKey){
        Mysql mysql = Mysql.getINSTANCE();
        PreparedStatement ps;
        try {
            ps = mysql.getConnection().prepareStatement("INSERT INTO PublicKey(p, g, h) VALUES(?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, publicKey.getP().toString());
            ps.setString(2, publicKey.getG().toString());
            ps.setString(3, publicKey.getH().toString());
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

    public static PublicKey derniere(){
        Mysql mysql = Mysql.getINSTANCE();
        PreparedStatement ps;
        ResultSet rs;
        PublicKey publicKey = null;

        try {
            //ps = mysql.getConnection().prepareStatement("SELECT * FROM PublicKey WHERE id = ?");
            ps = mysql.getConnection().prepareStatement("SELECT * FROM PublicKey WHERE id = (SELECT MAX(id) FROM PublicKey)");
            rs = ps.executeQuery();

            if(rs.next()){
                publicKey = new PublicKey.PublicKeyBuilder()
                        .setP(new BigInteger(rs.getString("p")))
                        .setG(new BigInteger(rs.getString("g")))
                        .setH(new BigInteger(rs.getString("h")))
                        .setId(rs.getInt("id"))
                        .build();
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return publicKey;
    }



    public static PublicKey chercher(int id){
        Mysql mysql = Mysql.getINSTANCE();
        PreparedStatement ps;
        ResultSet rs;
        PublicKey publicKey = null;

        try {
            //ps = mysql.getConnection().prepareStatement("SELECT * FROM PublicKey WHERE id = ?");
            ps = mysql.getConnection().prepareStatement("SELECT * FROM PublicKey WHERE id = ?");
            ps.setInt(1, id);
            rs = ps.executeQuery();

            if(rs.next()){
                publicKey = new PublicKey.PublicKeyBuilder()
                        .setP(new BigInteger(rs.getString("p")))
                        .setG(new BigInteger(rs.getString("g")))
                        .setH(new BigInteger(rs.getString("h")))
                        .setId(rs.getInt("id"))
                        .build();
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return publicKey;
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
