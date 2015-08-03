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
 * DownButtonHandler programs the event of the right button press so the image in the main display window 
 * is updated to the next file in the list. 
 * 
 * @author Carly Schulz
 * @date June 25 2015
 * @place South Dakota School of Mines & Technology
 *
 */
public class DownButtonHandler implements ActionListener {
	
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
	 * String that holds the file path to the folder where the image is held
	 */
	private String _path;
	/**
	 * ArrayList of the labels 
	 */
	private ArrayList<String> _labels;


	/**
	 * Constructor for the handler responsible for scrolling to the next image in the rotation.
	 * 
	 * @param jl : JLabel used to display the label corresponding to the current image
	 * @param jc : JLabel used to display the current image
	 * @param names : ArrayList of file names of the images
	 * @param path : String of the folder path where the images are saved
	 * @param label : ArrayList of labels for the images
	 */
	public DownButtonHandler(JLabel jl, JLabel jc, ArrayList<String> names, String path, ArrayList<String> label){
		_lab = jl;
		_image = jc;
		_names = names;
		_path = "../Desktop/Multi/Images/";
		_labels = label;
	}

	/**
	 * Takes the file name and label from their corresponding position in their ArrayLists
	 * and adds them to the end of the list to display the next image & label pair in the
	 * main display window. 
	 * <p> Uses a buffered image from the file location and resizes so the image takes up
	 * 267x200 (WxH) pixels for optimal display of images. </p>
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		
		String s1 = _names.remove(0);
		_names.add(s1);
		
		String s2 = _labels.remove(0);
		_labels.add(s2);
		
		String s = _names.get(0);
		String l = _labels.get(0);
		
		BufferedImage image = null;
		try {
			File f= new File(_path+s);
			image = ImageIO.read(f);
		} catch (IOException ioex) {
			System.err.println("load error: " + ioex.getMessage());
		}

		_lab.setText(l);
		
		Image dImage = image.getScaledInstance(267, 200, Image.SCALE_SMOOTH);
			
		ImageIcon icon = new ImageIcon(dImage);
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
