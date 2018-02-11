package baseDeDonnees;
import java.sql.*;
import java.sql.*;

import data.*;

/**
 * 
 * Cette classe regroupe les différentes
 * fonctions liées a la base de données.
 * @author Rabhi Fahem et Marais Bastien
 * 
 */
public class CommandesSQL  {

	
	
	/**
	 * Vérifie si l'adresse email existe dans la
	 * base de données.
	 * @param email
	 * @return True ou False 
	 * @throws SQLException 
	 */
	public static boolean verifEmail(String email) throws SQLException {
		
		DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
		Connection conn = DriverManager.getConnection ("jdbc:oracle:thin:@setna:1521:info","bmarais", "azerty");
	
		Statement stmt = conn.createStatement (); 
		ResultSet rset = stmt.executeQuery("select nom from CLIENT where EMAIL='"+ email +"' ");
		
		if (rset.next())
			return true;
		return false;
		
	}

	/**
	 * Vérifie si le mdp correspond a l'adresse
	 * email dans la base de données.
	 **** Est utilisé lors de la connexion pour verifier les coordonnés de l'utilisateur ****
	 * @param email
	 * @param mdp
	 * @return True ou False
	 * @throws SQLException 
	 */
	public static boolean verifMdp(String email,String mdp) throws SQLException {
		
		DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
		Connection conn = DriverManager.getConnection ("jdbc:oracle:thin:@setna:1521:info","bmarais", "azerty");
	
		Statement stmt = conn.createStatement (); 
		ResultSet rset = stmt.executeQuery("select NOM from CLIENT where MDP='"+ mdp +"' and EMAIL='"+ email +"' ");
		

		if (rset.next())
			return true;
		return false;

	}
	
	/**
	 * Ajoute un client dans la base données.
	 * @param client
	 * @throws SQLException 
	 */
	public static void addClient(Client client) throws SQLException {
		
		DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
		Connection conn = DriverManager.getConnection ("jdbc:oracle:thin:@setna:1521:info","bmarais", "azerty");
	
		Statement stmt = conn.createStatement (); 
		stmt.executeUpdate("insert into CLIENT(nom,prenom,email,mdp,adresse,ville,cp) values ('"+ client.getNom() +"','"+ client.getPrenom() +"','"+ client.getEmail() +"','"+ client.getMdp() +"','"+ client.getAdresse() +"','"+ client.getVille() +"',"+ client.getCp() +")");
		stmt.close();
		System.out.println("client créé");
	}
	
	/**
	 * Ajoute une commande dans la base de données.
	 * @param commande
	 * @throws SQLException 
	 */
	public static void addCommande(Commande commande) throws SQLException {
		DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
		Connection conn = DriverManager.getConnection ("jdbc:oracle:thin:@setna:1521:info","bmarais", "azerty");
	
		Statement stmt = conn.createStatement (); 
		int idCom = CommandesSQL.numCommande();
		stmt.executeUpdate("insert into Commande(idCom,email,montant) values ("+ idCom +",'"+ commande.getClient().getEmail() +"',"+ commande.getMontant()+")");
		
		for (Produit prod : commande.getProduits()){
			stmt.executeUpdate("insert into LIGNE_COM(idCom,nomP,qte) values ("+ idCom +",'"+ prod.getNom() +"',"+ prod.getQte()+")");
		}
		System.out.println("Commande ajoutée");
	}
	
	/**
	 * Ajoute un objet de la classe Produit dans la base de données
	 * @param prod
	 * @throws SQLException
	 */
	public static void addProduit(Produit prod) throws SQLException{
		DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
		Connection conn = DriverManager.getConnection ("jdbc:oracle:thin:@setna:1521:info","bmarais", "azerty");
		
		Statement stmt = conn.createStatement (); 
		stmt.executeUpdate("insert into PRODUIT(nomP,descP,prix) values ('"+ prod.getNom() +"','"+ prod.getDescription() +"',"+ prod.getPrix()+")");
		
		
	}
	
	/**
	 * Ajoute manuellement un produit dans la base de données,
	 * sans objet de la classe Produit
	 * @param nom
	 * @param description
	 * @param prix
	 * @throws SQLException
	 */
	public static void addProduit(String nom, String description, float prix) throws SQLException{
		DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
		Connection conn = DriverManager.getConnection ("jdbc:oracle:thin:@setna:1521:info","bmarais", "azerty");
		
		Statement stmt = conn.createStatement (); 
		stmt.executeUpdate("insert into PRODUIT(nomP,descP,prix) values ('"+ nom +"','"+ description +"',"+ prix+")");
		
		
	}

	/**
	 * Donne le prochain num de commande dans la base de données
	 * @return idCom
	 * @throws SQLException
	 */
	private static int numCommande() throws SQLException {
		DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
		Connection conn = DriverManager.getConnection ("jdbc:oracle:thin:@setna:1521:info","bmarais", "azerty");
		
		Statement stmt = conn.createStatement (); 
		ResultSet rset = stmt.executeQuery("select count(idCom) from COMMANDE");
		int idCom = 0;
		while(rset.next())
			idCom = rset.getInt(1) + 1;
		
		return idCom;
	}

	/**
	 * Cherche un client a partir de son adresse mail et de son mot de passe
	 * dans la base de données.
	 * @param email
	 * @param mdp
	 * @return un client
	 * @throws SQLException
	 */
	public static Client chercherClient(String email,String mdp) throws SQLException {
		DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
		Connection conn = DriverManager.getConnection ("jdbc:oracle:thin:@setna:1521:info","bmarais", "azerty");
	
		Statement stmt = conn.createStatement (); 
		ResultSet rset = stmt.executeQuery("select * from CLIENT where MDP='"+ mdp +"' and EMAIL='"+ email +"' ");
		Client client = new Client();
		while(rset.next()){
			client = new Client(rset.getString(1),rset.getString(2),rset.getString(3),rset.getString(4),rset.getString(5),rset.getString(6),rset.getInt(7));
		}
		return client ;
	}
	
	/**
	 * Permet de vérifier si un produit est présent dans la base de données ou pas.
	 * @param nom
	 * @param description
	 * @param prix
	 * @return true si le produit est dans la base de données
	 * ou false si le produit n'y est pas.
	 * @throws SQLException
	 */
	public static boolean verifProduit(String nom, String description, float prix) throws SQLException{
		DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
		Connection conn = DriverManager.getConnection ("jdbc:oracle:thin:@setna:1521:info","bmarais", "azerty");
	
		Statement stmt = conn.createStatement (); 
		ResultSet rset = stmt.executeQuery("select nomP from PRODUIT where nomP='"+ nom +"' and descP='"+ description +"' and prix="+ prix);
		

		if (rset.next())
			return true;
		return false;

	}
}
	
	
