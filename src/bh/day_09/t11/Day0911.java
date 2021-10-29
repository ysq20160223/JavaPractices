package bh.day_09.t11;

import utils.XLog;

/*
 * Exception中有一个特殊的子类异常，RuntimeException运行时异常
 * 		如果在函数内抛出该异常，函数上可以不用声明，编译一样通过
 * 
 * 如果在函数上声明了该异常，调用者可以不用进行处理，编译一样通过
 * 之所以不用在函数上声明，是因为不需要调用者处理
 * 
 * 当该异常发生，希望程序停止，因为在运行时，出现了无法
 * 继续运算的情况，希望停止程序后，对代码进行修正
 * 
 * 自定义异常时：如果该异常的发生，无法再继续进行运算，
 * 就让自定义异常继承RuntimeException
 * 
 * 对于异常分两种：
 * 		1，编译时被检测异常
 * 		2，编译时不被检测的异常
 */
public class Day0911 {

	public static void main(String[] args) {
		int a = 6;
		int b = 0;
		XLog.init().debug(a + " / " + b + " = " + new CustomMath().divide(6, 0));
	}

}

class CustomMath {
	public int divide(int a, int b) {
		if (b == 0) {
			throw new ArithmeticException("Custom / by zero");
		}
		return a / b;
	}
}

//
