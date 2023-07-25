package listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class MyContextListenr implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		// 어플리케이션 컨텍스트 구성 시 이벤트 발생
		// 최초 설정이 필요하는 부분이 있다면 이 곳을 사용 
	}
}
