package listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionIdListener;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class MySessionListener implements HttpSessionBindingListener, HttpSessionAttributeListener,
		HttpSessionIdListener, HttpSessionListener {

	// session의 아이디가 변경 되었을 때
	@Override
	public void sessionIdChanged(HttpSessionEvent event, String oldSessionId) {
	}
	
	// session을 만들었을 때
	@Override
	public void sessionCreated(HttpSessionEvent se) {
	}

	// session이 더 이상 유효하지 않을 때
	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
	}
	
	// session을 setAttribute로 호출했을 때 
	@Override
	public void valueBound(HttpSessionBindingEvent event) {
	}
	
	// session을 remove했을 때
	@Override
	public void valueUnbound(HttpSessionBindingEvent event) {
	}
}