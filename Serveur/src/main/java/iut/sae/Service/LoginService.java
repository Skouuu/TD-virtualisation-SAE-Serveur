package iut.sae.Service;


import iut.sae.Model.Role;
import iut.sae.Model.User;
import iut.sae.Repository.UserRepository;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class LoginService {

    private String result;
    private User user;

    private User userLogin;
    private ObjectOutputStream objectOutputStream;
    private ObjectInputStream objectInputStream;

    private String action;

    public LoginService(User user,
                        ObjectInputStream objectInputStream,
                        ObjectOutputStream objectOutputStream){
        this.user = user;
        this.objectInputStream = objectInputStream;
        this.objectOutputStream = objectOutputStream;
        result = "";

        try {
            objectOutputStream.writeObject("User received");
            this.action = (String) objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        System.out.println("action------------------------------------------" + action);

        if(action.equals("connexion")) connect();
        //else if(action.equals("initialisation")) signin();
    }


    public LoginService(User user,
                        String newPassword,
                        ObjectInputStream objectInputStream,
                        ObjectOutputStream objectOutputStream){
        this.user = user;
        this.objectInputStream = objectInputStream;
        this.objectOutputStream = objectOutputStream;
        result = "";

        try {
            objectOutputStream.writeObject("User received");
            this.action = (String) objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        //connect();
        //update(newPassword);
    }

    public void update(String newPassword){
        System.out.println("update => email : " + user.getEmail());
        System.out.println("udpate -> mot de passe : " + user.getMotDePasse());

        if(UserRepository.seConnecter(user.getEmail(), user.getMotDePasse()) != null && UserRepository.chercherNull(user.getEmail())){
            System.out.println("new password : " + newPassword);

            userLogin.setMotDePasse(newPassword);
            UserRepository.modifier(userLogin, userLogin.getEmail());
            System.out.println("mot de passe modifié : " + userLogin.getMotDePasse());
            user.setMotDePasse(newPassword);
            result = "true";
        } else {
            System.out.println("---------------- error -----------------");
        }
    }

    public void connect(){
        System.out.println("email : " + user.getEmail());

        userLogin = UserRepository.seConnecter(user.getEmail(), user.getMotDePasse());
        System.out.println("userlogin : " + userLogin);

        if(userLogin == null) {
            result = "l'utilisateur n'existe pas";
            System.out.println("l'utilisateur n'existe pas");
        }
        else if(userLogin.getRole().equals(Role.ROLE_ADMIN.toString())) {
            result = "admin";
            System.out.println("admin");
        }
        else{
            if(UserRepository.chercherNull(user.getEmail())){
                result = "signin";
                System.out.println( "--------- signin ----------------");
                System.out.println("signin");
            }
            else{
                result = "true";
                System.out.println("connected");
            }
        }
    }

    public User getUserLogin() {
        return userLogin;
    }

    public User getUser() {
        return user;
    }

    public String getResult() {
        return result;
    }

    public boolean estConnecte(){
        return result.equals("true");
    }

    public boolean estAdmin(){
        return result.equals("admin");
    }

    public void sendResult () {
        try {
            System.out.println("result : " + result);
            objectOutputStream.writeObject(result);
        } catch (IOException e) {
            //e.getMessage();
            throw new RuntimeException(e);
        } catch (Exception e) {
            try {
                objectOutputStream.writeObject(e.getMessage());
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
    }
}
