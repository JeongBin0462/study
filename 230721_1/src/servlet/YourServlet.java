package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebServlet("/your")
public class YourServlet extends HttpServlet {
	private static Logger logger = LoggerFactory.getLogger(YourServlet.class);
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// debug, info, warn, error ...
		// 위중도가 오른쪽으로 갈수록 높아진다
		logger.info("로거를 통한 콘솔 Info레벨 기록 남겨보기");
		
		req.setAttribute("your", "yourValue");
	}
}
