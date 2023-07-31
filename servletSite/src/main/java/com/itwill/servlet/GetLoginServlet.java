package com.itwill.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GetLoginServlet
 */
@WebServlet("/get_login.do")
public class GetLoginServlet extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		/*
		 * 1.요청시 전송되는 파라메타받기
		 	 - 파라메타이름은 input element의 name속성의  값
		 		<form action="get_login.do" method="get">
					아이디:<input type="text" name="id"><br/>
					패에쓰:<input type="password" name="pass"><br/><br/>
				</form>	
		 */
		String id=request.getParameter("id");
		String pass=request.getParameter("pass");
		if(id==null || pass==null || id.equals("")|| pass.equals("")) {
			
			out.println("<h1>GET 로그인결과</h1><hr>");
			out.println("<h3>아이디패쓰워드를 입력하세요!!!</h3><hr>");
			out.println("<a href='05-01.login_get.html'>다시로그인</a>");
			
			//response.sendRedirect("05-01.login_get.html");
			return;
		}
		/*
		 * 2.서비스객체를 사용해서 업무(로그인)실행
		 * ----------
		 *  id | pass
		 * ----------
		 * xxxx|1111
		 * ----------
		 * yyyy|2222
		 * ----------
		 */
		boolean isMember1 = id.equals("xxxx") && pass.equals("1111");
		boolean isMember2 = id.equals("yyyy") && pass.equals("2222");
		
		/*
		 * 3.클라이언트로 출력
		 */
		out.println("<h1>GET 로그인결과</h1><hr>");
		if(isMember1 || isMember2) {
			/*
			out.println("<h3>"+ id+"님 로그인성공</h3><hr>");
			out.println("<a href='index.html'>메인으로</a>");
			*/
			response.sendRedirect("index.html");
		}else {
			out.println("<h3>"+ id+"님 로그인실패</h3><hr>");
			out.println("<a href='05-01.login_get.html'>다시로그인</a>");
		}
	}

}















