package iut.sae.state;


import iut.sae.state.Sock;
import iut.sae.state.StateInit;
import org.testng.annotations.Test;

import static org.testng.Assert.assertThrows;
import static org.testng.AssertJUnit.assertEquals;

public class TestState {


    @Test
    void SimulationConnexionPuisVote(){
        Sock sock = new Sock();

        sock.connect();
        sock.question();
        sock.vote();
        sock.undo();
        sock.undo();

        assertEquals(StateInit.class, sock.getState().getClass());
    }

    @Test
    void simulationDemandeQuestionAllSansAuth(){
        Sock sock = new Sock();
        assertThrows(Exception.class, sock::questionAll);
    }

    @Test
    void simulationDemandeQuestionSansAuth(){
        Sock sock = new Sock();
        assertThrows(Exception.class, sock::question);
    }

    @Test
    void simulationDemandeResultatSansAuth(){
        Sock sock = new Sock();
        assertThrows(Exception.class, sock::result);
    }

    @Test
    void simulationAccesQuestionFiniSansAuth(){
        Sock sock = new Sock();
        assertThrows(Exception.class, sock::questionFini);
    }

    @Test
    void simulationDemandeResultatAvecAuth(){
        Sock sock = new Sock();
        sock.connect();
        sock.result();
        assertEquals(StateConnected.class, sock.getState().getClass());
    }

    @Test
    void simulationDemandeQuestionAllAvecAuth(){
        Sock sock = new Sock();
        sock.connect();
        sock.questionAll();

        assertEquals(StateConnected.class, sock.getState().getClass());
    }

    @Test
    void simulationDemandeQuestionAvecAuth(){
        Sock sock = new Sock();
        sock.connect();
        sock.questionAll();

        assertEquals(StateConnected.class, sock.getState().getClass());
    }

    @Test
    void simulationAccesQuestionFinitAvecAuth(){
        Sock sock = new Sock();
        sock.connect();
        sock.questionFini();
        assertEquals(StateConnected.class, sock.getState().getClass());
    }

    @Test
    void simulationVoteSansConnexion(){
        Sock sock = new Sock();
        assertThrows(Exception.class, sock::vote);
    }

    @Test
    void simulationAccesQuestionCreateSansAdmin(){
        Sock sock = new Sock();
        sock.connect();
        assertThrows(Exception.class, sock::questionCreate);
    }
    @Test
    void simulationAccesQuestionCreateAvecAdmin(){
        Sock sock = new Sock();
        sock.connectAdmin();
        sock.questionCreate();

        assertEquals(StateAdmin.class, sock.getState().getClass());
    }

    @Test
    void simulationAccesFinVoteSansAdmin(){
        Sock sock = new Sock();
        sock.connect();
        assertThrows(Exception.class, sock::questionFin);
    }
    @Test
    void simulationAccesFinVoteAvecAdmin(){
        Sock sock = new Sock();
        sock.connectAdmin();
        sock.questionFin();

        assertEquals(StateAdmin.class, sock.getState().getClass());
    }

    @Test
    void simulationAccesRegisterUserSansAdmin(){
        Sock sock = new Sock();
        sock.connect();
        assertThrows(Exception.class, sock::userSave);
    }
    @Test
    void simulationAccesRegisterUserAvecAdmin(){
        Sock sock = new Sock();
        sock.connectAdmin();
        sock.userSave();

        assertEquals(StateAdmin.class, sock.getState().getClass());
    }

    @Test
    void simulationAccesDeleteUserSansAdmin(){
        Sock sock = new Sock();
        sock.connect();
        assertThrows(Exception.class, sock::deleteUser);
    }

    @Test
    void simulationAccesDeleteUserAvecAdmin(){
        Sock sock = new Sock();
        sock.connectAdmin();
        sock.deleteUser();

        assertEquals(StateAdmin.class, sock.getState().getClass());
    }



    @Test
    void simulationAccesAllUserSansAdmin(){
        Sock sock = new Sock();
        sock.connect();
        assertThrows(Exception.class, sock::userAll);
    }
    @Test
    void simulationAccesAllUserAvecAdmin(){
        Sock sock = new Sock();
        sock.connectAdmin();
        sock.userAll();

        assertEquals(StateAdmin.class, sock.getState().getClass());
    }

    @Test
    void simulationVoteSansChoisirDeQuestion(){
        Sock sock = new Sock();
        sock.connect();
        assertThrows(Exception.class, sock::vote);
    }

    @Test
    void simulationVoteAvecAuthETChoixQuestion(){
        Sock sock = new Sock();
        sock.connect();
        sock.question();
        sock.vote();

        sock.undo();
        assertEquals(StateConnected.class, sock.getState().getClass());

    }

    @Test
    void simulationAccesResultSansAdmin(){
        Sock sock = new Sock();
        sock.connectAdmin();
        sock.questionFin();
        assertEquals(StateAdmin.class, sock.getState().getClass());

    }

    @Test
    void simulationConnexionPuisVoirResultat(){
        Sock socket = new Sock();

        socket.connect();
        socket.result();
        socket.undo();

        assertEquals(StateInit.class, socket.getState().getClass());
    }

    @Test
    void simulationConnexionPuisVoirResultat2(){
        Sock socket = new Sock();

        //socket.connect();
        socket.userUpdate();

        assertEquals(StateInit.class, socket.getState().getClass());
    }

    @Test
    void simulationVoteSansConnect(){

        Sock socket = new Sock();

        assertThrows(Exception.class, socket::vote);

    }
/*
    @Test
    void testAvecHistorique(){
        /*
        Client client = new Client();
        client.execute();

        System.out.println("historique : ---------------");
        for(String s : client.getSimulator().getList()){
            System.out.println(s);
        }

        assertEquals(StateInit.class, client.getSocket().getState().getClass());


    }

    @Test
    void testAvecMauvaiseCommande(){
       // Client client = new Client();
       // assertThrows(Exception.class, ()->client.getSimulator().executeCommande("ls"));

        //assertEquals(StateInit.class, client.getSocket().getState().getClass());

    }

    @Test
    void undoTest()
    {
        /*
        Client client = new Client();
        client.execute();
        client.getSocket().undo();
        assertEquals(StateClosed.class, client.getSocket().getState().getClass());


    }

     */

}
