package code.handlers.menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;


import code.gui.Menu;

/**
 * Handler for the menu button press which creates the new Menu object and 
 * causes the main display to be not visible so the user cannot accidentally 
 * go back to the main display before setting their changes and closing the
 * Menu with the "Back to Main Menu" button. 
 * 
 * @author Carly Schulz
 * @date June 23 2015
 * @place South Dakota School of Mines & Technology
 */
public class MenuButtonHandler implements ActionListener{
	/**
	 * Main display JFrame window
	 */
	private JFrame _win;
	/**
	 * ArrayList of file names for the images
	 */
	private ArrayList<String> _names;
	/**
	 * ArrayList of labels for the images
	 */
	private ArrayList<String> _labels;
	/**
	 * String of the location of the folder where the images are stored
	 */
	private String _path;
	
	/**
	 * Handles the button press for the Menu button. Causes the main display visibility to be set
	 * to false and creates a new Menu object. 
	 * 
	 * @param window : Main display JFrame
	 * @param names : ArrayList of file names
	 * @param labels : ArrayList of labels for the images
	 * @param path : String of the file path of the images
	 */
	public MenuButtonHandler(JFrame window, ArrayList<String> names, ArrayList<String> labels, String path)  {
		_win = window;
		_names = names;
		_labels = labels;
		_path = path;
	}

	/**
	 * Sets the main display window visibility to be false and 
	 * creates a new Menu object on the trigger of a button press.
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		new Menu(_names, _labels, _win, _path);
		_win.setVisible(false);
	}

}
