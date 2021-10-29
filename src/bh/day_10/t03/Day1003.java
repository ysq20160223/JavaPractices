package bh.day_10.t03;

import utils.XLog;

/*

异常在继承覆盖中出现的问题
	1, 子类在覆盖父类时,如果父类的方法抛出异常,那么子类覆盖方法只能抛出父类的异常或者该异常的子类; 
		如果子类覆盖会产生新的异常,只能在内部处理,不能外抛
	2, 如果父类方法抛出多个异常,那么子类在覆盖该方法时,只能抛出父类异常的子集
	3, 如果父类方法中没有异常抛出,那么子类在覆盖方法时,也不可以抛出异常
	
注意:
	1, finally中定义的通常是 关闭资源代码
	2, finally只有一种情况不会被执行, 当执行到System.exit(0);
	
	
 */
public class Day1003 {

	public static void test(Super s) {
		try {
			s.method();
		} catch (AException e) {
			XLog.init().debug(e.toString());
		}
	}

	public static void main(String[] args) {

	}

}

// ****************************************************
@SuppressWarnings("serial")
class AException extends Exception {

}

@SuppressWarnings("serial")
class BException extends AException {

}

@SuppressWarnings("serial")
class CException extends Exception {

}

// ****************************************************
class Super {
	public void method() throws AException {

	}
}

class Middle extends Super {

	// 只能抛出 AException 或者 AException 的子类,不能抛出其他新的异常
	// 原因: 调用原父类方法只能捕获 AException , 子类覆盖后抛出新的异常无法被捕获到
	@Override
	public void method() throws AException {
		super.method();

	}
}

//
