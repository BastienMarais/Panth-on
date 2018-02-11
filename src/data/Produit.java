package data;

import java.sql.SQLException;

import javax.swing.ImageIcon;

import baseDeDonnees.CommandesSQL;

/**
 * Cette classe permet de cr�er un produit que l'on pourra acheter
 * @author Rabhi Fahem et Marais Bastien
 *
 */
public class Produit {
	
	String nom;
	String description;
	float prix;
	ImageIcon image;
	int qte = 0;
	
	
	
	/**
	 * Permet de cr�er un produit de mani�re compl�te
	 * @param parNomP
	 * @param desc
	 * @param parPrix
	 * @param img
	 * @throws SQLException
	 */
	public Produit(String parNomP,String desc, float parPrix , ImageIcon img) throws SQLException{
		nom = parNomP;
		description = desc;
		prix = parPrix;
		image = img;
		
		if (CommandesSQL.verifProduit(nom,description,prix) == false)
			CommandesSQL.addProduit(nom,description,prix);
	}
	
	//--------------------GET-------------------
	/**
	 * Voici les ascesseurs
	 * 
	 */
	public String getNom(){
		return nom;
	}
	public String getDescription(){
		return description;
	}
	
	public float getPrix(){
		return prix;
	}
	public ImageIcon getImage(){
		return image;
	}
	
	public int getQte() {
		return qte;
	}
	//--------------------SET-------------------
	public void setNom(String nomP){
		nom = nomP;
	}
	
	public void setDescription(String desc){
		description = desc ;

	}
	
	public void setPrix(float prix2){
		prix = prix2;
	}

	public void setImage(ImageIcon img){
		image = img;
	}

	public void setQte(int nQte) {
		qte = nQte;
		
	}

	
}
