package iut.sae;

import iut.sae.Repository.Mysql;

import java.net.URL;

public class ApplicationServer {

	public static void main(String[] args) throws Exception {
		Mysql m = Mysql.getINSTANCE(); // connexion à la base de donnée
		ClassLoader classLoader = ApplicationServer.class.getClassLoader();
		URL resource = classLoader.getResource("server.jks"); // certificat
		if (resource == null) {
			System.out.println("fichier non trouvé ---------------------------------------------");
			throw new IllegalArgumentException("file not found! " + "server.trust");
		} else {
		}


		SSLServer server = new SSLServer(6666);
		server.start();
		System.out.println("serveur démarré");
	}

}
