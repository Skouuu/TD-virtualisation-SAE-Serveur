package iut.sae;

import iut.sae.Paquet.Paquet;
import iut.sae.Model.Scrutateur;
import iut.sae.Model.User;
import iut.sae.state.*;


import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import java.io.*;

import java.net.ServerSocket;
import java.net.Socket;
import java.net.URL;
import java.security.*;
import java.security.cert.CertificateException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

public class SSLServer {
	private ServerSocket serverSocket;
	public static PublicKey dernierePublicKey;
	private List<ClientHandler> listClient = new ArrayList<>();
	private SSLServerSocket sslServerSocket;

	public SSLServer(int port) throws KeyStoreException, IOException, CertificateException, NoSuchAlgorithmException, UnrecoverableKeyException, KeyManagementException {
		URL keystoreFile = SSLServer.class.getClassLoader().getResource("server.jks");
		String password = "password";

		KeyStore keyStore = KeyStore.getInstance("JKS");
		keyStore.load(keystoreFile.openStream(), password.toCharArray());

		KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance("SunX509");
		keyManagerFactory.init(keyStore, password.toCharArray());

		SSLContext sslContext = SSLContext.getInstance("TLS");
		sslContext.init(keyManagerFactory.getKeyManagers(), null, null);

		SSLServerSocketFactory sslServerSocketFactory = sslContext.getServerSocketFactory();
		this.sslServerSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(port);
	}


	public void start() {
		try {
			while (true){
				ClientHandler echoClientHandler = new ClientHandler(sslServerSocket.accept());
				echoClientHandler.start();
				listClient.add(echoClientHandler);
			}

		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public void stop() {
		try {
			sslServerSocket.close();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public static class ClientHandler extends Thread {
		private Socket clientSocket;
		private Scrutateur scrutateur;
		private PrintWriter out;
		private BufferedReader in;
		private String token;

		public User user;


		private ObjectInputStream objectInputStream;
		private ObjectOutputStream objectOutputStream;

		Sock socket = new Sock();
		Simulator simulator = new Simulator();


		private static final SecureRandom secureRandom = new SecureRandom();
		private static final Base64.Encoder base64Encoder = Base64.getUrlEncoder();

		public void createToken(){
			byte[] randomBytes = new byte[24];
			secureRandom.nextBytes(randomBytes);
			this.token =  base64Encoder.encodeToString(randomBytes);
		}

		public ClientHandler(Socket socket) {
			this.clientSocket = socket;
			simulator.setCommande(Paquet.TYPE.USER, new Connect(this.socket));
			simulator.setCommande(null, new Close(this.socket));
			simulator.setCommande(Paquet.TYPE.DEMANDE_RESULTAT, new Result(this.socket));
			simulator.setCommande(Paquet.TYPE.VOTE_CHIFFRE, new Vote(this.socket));
			simulator.setCommande(Paquet.TYPE.DEMANDE_ALL_QUESTION, new QuestionAll(this.socket));
			simulator.setCommande(Paquet.TYPE.DEMANDE_RESULTAT, new Result(this.socket));
			simulator.setCommande(Paquet.TYPE.DEMANDE_QUESTION_FINI, new QuestionFini(this.socket));
			simulator.setCommande(Paquet.TYPE.DEMANDE_QUESTION, new Question(this.socket));
			simulator.setCommande(Paquet.TYPE.VOTE_CHIFFRE, new Vote(this.socket));
			simulator.setCommande(Paquet.TYPE.DEMANDE_ALL_USER, new UserAll(this.socket));
			simulator.setCommande(Paquet.TYPE.DEMANDE_DELETE_USER, new DeleteUser(this.socket));
			simulator.setCommande(Paquet.TYPE.ENREGISTRER_USER, new UserSave(this.socket));
			simulator.setCommande(Paquet.TYPE.DEMANDE_FIN_VOTE, new QuestionFin(this.socket));
			simulator.setCommande(Paquet.TYPE.QUESTION, new QuestionCreate(this.socket));
			simulator.setCommande(Paquet.TYPE.PUBLIC_KEY, new PublicKeyAction(this.socket));
			simulator.setCommande(Paquet.TYPE.DEMANDE_PUBLIC_KEY, new PublicKeyClient(this.socket));
			simulator.setCommande(Paquet.TYPE.QUESTION_DATE_FIN_FINI, new QuestionDateFinFini(this.socket));
			simulator.setCommande(Paquet.TYPE.USER_UPDATE, new UserUpdate(this.socket));
		}

		public void run() {
			try {
				createToken();
				System.out.println("user is connected : token : " + token);

				out = new PrintWriter(clientSocket.getOutputStream(), true);
				in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
				objectInputStream = new ObjectInputStream(clientSocket.getInputStream());
				objectOutputStream = new ObjectOutputStream(clientSocket.getOutputStream());



				while (true) {

					Paquet paquet = (Paquet) objectInputStream.readObject();
					System.out.println("type : " + paquet.getType());
					simulator.executeCommande(paquet, objectInputStream, objectOutputStream);
				}

			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}
	}
}