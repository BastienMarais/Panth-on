package vues;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.*;

import baseDeDonnees.CommandesSQL;

/**
 * 
 * Cette classe est un panel de connexion
 * comportant un champs pour l'adresse email
 * et un pour le mdp et un bouton connexion.
 * @author Rabhi Fahem et Marais Bastien
 *
 */
public class PanelLogin extends JPanel implements ActionListener{

	GridBagLayout gestionnaireGrid = new GridBagLayout();
	GridBagConstraints contrainte = new GridBagConstraints();
	
	JLabel connexion = new JLabel("Se connecter :");
	JLabel email = new JLabel("Email :");
	JLabel mdp = new JLabel("Mot de passe :");
	JLabel affichage = new JLabel();
	JTextField saisieEmail = new JTextField(15);
	JTextField saisieMdp = new JTextField(15);
	JButton boutonConnexion = new JButton("CONNEXION");
	
	CardLayout gestCartes;
	PanelAffichage pAff;
	
	/**
	 * Permet de créer l'interface de connexion,
	 * utilise un GridBagLayout.
	 * @param gestionnaireCartes
	 * @param panelAffichage
	 */
	public PanelLogin(CardLayout gestionnaireCartes, PanelAffichage panelAffichage){
		
		gestCartes = gestionnaireCartes;
		pAff= panelAffichage;
		setBackground(new Color(155,155,155));
		
		setLayout(gestionnaireGrid);
		contrainte.fill=GridBagConstraints.BOTH;
		contrainte.insets = new Insets(10,10,10,10);
		
		contrainte.gridx = 0;
		contrainte.gridy = 0;
		contrainte.gridheight = 1;
		contrainte.gridwidth = 2;
		add(connexion,contrainte);
		
		contrainte.gridwidth = 1;
		contrainte.gridy = 1;
		add(email,contrainte);
		
		contrainte.gridy = 2;
		add(mdp,contrainte);
		
		contrainte.gridy = 3;
		add(boutonConnexion,contrainte);
		boutonConnexion.addActionListener(this);
		
		contrainte.gridx = 1;
		add(affichage,contrainte);
		
		contrainte.gridy = 2;
		add(saisieMdp,contrainte);
		
		contrainte.gridy = 1;
		add(saisieEmail,contrainte);
		
		
		
	}
	
	/**
	 * permet d'intéragir lorsqu'un bouton est pressé
	 */
	public void actionPerformed(ActionEvent evt) {
		if(evt.getSource()==boutonConnexion){
			try {
				if(CommandesSQL.verifEmail(saisieEmail.getText())){
					if(CommandesSQL.verifMdp(saisieEmail.getText(),saisieMdp.getText())){
						affichage.setText("Bienvenue !!");
						pAff.client = CommandesSQL.chercherClient(saisieEmail.getText(),saisieMdp.getText());
						gestCartes.show(pAff,"boutique");
						saisieEmail.setText("");
						saisieMdp.setText("");
					}
					else{
						affichage.setText("erreur de mot de passe");
					}
				}
				else {
					affichage.setText("Adresse email inexistante");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	

}
