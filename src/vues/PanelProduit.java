package vues;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import data.Produit;

/**
 * Cette classe est un panel qui affiche un
 * produit de la boutique.
 * @author Rabhi Fahem et Marais Bastien
 */
public class PanelProduit extends JPanel implements ActionListener{
	
	GridBagLayout gestionnaireGrid = new GridBagLayout();
	GridBagConstraints contrainte = new GridBagConstraints();
	
	Produit prod;
	JLabel labelImage;
	ImageIcon image;
	JLabel labelNom;
	JLabel labelPrix;
	JLabel labelDesc;
	JLabel labelQte;
	JButton plus = new JButton("+");
	JButton moins = new JButton("-");
	JButton addPanier = new JButton("Ajout panier");
	PanelPanier pPanier;
	
	PanelAffichage pAff;
	
	/**
	 * Permet d'afficher un produit dans le panel de la boutique
	 * @param produit
	 * @param panelPanier
	 * @param panelAffichage
	 */
	public PanelProduit(Produit produit, PanelPanier panelPanier, PanelAffichage panelAffichage){
		
		pAff = panelAffichage;
		
		setLayout(gestionnaireGrid);
		setBackground(new Color(155,75,75));
		contrainte.fill=GridBagConstraints.BOTH;
		contrainte.insets = new Insets(10,10,10,10);
		
		pPanier = panelPanier;
		prod = produit;
		labelNom = new JLabel("Nom : " + prod.getNom());
		labelPrix = new JLabel("Prix : " + prod.getPrix() +"€");
		labelDesc = new JLabel("Desc : " + prod.getDescription());
		labelQte = new JLabel("0");
		image = prod.getImage();
		labelImage = new JLabel(image);
		
		
		// ajout de l'image
		contrainte.gridx = 0;
		contrainte.gridy = 0;
		contrainte.gridwidth = 2;
		contrainte.gridheight = 3;
		add(labelImage,contrainte);
		
		// ajout du labelNom
		contrainte.gridx = 2;
		contrainte.gridwidth = 1;
		contrainte.gridheight = 1;
		add(labelNom,contrainte);
		
		// ajout du labelPrix
		contrainte.gridy = 1;
		add(labelPrix,contrainte);
		
		// ajout du labelDesc
		contrainte.gridy = 2;
		add(labelDesc,contrainte);
		
		// ajout du bouton plus
		contrainte.gridy = 0;
		contrainte.gridx = 4;
		add(plus,contrainte);
		plus.addActionListener(this);
		
		// ajout de la quantitée
		contrainte.gridy = 1;
		add(labelQte,contrainte);
		
		// ajout du bouton moins
		contrainte.gridy = 2 ;
		add(moins,contrainte);
		moins.addActionListener(this);
		
		// ajout du bouton addPanier
		contrainte.gridx = 5;
		contrainte.gridy = 1;
		add(addPanier,contrainte);
		addPanier.addActionListener(this);
		
		
	}


	/**
	 * permet d'intéragir lorsqu'un bouton est pressé,
	 * ou lorsque l'on ajoute un produit dans le panier
	 */
	public void actionPerformed(ActionEvent evt) {
		if(evt.getSource() == plus){
			String qte = Integer.toString(Integer.parseInt(labelQte.getText())+1);
			labelQte.setText(qte); 
			
			
		}
		if(evt.getSource() == moins){
			if(Integer.parseInt(labelQte.getText()) >  0){
				String qte = Integer.toString(Integer.parseInt(labelQte.getText())-1);
				labelQte.setText(qte);
			}
		}
		
		if ( evt.getSource()== addPanier){
			
			String mess = pPanier.panier.getText(); 
			
			int qteProd = Integer.parseInt(labelQte.getText());
			float prixProd = prod.getPrix() * qteProd ;
			
			mess += prod.getNom() + " en " + labelQte.getText() + " fois pour un total de " + prixProd + "€\n";
			
			pPanier.panier.setText(mess);
			pPanier.montant += prixProd; 
			pPanier.labelMontant.setText(pPanier.montant +"€");
			
			int nQte = prod.getQte() + qteProd;
			prod.setQte(nQte);
			pAff.commande.ajoutProduit(prod);
			float newMontant = pAff.commande.getMontant() + prod.getPrix()* qteProd;
			pAff.commande.setMontant(newMontant);
			
		}
	}
	
}
