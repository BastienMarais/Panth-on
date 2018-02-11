package vues;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.*;

import data.Client;
import data.Commande;
import data.Produit;

/**
 * 
 * Cette classe est un panel regroupant les 
 * panels produit et panier ainsi qu'un bouton de déconnexion.
 * @author Rabhi Fahem et Marais Bastien
 *
 */
public class PanelBoutique extends JPanel implements ActionListener {
	
	JPanel panelProduits = new JPanel();
	JButton boutonDeco = new JButton("Deconnexion");
	JButton boutonCommande = new JButton("Commander");
	Produit[] tabProd = new Produit[4];
	PanelProduit[] tabPanelProd = new PanelProduit[4];
	PanelPanier panelPanier = new PanelPanier();
	
	CardLayout gestCartes;
	PanelAffichage pAff;
	GridBagLayout gestionnaireGrid = new GridBagLayout();
	GridBagConstraints contrainte = new GridBagConstraints();
	
	/**
	 * Permet de créer la page de la boutique, utilise un GridBagLayout
	 * @param gestionnaireCartes
	 * @param panelAffichage
	 * @throws SQLException
	 */
	public PanelBoutique(CardLayout gestionnaireCartes, PanelAffichage panelAffichage) throws SQLException{
		
	
		setLayout(gestionnaireGrid);
		setBackground(new Color(155,155,155));
		contrainte.fill=GridBagConstraints.BOTH;
		contrainte.insets = new Insets(10,10,10,10);
		
		gestCartes = gestionnaireCartes;
		pAff= panelAffichage;
		
		// ajout des produits
		tabProd[0] = new Produit("Pain Choco","Bon et pas cher", (float) 0.90 , new ImageIcon("images/pain_choco.jpg"));
		tabPanelProd[0] = new PanelProduit(tabProd[0],panelPanier,panelAffichage);
		tabProd[1] = new Produit("Chocolatine","Mauvais et cher", (float) 1.20 , new ImageIcon("images/pain_choco.jpg"));
		tabPanelProd[1] = new PanelProduit(tabProd[1],panelPanier,panelAffichage);
		tabProd[2] = new Produit("Baguette","Bonne baguette", (float) 1 , new ImageIcon("images/baguette.jpg"));
		tabPanelProd[2] = new PanelProduit(tabProd[2],panelPanier,panelAffichage);
		tabProd[3] = new Produit("Forêt Noire","Une merveille", (float) 2.5 , new ImageIcon("images/foret.jpg"));
		tabPanelProd[3] = new PanelProduit(tabProd[3],panelPanier,panelAffichage);
		
		JLabel labelTotal = new JLabel("Montant total : ");
		
		panelProduits.setBackground(new Color(100,100,100));
		panelProduits.setLayout(new GridLayout(4,1));
		panelProduits.add(tabPanelProd[0]);
		panelProduits.add(tabPanelProd[1]);
		panelProduits.add(tabPanelProd[2]);
		panelProduits.add(tabPanelProd[3]);
		
		/* ajout du boutonDeco*/
		contrainte.gridx = 0;
		contrainte.gridy = 0;
		contrainte.gridwidth = 1;
		contrainte.gridheight = 1;
		add(boutonDeco,contrainte);
		boutonDeco.addActionListener(this);
		
		// ajout du boutonCommande
		contrainte.gridx = 1;
		add(boutonCommande,contrainte);
		boutonCommande.addActionListener(this);
		
		
		// ajout du du panelProduits
		contrainte.gridx = 0;
		contrainte.gridy = 1;
		contrainte.gridwidth = 3;
		contrainte.gridheight = 5;
		add(panelProduits,contrainte);
		
		// ajout panelPanier 
		contrainte.gridx = 4;
		contrainte.gridy = 1;
		contrainte.gridwidth = 3;
		contrainte.gridheight = 3;
		add(panelPanier,contrainte);
		
		
		
	}

	/**
	 * permet d'interagir en fonction du bouton pressé
	 */
	public void actionPerformed(ActionEvent evt) {
		if(evt.getSource() == boutonDeco){
			panelPanier.panier.setText("Panier :\n");
			panelPanier.labelMontant.setText("0€");
			gestCartes.show(pAff,"acceuil");
			pAff.client = new Client();
			pAff.commande = new Commande(pAff.client,0,new ArrayList<Produit>());
		}
		if (evt.getSource() == boutonCommande){
			panelPanier.panier.setText("Panier :\n");
			panelPanier.labelMontant.setText("0€");
			pAff.commande.setClient(pAff.client);
			gestCartes.show(pAff,"commande");
		}
	}
}
