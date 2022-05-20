package y_2022.data.stack_queue;

import java.util.Arrays;

import utils.XLog;

/*
 	栈: 出栈记录当前栈顶的位置, 不操作栈数据结构; 若出栈后重新入栈, 则新值会覆盖
 */
public class StackFunc {

	public static void main(String[] args) {
		Stack stack = new Stack(4);
		stack.push(21);
		stack.push(1);
		stack.push(9);
		stack.push(17);
		XLog.init().debug(Arrays.toString(stack.getStack()));

		stack.pop(); // 只改变 栈顶的位置
		XLog.init().debug(Arrays.toString(stack.getStack()));

		stack.push(3);
		for (int i = 0; !stack.isEmpty(); i++) {
			XLog.init().debug("i: " + i + "; pop: " + stack.pop() + "; stack: " + Arrays.toString(stack.getStack()));
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
			XLog.init().debug("top: " + top + "; " + i);
		} else {
			XLog.init().warn("isFull already; push: " + i + "; " + Arrays.toString(array));
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

	public int[] getStack() {
		return array;
	}

}
