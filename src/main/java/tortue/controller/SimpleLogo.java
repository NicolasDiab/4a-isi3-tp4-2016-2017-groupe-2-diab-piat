package tortue.controller;// package logo;

import tortue.model.Tortue;
import tortue.model.shapes.Poly;
import tortue.model.shapes.Spiral;
import tortue.model.shapes.Square;
import tortue.view.FeuilleDessin;
import tortue.view.Window;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


/*************************************************************************

	Un petit Logo minimal qui devra etre ameliore par la suite

				J. Ferber - 1999-2001

				Cours de DESS TNI - Montpellier II

	@version 2.0
	@date 25/09/


**************************************************************************/


public class SimpleLogo implements ActionListener {
	private FeuilleDessin feuille;
	private Tortue courante;
	private Window window;
	
	private void quitter() {
		System.exit(0);
	}

	public SimpleLogo(Window window) {
		this.window = window;
	}

	public String getInputValueString(){
		return this.window.getInputValue().getText();
	}

	@Override
	/** la gestion des actions des boutons */
	public void actionPerformed(ActionEvent e)
	{
		String c = e.getActionCommand();

		switch (c) {
			case "Avancer":
				System.out.println("command avancer");
				try {
					int v = Integer.parseInt(this.getInputValueString());
					courante.avancer(v);
				} catch (NumberFormatException ex){
					System.err.println("ce n'est pas un nombre : " + this.getInputValueString());
				}
				break;
			case "Droite":
				try {
					int v = Integer.parseInt(this.getInputValueString());
					courante.droite(v);
				} catch (NumberFormatException ex){
					System.err.println("ce n'est pas un nombre : " + this.getInputValueString());
				}
				break;
			case "Gauche":
				try {
					int v = Integer.parseInt(this.getInputValueString());
					courante.gauche(v);
				} catch (NumberFormatException ex){
					System.err.println("ce n'est pas un nombre : " + this.getInputValueString());
				}
				break;
			case "Lever":
				courante.leverCrayon();
				break;
			case "Baisser":
				courante.baisserCrayon();
				// actions des boutons du bas
			case "Proc1":
				proc1();
				break;
			case "Proc2":
				proc2();
				break;
			case "Proc3":
				proc3();
				break;
			case "Effacer":
				effacer();
				break;
			case "Quitter":
				quitter();
				break;
		}

		window.repaint();
	}

	public void manageAction(String c){
		// actions des boutons du haut


		feuille.repaint();
	}

  	/** les procedures Logo qui combinent plusieurs commandes..*/

  	/* Square */
	public void proc1() {
		new Square(courante);
	}
  	/* Poly */
	public void proc2() {
		new Poly(courante, 60, 8);
	}
  	/* Spiral */
	public void proc3() {
		new Spiral(courante, 50,40,6);
	}

	// efface tout et reinitialise la feuille
	public void effacer() {
		feuille.reset();
		feuille.repaint();

		// Replace la tortue au centre
		Dimension size = feuille.getSize();
		courante.setPosition(size.width/2, size.height/2);
	}
}
