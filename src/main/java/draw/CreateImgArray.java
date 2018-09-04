/**
 * 
 */
package main.java.draw;

import main.java.calculate.Calculator;
import main.java.python.RunPython;

public class CreateImgArray {

/**
 * About: The whiteboard class gives a 28*28 array containing the info of handwritten digits
 * This class transforms the array into a string, and call Run_python to run the python file,
 * which recognize the handwritten digits, and returns the label into the variable result
 */

	public CreateImgArray(int[][] newImgArray) {
		String imgArray = "";

		for (int i=0; i<newImgArray.length; i++) {
			for (int j=0; j<newImgArray[i].length; j++) {
				imgArray+=Integer.toString(newImgArray[i][j]);
				imgArray+=" ";
			}
		}
		
		// call Run_python
		RunPython rp = new RunPython(imgArray);	
		String result = rp.run();
		System.out.print(result);
		// add the label on to the screen
		Calculator.operand.setText(Calculator.operand.getText()+result); 
	}
}
