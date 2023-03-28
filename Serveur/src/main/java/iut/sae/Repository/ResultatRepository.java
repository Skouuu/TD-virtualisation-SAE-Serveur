package iut.sae.Repository;


import iut.sae.Model.Resultat;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ResultatRepository {

    public static int enregistrer(Resultat resultat){
        Mysql mysql = Mysql.getINSTANCE();
        PreparedStatement ps;
        try {
            ps = mysql.getConnection().prepareStatement("INSERT INTO resultat(reponse1, reponse2) VALUES(?,?)", Statement.RETURN_GENERATED_KEYS);
            ps.setDouble(1, resultat.getReponse1());
            ps.setDouble(2, resultat.getReponse2());
            ps.execute();

            ResultSet rs = ps.getGeneratedKeys();
            int generatedKey = 0;
            if (rs.next()) {
                generatedKey = rs.getInt(1);
            }
            return generatedKey;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static Resultat chercher(int id){
        Mysql mysql = Mysql.getINSTANCE();
        PreparedStatement ps;
        ResultSet rs;
        Resultat resultat = null;

        try {
            ps = mysql.getConnection().prepareStatement("SELECT * FROM resultat WHERE id = ?");
            ps.setInt(1, id);
            rs = ps.executeQuery();

            if(rs.next()){
                resultat = new Resultat.ResultatBuilder()
                        .setReponse1(rs.getInt("reponse1"))
                        .setReponse2(rs.getInt("reponse2"))
                        .setId(rs.getInt("id"))
                        .build();
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return resultat;
    }

    public static List<Resultat> getAllResultats(){
        List<Resultat> list = new ArrayList<>();
        Mysql mysql = Mysql.getINSTANCE();
        PreparedStatement ps;
        ResultSet rs;

        try {
            ps = mysql.getConnection().prepareStatement("SELECT * FROM resultat");
            rs = ps.executeQuery();
            while (rs.next()){
                Resultat  resultat = new Resultat.ResultatBuilder()
                        .setReponse1(rs.getInt("reponse1"))
                        .setReponse2(rs.getInt("reponse2"))
                        .setId(rs.getInt("id"))
                        .build();
                list.add(resultat);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

}
