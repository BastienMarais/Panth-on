package vues;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import data.Client;
import data.Commande;
import data.Produit;

/**
 * 
 * Cette classe est un panel regroupant le 
 * panel CoordBancaire et 2 boutons.
 * @author Rabhi Fahem et Marais Bastien
 *
 */
public class PanelCommande extends JPanel implements ActionListener{

	
	JButton boutonDeco = new JButton("Deconnexion");
	JButton boutonBoutique = new JButton("Boutique");
	PanelCoordBancaire coordCB;
	
	CardLayout gestCartes;
	PanelAffichage pAff;
	
	GridBagLayout gestionnaireGrid = new GridBagLayout();
	GridBagConstraints contrainte = new GridBagConstraints();
	
	
	/**
	 * Permet de créer la page de validation de commande,
	 * utilise un GridBagLayout.
	 * @param gestionnaireCartes
	 * @param panelAffichage
	 */
	public PanelCommande(CardLayout gestionnaireCartes, PanelAffichage panelAffichage){
		
		
		coordCB = new PanelCoordBancaire(panelAffichage);
		
		setLayout(gestionnaireGrid);
		setBackground(new Color(55,55,55));
		contrainte.fill=GridBagConstraints.BOTH;
		contrainte.insets = new Insets(10,10,10,10);
		
		gestCartes = gestionnaireCartes;
		pAff= panelAffichage;
		
		
		/* ajout du boutonDeco*/
		contrainte.gridx = 0;
		contrainte.gridy = 0;
		contrainte.gridwidth = 1;
		contrainte.gridheight = 1;
		add(boutonDeco,contrainte);
		boutonDeco.addActionListener(this);
		
		// ajout du bountonBoutique
		contrainte.gridx = 1;
		add(boutonBoutique,contrainte);
		boutonBoutique.addActionListener(this);
		
		// ajout panelCoord
		contrainte.gridx = 0;
		contrainte.gridy = 1;
		contrainte.gridwidth = 2;
		contrainte.gridheight = 4;
		add(coordCB,contrainte);
		
	
		
	}
	
	/**
	 * permet d'interagir en fontion du bouton pressé
	 */
	public void actionPerformed(ActionEvent evt) {
		if(evt.getSource() == boutonDeco){
			gestCartes.show(pAff,"acceuil");
			coordCB.nom.setText("");
			coordCB.cB.setText("");
			coordCB.crypto.setText("");
			coordCB.dateVal.setText("");
			pAff.client = new Client();
			pAff.commande = new Commande(pAff.client,0,new ArrayList<Produit>());
			pAff.panelBoutique.panelPanier.labelMontant.setText("0");
			pAff.panelBoutique.panelPanier.montant = 0;
			
		}
		if(evt.getSource() == boutonBoutique){
			gestCartes.show(pAff,"boutique");
		}
		
	}

}
