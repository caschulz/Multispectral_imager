package code.handlers.menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

/**
 * A class to handle the back button press to the main display window. Disposes of the
 * menu and sets the window's visibility to true.
 * 
 * @author Carly Schulz
 * @date June 22 2015
 * @place South Dakota School of Mines & Technology
 */

public class BackButtonHandler implements ActionListener {

	/**
	 * The menu JFrame with different options for the display
	 */
	private JFrame _men;
	/**
	 * The main display window JFrame that holds the picture, label, and three buttons
	 */
	private JFrame _win;
	
	/**
	 * Constructs the Back button handler which should dispose of the menu
	 * and set the window to be visible again when the button is pressed. 
	 * 
	 * @param menu : the secondary menu that is being displayed
	 * @param window : the default main display window 
	 */
	public BackButtonHandler(JFrame menu, JFrame window) {
		_men = menu;
		_win = window;
	}

	/**
	 * Disposes of the menu and makes the main display window visible.
	 * 
	 * @param arg0 : event that triggered the actionPerformed method
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		_men.dispose();
		_win.setVisible(true);
	}

}
