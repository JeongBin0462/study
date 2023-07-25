package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/my")
public class MyServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("사용자 요청 처리를 위한 Do Get 메소드 호출");
		
		System.out.println("요청 scope의 attribute 확인");
		Object test = req.getAttribute("test");
		
		System.out.println("속성 값 확인: " + test);
		
		System.out.println("요청 scope의 attribute 값 변경");
		req.setAttribute("test", "testValue");
	}
}
