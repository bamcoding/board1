package com.ktds.board.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.ktds.board.constants.Session;

/**
 * Servlet Filter implementation class SessionFilter
 */
public class SessionFilter implements Filter {

    /**
     * Default constructor. 
     */
    public SessionFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		//세션을 가져온다
		//필터는 서블릿 리퀘스트 사용 서블릿은 http 리쿼스트다
		HttpSession session = ((HttpServletRequest)request).getSession();
		
		//로그인이 안된 조건으로 확인.
		if(session.getAttribute(Session.USER_INFO)==null){
			
			PrintWriter out = response.getWriter();
			out.print("<script type ='text/javascript'>");
			out.print("alert('로그인이 필요한 서비스입니다.');");
			out.print("location.href='/Board/signIn';");
			out.print("</script>");
			out.flush();
			out.close();
			
			//response.sendRedirect("/Board/signIn");
			return;
		}
		
		// pass the request along the filter chain
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
