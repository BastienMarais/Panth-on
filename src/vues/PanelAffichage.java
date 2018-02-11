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
 * Cette classe est un panel permettant de 
 * naviguer entre les différents panels
 * a l'aide d'un CardLayout.
 * @author Rabhi Fahem et Marais Bastien
 *
 */
public class PanelAffichage extends JPanel {
	
	
	CardLayout gestionnaireCartes = new CardLayout(5,5);
	PanelAcceuil panelAcceuil = new PanelAcceuil(gestionnaireCartes,this);
	PanelBoutique panelBoutique = new PanelBoutique(gestionnaireCartes,this);
	PanelCommande panelCommande = new PanelCommande(gestionnaireCartes,this);
	Client client = new Client();
	Commande commande = new Commande(client,0,new ArrayList<Produit>());
	
	/**
	 * Permet d'afficher les différentes interfaces sur la même fenetre d'acceuil
	 * (connection, inscription), utilise un CardLayout.
	 * @throws SQLException
	 */
	public PanelAffichage() throws SQLException {

		setLayout(gestionnaireCartes);
		
		
		add(panelAcceuil,"acceuil");
		add(panelBoutique,"boutique");
		add(panelCommande,"commande");
			
		
	}

}
