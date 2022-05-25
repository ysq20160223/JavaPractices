package y_2022.data.stack_queue;

import utils.XLog;

public class PriorityQueueFunc {

	public static void main(String[] args) {
		PriorityQueue priorityQ = new PriorityQueue(5);
		priorityQ.insert(21);
		priorityQ.insert(1);
		priorityQ.insert(9);
		priorityQ.insert(3);
		priorityQ.insert(30);

		for (int i = 0; !priorityQ.isEmpty(); i++) {
			XLog.init().debug("i: " + i + "; " + priorityQ.remove());
		}
	}

}

class PriorityQueue {

	private int mMaxSize;
	private long[] array;
	private int mItem;

	public PriorityQueue(int size) {
		array = new long[size];
	}

	public void insert(long value) {
		int j;
		if (0 == mItem) {
			array[0] = value;
		} else {
			for (j = mItem - 1; j >= 0; j--) {
				if (value > array[j]) {
					array[j + 1] = array[j];
				} else {
					break;
				}
			}
			array[j + 1] = value;
		}
		mItem++;
	}

	public long remove() {
		return array[--mItem];
	}

	public boolean isFull() {
		return mItem == mMaxSize;
	}

	public boolean isEmpty() {
		return 0 == mItem;
	}

	public long[] getQueue() {
		return array;
	}

}
