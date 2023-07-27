package com.itwill.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/lifeCount_mapping.do")
public class LifeCycleCounterServlet extends HttpServlet {
	private int count;
	public LifeCycleCounterServlet() {
		System.out.println("0.LifeCycleCounterServlet 기본생성자[최초요청시 단한번 호출] 객체주소:" + this);
	}
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		System.out.println("1.init메소드 --> 생성자호출 직후에 단 한번 호출[객체초기화,리소스 획득]");
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("2.service메소드실행[요청시마다 호출]");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body bgcolor=#40e0d0 style=font-size:9pt;line-height:140%;>");
		out.println("<center>		");
		out.println("현재까지의 페이지 뷰 수");
		out.println("<font color=#0000FF>");
		out.println(++count);
		out.println("</font>");
		out.println("명입니다 ");
		out.println("</center> ");
		out.println("</body> ");
		out.println("</html>");
	}

	@Override
	public void destroy() {
		System.out.println("3.destroy메소드 --> 서블릿 객체가 메모리에서 해제되기 직전에 호출[리소스 반납]");
	}

}
