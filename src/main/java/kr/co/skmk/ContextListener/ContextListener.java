package kr.co.skmk.ContextListener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import kr.co.skmk.Controller.Index.IndexController;

public final class ContextListener implements ServletContextListener {

	public void contextInitialized (ServletContextEvent servletContextEvent)
	{
		ServletContext servletContext = servletContextEvent.getServletContext();
		try
		{
			IndexController.RESOURCE_PATH = servletContext.getRealPath("/resources").replace("\\",  "/");
			IndexController.FILE_MEMBER_PATH = servletContext.getRealPath("/resources/image/member").replace("\\",  "/");
			IndexController.FILE_SHOP_PATH = servletContext.getRealPath("/resources/image/shop").replace("\\",  "/");
			IndexController.FILE_FOOD_PATH = servletContext.getRealPath("/resources/image/food").replace("\\",  "/");
			IndexController.FILE_QR_PATH = servletContext.getRealPath("/resources/image/qr").replace("\\",  "/");
		}
		catch (Exception e)
		{
			e.getStackTrace();
		}
	}

	public void contextDestroyed (ServletContextEvent servletContextEvent)
	{

	}

}