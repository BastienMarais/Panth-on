package vues;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * 
 * Cette classe est un panel regroupant les 
 * panels inscription,connexion et une image.
 * @author Rabhi Fahem et Marais Bastien
 *
 */
public class PanelAcceuil extends JPanel {
	
	PanelLogin zoneLogin; 
	PanelInscription zoneInscription; 
	JLabel image = new JLabel(new ImageIcon("images/banniere.jpg"));
	GridBagLayout gestionnaireGrid = new GridBagLayout();
	GridBagConstraints contrainte = new GridBagConstraints();
	
	
	/**
	 * Constructeur de la page d'acceuil, fonctionnant avec un GridBagLayout
	 * @param gestionnaireCartes
	 * @param panelAffichage
	 */
	public PanelAcceuil(CardLayout gestionnaireCartes, PanelAffichage panelAffichage){

		setLayout(gestionnaireGrid);
		setBackground(new Color(55,55,55));
		contrainte.fill=GridBagConstraints.BOTH;
		contrainte.insets = new Insets(10,10,10,10);
		
		zoneLogin= new PanelLogin(gestionnaireCartes,panelAffichage);
		zoneInscription = new PanelInscription(gestionnaireCartes,panelAffichage);
		
		/*Ajout du panel login*/
		contrainte.gridx = 0;
		contrainte.gridy = 0;
		contrainte.gridwidth =  2;
		add(zoneLogin,contrainte);
		
		/*Ajout de l'image*/
		contrainte.gridx = 2;
		add(image,contrainte);
		
		/*Ajout du panel inscription*/
		contrainte.gridx = 0;
		contrainte.gridwidth =  4;
		contrainte.gridy=1;
		add(zoneInscription,contrainte);
		
	}
}
