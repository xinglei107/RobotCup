package com.robotcup.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.robotcup.parameter.Parameters;

/**
 * 
 * 用户登录后要判断session是否过期，如果过期则要求重新登录
 *
 */
public class LoginFilter implements Filter{

  
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {  
        // TODO Auto-generated method stub  
        HttpServletRequest request = (HttpServletRequest) req;  
        HttpServletResponse response = (HttpServletResponse) res;  
        HttpSession session = request.getSession();  
   
       // System.out.println(request.getServletPath());
        //可以跳到登录页面
        if ((!request.getServletPath().equals("/reLogin.do"))
        		&&(!request.getServletPath().equals("/index.do"))
        		&&(!request.getServletPath().equals("/more.do"))
        		&&(!request.getServletPath().equals("/articleShow.do"))
        		&&(!request.getServletPath().equals("/register.do"))
        		&&(!request.getServletPath().equals("/loginAndout.do"))
        		&&(!request.getServletPath().equals("/redirect.do"))
        		&&(!request.getServletPath().equals("/download.do"))) 
        {
	        if (session.getAttribute("teamuser") == null&&session.getAttribute("teamadmin")==null) { 
	            response.setContentType("text/html;charset=gb2312");  
	            PrintWriter out = response.getWriter();
	            out.println("<script language='javascript' type='text/javascript'>");  
	            out.println("alert('由于您长时间没有操作，登录信息失效。请重新登录!');window.location.href='" + request.getContextPath() + "/reLogin.do'");  
	            out.println("</script>");  
	    		out.flush(); 
	            out.close();
	        } else {  
	            chain.doFilter(request, response);  
	        }
        }
        else
        {
        	chain.doFilter(request, response);  
        }
  
    }

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}  
}
