package com.itwill.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class HelloServlet extends HttpServlet {

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		 		out.println("<!DOCTYPE html>");
				out.println("<html>");
				out.println("<head>");
				out.println("<meta charset=\"UTF-8\">");
				out.println("<title>Insert title here</title>");
				out.println("</head>");
				out.println("<body>");
				for (int i = 0; i < 10; i++) {
					out.printf("<h1>Hello Servlet(안녕서블릿)[%d]</h1><hr>",i+1);
				}
				out.println("</body>");
				out.println("</html>");

		 
	}

}
