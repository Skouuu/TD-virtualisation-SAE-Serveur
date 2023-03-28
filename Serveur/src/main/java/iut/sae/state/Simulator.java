package iut.sae.state;

import iut.sae.Paquet.Paquet;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Simulator {
    private Map<Paquet.TYPE, Commande> listCommande;
    private ArrayList<String> list;
    private DateTimeFormatter dtf;
    private LocalDateTime now;

    public ArrayList<String> getList() {
        return list;
    }

    public Simulator(){
        listCommande = new HashMap<>();
        list = new ArrayList<>();
        this.dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
    }

    public void setCommande(Paquet.TYPE type, Commande c){
        listCommande.put(type, c);
    }

    public void executeCommande(Paquet paquet, ObjectInputStream objectInputStream, ObjectOutputStream objectOutputStream) throws Exception {
        Commande commande = listCommande.get(paquet.getType());

        if(commande == null){
            throw new Exception("Commande " + paquet.getType().name() + " inconnue");
        }

        System.out.println("Commande : " + commande.toString());
        commande.execute(paquet, objectInputStream, objectOutputStream);


        this.now = LocalDateTime.now();
        //list.add("date : " + dtf.format(now) + " : " + listCommande.get(paquet).toString());
    }
}
