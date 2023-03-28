package iut.sae.Repository;


import iut.sae.Model.Role;
import iut.sae.Model.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserRepository {

    public static void update(User user) throws SQLException {
        Mysql mysql = Mysql.getINSTANCE();
        PreparedStatement ps;

        ps = mysql.getConnection().prepareStatement("UPDATE user set password=? WHERE email=?");
        ps.setString(1, user.getMotDePasse());
        ps.setString(2, user.getEmail());
        ps.execute();
    }

    public static void enregistrer(User user) throws SQLException {
        Mysql mysql = Mysql.getINSTANCE();
        PreparedStatement ps;

        ps = mysql.getConnection().prepareStatement("INSERT INTO user(email, password, role) VALUES(?,?,?)");
        ps.setString(1, user.getEmail());
        ps.setString(2, user.getMotDePasse());
        ps.setString(3, Role.ROLE_USER.toString());
        ps.execute();
    }

    public static User seConnecter(String email, String motDePasse){

        User user = chercher(email);
        if(user == null) return null;
        if(user.getMotDePasse().equals(motDePasse)) return user;
        else return null;
    }

    /**
     * @param user → objet à modifier en base de donnée
     * @param email → primary key
     */
    public static void modifier(User user, String email){
        Mysql mysql = Mysql.getINSTANCE();
        PreparedStatement ps;
        try {
            ps = mysql.getConnection().prepareStatement("UPDATE user set password = ?, role = ?, premiereConnexion=0 WHERE email = ?");
            ps.setString(1, user.getMotDePasse());
            ps.setString(2, Role.ROLE_USER.toString());
            ps.setString(3, email);
            ps.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public static void supprimer(String email){
        Mysql mysql = Mysql.getINSTANCE();
        PreparedStatement ps;
        try {
            ps = mysql.getConnection().prepareStatement("DELETE FROM user WHERE email = ?");
            ps.setString(1, email);
            ps.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean chercherNull(String email){
        Mysql mysql = Mysql.getINSTANCE();
        PreparedStatement ps;
        ResultSet rs;
        User user = null;

        try {
            ps = mysql.getConnection().prepareStatement("SELECT * FROM user WHERE email = ? AND premiereConnexion=1");
            ps.setString(1, email);
            rs = ps.executeQuery();

            return rs.next();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static User chercher(String email){
        Mysql mysql = Mysql.getINSTANCE();
        PreparedStatement ps;
        ResultSet rs;
        User user = null;

        try {
            ps = mysql.getConnection().prepareStatement("SELECT * FROM user WHERE email = ?");
            ps.setString(1, email);
            rs = ps.executeQuery();

            if(rs.next()){
                user = new User.UserBuilder()
                        .setEmail(rs.getString("email"))
                        .setMotDePasse(rs.getString("password"))
                        .setRole(rs.getString("role"))
                        .build();
            }
            else System.out.println("aucun utilisateur");


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return user;
    }

    public static List<User> getAllUsers(){
        List<User> list = new ArrayList<>();
        Mysql mysql = Mysql.getINSTANCE();
        PreparedStatement ps;
        ResultSet rs;

        try {
            ps = mysql.getConnection().prepareStatement("SELECT * FROM user");
            rs = ps.executeQuery();
            while (rs.next()){
                User user = new User.UserBuilder()
                        .setEmail(rs.getString("email"))
                        .setMotDePasse(rs.getString("password"))
                        .setRole(rs.getString("role"))
                        .build();
                list.add(user);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }
}
