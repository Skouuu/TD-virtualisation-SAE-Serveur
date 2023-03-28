package iut.sae.Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Mysql {
    private static Mysql INSTANCE = null; // instance singleton

    private Connection connection;

    public static Mysql getINSTANCE() {
        if(INSTANCE == null) INSTANCE = new Mysql(); // si pas d'instance, on en créé une
        return INSTANCE; // on retourne l'instance
    }

    public Connection getConnection() {
        return connection;
    }

    private Mysql(){ // constructeur privé car instance singleton

        // connexion mysql chiffrée
        String connectionUrl = "jdbc:mysql://localhost:3306/sae?serverTimezone=UTC";
        String url = "jdbc:mysql://127.0.0.1:3306/sae"+
                "?verifyServerCertificate=false"+
                "&useSSL=true"+
                "&requireSSL=true";
        try {

           // Class.forName("com.mysql.jdbc.Driver");
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, "newuser", "password");
        } catch (SQLException e) {
            System.out.println("Impossible de se connecter à la base de donnée");
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }






}
