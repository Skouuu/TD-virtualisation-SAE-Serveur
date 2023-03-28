package iut.sae.Paquet;

public class DeleteUserPaquet extends Paquet{
    private String email;
    public DeleteUserPaquet(String u) {
        super(TYPE.DEMANDE_DELETE_USER);
        this.email = u;
    }

    public String getEmail() {
        return email;
    }
}
