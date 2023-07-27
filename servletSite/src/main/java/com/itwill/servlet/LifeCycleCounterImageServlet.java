package com.itwill.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/lifecycle_image_counter.do")
public class LifeCycleCounterImageServlet extends HttpServlet {

	private int count;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("2.service 메쏘드실행(count=" + count + ") -->클라이언트가 요청할때마다실행");
		/*
		 * 응답헤더의 contentType설정
		 */
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println(
				"<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Insert title here</title>");
		out.println("</head>");
		out.println("<body bgcolor=#40e0d0 style=\"font-size: 9pt; line-height: 140%;\">");
		out.println("	<center>");
		/*
		 * img 태그를 사용해서 출력
		 */
		out.println("		현재까지의 페이지뷰수 <font color=#0000FF> " + ++count + "</font> 번입니다");
		out.println("<br>");
		out.println("현재까지의 페이지뷰수");

		out.println("<img src='image/8.png'>");
		out.println("<img src='image/7.png'>");
		out.println("<img src='image/9.png'>");
		out.println("<img src='image/9.png'>");
		out.println("<img src='image/9.png'>");
		out.println("<img src='image/9.png'>");
		out.println("<img src='image/9.png'>");
		out.println("<img src='image/9.png'>");
		out.println("<img src='image/9.png'>");

		out.println(" 번입니다");
		out.println("	</center>");
		out.println("</body>");
		out.println("</html>");
	}
}