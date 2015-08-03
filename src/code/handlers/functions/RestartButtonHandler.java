package code.handlers.functions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.lang.ProcessBuilder.Redirect;
import java.util.Arrays;
/**
 * Handler that runs the Python program that restarts the thermal camera when the button is pressed.
 * 
 * @author Carly Schulz
 * @date July 10 2015
 * @place South Dakota School of Mines & Technology
 */
public class RestartButtonHandler implements ActionListener {

	/**
	 * Restarts the thermal camera only for troubleshooting purposes by triggering a Python program 
	 * with a button press. 
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		try {

			String pyPath = "C:/Users/Carly/cse115/MultiSpect/src/code/model/restartCam.py"; //for computer testing

			//String pyPath = "restartCam.py";	//for RPi running
			ProcessBuilder pyth = new ProcessBuilder(Arrays.asList("python", pyPath)); //( "fileName.py", arg, arg, 
			Process scrip = pyth.start();

			pyth.redirectOutput(Redirect.PIPE);

			try {
				scrip.waitFor();
			} catch (InterruptedException e1) {
				System.out.println("the code you are running has been interrupted");
				e1.printStackTrace();
			}

			System.out.println("Restarted the thermal camera");

		} catch (IOException e2) {
			System.out.println("Hehe, I broke");
			e2.printStackTrace();
		}	
	}

}
