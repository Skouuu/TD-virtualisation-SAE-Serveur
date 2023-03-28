package iut.sae.state;

public interface Undoable extends Commande {
    void undo();
}
