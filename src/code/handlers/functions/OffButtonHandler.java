package code.handlers.functions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.lang.ProcessBuilder.Redirect;
import java.util.Arrays;

/**
 * Handler that runs the Python program that shuts down the system when the button is pressed.
 * 
 * @author Carly Schulz
 * @date July 10 2015
 * @place South Dakota School of Mines & Technology
 */
public class OffButtonHandler implements ActionListener {

	/**
	 * Stops all the raspberry pis from computing so the system can be safely powered off. 
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		
		try {

			String pyPath = "C:/Users/Carly/cse115/MultiSpect/src/code/model/shutDown.py"; //for computer testing

			//String pyPath = "shutDown.py";	//for RPi running
			ProcessBuilder pyth = new ProcessBuilder(Arrays.asList("python", pyPath)); //( "fileName.py", arg, arg, 
			Process scrip = pyth.start();

			pyth.redirectOutput(Redirect.PIPE);

			try {
				scrip.waitFor();
			} catch (InterruptedException e1) {
				System.out.println("the code you are running has been interrupted");
				e1.printStackTrace();
			}

			System.out.println("Safe to turn off");

		} catch (IOException e2) {
			System.out.println("Hehe, I broke");
			e2.printStackTrace();
		}	
	}

	
}
