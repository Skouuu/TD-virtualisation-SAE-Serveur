package iut.sae.Model;

import java.io.Serializable;

public class User implements Serializable {
    private String email;
    private String motDePasse;
    private String role;

    public User(UserBuilder userBuilder){
        this.email = userBuilder.email;
        this.motDePasse = userBuilder.motDePasse;
        this.role = userBuilder.role;
    }

    public String getEmail() {
        return email;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public String getRole() {
        return role;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    @Override
    public String toString() {
        return "email : " + email + "\n" +
                "mot de passe : " + motDePasse + "\n" +
                "role : " + role;
    }

    // -------------------------------------------------------

    public static class UserBuilder{
        private String email;
        private String motDePasse;

        private String role;

        public UserBuilder setEmail(String email){
            this.email = email;
            return this;
        }

        public UserBuilder setRole(String role) {
            this.role = role;
            return this;
        }

        public UserBuilder setMotDePasse(String motDePasse){
            this.motDePasse = motDePasse;
            return this;
        }

        public User build(){
            User user = new User(this);
            if(user.role == null) user.role = Role.ROLE_USER.toString();
            return user;
        }

    }


}
