package code.handlers.functions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.lang.ProcessBuilder.Redirect;
import java.util.Arrays;

/**
 * Handler that runs the Python program that reboots the system when the button is pressed.
 * 
 * @author Carly Schulz
 * @date July 10 2015
 * @place South Dakota School of Mines & Technology
 */
public class RebootButtonHandler implements ActionListener {

	/**
	 * Runs the Python program that reboots the entire camera system. 
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		try {

			String pyPath = "C:/Users/Carly/cse115/MultiSpect/src/code/model/reboot.py"; //for computer testing

			//String pyPath = "reboot.py";	//for RPi running
			ProcessBuilder pyth = new ProcessBuilder(Arrays.asList("python", pyPath)); //( "fileName.py", arg, arg, 
			Process scrip = pyth.start();

			pyth.redirectOutput(Redirect.PIPE);

			try {
				scrip.waitFor();
			} catch (InterruptedException e1) {
				System.out.println("the code you are running has been interrupted");
				e1.printStackTrace();
			}

			System.out.println("Restarted the camera system");

		} catch (IOException e2) {
			System.out.println("Hehe, I broke");
			e2.printStackTrace();
		}	
	}

	
}
