package config;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Invoker {
    public static void main(String[] args) {
		ApplicationContext ctx=new AnnotationConfigApplicationContext(AppConfig.class);
		DataSource ds= (DataSource) ctx.getBean("dataSource");
		
		System.out.println(ds);
	}
}
