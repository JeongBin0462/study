package my;

// 배포되지 않는 테스트 목적의 폴더
public class test {
	public static void main(String[] args) {
		MyMath m = new MyMath();
		int sum = m.plus(10, 20);
		System.out.println(sum == 30);
	}
}
