package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns = "/number/status")
public class NumberStatusServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);

		Integer cnt = (Integer) session.getAttribute("cnt");
		Integer successCnt = (Integer) session.getAttribute("successCnt");
		
		if (cnt == null) {
			cnt = 0;
		}
		if (successCnt == null) {
			successCnt = 0;
		}
		
		if (session != null && cnt != null) {
			resp.getWriter().println(" count : " + cnt);
			resp.getWriter().println("success count : " + successCnt);
		} else {
			resp.getWriter().println("No History");
		}
	}
}
