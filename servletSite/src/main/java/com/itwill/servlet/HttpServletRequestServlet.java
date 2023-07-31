package com.itwill.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HttpServletRequestServlet
 */
@WebServlet("/request.do")
public class HttpServletRequestServlet extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out=response.getWriter();
		
		
		
		/****************************
		<< query string >> 
	  	- 클라이언트가 서버로 요청시데이타를 전송하는방법 
	  	- 형식:name1=value1&name2=value2
	  	- ex> name=kim&phone=1234&address=seoul
  
		  1.GET  요청방식 : request.do?
		    ex>request.do?name=kim&phone=1234&address=kyunggi
		    			-----------------------------------------------------------------
		    요청라인  	|GET request.do?name=kim&phone=1234&address=kyunggi HTTP/1.1	|	
		    요청헤더  	|HOST:192.168.15.31												|
		    ...			|...															|
		    			|--------------------------------------------------------------	|
		    요청바디	|없다															|
		    	-----------------------------------------------------------------
		    
		  2.POST 요청방식 : request.do  
		    			-----------------------------------------------------------------
		    요청라인  	|POST request.do HTTP/1.1										|						
		    요청헤더  	|HOST:192.168.15.31												|
		    ...			|...															|
		    			|--------------------------------------------------------------	|
		    요청바디	|name=kim&phone=1234&address=kyunggi							|								|
		     			-----------------------------------------------------------------
			 ****************************/
		// 클라이언트요청URL ==>
		// http://192.168.15.31/servletSite/request.do?name=kim&phone=1234&address=seoul

		String remoteAddress = request.getRemoteAddr();
		String queryString = request.getQueryString();
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		
		System.out.println("******************" +remoteAddress+ "님이 전송한정보*******************");
		System.out.println("queryString:" + queryString);
		System.out.println("name 파라메타값:" +name);
		System.out.println("phone 파라메타값:" +phone);
		System.out.println("address 파라메타값:" + address);
		System.out.println("***********************************************");
		
		
		
		String method = request.getMethod();
		String url = request.getRequestURI().toString();
		String contextPath = request.getContextPath();
		
		out.println("<h1>HttpServletRequest객체</h1><hr>");
		out.println("<ol>");
		out.println("<li>요청메쏘드:"+method+"</li>");
		out.println("<li>요청URL:" +url+ "</li>");
		out.println("<li>요청URI:"+url+"</li>");
		out.println("<li>contextPath:"+contextPath+"</li>");
		out.println("<li>remoteAddress:"+remoteAddress+"</li>");
		out.println("<li>-----------요청시전송된파라메타----------</li>");
		out.println("<li>queryString:"+queryString+"</li>");
		out.println("<li>name 파라메타값:"+name+"</li>");
		out.println("<li>phone 파라메타값:"+phone+"</li>");
		out.println("<li>address 파라메타값:"+address+"</li>");
		out.println("</ol>");
		

		
	}

}












