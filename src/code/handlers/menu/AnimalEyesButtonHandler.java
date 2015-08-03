package code.handlers.menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;

import code.gui.AnimalWindow;

/**
 * Triggers the creation of the Animal Vision display when the appropriate button is pressed
 * on the menu display. 
 * 
 * @author Carly Schulz
 * @date July 14 2015
 * @place South Dakota School of Mines & Technology
 *
 */
public class AnimalEyesButtonHandler implements ActionListener {
	/**
	 * 
	 */
	private JFrame _menu;
	/**
	 * 
	 */
	private JFrame _window;
	/**
	 * 
	 */
	private String _path;
	/**
	 * 
	 */
	private ArrayList<String> _labels;
	/**
	 * 
	 */
	private ArrayList<String> _names;
 
	/**
	 * 
	 * 
	 * @param window : JFrame for the main display window
	 * @param menu : JFrame for the current menu window
	 * @param path : String for the folder path where the images are stored
	 * @param names : ArrayList of the file names for the images
	 * @param labels : ArrayList of the labels for the images
	 */
	public AnimalEyesButtonHandler(JFrame window, JFrame menu, String path, ArrayList<String> names, ArrayList<String> labels) {
		_window = window;
		_menu = menu;
		_path = path;
		_labels = labels;
		_names = names;
	}

	/**
	 * Disposes of the menu JFrame and creates an Animal Vision menu. 
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		_menu.dispose();
		new AnimalWindow(_window, _menu, _labels, _names, _path);
	}

}
