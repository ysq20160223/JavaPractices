package bh.day_15.t11;

import utils.XLog;

public class Day1511 {
	public static void main(String[] args) {
		InterfaceImpl<Object> interfaceImpl = new InterfaceImpl<Object>();
		interfaceImpl.show("hhyy");
		interfaceImpl.show(1721);
	}
}

interface Interface<T> {
	void show(T t);
}

class InterfaceImpl<T> implements Interface<T> {
	public void show(T t) {
		XLog.init().debug(t);
	}
}
