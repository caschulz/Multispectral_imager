package code.handlers.menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;

import code.gui.Menu;

/**
 * Handles the button press of the "Back to the Menu button" press by disposing of the current
 * menu and creating a new menu object with the original check box options and buttons. 
 * 
 * @author Carly Schulz
 * @date June 24 2015
 * @place South Dakota School of Mines & Technology
 */
public class BackMenuButtonHandler implements ActionListener {
	/**
	 * JFrame for the menu options
	 */
	private JFrame _menu;
	/**
	 * JFrame for the main display 
	 */
	private JFrame _window;
	/**
	 * ArrayList of file names of the images
	 */
	private ArrayList<String> _names;
	/**
	 * ArrayList of the labels for the images
	 */
	private ArrayList<String> _labels;
	/**
	 * Path for the folder where the images are stored
	 */
	private String _path;
	
	/**
	 * Constructor for the BackMenuHandler class that disposes of the JFrame displaying the newly created composite image
	 * and redisplaying the original check box menu. 
	 * 
	 * @param names : ArrayList of the file names of the images
	 * @param labels : ArrayList of the labels for the images
	 * @param window : the main display JFrame for the images and default buttons
	 * @param menu : the menu JFrame that holds extra options 
	 * @param path : the String for the folder where the images are
	 */
	public BackMenuButtonHandler(ArrayList<String> names, ArrayList<String> labels, JFrame window, JFrame menu, String path){
		_menu = menu;
		_names = names;
		_labels = labels;
		_window = window;
		_path = path;
	}
	
	/**
	 * Creates a new menu object and disposes of the old menu JFrame. 
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		new Menu(_names, _labels, _window, _path);
		_menu.dispose();
	}

}
