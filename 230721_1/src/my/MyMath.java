package my;

public class MyMath {
	public int plus(int a, int b) {
		return a + b;
	}

	// 정수가 0 ~ 100 사이이면 true 반환
	public boolean rangeHund(int num) {
		if (num > 0 && num <= 100) {
			return true;
		}
		return false;
	}
}