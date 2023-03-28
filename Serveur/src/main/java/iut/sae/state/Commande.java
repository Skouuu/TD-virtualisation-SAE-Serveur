package iut.sae.state;

import iut.sae.Paquet.Paquet;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public interface Commande {
    void execute(Paquet paquet, ObjectInputStream objectInputStream, ObjectOutputStream objectOutputStream);
}
