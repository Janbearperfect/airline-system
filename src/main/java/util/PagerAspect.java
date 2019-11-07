package util;

import java.lang.reflect.Method;
import java.util.List;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class PagerAspect {
     
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	//1.自定义切点
	@Pointcut("execution(* service..*(..))")
	public void selfPointcut() {}
	
	@Around("selfPointcut()")
	public Object aroundAdvice(ProceedingJoinPoint jp) {
		Object o=null;
		
	 // 根据Jp对象获取method对象
		 MethodSignature signature =(MethodSignature) jp.getSignature();
		 Method m=signature.getMethod();
		 
		 MiniPager  miniPager=(MiniPager)m.getAnnotation(MiniPager.class);
		 System.out.println(miniPager.tableName());
		 
		 try {
			jp.proceed();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 if(miniPager==null) {
			 try {
				o=jp.proceed();
			} catch (Throwable e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 return o;
		 }
		 //4.若加有@MiniPager标注，则加入分页代码
		 //1.获取某实体类对应总条目数
		 System.out.println("Pager Success");
		 String tableName=miniPager.tableName();
		 int totalItems=jdbcTemplate.queryForObject("select count(*) from "+tableName,Integer.class);
		 System.out.println(totalItems);
		 //2.根据页大小计算总的页数
		  int pageSize=(Integer) jp.getArgs()[1];
		  int pageNo=(Integer)jp.getArgs()[0];
		  int totalPages=(totalItems +pageSize -1)/pageSize;
		  if(pageNo>=totalPages)pageNo=totalPages;
		  System.out.println(pageSize);
	
		  //3.返回Pager对象
		  Pager pager=new Pager();
		  
		  try {
		     List data=(List) jp.proceed(new Object[] {pageNo,pageSize});
		     pager.setData(data);
		     pager.setTotal(totalPages);
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pager;
		
		
		
	}
	
}
