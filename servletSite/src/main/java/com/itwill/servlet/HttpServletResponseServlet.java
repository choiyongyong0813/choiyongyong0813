package com.itwill.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HttpServletResponseServlet
 */
@WebServlet("/response.do")
public class HttpServletResponseServlet extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out=response.getWriter();
		/*
		http://192.168.15.31/servletSite/response.do?cmd=1
		http://192.168.15.31/servletSite/response.do?cmd=2
		http://192.168.15.31/servletSite/response.do?cmd=3
		http://192.168.15.31/servletSite/response.do?cmd=343243423
		http://192.168.15.31/servletSite/response.do?cmd=			==> ""
		http://192.168.15.31/servletSite/response.do				==> null
		 */
	   String cmd=request.getParameter("cmd");
	   if(cmd==null || cmd=="") {
		   /************case1****************/
			out.println("<h1>다시요청하세요</h1><hr>");
			out.println("<a href='./04.HttpServletResponse.html'>04.HttpServletResponse.html</a>");
		  /*******************************/
			/************case2****************/
		   return;
	   }
		
		if(cmd.equals("1")) {
			/*
			 * <<정상응답>>
			 * 	1.응답라인 상태코드 200
			 *  2.응답헤더
			 *  3.응답바디데이타(html)전송
			 */
			out.println("<h3>정상응답</h3><hr>");
			
		}else if(cmd.equals("2")) {
			/*
			 * <<error응답>>
			 *  1.응답라인 4xx,5xx
			 *  2.응답헤더
			 *  3.응답바디데이타없음(보낼수없음)
			 */
			response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		}else if(cmd.equals("3")) {
			/*
			 * <<redirect[방향재지정]>>
			 *  1.응답라인 302
			 *  2.응답헤더[Location:05-03.form1.html(redirection url) 이포함]
			 *  3.응답바디데이타 없음(보낼수없음)
			 */
			response.sendRedirect("./index.html");
		}
			
		
			
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}