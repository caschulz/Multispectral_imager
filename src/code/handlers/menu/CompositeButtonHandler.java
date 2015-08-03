package code.handlers.menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import code.gui.CompositeMenu;
/**
 * Handles the button press for composing the composite image by clearing the JPanel of check boxes
 * and replacing them with combo boxes. 
 * 
 * @author Carly Schulz
 * @date June 24 2015
 * @place South Dakota School of Mines & Technology
 */
public class CompositeButtonHandler implements ActionListener {
	/**
	 * JFrame of the option menu
	 */
	private JFrame _men;
	/**
	 * JPanel for the check boxes and main display 
	 */
	private JPanel _checks;
	/**
	 * JPanel for the buttons
	 */
	private JPanel _butts;
	/**
	 * "New Composite Image" button in the menu JFrame 
	 */
	private JButton _cmb;
	/**
	 * JFrame of the main display window for the program
	 */
	private JFrame _wind;
	/**
	 * Array List of labels for the images
	 */
	private ArrayList<String> _labs;
	/**
	 * Array list of file names for the images 
	 */
	private ArrayList<String> _nams;
	/**
	 * 
	 */
	private JPanel _lab;
	
	/**
	 * Initializes all the settings for the combo menu that will replace the check box menu to allow the user
	 * to create a new composite image of their own choosing. 
	 * 
	 * @param window : main display JFrame
	 * @param menu : menu JFrame 
	 * @param j : display JPanel
	 * @param but : JPanel for the buttons
	 * @param label : JPanel that holds the descriptor
	 * @param cmb : the "New Composite Image" button
	 * @param lab : the ArrayList of labels for the images
	 * @param nam :  the ArrayList of file names for the images
	 */
	public CompositeButtonHandler(JFrame window, JFrame menu, JPanel j, JPanel but, JPanel label, JButton cmb, ArrayList<String> lab,  ArrayList<String> nam) {
		_wind = window;
		_men = menu;
		_checks = j;
		_butts = but;
		_cmb = cmb;
		_labs = lab;
		_nams = nam;
		_lab = label;
	}

	/**
	 * Removes all the checks from the display JPanel, the "New Composite Image" button from the button JPanel and resizes
	 * the Menu JFrame to update the display then creates a new CompositeMenu object. 
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		_lab.removeAll();
		JLabel fun = new JLabel("Select which aspects of the images you would like to combine");
		_lab.add(fun);
		_checks.removeAll();
		_butts.remove(_cmb);
		_men.pack();
		new CompositeMenu(_wind,_checks, _men, _butts, _labs, _nams, fun);

	}

}
