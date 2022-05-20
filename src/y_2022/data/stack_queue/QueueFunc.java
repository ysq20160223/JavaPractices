package y_2022.data.stack_queue;

import java.util.Arrays;

import utils.XLog;

public class QueueFunc {

	public static void main(String[] args) {
		Queue queue = new Queue(5);
		queue.insert(21);
		queue.insert(1);
		queue.insert(9);
		queue.insert(3);
		XLog.init().debug(Arrays.toString(queue.getQueue()));

		XLog.init().debug("" + queue.remove());
		XLog.init().debug("" + queue.remove());
		XLog.init().debug("" + queue.remove());

		queue.insert(17);
		queue.insert(30);
		XLog.init().debug(Arrays.toString(queue.getQueue()));

		for (int i = 0; !queue.isEmpty(); i++) {
			XLog.init().debug("i: " + i + "; " + queue.remove());
		}
	}

}

class Queue {

	private int mMaxSize;
	private long[] array;
	private int front;
	private int rear;
	private int nItem;

	public Queue(int size) {
		mMaxSize = size;
		array = new long[size];

		front = 0;
		rear = -1;
	}

	public void insert(long v) {
		if (rear == mMaxSize - 1) {
			rear = -1;
		}
		array[++rear] = v;
		nItem++;
	}

	public long remove() {
		long temp = array[front++];
		if (front == mMaxSize) {
			front = 0;
		}
		nItem--;
		return temp;
	}

	public long peek() {
		return array[front];
	}

	public boolean isEmpty() {
		return 0 == size();
	}

	public boolean isFull() {
		return mMaxSize == size();
	}

	public int size() {
		return nItem;
	}

	public long[] getQueue() {
		return array;
	}

}
