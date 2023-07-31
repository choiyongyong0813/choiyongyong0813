package com.itwill.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/join1.do")
public class JoinServlet1 extends HttpServlet {
	@Override
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		/*
		PrintWriter out=response.getWriter();
		out.println("<h3>호갱님 죄송합니다.[잘못된요청방식입니다(405)]</h3>");
		out.println("<a href='05-03.form1.html'>가입하기</a>");
		*/
		response.sendRedirect("05-03.form1.html");
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");

		PrintWriter out = response.getWriter();

		/*
		 * 0.요청객체인코딩설정
		 */
		request.setCharacterEncoding("UTF-8");
		/*
		 * 1.파라메타받기
		 */
		String id=request.getParameter("id");
		String password=request.getParameter("password");
		String email1=request.getParameter("email1");
		String email2=request.getParameter("email2");
		String email = email1+"@"+email2;
		String gender = request.getParameter("gender");
		String[] favorites=request.getParameterValues("favorite");
		if(favorites==null) {
			favorites=new String[0];
		}
		String message=request.getParameter("message");
		/*
		 * 2.업무실행(Service객체 메쏘드호출)
		 */
		/*
		 * 3.클라이언트로 응답출력
		 */
		out.printf("<h1>가입정보</h1>");
		out.printf("<ul>");
		out.printf("<li>아이디:%s</li>",id);
		out.printf("<li>패쓰워드:%s</li>",password);
		out.printf("<li>이메일:%s</li>",email);
		out.printf("<li>성별:%s</li>",gender); 
		out.printf("<li>가입인사:%s</li>",message);
		out.printf("<li>관심사");
		out.printf("<ul>");
		for(String favorite:favorites) {
			out.printf("<li>%s</li>",favorite);
		}
		out.printf("</ul>");
		out.printf("</li>");
		out.printf("</ul>");
		out.printf("<a href='05-03.form1.html'>가입폼</a>");
		

	}

}