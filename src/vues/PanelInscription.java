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

import baseDeDonnees.CommandesSQL;
import data.Client;


/**
 * 
 * Cette classe est un panel qui permet
 * de se créer un compte dans la base de 
 * données.
 * @author Rabhi Fahem et Marais Bastien
 *
 */
public class PanelInscription extends JPanel implements ActionListener {
	
	GridBagLayout gestionnaireGrid = new GridBagLayout();
	GridBagConstraints contrainte = new GridBagConstraints();
	
	
	JLabel labelCreeCompte = new JLabel ("Créer compte");
	
	JLabel labelNom = new JLabel ("Nom");
	JTextField champNom = new JTextField(15);

	JLabel labelPrenom = new JLabel ("Prenom");
	JTextField champPrenom = new JTextField(15);
	
	
	JLabel labelMdp = new JLabel ("Mot de passe");
	JTextField champMdp = new JTextField(15);
	
	JLabel labelMail = new JLabel ("Adresse email");
	JTextField champMail = new JTextField(15);
	
	JLabel labelAdresse = new JLabel ("Adresse");
	JTextField champAdresse = new JTextField(15);
	
	JLabel labelVille = new JLabel ("Ville");
	JTextField champVille = new JTextField(15);
	
	JLabel labelCp = new JLabel ("Code postal");
	JTextField champCp = new JTextField(15);
	
	JLabel labelAffichage = new JLabel ();
	
	JButton inscrire = new JButton("S'inscrire");
	
	/**
	 * Permet d'ajouter l'interface de création de compte dans la page d'acceuil,
	 * utilse un GridBagLayout.
	 * @param gestionnaireCartes
	 * @param panelAffichage
	 */
	public PanelInscription(CardLayout gestionnaireCartes, PanelAffichage panelAffichage){
		
		setLayout(gestionnaireGrid);
		contrainte.fill = GridBagConstraints.BOTH;
		contrainte.insets = new Insets(10,10,10,10);
		setBackground(new Color(155,155,155));
		
		contrainte.gridx = 0;
		contrainte.gridy = 0;
		contrainte.gridwidth = 2;
		this.add(labelCreeCompte,contrainte);//panneau
//------------------
		contrainte.gridx = 0;
		contrainte.gridy = 1;
		contrainte.gridwidth = 1;
		this.add(labelNom,contrainte);//Nom
		
		contrainte.gridx = 1;
		contrainte.gridy = 1;
		contrainte.gridwidth = 1;
		this.add(champNom,contrainte);
//-----------------		
		contrainte.gridx = 0;
		contrainte.gridy = 2;
		contrainte.gridwidth = 1;
		this.add(labelPrenom,contrainte);//Prenom
		
		contrainte.gridx = 1;
		contrainte.gridy = 2;
		contrainte.gridwidth = 1;
		this.add(champPrenom,contrainte);
//------------------		
		contrainte.gridx = 0;
		contrainte.gridy = 3;
		contrainte.gridwidth = 1;
		this.add(labelMdp,contrainte);//Mdp
		
		contrainte.gridx = 1;
		contrainte.gridy = 3;
		contrainte.gridwidth = 1;
		this.add(champMdp,contrainte);
//-----------------		
		contrainte.gridx = 0;
		contrainte.gridy = 4;
		contrainte.gridwidth = 1;
		this.add(labelMail,contrainte);//@@
		
		contrainte.gridx = 1;
		contrainte.gridy = 4;
		contrainte.gridwidth = 1;
		this.add(champMail,contrainte);
//-----------------		
		contrainte.gridx = 2;
		contrainte.gridy = 1;
		contrainte.gridwidth = 1;
		this.add(labelAdresse,contrainte);//adresse
		
		contrainte.gridx = 3;
		contrainte.gridy = 1;
		contrainte.gridwidth = 1;
		this.add(champAdresse,contrainte);
//-----------------------
		contrainte.gridx = 2;
		contrainte.gridy = 2;
		contrainte.gridwidth = 1;
		this.add(labelVille,contrainte);//ville
		
		contrainte.gridx = 3;
		contrainte.gridy = 2;
		contrainte.gridwidth = 1;
		this.add(champVille,contrainte);
//-------------------		
		contrainte.gridx = 2;
		contrainte.gridy = 3;
		contrainte.gridwidth = 1;
		this.add(labelCp,contrainte);//Code postal
		
		contrainte.gridx = 3;
		contrainte.gridy = 3;
		contrainte.gridwidth = 1;
		this.add(champCp,contrainte);
//--------------------		
		contrainte.gridx = 0;
		contrainte.gridy = 6;
		contrainte.gridwidth = 2;
		this.add(inscrire,contrainte);//bouton
		inscrire.addActionListener(this);
//---------------------
		contrainte.gridx = 2;
		contrainte.gridy = 4;
		contrainte.gridwidth = 2;
		this.add(labelAffichage,contrainte);//		
		
	}
	
	/**
	 * permet d'intéragir lorsqu'un bouton est pressé
	 */
	public void actionPerformed(ActionEvent evt) {
		if(evt.getSource()==inscrire){
			try {
				
				if (CommandesSQL.verifEmail(champMail.getText()) == false ){
					
					Client client = new Client(champNom.getText(),champPrenom.getText(),
						champMail.getText(),champMdp.getText(),
						champAdresse.getText(),champVille.getText(),
						Integer.parseInt(champCp.getText()));
					
					labelAffichage.setText("Votre compte a bien été créé !");
					CommandesSQL.addClient(client);
					champNom.setText("");
					champPrenom.setText("");
					champMail.setText("");
					champAdresse.setText("");
					champVille.setText("");
					champCp.setText("");
					champMdp.setText("");
					
				}
				
				else labelAffichage.setText("Cette adresse email existe déjà !");
			}//try
			
			catch (NumberFormatException e) {
				e.printStackTrace();
				}
			
			catch (SQLException e) {	
				e.printStackTrace();
			}
			
		

		}
	}
}