package code.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import code.handlers.DownButtonHandler;
import code.handlers.UpButtonHandler;
import code.handlers.functions.TakePhotoButtonHandler;
import code.handlers.menu.MenuButtonHandler;


/**
 * A single image display. Defaults to the composite image from the four cameras. 
 * Consists of three JButtons and two JLabels: buttons for taking picture, scrolling 
 * back and forth; labels for description and image
 * 
 * @author Carly Schulz
 * @place South Dakota School of Mines & Technology
 * @date June 05 2015
 */
public class Display {

	/**
	 * Constructor for the final display for the MultiSpectral Imager. 
	 * 
	 * <p> One JFrame with two panels. One panel holds the buttons scrolling
	 * through the images that have been taken and the description label, the other panel holds the label for triggering the images and and image label. </p>
	 * 
	 * <p> There are three event handlers that have to be implemented in this display method, one for each button. </p>
	 * 
	 * @author Carly Schulz
	 * @place South Dakota School of Mines & Technology
	 * @date June 05 2015
	 *
	 * @param ms : the  the MultiSpect Model code that holds the cameras and the files associated with them
	 */
	public Display(){
		
		JFrame window = new JFrame("Multi-Spectral Imager");
		
		JPanel labels = new JPanel();
		JPanel window1 = new JPanel();
		JPanel window2 = new JPanel();
		
		JLabel descr = new JLabel("Press the 'Take Photo' button to take pictures. To scroll through images press the '<' or '>'  ");
		JLabel descr1 = new JLabel("buttons. For more options click on 'Menu'");
		JButton main = new JButton("Take Photos");
		JLabel jl = new JLabel("Composite Image");
		JLabel jc = new JLabel();
		JButton up = new JButton("<");
		JButton down = new JButton(">");
		JButton men = new JButton("Menu");
		
		labels.setLayout(new GridLayout(2,1));
		
		labels.add(descr, BorderLayout.NORTH);
		labels.add(descr1, BorderLayout.SOUTH);
		
		window1.setLayout(new GridLayout());
		
		window1.add(jc);
		window1.add(main);
		
		window2.add(jl);
		window2.add(men);
		
		window2.setLayout(new GridLayout());
		
		
		window2.add(up);

		window2.add(down);

		
		
		ArrayList<String> label = new ArrayList<String>();
		ArrayList<String> names = new ArrayList<String>();
		
//TODO: Change these for testing
//		String path = "C:/Users/Carly/cse115/MultiSpect/Images/"; //for Computer testing
		String path = "../Multi/Images/"; //for RPi
		
		MenuButtonHandler menu = new MenuButtonHandler(window, names, label, path);
		UpButtonHandler up1 = new UpButtonHandler(jl, jc, names, path, label);
		DownButtonHandler down1 = new DownButtonHandler(jl, jc, names, path, label);
		TakePhotoButtonHandler mainL = new TakePhotoButtonHandler(jl, jc, window, path, names, label, up1, down1);
		
		main.addActionListener(mainL);
		up.addActionListener(up1);
		down.addActionListener(down1);
		men.addActionListener(menu);
		
		label.add("Composite");
		label.add("Visual");
		label.add("UV");
		label.add("Infrared");
		label.add("Thermal");

		names.add("composite.jpg");
		names.add("visual.jpg");
		names.add("uv.jpg");
		names.add("ir.jpg");
		names.add("thermal.jpg"); 
		
		BufferedImage image = null;
		
		try {
			File f= new File(path+names.get(4));
			image = ImageIO.read(f);
		} catch (IOException ioex) {
			System.err.println("load error: " + ioex.getMessage());
		}
		
		Image dImage = image.getScaledInstance(267, 200, Image.SCALE_SMOOTH);
		ImageIcon icon = new ImageIcon(dImage);
		jc.setIcon(icon);
		
		jc.setSize(267, 200);
		
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.add(labels, BorderLayout.NORTH);
		window.add(window1);
		window.add(window2, BorderLayout.SOUTH);
		window.setVisible(true);
		
		up.setPreferredSize(new Dimension(20,30));
		down.setPreferredSize(new Dimension(20,30));
		
		window.pack();

		
	}
}
