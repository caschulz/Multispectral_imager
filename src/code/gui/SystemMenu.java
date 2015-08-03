package code.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import code.handlers.functions.OffButtonHandler;
import code.handlers.functions.RebootButtonHandler;
import code.handlers.functions.RestartButtonHandler;
import code.handlers.menu.BackButtonHandler;
import code.handlers.menu.BackMenuButtonHandler;
/**
 * 
 * 
 * @author Carly Schulz
 * @date July 20 2015
 * @place South Dakota School of Mines & Technology
 *
 */
public class SystemMenu {

	/**
	 * 
	 * 
	 * @param window : JFrame for the main display window
	 * @param names : ArrayList of the file names for the images
	 * @param labels : ArrayList of the labels for the images
	 * @param path : String for the folder path where the images are stored
	 */
	public SystemMenu(JFrame window, ArrayList<String> names, ArrayList<String> labels, String path) {
		JFrame buttons = new JFrame("System Menu");
		
		JPanel buttons1 = new JPanel();
		JPanel buttons2 = new JPanel();
		
		JButton restart = new JButton("Restart Thermal Camera");
		JButton reboot = new JButton("Reboot System");
		JButton off = new JButton("Shutdown Camera");
		
		JButton back = new JButton("Back to Main Window");
		JButton menu = new JButton("Back to Menu");
		
		restart.addActionListener(new RestartButtonHandler());
		reboot.addActionListener(new RebootButtonHandler());
		off.addActionListener(new OffButtonHandler());
		
		back.addActionListener(new BackButtonHandler(buttons, window));
		menu.addActionListener(new BackMenuButtonHandler(names, labels, window, buttons, path));
		
		restart.setPreferredSize(new Dimension(80,50));
		reboot.setPreferredSize(new Dimension(80,50));
		off.setPreferredSize(new Dimension(80,50));
		
		buttons1.setLayout(new GridLayout(2,2));
		
		buttons1.add(restart);
		buttons1.add(reboot);
		buttons1.add(off);
		
		buttons2.add(back);
		buttons2.add(menu);
		
		buttons.add(buttons1, BorderLayout.NORTH);
		buttons.add(buttons2, BorderLayout.SOUTH);
		
		buttons.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		buttons.setVisible(true);
		buttons.pack();
	}

}
