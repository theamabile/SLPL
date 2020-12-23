package com.slpl.web.controller.test.make;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.slpl.web.service.test.CharacterService;
import com.slpl.web.entity.test.Character;

@WebServlet("/test/make/character-img")
public class CharacterImgController extends HttpServlet {

	CharacterService service;

	public CharacterImgController() {
		service = new CharacterService();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Cookie[] cookies = request.getCookies();
		int testId = 0;
		if (cookies != null) {
			for (Cookie cookie : cookies)
				if ("testId".equals(cookie.getName()))
					testId = Integer.parseInt(cookie.getValue());
			int id = 0;
			String imgName = "default.png";
			String no_ = request.getParameter("no");

			System.out.println("들어옴!" + id);

			Character c = null;
			if (no_ != null) {
				int no = Integer.parseInt(no_);
				c = service.search(testId, no);
				imgName = c.getImg();
			} else {
				return;
			}

			// 경로 받아오기
			String pathTemp = request.getServletContext().getRealPath("/static/test/"); // 기본 이미지(기본 이미지인 경우 : 프로필
																						// 등록한적X,
																						// 초기화)
			if (imgName.equals("default.png") == false) {
				pathTemp = request.getServletContext().getRealPath("/static/test/" + testId + "/"); // 실제 서블릿 있는 경로를
																									// 알아내고, 인자로
				// 넣은 경로의 실제 물리경로를 알아내주는 녀석.
			}

			// 디렉토리 찾기
			File path = new File(pathTemp);

			if (path.exists()) { // 이미지 폴더가 있으면
				// 파일 저장은 톰캣 디렉토리에 됨.(동적으로 만들어진건 다 저기에 되는듯)
				String filePath = pathTemp + File.separator + imgName;
				System.out.println("filePath : " + filePath); // 전송된 파일의 이름 갖고오기

				FileInputStream fis = new FileInputStream(filePath); // 경로에 있는 파일을 읽어옴
				OutputStream fos = response.getOutputStream(); // 저장과는 반대로 출력임

				byte[] buf = new byte[1024];
				int size = 0;
				while ((size = fis.read(buf)) != -1) {
					fos.write(buf, 0, size);
				}

				fos.close();
				fis.close();

			}
		}
	}
}
