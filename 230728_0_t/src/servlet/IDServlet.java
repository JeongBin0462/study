package servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/id")
/*
 *	 주소: /id
 *	GET
 *	파라미터(id => 영문자 10글자 이하 not null)
 *	응답 
 *	200 : json (ex: {"exist": true})
 *	400 : json (ex: {"message": "bad request" })(미구현)
 *	500 : 서버 에러
 *	----
 *	POST
 *	요청 바디 json (ex: {"id":"newId"}
 *	응답
 *	200 : json (ex: {"result": "success"})
 *	400 : json (ex: {"message": "bad request" })(미구현)
 *	500 : 서버 에러
 */

public class IDServlet extends HttpServlet {
	private IDService service = new IDService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");

		boolean isExist = service.isExist(id);

		String body = "{\"exist\": " + isExist + "}";
		resp.setStatus(200);
		resp.setHeader("Content-Type", "application/json;charset=utf-8");
		resp.getWriter().println(body);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = req.getReader();
		String line;
		while ((line = br.readLine()) != null) {
			sb.append(line);
		}
		String body = sb.toString();
		System.out.println("사용자 요청 body 확인: " + body);

		// 사용자가 올바른 형태로 요청을 했는지는 생략
		Pattern p = Pattern.compile("\\{\"id\":\"(\\w+)\"}");
		Matcher m = p.matcher(body);
		m.find();
		String id = m.group(1);
		
		int result = service.add(id);
		String respBody = "{\"result\":\"success\"}"; 
		resp.setStatus(301);
		resp.setHeader("Content-type", "application/json;charset=utf-8");
		resp.getWriter().println(respBody);
	}
}
