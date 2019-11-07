package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

/*
 * 应用配置(Spring 配置)
 * 相当于XML的替代者
 * 
 * */
@Configuration
@ComponentScan({"dao","service","controller"})
//@EnableWebMvc
@EnableAspectJAutoProxy //启用Spring AOP的功能
@Import(DBConfig.class)
public class AppConfig  extends  WebMvcConfigurationSupport{

	@Bean  //bean的作用就是告诉Spring MVC你写的jsp文件的位置  
    public UrlBasedViewResolver setupViewResolver() { //jsp解析器
		UrlBasedViewResolver resolver=new UrlBasedViewResolver();
		resolver.setPrefix("/WEB-INF/");    //位置  [受保护的，不可以直接访问]
		resolver.setSuffix(".jsp");            //jsp文件的后缀，就可以省略掉后缀
		resolver.setViewClass(JstlView.class);
		return resolver;
    	
    }
	/*
	 * 配置静态资源
	 * */
	@Override
	protected void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/assets/**").addResourceLocations("/assets/");
		super.addResourceHandlers(registry);
	}
}
