package code.handlers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JCheckBox;
/**
 * Handler for the case where a blue check box has been selected. Adds the file name and label
 * to the ArrayLists for the main display.  
 * 
 * @author Carly Schulz
 * @date June 25 2015
 * @place South Dakota School of Mines & Technology
 */
public class BlueCheckHandler implements ActionListener {
	/**
	 * String for the file name of the image
	 */
	private String _file;
	/**
	 * ArrayList of the file names for the images in the rotation
	 */
	private ArrayList<String> _names;
	/**
	 * JCheckBox associated with the handler
	 */
	private JCheckBox _box;
	/**
	 * ArrayList of the labels for the images in the rotation
	 */
	private ArrayList<String> _labels;
	/**
	 * String of the new Blue-ified label
	 */
	private String _blue;

	/**
	 * Handler that sets up the behavior when the check box is clicked. Adds the prefix for the new file
	 * and the .jpg file extension. 
	 * 
	 * @param names : ArrayList of image file names
	 * @param labels : ArrayList of labels for the images
	 * @param box : JCheckBox associated with the handler 
	 * @param f : String of the current label associated with the check box (ie: infrared, UV, Visual)
	 */
	public BlueCheckHandler(ArrayList<String> names, ArrayList<String> labels, JCheckBox box, String f) {
		_names = names;
		_box = box;
		_file = "b"+f+".jpg";
		_blue = "Blue in "+f;
		_labels = labels;
	}

	/**
	 * Checks the event to see if the check box is selected or not selected. If it is 
	 * selected, the corresponding label and image name are added to the ArrayLists to
	 * be viewed on the main display rotation. If it was just deselected, then it is 
	 * removed. 
	 */
	@Override
	public void actionPerformed(ActionEvent a) {
		if(_box.isSelected()==true&&_names.contains(_file)==false){
			_names.add(_file);
			_labels.add(_blue);
		}
		else if (_box.isSelected()==false){
			_names.remove(_file);
			_labels.remove(_blue);
		}
//		System.out.println(_names);
	}

}
