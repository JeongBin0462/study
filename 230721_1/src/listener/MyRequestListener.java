package listener;

import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpServletRequest;

public class MyRequestListener implements ServletRequestListener, ServletRequestAttributeListener {
	@Override
	public void attributeAdded(ServletRequestAttributeEvent srae) {
		System.out.println("요청 scope에 add attribute");
		System.out.println(srae.getName() + " : " + srae.getValue());
	}

	@Override
	public void attributeRemoved(ServletRequestAttributeEvent srae) {
	}

	@Override
	public void attributeReplaced(ServletRequestAttributeEvent srae) {
	}

	@Override
	public void requestInitialized(ServletRequestEvent sre) {
		System.out.println("사용자 요청이 생성됨");
		
		HttpServletRequest req = (HttpServletRequest) sre.getServletRequest();
		System.out.println("요청 자원: " + req.getRequestURI());
		System.out.println("요청 방식: " + req.getMethod());
	}
}