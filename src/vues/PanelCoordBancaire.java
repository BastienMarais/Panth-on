package vues;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import data.*;
import baseDeDonnees.*;


/**
 * 
 * Cette classe est un panel regroupant les 
 * différens champs pour une CB. 
 * @author Rabhi Fahem et Marais Bastien
 *
 */
public class PanelCoordBancaire extends JPanel implements ActionListener{

	JButton boutonDeco = new JButton("Deconnexion");
	
	
	JLabel labNom = new JLabel("Nom titulaire :");
	JLabel labCb = new JLabel("Numéro de la CB :");
	JLabel labCrypto = new JLabel("Cryptogramme visuel :");
	JLabel labDateVal = new JLabel("Date de validitée :");
	JLabel affichage = new JLabel("");
	JTextField nom = new JTextField(15);
	JTextField cB = new JTextField(15);
	JTextField crypto = new JTextField(15);
	JTextField dateVal = new JTextField(15);
	JButton passerCommande = new JButton("Passer la commande");
	

	GridBagLayout gestionnaireGrid = new GridBagLayout();
	GridBagConstraints contrainte = new GridBagConstraints();
	
	PanelAffichage pAff;
	
	/**
	 * Permet de créer la fenetre où l'on va entrer les coordonnés bancaires
	 * @param panelAffichage
	 */
	public PanelCoordBancaire(PanelAffichage panelAffichage) {
		
		pAff = panelAffichage;
		setLayout(gestionnaireGrid);
		contrainte.fill=GridBagConstraints.BOTH;
		contrainte.insets = new Insets(10,10,10,10);
		
		
		contrainte.gridx = 0;
		contrainte.gridy = 0;
		contrainte.gridheight =1;
		contrainte.gridwidth = 1;
		add(labNom,contrainte);
		
		contrainte.gridy = 1;
		add(labCb,contrainte);
		
		contrainte.gridy = 2;
		add(labCrypto,contrainte);
		
		contrainte.gridy = 3;
		add(labDateVal,contrainte);
		
		contrainte.gridx = 1;
		add(dateVal,contrainte);
		
		contrainte.gridy = 2;
		add(crypto,contrainte);
		
		contrainte.gridy = 1;
		add(cB,contrainte);
		
		contrainte.gridy = 0;
		add(nom,contrainte);
		
		contrainte.gridx = 0;
		contrainte.gridy = 4;
		add(passerCommande,contrainte);
		passerCommande.addActionListener(this);
		
		contrainte.gridx = 1;
		add(affichage,contrainte);
		
	}

	/**
	 * permet d'intéragir lorsqu'un bouton est pressé
	 */
	public void actionPerformed(ActionEvent evt) {
		if(evt.getSource() == passerCommande){
			try {
				CommandesSQL.addCommande(pAff.commande);
				nom.setText("");
				cB.setText("");
				crypto.setText("");
				dateVal.setText("");
			} catch (SQLException e) {
				e.printStackTrace();
			}
			affichage.setText("Merci de votre achat :) ");
		}
		
	}

}
