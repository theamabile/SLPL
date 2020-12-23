package com.slpl.web.controller.test.make;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.slpl.web.entity.member.Member;
import com.slpl.web.service.test.TestService;

@WebServlet("/test/make/update-cover-img")
@MultipartConfig(fileSizeThreshold = 1024 * 1024, maxFileSize = 1024 * 1024 * 5, maxRequestSize = 1024 * 1024 * 10)
public class RegCoverConotroller extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {


		request.setCharacterEncoding("UTF-8");
		
		Cookie[] cookies = request.getCookies();
		int testId = 0;
		int memberId = 0;
		if (cookies != null) {
			for (Cookie cookie : cookies)
				if ("testId".equals(cookie.getName()))
					testId = Integer.parseInt(cookie.getValue());
//				else if ("memberId".equals(cookie.getName()))
//					memberId = Integer.parseInt(cookie.getValue());
		}
		
		HttpSession session = request.getSession();
		Member m = (Member) session.getAttribute("login");
		
		if(m!=null)
			memberId=m.getId();
		
//		파일 얻어오기
		Part filePart = request.getPart("file");
		
		String fileName = null;
		if (filePart != null) {
			fileName = filePart.getSubmittedFileName();
			
			TestService service = new TestService();
			service.coverUpdate(testId,fileName);
		}
		String img = request.getParameter("img");
		if (filePart != null) {
			String pathTemp = request.getServletContext().getRealPath("/static/test/"+testId + "/");
			System.out.println(pathTemp);
			
			File path = new File(pathTemp);
//			경로 존재 여부 확인
			if (!path.exists())
				path.mkdirs();
			
//			유닉스 환경을 고려하여 separator 이용
			String filePath = pathTemp + File.separator + fileName;
			
//			파일 저장
			InputStream fis = filePart.getInputStream();
			FileOutputStream fos = new FileOutputStream(filePath);
			
			byte[] buf = new byte[1024];
			int size = 0;
			while ((size = fis.read(buf)) != -1)
				fos.write(buf, 0, size);
			System.out.printf("testId : %d , file : %s\n", testId, filePart.getSubmittedFileName());

			fos.close();
		}
	}
	

}
