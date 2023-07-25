package my;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;

import org.junit.Test;

public class testMath {
	@Test
	public void testInit() {
		MyMath m = new MyMath();
		// 객체의 생성을 테스트
		// nut null이면 통과
		assertNotNull(m);
	}

	@Test
	public void testPlus() {
		MyMath m = new MyMath();
		int result = m.plus(10, 20);
		// 기대값과 실제값이 같으면 통과
		assertEquals(30, result);
	}

	@Test
	public void testMethod1() {
		MyMath m = new MyMath();

		// true면 통과
		boolean result = m.rangeHund(55);
		assertTrue(result);

		// false면 통과
		boolean result2 = m.rangeHund(155);
		assertTrue(result2);
	}
	
	@Test
	public void testSame1() {
		Object o1 = new Object();
		Object o2 = new Object();
		
		// 객체 참조가 다른 경우 통과
		assertNotSame(o1, o2);
	}
	
	@Test
	public void testSame2() {
		LocalDate d = LocalDate.now();
		LocalDate d2 = d;
		
		
		// 객체 참조가 같을 경우 통과
		assertSame(d, d2);
	}
}
