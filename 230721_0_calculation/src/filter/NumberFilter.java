package filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class NumberFilter implements Filter {
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;

		String num1 = req.getParameter("num1");
		String num2 = req.getParameter("num2");

		String method = req.getMethod();

		if (method.equals("POST") && (num1 == null || num2 == null)) {
			resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);

			resp.setCharacterEncoding("utf-8");
			resp.setHeader("Content-Type", "text/plain;charset=utf-8");

			PrintWriter pw = resp.getWriter();
			pw.println("정수 2개를 입력해야합니다.");
			pw.flush();
		} else {
			chain.doFilter(request, response);

			if (method.equals("POST")) {
				req.setAttribute("success", "ok");
			}
		}
	}
}
