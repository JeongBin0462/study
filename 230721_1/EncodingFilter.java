package filter;

import java.io.IOException;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

// WEB-XML에서 적힌 필터는 필터가 순서대로 적용
// 여기서 적힌 필터들은 정해진 순서가 없음
@WebFilter(dispatcherTypes = {DispatcherType.REQUEST }
					, urlPatterns = { "/*" }
					, initParams = @WebInitParam(name = "charset", value = "utf-8"))
public class EncodingFilter implements Filter {
	private String charset;

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding(charset);
		response.setCharacterEncoding(charset);
		chain.doFilter(request, response);
		System.out.println("인코딩 필터 동작 확인");
	}

	public void init(FilterConfig fConfig) throws ServletException {
		charset = fConfig.getInitParameter("charset");
	}
}