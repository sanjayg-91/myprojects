package listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class Listener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		ServletContext appScope = sce.getServletContext();
		appScope.setAttribute("email","ghimire.sanjay100@gmail.com" );
		appScope.setAttribute("address","Austin, Texas" );
		appScope.setAttribute("phone","1234567890" );
	}


	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		
	}


}
