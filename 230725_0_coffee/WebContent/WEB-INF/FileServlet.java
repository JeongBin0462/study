package servlet;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet("/file")
// 사용자가 넣는 파일들은 용량이 커 메모리 공간을 많이 차지하는 문제가 생길 수 있다.
// maxFileSize, maxRequestSize: 용량 제한
// fileSizeThreshold: fileUpload시에 메모리에 저장되는 임시 파일 크기를 정의
// 1024 * 1024 = 1mb
@MultipartConfig(fileSizeThreshold = 1024 * 1024, location = "D:\\logs")
public class FileServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/fileform.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Part part = req.getPart("upload");
		
		System.out.println("파라미터 이름: " + part.getName());
		System.out.println("사용자가 전송한 파일 이름: " + part.getSubmittedFileName());
		
		System.out.println("Content-Disposition 헤더 정보: " + part.getHeader("Content-Disposition"));
		
		Path path = Paths.get("D:\\myfolder");
		Path filePath = path.resolve(part.getSubmittedFileName());
		
		Files.copy(part.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
		
		resp.setStatus(200);
		resp.setHeader("Content-Type", "text/plain;charset=utf-8");
		resp.getWriter().println("File Upload Complete");
	}
}
