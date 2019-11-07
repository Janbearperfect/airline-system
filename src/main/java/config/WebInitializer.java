package config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
/*
 * Tomcat启动时候会检测是否有这个WebApplicationInitializer接口的类
 * 若检测到有，会实例化它，并调用它的onStartup方法
 * */
public class WebInitializer implements WebApplicationInitializer{

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		System.out.println("start up ");
	 	//1.构造Spring容器
		AnnotationConfigWebApplicationContext ctx=new AnnotationConfigWebApplicationContext();
		//2.Spring容器加载配置
		ctx.register(AppConfig.class);
		ctx.setServletContext(servletContext);
		ServletRegistration.Dynamic servlet=
				servletContext.addServlet("dispatcher", new DispatcherServlet(ctx));
		servlet.addMapping("/");
		servlet.setLoadOnStartup(1);
		
		
	}

}
//你想使用Spring 就得有Spring容器的实例，想使用Spring MVC ，就得配置DispatcherServlet的实例
//要把这两个东西放到ServletContext对象里，因为他们俩都是重量级对象
