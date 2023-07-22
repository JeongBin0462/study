package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/number/minus")
public class MinusServelt extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("message", "빼기 연산 숫자값 두 개 입력");
		req.getRequestDispatcher("/WEB-INF/numberform.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String num1 = req.getParameter("num1");
		String num2 = req.getParameter("num2");
		
		Integer i1 = Integer.valueOf(num1);
		Integer i2 = Integer.valueOf(num2);

		Integer minus = i1 - i2;
		
		
		req.setAttribute("result", minus);
		req.setAttribute("oper", "차");
		req.getRequestDispatcher("/WEB-INF/result.jsp").forward(req, resp);
	}
}
