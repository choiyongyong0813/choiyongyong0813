package com.itwill.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//#1. jacax.servlet.http.HttpSerblet 클래스를 상속 받아야한다.
public class GugudanTextServlet extends HttpServlet {
	//#2. HttpServlet service 메소드를 오버라이딩 해야한다.
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	//#2-1. 클라이언트에 전송할 데이터의 타입(종류)설정.
	response.setContentType("text/plain;charset+UTF-8");
	//#2-2. 클라이언트에 데이터를 전송하기위한 출력스트림 생성.
	PrintWriter out=response.getWriter();
	//#2-3. 클라이언트 데이터(text) 전송.
	for (int i = 1; i <= 9; i++) {
		out.printf("2*1=2 3*1=3 4*1=4 5*1=5 6*1=6 7*1=7 8*1=8 9*1=9");
		out.println();
	
		
	}
	}

}
