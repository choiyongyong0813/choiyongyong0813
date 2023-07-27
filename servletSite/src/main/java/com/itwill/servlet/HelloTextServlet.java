package com.itwill.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//HelloTextServlet 클래스: HttpServlet을 상속하는 Java 서블릿
public class HelloTextServlet extends HttpServlet {

	// service 메소드: 모든 HTTP 요청에 대해 호출되는 핵심 메소드
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 응답의 컨텐츠 타입을 "text/plain"으로 설정하고, 문자 인코딩을 UTF-8로 지정
		response.setContentType("text/plain;charset=UTF-8");
		// PrintWriter를 사용하여 클라이언트로 텍스트 기반의 응답을 보낼 수 있도록 함
		PrintWriter out=response.getWriter();
		// 이는 동적으로 생성된 웹 리소스로, 클라이언트가 HelloTextServlet을 요청할 때마다 같은 내용으로 응답됨  
		for (int i = 0; i < 10; i++) {  // 10번 반복하는 반복문
			 // "Hello text [dynamic web resource]"를 출력하고, i 값을 1씩 증가시켜 출력함
			out.println("Hello text "+(i+1)+" [dynamic web resource]");
			
		}

	}

}
