package code.gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import code.handlers.AnimalBoxHandler;
import code.handlers.menu.BackButtonHandler;
import code.handlers.menu.BackMenuButtonHandler;

/**
 * 
 * @author Carly Schulz
 * @date July 09 2015
 * @place South Dakota School of Mines & Technology
 *
 */
public class AnimalWindow {

	/**
	 * 
	 * 
	 * @param window : main display JFrame 
	 * @param Menu : menu display JFrame
	 * @param labels : ArrayList that holds the labels associated with each image 
	 * @param names : ArrayList that holds the file names of the images
	 * @param path : String that holds the path for the folder the images 
	 */
	public AnimalWindow(JFrame window, JFrame Menu, ArrayList<String> labels, ArrayList<String> names,String path) {
		JFrame animalEyes = new JFrame("Animal Eyes");
		
		JPanel label = new JPanel();
		JPanel image = new JPanel();
		JPanel buttons = new JPanel();
		
		JLabel exp = new JLabel("Animals see things very differently from humans. Pick an");
		JLabel exp1 = new JLabel("animal from the combo box to see how they see the world");
		
		JLabel pic = new JLabel();
		
		JComboBox animal = new JComboBox();
		animal.addItem("Snake");
		animal.addItem("Bee");
		animal.addItem("Crayfish");
		animal.addItem("Dog");
		animal.addItem("Octopus");
		animal.addItem("Rabbit");
		animal.addItem("Rat");
//		animal.addItem("Snake"); 	//TODO: When this works delete Snake from the top and uncomment it here
		animal.addItem("Spider");

		
		JButton menu = new JButton("Back to Menu");
		JButton back = new JButton("Back to Main Window");
		
		menu.addActionListener(new BackMenuButtonHandler(names, labels, window, animalEyes, path));
		back.addActionListener(new BackButtonHandler(animalEyes, window));
		animal.addActionListener(new AnimalBoxHandler(pic, path, animal));
		
		label.setLayout(new GridLayout(2,1));
		
		label.add(exp);
		label.add(exp1);
		
		image.add(animal, BorderLayout.EAST);
		image.add(pic, BorderLayout.WEST);
		
		BufferedImage photo = null;
		try {
			File f= new File(path+"thermal.jpg");
			photo = ImageIO.read(f);
		} catch (IOException ioex) {
			System.err.println("load error: " + ioex.getMessage());
		}

		Image dImage = photo.getScaledInstance(267, 200, Image.SCALE_SMOOTH);

		ImageIcon icon = new ImageIcon(dImage);
		pic.setIcon(icon);
		
		buttons.add(back);
		buttons.add(menu);
		
		animalEyes.add(label, BorderLayout.NORTH);
		animalEyes.add(image, BorderLayout.EAST);
		animalEyes.add(buttons, BorderLayout.SOUTH);
		
		animalEyes.pack();
		animalEyes.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		animalEyes.setVisible(true);
		
	}

}
