package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Account;
import service.impl.AccountServiceDaoImpl;
import service.prototype.IAccountService;
import util.Pager;

@WebServlet("/listacts")
public class ListAccountsServlet extends HttpServlet{
	
	private IAccountService actService;
	@Override
		public void init() throws ServletException {
			actService=new AccountServiceDaoImpl();
			
		}
   @Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	Integer pageNo=null;
	Integer pageSize=null;
	
	pageNo=Integer.parseInt( req.getParameter("pageNo"));
	pageSize=Integer.parseInt(req.getParameter("pageSize"));
	
	Pager<Account> pager=new Pager<Account>();
	if(pageNo==null || pageSize==null) {
	 pager=actService.findPaged(1, 3);
	}else {
	pager=	actService.findPaged(pageNo, pageSize);
	}
	
	req.setAttribute("pager", pager);
	req.getRequestDispatcher("list.jsp").forward(req, resp);
	
	   
}
}
