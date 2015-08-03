package code.handlers;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
/**
 * Handler for the selection of Animals from the JComboBox. Switches to the new
 * image for the selected animal when the JComboBox experiences an actionEvent 
 * such as a click.
 * 
 * @author Carly Schulz
 * @date July 20 2015
 * @place South Dakota School of Mines & Technology
 *
 */
public class AnimalBoxHandler implements ActionListener {
	/**
	 * JLabel that holds the image being displayed
	 */
	private JLabel _image;
	/**
	 * String for the folder path where the images are being held
	 */
	private String _path;
	/**
	 * JComboBox that holds all the animal options
	 */
	private JComboBox _box;

	/**
	 * This handler updates the image being displayed in the image JLabel based on the user's 
	 * selection on the box JComboBox.
	 * 
	 * @param image : JLabel for the image to be displayed in
	 * @param path : String for the folder where the images are housed
	 * @param box : JComboBox that holds the animal choices 
	 */
	public AnimalBoxHandler(JLabel image, String path, JComboBox box) {
		_image = image;
		_path = path;
		_box = box;
	}

	/**
	 * Updates the photo on display to match what the animal selected from the combo box would see.
	 * The image is then read in as a buffered image and displayed in the image label.  
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		String anim = (String) _box.getSelectedItem();
		
		//If animals in a separate file, then add that before the anim
		String file = anim+".jpg";
		
		BufferedImage photo = null;
		try {
			File f= new File(_path+file);
			photo = ImageIO.read(f);
		} catch (IOException ioex) {
			System.err.println("load error: " + ioex.getMessage());
			System.out.println(file);
		}

		Image dImage = photo.getScaledInstance(267, 200, Image.SCALE_SMOOTH);

		ImageIcon icon = new ImageIcon(dImage);
		_image.setIcon(icon);

	}

}
