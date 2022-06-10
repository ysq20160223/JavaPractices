package y_2022.data.link;

import utils.XLog;

public class LinkFunc {
	public static void main(String[] args) {
		LinkList linkList = new LinkList();
		linkList.createFirst(21);
		linkList.createFirst(1);
		linkList.createFirst(3);
		linkList.createFirst(9);
		linkList.displayList();

		while (!linkList.isEmpty()) {
			XLog.init().debug(linkList.deleteFirst());
		}

		linkList.displayList();
	}
}

class Link {

	private int mData;
	private Link mNextLink;

	public Link(int data) {
		mData = data;
		mNextLink = null;
	}

	public void setNextLink(Link nextLink) {
		mNextLink = nextLink;
	}

	public Link getNextLink() {
		return mNextLink;
	}

	@Override
	public String toString() {
		return Link.class.getSimpleName() + "[" + mData + "]";
	}

}

class LinkList {
	private Link first;

	public boolean isEmpty() {
		return null == first;
	}

	public void createFirst(int data) {
		Link link = new Link(data);
		link.setNextLink(first);
		first = link;
	}

	public Link deleteFirst() {
		if (!isEmpty()) {
			Link temp = first;
			first = first.getNextLink();
			return temp;
		}
		return null;
	}

	public void displayList() {
		Link current = first;
		if (null != current) {
			while (null != current) {
				XLog.init().debug(current);
				current = current.getNextLink();
			}
		} else {
			XLog.init().debug(LinkList.class.getSimpleName() + " is Empty");
		}
	}

}
