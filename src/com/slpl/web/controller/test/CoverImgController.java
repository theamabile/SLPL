package com.slpl.web.controller.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.slpl.web.entity.test.TestPlayView;
import com.slpl.web.entity.test.TestResultView;
import com.slpl.web.service.test.TestPlayService;
import com.slpl.web.service.test.TestResultService;

@WebServlet("/test/coverImg")
public class CoverImgController extends HttpServlet{
	private TestPlayService service;
	private TestResultService service2;
	
	public CoverImgController() {
		service = new TestPlayService();
		service2 = new TestResultService();
	}
	
	@Override
	   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	      
	      String imgName = "default.png";
	      String idParam = request.getParameter("id");      // 유저의 아이디
	      String type = request.getParameter("type");
	      System.out.println(idParam);
	      int id = 0;
	      TestPlayView t = null;
	      TestResultView r = null;
	      if(idParam != null) {
	         id = Integer.parseInt(idParam);
	         t = service.get(id);
	         r = service2.get(id);
	         if(type == "c") {
	        	 imgName = t.gettCoverImg();	        	 
	         }
	         else {
	        	 imgName = r.getcImg();	        	 
	         }
	      } else {
	         return;
	      }
	      
	      // 경로 받아오기
	      String pathTemp = request.getServletContext().getRealPath("/static/test/"+id);   // 실제 서블릿 있는 경로를 알아내고, 인자로 넣은 경로의 실제 물리경로를 알아내주는 녀석.
	      
	      // 디렉토리 찾기
	      File path = new File(pathTemp);
	      if(path.exists()) {   // 이미지 폴더가 있으면
	         // 파일 저장은 톰캣 디렉토리에 됨.(동적으로 만들어진건 다 저기에 되는듯)
	         String filePath = pathTemp + File.separator + imgName;
	         System.out.println("filePath : "+filePath);  // 전송된 파일의 이름 갖고오기
	      
	         FileInputStream fis = new FileInputStream(filePath);    // 경로에 있는 파일을 읽어옴
	         OutputStream fos = response.getOutputStream();         // 저장과는 반대로 출력임
	         
	         byte[] buf = new byte[1024];
	         int size = 0;
	         while((size = fis.read(buf)) != -1) {
	            fos.write(buf, 0, size);
	         }
	         
	         fos.close();
	         fis.close();
	      }
	   }

}
