package config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;

import com.alibaba.druid.pool.DruidDataSource;

/*
 * 数据库配置
 * 1.要告诉配置类你的配置信息配置@PropertySource
 * 2.利用IOC功能注入配置信息
 * */
@Configuration
@PropertySource("classpath:jdbc.properties")
public class DBConfig {
	@Value("${jdbc.driverClass}")
    private String driver;
	@Value("${jdbc.url}")
    private String url;
	@Value("${jdbc.username}")
    private String username;
	@Value("${jdbc.password}")
    private String password;
	
	//2数据库连接池
	@Bean(name="dataSource")
	public DataSource creatDataSource() {
		DruidDataSource ds=new DruidDataSource();//c3p0  
		ds.setDriverClassName(driver);
		ds.setUrl(url);
		ds.setUsername(username);
		ds.setPassword(password);
		return ds;
		
	}
	
	//配置JdbcTemplate
	@Bean(name="jdbcTemplate")
	public JdbcTemplate creatsJdbcTemplate(DataSource ds) {
		return new JdbcTemplate(ds);//利用数据源构造JdbcTemplate
		
	}
	
	//DataSource Bean
}
