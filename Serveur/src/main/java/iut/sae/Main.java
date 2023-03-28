package iut.sae;

import iut.sae.Model.User;
import iut.sae.Paquet.Paquet;
import iut.sae.Paquet.UserPaquet;
import iut.sae.state.*;

public class Main {
    public static void main(String[] args) {
        Simulator simulator = new Simulator();
        Sock sock = new Sock();

        System.out.println(sock.getState());

        simulator.setCommande(Paquet.TYPE.USER, new Connect(sock));
        simulator.setCommande(null, new Close(sock));
        simulator.setCommande(Paquet.TYPE.DEMANDE_RESULTAT, new Result(sock));
        simulator.setCommande(Paquet.TYPE.VOTE_CHIFFRE, new Vote(sock));

        try {
            User user = new User.UserBuilder()
                    .setEmail("test@gmail.com")
                    .setMotDePasse("test")
                    .build();

            Paquet paquetRecu = new UserPaquet(user);

           // simulator.executeCommande(paquetRecu);

            System.out.println("--------" + sock.getState());

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        // le but est d'executer une commande en fonction du paquet reçu




    }

}