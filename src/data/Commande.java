package data;

import java.util.ArrayList;

/**
 * Cette classe permet de cr�er un objet commande
 * qui stocke des produits
 * @author Rabhi Fahem et Marais Bastien
 *
 */
public class Commande {

	Client client;
	float montant;
	ArrayList<Produit> produits ;
	
	/**
	 * Pour pouvoir cr�er une commande rapidement
	 */
	public Commande(){
		
	}
	
	/**
	 * Permet de cr�er une commande qui sera li�e a un client, qui aura un montant et
	 * une ArrayList de produit.
	 * @param parClient
	 * @param parMontant
	 * @param parProduits
	 */
	public Commande(Client parClient, float parMontant, ArrayList<Produit> parProduits){
		client = parClient;
		montant = parMontant;
		produits = parProduits;
	}
	//----------------METHODES--------------

	/**
	 * Permet d'ajouter un produit dans la ArrayList de produits
	 * @param produit1
	 */
	public void ajoutProduit (Produit produit1){
		produits.add(produit1);
	}
	
	
	//-----------------GET--------------
	
	public Client getClient(){
		return client;
	}
	public float getMontant(){
		return montant;
	}
	public ArrayList<Produit> getProduits(){
		return produits;
	}
	
	
	//---------------SET-------------------
	public void setClient(Client parClient){
		client = parClient;
	}
	public void setMontant(float montant2){
		montant = montant2;
	}
	public void setProduits(ArrayList<Produit> produits2){
		produits2 = produits;
	}
	
}
