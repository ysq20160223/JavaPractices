package y_2022.data.stack_queue;

import utils.XLog;

public class StackFunc {

	public static void main(String[] args) {
		Stack stack = new Stack(4);
		stack.push(21);
		stack.push(1);
		stack.push(9);
		stack.push(3);
		stack.push(17);
		for (int i = 0; !stack.isEmpty(); i++) {
			XLog.init().debug("i: " + i + "; " + stack.pop());
		}
	}

}

class Stack {

	int maxSize;
	int[] array;
	int top;

	public Stack(int size) {
		maxSize = size;
		array = new int[maxSize];
		top = -1;
	}

	public void push(int i) {
		if (!isFull()) {
			array[++top] = i;
		} else {
			XLog.init().warn("isFull already; push: " + i);
		}
	}

	public int pop() {
		return array[top--];
	}

	public int peek() {
		return array[top];
	}

	public boolean isFull() {
		return top == maxSize - 1;
	}

	public boolean isEmpty() {
		return top == -1;
	}

}
