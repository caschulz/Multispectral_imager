package code.gui;

import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import code.handlers.functions.BuildImageButtonHandler;
/**
 * This class displays three combo boxes for the user to choose which red, green, and blue, images of 
 * their chosen spectrums. There are two buttons, one to go back to the main display and one to build 
 * the selected image. 
 * 
 * @author Carly Schulz
 * @date June 22 2015
 * @place South Dakota School of Mines & Technology
 *
 */
public class CompositeMenu {

	
	/**
	 * Builds a menu for the user to select individual red, green, and blue spectra
	 * of their desired range of light to be stitched together into a full false image. 
	 * It uses an already displayed menu JFrame and just removes all the other objects
	 * that are currently displayed. There are three combo-boxes and three corresponding 
	 * labels to show which combo box corresponds to red, green, or blue. There are extra
	 * blank labels for spacing between the boxes and the labels. 
	 * 
	 * <p> The "New Composite Image" button is removed in this stage and replaced with a 
	 * "Build Image" button that triggers the composition of the three selected images.  </p>
	 *  
	 * @param window : the main display window of the system, hidden at this point of execution
	 * @param panel : the JPanel holding the options in the men JFrame
	 * @param men : the JFrame displaying the menu options, visible at this time
	 * @param buts : the JPanel holding the buttons on the men JFrame
	 * @param labels : the ArrayList of labels for the original images
	 * @param names : the ArrayList of names for the files of the images
	 * @param fun 
	 */
	
	public CompositeMenu(JFrame window, JPanel panel, JFrame men, JPanel buts, ArrayList<String> labels, ArrayList<String> names, JLabel fun) {
		
		JComboBox red = new JComboBox();
		JComboBox green = new JComboBox();
		JComboBox blue = new JComboBox();

		JLabel redL = new JLabel("Red of:");
		JLabel greenL = new JLabel("Green of:");
		JLabel blueL = new JLabel("Blue of:");

		JButton build = new JButton("Build New Image");

		String s = "";

		ArrayList<String> label = new ArrayList<String>();
		
		label.add("UV");
		label.add("Composite");
		label.add("Visual");
		label.add("Infrared");
		label.add("Thermal");
		
		for(int i= 0; i<label.size(); i++){
			s = labels.get(i);
			if(s != "Composite"){
				red.addItem(labels.get(i));
				green.addItem(labels.get(i));
				blue.addItem(labels.get(i));
			}
		}

		build.addActionListener(new BuildImageButtonHandler(names, labels, window, men, buts, build, panel, red, green, blue, fun));

		panel.setLayout(new GridLayout(2,5));
		panel.add(redL);
		panel.add(new JLabel());
		panel.add(greenL);
		panel.add(new JLabel());
		panel.add(blueL);


		panel.add(red);
		panel.add(new JLabel());
		panel.add(green);
		panel.add(new JLabel());
		panel.add(blue);

		buts.add(build);

		men.pack();
	}

}
