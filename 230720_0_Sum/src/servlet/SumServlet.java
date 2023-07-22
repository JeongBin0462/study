package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
	- 정수 합을 구하는 서비스 제공
	
	1. 서블릿 생성
	2. 주소 매핑 : /sum
	3. post 방식의 요청만을 처리. 나머지 방식의 요청에는 405 응답
	4. query param의 이름: num1, num2
	5. 합 연산 view 페이지 응답 전송
	6. postman 사용해서 요청 테스트
	7. form 양식 작성 후 action 속성 설정
*/

@WebServlet("/sum")
public class SumServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("numberform.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String num1 = req.getParameter("num1");
		String num2 = req.getParameter("num2");
		
		if (num1 == null || num2 == null) {
			resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			
			resp.setCharacterEncoding("utf-8");
			resp.setHeader("Content-Type", "text/plain;charset=utf-8");
			
			PrintWriter pw = resp.getWriter();
			pw.println("정수 2개를 입력해야합니다.");
			pw.flush();
		} else {
			Integer i1 = Integer.valueOf(num1);
			Integer i2 = Integer.valueOf(num2);
			
			Integer sum = i1 + i2;
			
			req.setAttribute("sum", sum);
			req.getRequestDispatcher("/WEB-INF/sum.jsp").forward(req, resp);
		}
	}
}