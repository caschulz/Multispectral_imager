package code.handlers.functions;

import java.awt.GridLayout;
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
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import code.handlers.menu.BackMenuButtonHandler;

/**
 * Handler for construction of the new image on the button press from combo boxes. 
 * 
 * @author Carly Schulz
 * @date June 29 2015
 * @place South Dakota School of Mines & Technology
 *
 */
public class BuildImageButtonHandler implements ActionListener {
	/**
	 * 
	 */
	private JComboBox _red;
	/**
	 * 
	 */
	private JComboBox _green;
	/**
	 * 
	 */
	private JComboBox _blue;
	/**
	 * 
	 */
	private JFrame _men;
	/**
	 * 
	 */
	private JFrame _window;
	/**
	 * 
	 */
	private JPanel _image;
	/**
	 * 
	 */
	private JPanel _button;
	/**
	 * 
	 */
	private JButton _build;
	/**
	 * 
	 */
	private ArrayList<String> _names;
	/**
	 * 
	 */
	private ArrayList<String> _labels;
	/**
	 * 
	 */
	private String _path;
	/**
	 * 
	 */
	private JLabel _fun;

	/**
	 * 
	 * @param names : ArrayList of names of the image files
	 * @param labels : ArrayList of labels for the images
	 * @param window : main display window of JFrame
	 * @param menu : menu JFrame
	 * @param buttons : JPanel on the menu holding the buttons
	 * @param build : JButton that triggers the build operation and is associated with the handler
	 * @param image : JPanel that holds the images on the menu
	 * @param red : ComboBox for the Red image component 
	 * @param green : ComboBox for the Green image component
	 * @param blue : ComboBox for the Blue image component
	 * @param fun 
	 */
	public BuildImageButtonHandler(ArrayList<String> names, ArrayList<String> labels,JFrame window, JFrame menu, JPanel buttons,JButton build, JPanel image, JComboBox red, JComboBox green, JComboBox blue, JLabel fun) {
		_men = menu;
		_window = window;
		_button = buttons;
		_red = red;
		_green = green;
		_blue = blue;
		_image = image;
		_build = build;
		_names = names;
		_labels = labels;
		_path = "../MultiSpect/Images/";
		_fun = fun;
	}

	/**
	 * 
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		_fun.setText("Here is your new image. Go Back to Menu to create another or select a different option.");
		
		String built;
		String r = (String) _red.getSelectedItem();
		String g = (String) _green.getSelectedItem();
		String b = (String) _blue.getSelectedItem();
		
		System.out.println(r);
		System.out.println(g);
		System.out.println(b);
		
		
		_image.removeAll();
		_image.setLayout(new GridLayout());
		
		//add image to array lists
		built = r+g+b;
		_labels.add(built);
		built = built+".jpg";
		_names.add(built);
				
		JButton menu = new JButton("Back to Menu");
		
		_button.remove(_build);
		
		menu.addActionListener(new BackMenuButtonHandler(_names, _labels, _window, _men, _path));
		
		_button.add(menu);
		
		//TODO: Write build.py so that it takes in the three arguments and constructs a new image
		
		//Program call to composite the new false image needs to send info over. 
		try {
			
			String pyPath = "C:/Users/Carly/cse115/MultiSpect/src/code/model/build.py"; //For computer testing
			//String pyPath = "build.py"; //for RPi running
			
			//TODO: Make it so the r, g, and b are sent to the program!!
			ProcessBuilder pyth = new ProcessBuilder(Arrays.asList("python", pyPath));
			Process script = pyth.start();
			
			pyth.redirectOutput(Redirect.PIPE);
			
			try {
				script.waitFor();
			} catch(InterruptedException e){
				e.printStackTrace();
			}

			try {
				Thread.sleep(1000);                 //1000 milliseconds is one second.
			} catch(InterruptedException ex) {
				Thread.currentThread().interrupt();
				System.out.println("didn't work");
			}

			BufferedReader in = new BufferedReader(new InputStreamReader(script.getInputStream()));
			String s = in.readLine();
			if(s != null){
				_path = s;
			}
			System.out.println(s);

		}catch (IOException e){
			System.out.println("Yep");
			e.printStackTrace();
		}
		
		
		BufferedImage image1 = null;

		try {
			File f= new File(_path+"thermal.jpg");
			image1 = ImageIO.read(f);
		} catch (IOException ioex) {
			System.err.println("load error: " + ioex.getMessage());
		}

		JLabel image = new JLabel("Red of "+ r+ " + Green of " + g + " + Blue of "+b);
		
		_image.add(image);
		
		if(image1!= null){

			Image dImage = image1.getScaledInstance(267, 200, Image.SCALE_SMOOTH);
			ImageIcon icon = new ImageIcon(dImage);

			image.setIcon(icon);
		}
		
		_men.pack();
		
	}

}
