package bad.easy;

import java.util.Stack;

public class MinStack {

	public static void main(String[] args) {
		MinStack stack = new MinStack();
		stack.push(4);
		stack.push(0);
		stack.push(0);
		stack.push(-2);
		System.out.println(stack.data.toString() + "\tmin : " + stack.getMin());
		stack.pop();
		System.out.println(stack.data.toString() + "\tmin : " + stack.getMin());
		stack.pop();
		System.out.println(stack.data.toString() + "\tmin : " + stack.getMin());
		
	}

	Stack<Integer> data;
	Stack<Integer> minStack;

	public MinStack() {
		this.data = new Stack<>();
		this.minStack = new Stack<>();
	}

	public void push(int x) {
		data.push(x);
		if (minStack.isEmpty() || x <= minStack.peek()) 
			minStack.push(x);
	}

	public void pop() {
		if (data.isEmpty())
			return;
		
		int first = data.peek();
		data.pop();
		if (first == minStack.peek())
			minStack.pop();
	}

	public int top() {
		if (data.isEmpty())
			return 0;
		
		return data.peek();
	}

	public int getMin() {
		if (minStack.isEmpty())
			return 0;
		
		return minStack.peek();
	}

}
