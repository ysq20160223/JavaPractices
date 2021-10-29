package bh.day_08.t03;

import utils.XLog;

public class Day0803 {

	public static void main(String[] args) {
		doSomething(new Cat());
		doSomething(new Dog());
	}

	public static void doSomething(Animal a) {
		a.eat();
		if (a instanceof Dog) {
			Dog d = (Dog) a;
			d.watchHome();
		} else if (a instanceof Cat) {
			Cat c = (Cat) a;
			c.catchMouse();
		}
	}

}

abstract class Animal {
	abstract void eat();
}

class Dog extends Animal {

	public void eat() {
		XLog.init().debug("Dog eat");
	}

	public void watchHome() {
		XLog.init().debug("Dog watch home");
	}
}

class Cat extends Animal {

	public void eat() {
		XLog.init().debug("Cat eat");
	}

	public void catchMouse() {
		XLog.init().debug("Cat catch mouse");
	}
}
