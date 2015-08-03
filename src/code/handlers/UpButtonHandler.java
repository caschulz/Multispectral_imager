package code.handlers;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * Handles the UpButton press event to scroll to the previous file in the folder. 
 * 
 * @author Carly Schulz
 * @date June 22 2015
 * @place South Dakota School of Mines & Technology
 */
public class UpButtonHandler implements ActionListener{
	/**
	 * Description label for the display
	 */
	private JLabel _lab;
	/**
	 * Image label for the display
	 */
	private JLabel _image;
	/**
	 * Array list of the file names
	 */
	private ArrayList<String> _names;
	/**
	 * String that holds the file path of the image folder
	 */
	private String _path;
	/**
	 * ArrayList of the strings of the labels
	 */
	private ArrayList<String> _label;


	/**
	 * Event handler creation to initiate the response of the button press to go to the previous
	 * image in the rotation. 
	 * 
	 * @param jl : label for the image display
	 * @param jc : label to display the image
	 * @param names : ArrayList of the file names
	 * @param path : folder path
	 * @param label : ArrayList of the labels 
	 */

	public UpButtonHandler(JLabel jl, JLabel jc, ArrayList<String> names, String path, ArrayList<String> label) {
		_lab = jl;
		_image = jc;
		_names = names;
		_path = "../Desktop/Multi/Images/";
		_label = label;
	}

	/**
	 * Takes the previous label and file name from the lists and re-adds them to the front of the
	 * ArrayLists to display the previous image on the main display. Image is then dimensioned to 
	 * be 267x200 pixels (WxH) for optimal display. The label and the image and label in the main
	 * display window are then updated.
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {

		int x =_names.size()-1;

		String s1 = _names.remove(x);
		_names.add(0, s1);

		String s2 = _label.remove(x);
		_label.add(0, s2);

		BufferedImage image = null;
		try {
			File f= new File(_path+s1);
			image = ImageIO.read(f);
		} catch (IOException ioex) {
			System.err.println("load error: " + ioex.getMessage());
		}

		Image dImage = image.getScaledInstance(267, 200, Image.SCALE_SMOOTH);

		ImageIcon icon = new ImageIcon(dImage);
		_lab.setText(s2);
		_image.setIcon(icon);
	}

	/**
	 * Mutator method to set the new file path for the images. Should be updated only when new pictures
	 * are taken by the user pressing the take photos button. 
	 * 
	 * @param p : a String that holds the path to the folder where the images are being stored. 
	 */
	public void setPath(String p){
		_path = p;
	}

}
