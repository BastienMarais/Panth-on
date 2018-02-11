package data;

import java.util.ArrayList;

/**
 * Cette classe permet de créer des Clients
 * @author Rabhi Fahem et Marais Bastien
 *
 */
public class Client {

	String nom;
	String prenom;
	String email;
	String mdp;
	String adresse;
	String ville;
	int cp;
	
	/**
	 * Pour pouvoir créer un client rapidement.
	 */
	public Client(){
		
	}
	
	/**
	 * Permet de créer un client de manière complète.
	 * @param parNom
	 * @param parPrenom
	 * @param parEmail
	 * @param parMdp
	 * @param parAdresse
	 * @param parVille
	 * @param parCp
	 */
	public Client(String parNom,String parPrenom,
			String parEmail,String parMdp,String parAdresse,
			String parVille,int parCp){

		nom = parNom;
		prenom = parPrenom;
		email = parEmail;
		mdp = parMdp;
		adresse = parAdresse;
		ville = parVille;
		cp = parCp;
	
	}
	//-----------------METHODES----------------
	
	/**
	 * Permet de créer une Commande a remplir
	 * @param parClient
	 * @param parMontant
	 * @param parProduits
	 * @return new Commande()
	 */
	public Commande passerCommande(Client parClient, float parMontant, ArrayList<Produit> parProduits){
		return new Commande();
	}
	
	
	
	
	
	//---------------------GET------------------
	
	public String getNom(){
		return nom;
	}
	public String getPrenom(){
		return prenom;
	}
	public String getEmail(){
		return email;
	}
	public String getMdp(){
		return mdp;
	}
	public String getAdresse(){
		return adresse;
	}
	public String getVille(){
		return ville;
	}
	public int getCp(){
		return cp;
	}
	
	
	//-------------------SET------------------
	public void setNom(String nom2){
		nom = nom2;	
	}
	
	public void setPrenom(String prenom2){
		prenom = prenom2;		
	}
	public void setEmail(String email2){
		email = email2;	
	}
	public void setMdp(String mdp2){
		mdp = mdp2;	
	}
	public void setAdresse(String adresse2){
		adresse = adresse2;	
	}
	public void setVille(String ville2){
		ville = ville2;		
	}
	public void setCp(int cp2){
		cp = cp2;	
	}
	
}
