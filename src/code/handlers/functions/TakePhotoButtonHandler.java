package code.handlers.functions;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.ProcessBuilder.Redirect;
import java.util.ArrayList;
import java.util.Arrays;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import code.handlers.DownButtonHandler;
import code.handlers.UpButtonHandler;

/** 
 * Triggers when the button is pressed to take images and compile them.
 * Calls a python script to take images from RPi cameras and push them
 * into one image and displays the image
 *  
 * @author Carly Schulz
 * @place South Dakota School of Mines & Technology
 * @date June 05 2015
 */
public class TakePhotoButtonHandler implements ActionListener{
	/**
	 * Description label for the display
	 */
	private JLabel _lab;
	/**
	 * Image label for the display
	 */
	private JLabel _image;
	/**
	 * JFrame for the display
	 */
	private JFrame _window;
	/**
	 * String for the file path
	 */
	private String _path;
	/**
	 * ArrayList of the names of the files of the images
	 */
	private ArrayList<String> _names;
	/**
	 * UpButtonHandler for the system
	 */
	private UpButtonHandler _up;
	/**
	 * DownButtonHandler for the system
	 */
	private DownButtonHandler _down;
	/**
	 * ArrayList of the labels for the images
	 */
	private ArrayList<String> _labels;

	/** 
	 * Constructor for the FinalButtonHandler. Takes in the description label, the image label, 
	 * the ArrayList of Cameras, and the JFrame that everything is displayed in. 
	 *  
	 *  
	 * @param lab : JLabel to describe image
	 * @param jc : JLabel to display image
	 * @param c : Array list of cameras
	 * @param window : JFrame for resizing when image is displayed
	 * @param path 
	 * @param names 
	 * @param label 
	 * @param down1 
	 * @param up1 
	 */

	public TakePhotoButtonHandler(JLabel lab, JLabel jc, JFrame window, String path, ArrayList<String> names, ArrayList<String> label, UpButtonHandler up1, DownButtonHandler down1){
		_lab = lab;
		_image = jc;
		_window = window;
		_path = "";
		_names = names;
		_labels = label;
		_up = up1;
		_down = down1;

	}

	/**
	 * Runs the Python program that takes and compiles four images 
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {


		//This runs the Python program that takes the pictures and returns the location where it saved them
		try {
			
			String pyPath = "C:/Users/Carly/cse115/MultiSpect/src/code/model/test.py"; //for computer testing

			//String pyPath = "test.py";	//for RPi running
			ProcessBuilder pyth = new ProcessBuilder(Arrays.asList("python", pyPath)); //( "fileName.py", arg, arg, 
			Process scrip = pyth.start();

			pyth.redirectOutput(Redirect.PIPE);

			try {
				scrip.waitFor();
			} catch (InterruptedException e) {
				System.out.println("the code you are running has been interrupted");
				e.printStackTrace();
			}

			try {
				Thread.sleep(7000);                 //1000 milliseconds is one second.
			} catch(InterruptedException ex) {
				Thread.currentThread().interrupt();
				System.out.println("didn't work");
			}

			BufferedReader in = new BufferedReader(new InputStreamReader(scrip.getInputStream()));
			String s = in.readLine();
			_path = s;
			System.out.println(s);

		} catch (IOException e) {
			System.out.println("Hehe, I broke");
			e.printStackTrace();
		}	

		//TODO: Write composite.py so that it composites the visual, thermal, IR, and UV images into one
		try {
			
			//TODO: Change these based on testing env
			//String pyPath = "C:/Users/Carly/cse115/MultiSpect/src/code/model/composite.py"; //for computer testing

			String pyPath = "composite.py";	//for RPi running
			ProcessBuilder pyth = new ProcessBuilder(Arrays.asList("python", pyPath)); //( "fileName.py", arg, arg, 
			Process scrip = pyth.start();

			pyth.redirectOutput(Redirect.PIPE);

			try {
				scrip.waitFor();
			} catch (InterruptedException e) {
				System.out.println("the code you are running has been interrupted");
				e.printStackTrace();
			}

		} catch (IOException e) {
			System.out.println("Images not Composited");
			e.printStackTrace();
		}	
		
		
		//_path = "/var/www/";

		_down.setPath(_path);

		_up.setPath(_path);

		resetList();

		_lab.setText(_labels.get(0));

		BufferedImage image = null;

		try {
			File f= new File(_path+_names.get(0));
			image = ImageIO.read(f);
		} catch (IOException ioex) {
			System.err.println("load error: " + ioex.getMessage());
		}

		if(image!= null){

			Image dImage = image.getScaledInstance(267, 200, Image.SCALE_SMOOTH);
			ImageIcon icon = new ImageIcon(dImage);

			_image.setIcon(icon);
		}
		_window.pack();
	}

	/**
	 * Re-orders the list for the default ordering of files
	 */
	public void resetList(){
		_labels.clear();
		_labels.add("Composite");
		_labels.add("Visual");
		_labels.add("UV");
		_labels.add("Infrared");
		_labels.add("Thermal");

		_names.clear();
		_names.add("composite.jpg");
		_names.add("visual.jpg");
		_names.add("uv.jpg");
		_names.add("ir.jpg");
		_names.add("thermal.jpg"); 
	}

}
