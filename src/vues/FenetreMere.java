package vues;
import java.awt.*;
import java.sql.SQLException;

import javax.swing.JFrame;

/**
 * Cette classe est la JFrame de l'application.
 * Il contient un PanelAffichage.
 * @author Rabhi Fahem et Marais Bastien
 *
 */
public class FenetreMere extends JFrame{
	
	public FenetreMere() throws SQLException{
		super("Boulangerie Panthéon");
		PanelAffichage contentPane = new PanelAffichage();
		setContentPane(contentPane); 
		contentPane.setBackground(new Color(150,150,150)); // couleur du conteneur
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(1200,750); // dimensions
		setVisible(true); // visible ou non 
		setLocation(50,150); // position de la fenètre
	}

	/**
	 * créer la fenetre qui acceuillera toute les pages
	 * @param args
	 * @throws SQLException
	 */
	public static void main(String[] args) throws SQLException {
		new FenetreMere();
	}

}
