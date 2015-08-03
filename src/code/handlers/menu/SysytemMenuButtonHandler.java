package code.handlers.menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;

import code.gui.SystemMenu;

/**
 * Handler that is triggered by the button press to create a system menu
 * 
 * @author Carly Schulz
 * @date July 13 2015
 * @place South Dakota School of Mines & Technology 
 *
 */
public class SysytemMenuButtonHandler implements ActionListener {
	/**
	 * JFrame for the main display window
	 */
	private JFrame _window;
	/**
	 * JFrame for the menu  
	 */
	private JFrame _menu;
	/**
	 * ArrayList that holds the file names of the images
	 */
	private ArrayList<String> _names;
	/**
	 * ArrayList that holds the labels for the images
	 */
	private ArrayList<String> _labels;
	/**
	 * String to hold the path of the main folder holding the images
	 */
	private String _path;
 	
	/**
	 * Handler for creating the system menu where the user has the option to restart the thermal camera,
	 * restart the system, or turn off the system. 
	 * 
	 * @param window : the main display window JFrame
	 * @param menu : the menu JFrame
	 * @param names : the ArrayList of file names
	 * @param labels : the ArrayList of image names
	 * @param path : string for the path of the folder 
	 */
	public SysytemMenuButtonHandler(JFrame window, JFrame menu, ArrayList<String> names, ArrayList<String> labels, String path) {
		_window =window;
		_menu = menu;
		_names = names;
		_labels = labels;
		_path = path;
	}

	/**
	 * Disposes of the old menu and creates a system menu with options to restart the system, shut down the system or restart the thermal camera. 
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		_menu.dispose();
		new SystemMenu(_window, _names, _labels, _path);
	}

}
