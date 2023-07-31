package com.itwill.servlet;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet({ "/MIMETypeMP3ReponseSevlet", "/response.Mp3.do" })
public class MIMETypeMP3ResponseSevlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * 1.응답객체 MIME타입설정
		 */
		response.setContentType("audio/mpeg");		
		/*
		 * 2.브라우저와 연결된 출력(이미지) 스트림얻기
		 */
		OutputStream out = response.getOutputStream();
		
		String MP3FilePath = "C:\\Users\\ITWILL\\git\\choiyongyong0813\\servletSite\\src\\main\\webapp\\image\\car1.jpg";
		FileInputStream imageInputStream = new FileInputStream(MP3FilePath);
		
		while (true) {
			int readByte = imageInputStream.read();
			if (readByte==-1)break; 
			/*
			 * 3.브라우저와 연결된 출력(이미지) 스트림에 이미지 데이터 쓰기
			 */	
			out.write(readByte);
			
		}
		
	
		
	}

}
