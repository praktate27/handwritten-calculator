/**
 * 
 */
package main.java.calculate;

/**
 * @author prachi
 *
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

/**
 * Do the calculation!
 */
public class GetResult {

	private ArrayList<String> list = new ArrayList<String>();
	public float result;
	public String finalResult;

	/*
	 * Constructor
	 * 
	 * @param s - operand
	 */
	public GetResult(String s) {
		s = "(" + s + ")";
		generateList(s);
		result = calculate(list);
		finalResult = Float.toString(result);
	}

	public GetResult(ArrayList<String> s) {
		s.add(0, "(");
		s.add(s.size() - 1, ")");
		result = calculate(s);
		finalResult = Float.toString(result);
	}

	/*
	 * Generate list that contain numbers and operations Ex: "(1+12.2*3)" ->
	 * ["(","1","+","12.2","*","3",")"]
	 */
	public void generateList(String s) {

		int len = s.length();
		int i = 0;
		while (i < len) {
			if (((s.charAt(i) - '0') >= 0 && (s.charAt(i) - '0') <= 9) || s.charAt(i) == '.') {
				int j = i;
				while (j < len && (((s.charAt(j) - '0') >= 0 && (s.charAt(j) - '0') <= 9) || s.charAt(j) == '.')) {
					j++;
				}
				list.add(s.substring(i, j));
				i = j;
			} else {
				list.add(s.substring(i, i + 1));
				i++;
			}
		}
	}

	/*
	 * Calculate based on the ArrayList It mainly deal with "()" Need helper
	 * function to calculate something like "1*2+3"
	 * 
	 * @return result
	 */
	public float calculate(ArrayList<String> input_list) {

		int len = input_list.size();
		Stack<String> stack = new Stack<String>();
		int i = 0;

		while (i < len) {
			String ele = input_list.get(i);
			if (ele.equals(")")) {
				ArrayList<String> temp = new ArrayList<String>();
				String start = stack.pop();
				while (stack.empty() == false && start.equals("(") == false) {
					temp.add(start);
					start = stack.pop();
				}
				Collections.reverse(temp);
				String temp_result = calculateNumber(temp);
				stack.push(temp_result);
				i++;
			} else {
				stack.push(ele);
				i++;
			}
		}
		float f = Float.parseFloat(stack.get(0));
		return f;
	}

	/*
	 * Helper function to calculate something like "1*2+3"
	 */
	private String calculateNumber(ArrayList<String> operand) {
		Stack<Float> stack = new Stack<Float>();
		int fuhao = 1;
		int i = 0;
		int len = operand.size();
		while (i < len) {
			String ele = operand.get(i);
			if (ele.equals("-")) {
				fuhao = -1;
			} else if (ele.equals("+")) {
				fuhao = 1;
			} else if (ele.equals("*")) {
				float pre = stack.pop();
				float pos = Float.parseFloat(operand.get(++i));
				float temp = pre * pos;
				stack.push(temp);
			} else if (ele.equals("/")) {
				float pre = stack.pop();
				float pos = Float.parseFloat(operand.get(++i)); // if pos == 0 ????!!!!
				float temp = pre / pos;
				stack.push(temp);
			} else {
				float hehe = Float.parseFloat(ele);
				stack.push(fuhao * hehe);
			}
			i++;
		}
		float tempResult = 0;
		for (float num : stack) {
			tempResult = tempResult + num;
		}
		String sum = Float.toString(tempResult);
		return sum;
	}
}
