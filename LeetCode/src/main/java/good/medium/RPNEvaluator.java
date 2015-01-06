package good.medium;

import java.util.Scanner;
import java.util.Stack;

public class RPNEvaluator {

	/**
	 * @param args
	 * @author hellouniverse
	 * @date 2014-5-10 上午9:24:59
	 */
	public static void main(String[] args) {
		System.out.println("input:");//2 1 + 3 * ; 4 13 5 / +； 3 -4 +
		String input = new Scanner(System.in).nextLine();
		String[] tokens = input.split(" ");
		int result = new RPNEvaluator().evalRPN(tokens);
		System.out.println(result);
	}

	public int evalRPN(String[] tokens) {
		if (tokens.length == 1 && !isOperator(tokens[0]))
			return Integer.parseInt(tokens[0]);

		Stack<String> stack = new Stack<String>();
		for (int i = tokens.length - 1; i >= 0; i--) {
			if (isOperator(tokens[i]))
				stack.add(tokens[i]);
			else {
				caclulateIt(tokens[i], stack);
			}
		}
		if(stack.size()!=1) return Integer.MIN_VALUE;
		return Integer.parseInt(stack.pop());
	}

	private void caclulateIt(String s, Stack<String> stack) {
		if (stack.isEmpty() || isOperator(stack.peek())) {
			stack.add(s);
			return;
		}

		int operand1 = Integer.parseInt(s);
		int operand2 = Integer.parseInt(stack.pop());

		int tempResult = calculate(operand1, operand2, stack.pop().charAt(0));
		caclulateIt(String.valueOf(tempResult), stack);
	}

	private int calculate(int operand1, int operand2, char operator) {
		switch (operator) {
		case '+':
			return operand1 + operand2;
		case '-':
			return operand1 - operand2;
		case '*':
			return operand1 * operand2;
		case '/':
			return operand1 / operand2;
		}
		return -1 / 0;
	}

	private boolean isOperator(String s) {
		if(s.length()!=1) return false;
		char t = s.charAt(0);
		switch (t) {
		case '+':
		case '-':
		case '*':
		case '/':
			return true;
		}
		return false;
	}

}
