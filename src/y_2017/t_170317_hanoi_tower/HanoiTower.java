package y_2017.t_170317_hanoi_tower;

// 经典递归 实现 汉诺塔

// 1 - 将 N-1 个盘借助 C 柱移动到 B 柱
// 2 - 将 N 从 A 柱移动到 C 柱

// 3 - 将 N-2 个盘借助 C 柱移动到 A 柱
// 4 - 将 N-1 个盘 从 B 柱移动到 C 柱
// 5 - ...

public class HanoiTower {

	public static void main(String[] args) {
		move(3, 'A', 'B', 'C');
	}

	private static int count = 0;

	public static void move(int num, char a, char b, char c) {
		if (num == 1) {
			System.out.println("count " + ++count + " - 盘  " + num + " : 从 " + a + " 柱移动到 " + c + " 柱");
		} else {
			move(num - 1, a, c, b);
			System.out.println("count " + ++count + " - 盘  " + num + " : 从 " + a + " 柱移动到 " + c + " 柱");
			move(num - 1, b, a, c);
		}
	}

}
