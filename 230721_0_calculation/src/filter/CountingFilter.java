package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CountingFilter implements Filter {
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;

		String method = req.getMethod();

		if (method.equals("POST")) {
			HttpSession session = req.getSession();
			Integer cnt = (Integer) session.getAttribute("cnt");

			if (cnt == null) {
				cnt = 0;
			}
			cnt++;
			System.out.println("세션값 변경 : " + cnt);
			session.setAttribute("cnt", cnt);
		}

		chain.doFilter(request, response);

		boolean isOk = req.getAttribute("success") != null;
		if (method.equals("POST") && isOk) {
			HttpSession session = req.getSession();
			Integer successCnt = (Integer) session.getAttribute("successCnt");

			if (successCnt == null) {
				successCnt = 0;
			}
			successCnt++;
			System.out.println("세션값 변경 : " + successCnt);
			session.setAttribute("successCnt", successCnt);
		}
	}
}