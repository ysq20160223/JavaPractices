package bh.day_14.t09;

import java.util.LinkedList;

import utils.XLog;

public class Day1409 {

	public static void main(String[] args) {
		Queue queue = new Queue();
		for (int i = 0; i < 3; i++) {
			queue.add("Queue-" + i);
		}
		while (!queue.isEmpty()) {
			XLog.init().debug(queue.poll());
		}

		XLog.init().debug("-----------------------");

		Stack stack = new Stack();
		for (int i = 0; i < 3; i++) {
			stack.add("Stack-" + i);
		}
		while (!stack.isEmpty()) {
			XLog.init().debug(stack.poll());
		}
	}

}

// 队列类型：先进先出 first in first out : FIFO
class Queue {
	private LinkedList<Object> linkedList;

	public Queue() {
		linkedList = new LinkedList<Object>();
	}

	public void add(Object obj) {
		linkedList.add(obj);
	}

	public Object poll() {
		return linkedList.pollFirst();
	}

	public boolean isEmpty() {
		return linkedList.isEmpty();
	}
}

// 堆栈特点：先进后出
class Stack {
	private LinkedList<Object> linkedList;

	public Stack() {
		linkedList = new LinkedList<Object>();
	}

	public void add(Object obj) {
		linkedList.add(obj);
	}

	public Object poll() {
		return linkedList.pollLast();
	}

	public boolean isEmpty() {
		return linkedList.isEmpty();
	}
}

//
