package code.gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import code.handlers.BlueCheckHandler;
import code.handlers.GreenCheckHandler;
import code.handlers.RGBCheckHandler;
import code.handlers.RedCheckHandler;
import code.handlers.menu.AnimalEyesButtonHandler;
import code.handlers.menu.BackButtonHandler;
import code.handlers.menu.CompositeButtonHandler;
import code.handlers.menu.SysytemMenuButtonHandler;

/**
 * Creates the graphical menu interface for users to choose which extra images should
 * be added or removed from the main program's rotation. 
 * 
 * @author Carly Schulz
 * @date June 22 2015
 * @place South Dakota School of Mines & Technology
 */
public class Menu {
	
	/**
	 * Displays a grid of check boxes in a new JFrame to allow images to be added to the rotation at the 
	 * behest of the user. 
	 * 
	 * <p> Each spectrum of light (Infrared, UV, Thermal, and Visual) is represented by 4 check boxes (one 
	 * for RGB, R, G, and B). Each check box has an ActionListener to respond to a click. This adds or removes 
	 * the selected image to the rotation on the main display screen.  </p>
	 * 
	 * @param names : ArrayList of names of the images' files
	 * @param labels : ArrayList of the labels for the images
	 * @param window : JFrame for the main display window
	 */
	public Menu(ArrayList<String> names, ArrayList<String> labels, JFrame window, String path){
		JFrame menu = new JFrame("Menu");
		
		JPanel j = new JPanel();
		JPanel but = new JPanel();
		JPanel lab = new JPanel();
		
		lab.setLayout(new GridLayout(2,1));
		j.setLayout(new GridLayout(4,4));
		
		JLabel des = new JLabel("Check the boxes of items you would like to add to the rotation.");
		JLabel des2 = new JLabel("Check and uncheck if you wish to remove the image.");

		JCheckBox nIR = new JCheckBox("RGB: Infrared");
		JCheckBox rIR = new JCheckBox("R: Infrared");
		JCheckBox gIR = new JCheckBox("G: Infrared");
		JCheckBox bIR = new JCheckBox("B: Infrared");
		
		JCheckBox nUV = new JCheckBox("RGB: UV");
		JCheckBox rUV = new JCheckBox("R: UV");
		JCheckBox gUV = new JCheckBox("G: UV");
		JCheckBox bUV = new JCheckBox("B: UV");
		
		JCheckBox nTh = new JCheckBox("RGB: Thermal");
		JCheckBox rTh = new JCheckBox("R: Thermal");
		JCheckBox gTh = new JCheckBox("G: Thermal");
		JCheckBox bTh = new JCheckBox("B: Thermal");
		
		JCheckBox nV = new JCheckBox("RGB: Visual");
		JCheckBox rV = new JCheckBox("R: Visual");
		JCheckBox gV = new JCheckBox("G: Visual");
		JCheckBox bV = new JCheckBox("B: Visual");
		
		JButton dsfa = new JButton("Back to Display");
		JButton cmb = new JButton("Composite Menu");
		JButton anim = new JButton("Animal Vision");
		JButton maint = new JButton("System Menu");

		nIR.addActionListener(new RGBCheckHandler(names, labels, nIR, "ir"));
		bIR.addActionListener(new BlueCheckHandler(names, labels, bIR, "IR"));
		gIR.addActionListener(new GreenCheckHandler(names, labels, gIR, "IR"));
		rIR.addActionListener(new RedCheckHandler(names, labels, rIR, "IR"));
		
		nUV.addActionListener(new RGBCheckHandler(names, labels, nUV, "uv"));
		bUV.addActionListener(new BlueCheckHandler(names, labels, bUV, "UV"));
		gUV.addActionListener(new GreenCheckHandler(names, labels, gUV, "UV"));
		rUV.addActionListener(new RedCheckHandler(names, labels, rUV, "UV"));
		
		nTh.addActionListener(new RGBCheckHandler(names, labels, nTh, "thermal"));
		bTh.addActionListener(new BlueCheckHandler(names, labels, bTh, "Thermal"));
		gTh.addActionListener(new GreenCheckHandler(names, labels, gTh, "Thermal"));
		rTh.addActionListener(new RedCheckHandler(names, labels, rTh, "Thermal"));

		nV.addActionListener(new RGBCheckHandler(names, labels, nV, "visual"));
		bV.addActionListener(new BlueCheckHandler(names, labels, bV, "Visual"));
		gV.addActionListener(new GreenCheckHandler(names, labels, gV, "Visual"));
		rV.addActionListener(new RedCheckHandler(names, labels, rV, "Visual"));
		
		dsfa.addActionListener(new BackButtonHandler(menu, window));
		cmb.addActionListener(new CompositeButtonHandler(window, menu, j, but, lab, cmb, labels, names));
		anim.addActionListener(new AnimalEyesButtonHandler(window, menu, path, labels, names));
		maint.addActionListener(new SysytemMenuButtonHandler(window, menu, names, labels, path));
		
		lab.add(des);
		lab.add(des2);
		
		but.add(dsfa);
		but.add(cmb);
		but.add(anim);
		but.add(maint);

		j.add(nIR);
		j.add(rIR);
		j.add(gIR);
		j.add(bIR);		

		j.add(nUV);		
		j.add(rUV);
		j.add(gUV);
		j.add(bUV);
		
		j.add(nTh);		
		j.add(rTh);
		j.add(gTh);
		j.add(bTh);
		
		j.add(nV);		
		j.add(rV);
		j.add(gV);
		j.add(bV);
		
		menu.add(lab, BorderLayout.NORTH);
		menu.add(j);
		menu.add(but, BorderLayout.SOUTH);
		menu.setVisible(true);
		menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		menu.pack();
	}

}
