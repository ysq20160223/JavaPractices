package bh.day_08.t02;

import utils.XLog;

/*
 * 1，多态的体现：
 * 		父类引用指向了子类对象
 * 
 * 2，多态的前提：
 * 		必须是类与类之间有联系，要么继承，要不实现
 * 		通常还有一个前提：存在覆盖
 * 
 * 3，多态的好处：
 * 		多态的出现大大的提高程序的扩展性
 * 
 * 4，多态的弊端：
 * 		提高了扩展性，但是只能使用父类的引用访问父类中的成员
 * 
 * 5，多态的应用：
 */

public class Day0802 {

	public static void main(String[] args) {
		function(new Dog());

		function(new Cat());
	}

	public static void function(Animal a) {
		a.eat();
	}

}

abstract class Animal {
	abstract public void eat();
}

class Dog extends Animal {

	@Override
	public void eat() {
		XLog.init().debug("Dog eat");
	}
}

class Cat extends Animal {

	@Override
	public void eat() {
		XLog.init().debug("Cat eat");
	}
}
