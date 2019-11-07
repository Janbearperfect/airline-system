package config;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;


/*
 * 应用配置(Spring 配置)
 * 相当于XML的替代者
 * 
 * */
@Configuration
@ComponentScan({"dao","service","controller"})

@EnableAspectJAutoProxy //启用Spring AOP的功能
@Import(DBConfig.class)
public class TestConfig {

	
}
