package vues;

import java.awt.CardLayout;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.*;

/**
 * Cette classe est un panel qui affiche 
 * le contenu du panier.
 * @author Rabhi Fahem et Marais Bastien
 */
public class PanelPanier extends JPanel{
	
	String message = new String("Panier : \n");
	JTextArea panier = new JTextArea(message);
	float montant;
	
	CardLayout gestCartes;
	PanelAffichage pAff;
	GridBagLayout gestionnaireGrid = new GridBagLayout();
	GridBagConstraints contrainte = new GridBagConstraints();
	JLabel labelTotal = new JLabel("Montant total : ");
	JLabel labelMontant = new JLabel();
	
	/**
	 * Crée l'interface qui affiche le panier
	 */
	public PanelPanier(){
		
		setLayout(gestionnaireGrid);
		setBackground(new Color(155,75,75));
		contrainte.fill=GridBagConstraints.BOTH;
		contrainte.insets = new Insets(10,10,10,10);
		
		//ajout du panier
		contrainte.gridx = 0;
		contrainte.gridy = 0;
		contrainte.gridwidth = 2;
		contrainte.gridheight = 2;
		add(panier,contrainte);
		
		//ajout du labelTotal
		contrainte.gridx = 0;
		contrainte.gridy = 2;
		contrainte.gridwidth = 1;
		contrainte.gridheight = 1;
		add(labelTotal,contrainte);
		
		//ajout du labelTotal
		labelMontant.setText("0€");
		contrainte.gridx = 1;
		add(labelMontant,contrainte);
		
		
		
	}
}
