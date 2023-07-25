package kr.co.greenart.coffee;

import java.io.BufferedReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

/*
 * GET / coffee => 목록
 * GET / coffee?no=# => #번호(no)의 커피 정보
 * 없는 번호인 경우 404 NOT FOUND 응답
 * 잘못된 값(실수,문자)의 요청 400 BAD REQUEST
 * CRUD(같은 주소 일 때 요청방식)
 * PUT(수정요청)
 * DELEATE(삭제요청)
 * rest 인터페이스
 */

@WebServlet("/coffee")
public class CoffeeServlet extends HttpServlet {
	private final CoffeeDAO dao = new CoffeeDAO();
	private final JSONmapper jsonMapper = new JSONmapper();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String no = req.getParameter("no");
		String message = null;
		int status = 0;
		try {
			if (no == null) {
				message = sendList();
				status = 200;
			} else {
				message = sendOne(Integer.parseInt(no));
				status = 200;
			}
		} catch (NumberFormatException e) {
			status = 400;
			message = sendError(status);
		} catch (NotFoundException e) {
			status = 404;
			message = sendError(status);
		} catch (Exception e) {
			e.printStackTrace();
			status = 500;
			message = sendError(status);
		}
		send(resp, status, message);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		BufferedReader br = req.getReader();
		StringBuilder sb = new StringBuilder();
		
		String line;
		while ((line = br.readLine()) != null) {
			sb.append(line);
		}
		String body = sb.toString();
		
		System.out.println("사용자가 입력한 body영역 문자열: " + body);
		
		ObjectMapper mapper = new ObjectMapper();
		Coffee coffee = mapper.readValue(body, Coffee.class);
		
		System.out.println("객체 parsing : " + coffee );
		
		try {
			int pk = dao.insert(coffee);
			send(resp, 201, sendOne(pk));
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("사용자가 삭제를 요청함");
	}

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("사용자가 수정을 요청함");
	}

	private void send(HttpServletResponse resp, int status, String json) throws IOException {
		resp.setStatus(status);
		resp.setHeader("Content-Type", "application/json;charset=utf-8");
		resp.getWriter().println(json);
	}

	private String sendOne(int no) throws Exception {
		Coffee coffee = dao.getByNo(no);
		String json = jsonMapper.writeJson(coffee);
		return json;
	}

	private String sendList() throws Exception {
		List<Coffee> list = dao.getAll();

		String json = jsonMapper.writeJson(list);
		return json;
	}

	private String sendError(int status) {
		ObjectMapper mapper = new ObjectMapper();
		ObjectNode errorNode = mapper.createObjectNode();
		if (status == 500) {
			errorNode.put("message", "서버 요청 처리 중 에러가 발생했습니다.");
		} else if (status == 400) {
			errorNode.put("message", "잘못된 요청입니다. (올바른 정수값을 입력해주세요.");
		} else if (status == 404) {
			errorNode.put("message", "해당 번호의 정보가 존재하지 않습니다. 번호를 확인해주세요.");
		}
		errorNode.put("callNumber", "010-5039-5692");
		String errorMessage = "";
		try {
			errorMessage = jsonMapper.writeJson(errorNode);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}

		return errorMessage;
	}
}
