package com.slpl.web.controller.test.make;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLDecoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.slpl.web.entity.test.Character;
import com.slpl.web.service.test.CharacterService;

@WebServlet("/test/make/reg-result-content")
@MultipartConfig(fileSizeThreshold = 1024 * 1024, maxFileSize = 1024 * 1024 * 5, maxRequestSize = 1024 * 1024 * 10)
public class RegResultContentConotroller extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/json; charset=UTF-8");


	}


	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");

		Cookie[] cookies = request.getCookies();
		int testId = 0;
		int memberId = 0;
		String [] characterIds = null;


//		테스트 정보 
		if (cookies != null) {
			for (Cookie cookie : cookies)
				if ("testId".equals(cookie.getName()))
					testId = Integer.parseInt(cookie.getValue());
				else if ("memberId".equals(cookie.getName()))
					memberId = Integer.parseInt(cookie.getValue());
				else if("characterIds".equals(cookie.getName())){
						String temp = URLDecoder.decode(cookie.getValue(), "UTF-8");
						String temp2 = temp.substring(1, temp.length() - 1);
						temp = temp2.replace(" ","");
						characterIds = temp.split(",");
				}
		}

//		캐릭터 정보 업데이트
		String content = request.getParameter("result-content");
		System.out.println("controller   : " +content);
		
		String file = request.getParameter("file");
		String id_ = request.getParameter("page").trim();;
		System.out.println(id_);
		int id = Integer.parseInt(id_);

		
		CharacterService service = new CharacterService();
		Character character = new Character();
		
		
//		파일 얻어오기
		Part filePart = request.getPart("file");
		
		String fileName = null;
//		  이미지 파일 명 얻어오기
			if (filePart != null) {
				fileName = filePart.getSubmittedFileName();
				character.setImg(fileName);
			}
			character.setId(Integer.parseInt(characterIds[id-1]));
			character.setContent(content);
			
			service.insertContent(character);
		
			
//			  이미지 파일 저장
				if (filePart != null) {
					String pathTemp = request.getServletContext().getRealPath("/static/test/"+ testId + "/");
					System.out.println(pathTemp);
					
					File path = new File(pathTemp);
//					경로 존재 여부 확인
					if (!path.exists())
						path.mkdirs();
					
//					유닉스 환경을 고려하여 separator 이용
					String filePath = pathTemp + File.separator + fileName;
					
//					파일 저장
					InputStream fis = filePart.getInputStream();
					FileOutputStream fos = new FileOutputStream(filePath);
					
					byte[] buf = new byte[1024];
					int size = 0;
					while ((size = fis.read(buf)) != -1)
						fos.write(buf, 0, size);
					System.out.printf("characterId : %d , file : %s\n", id, filePart.getSubmittedFileName());

					fos.close();
				}
		
		
	}
}
