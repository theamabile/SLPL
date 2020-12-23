package com.slpl.web.controller.community;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.eclipse.jdt.internal.compiler.ast.ParameterizedQualifiedTypeReference;

import com.slpl.web.entity.community.Community;
import com.slpl.web.service.community.CommunityService;

@WebServlet("/community/all/write")
@MultipartConfig(fileSizeThreshold = 1024 * 1024, maxFileSize = 1024 * 1024 * 5, maxRequestSize = 1024 * 1024 * 5 * 5)
public class RegController extends HttpServlet {
	private CommunityService service;

	public RegController() {
		service = new CommunityService();
	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (request.getMethod().equals("GET"))
			request.getRequestDispatcher("write.jsp").forward(request, response);
		else if (request.getMethod().equals("POST")) {
			// 1.사용자 입력을 변수에 담기
			String category = request.getParameter("c");
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			Part filePart = request.getPart("file");

			Collection<Part> fileParts = request.getParts();

			for (Part p : fileParts) {
				if (p.getName().equals("file")) {
					System.out.println();
				}
			}

			int categoryId = 0;
			if (category.equals("전체게시판") ) {
				 categoryId = 0;
			} else if (category.equals("민슈찍")) {
				 categoryId = 1;
			} else if (category.equals("민슈부")) {
				 categoryId = 2;
			}else if (category.equals("민팥부")) {
				 categoryId = 3;
			} else if (category.equals("반민팥부")) {
				 categoryId = 4;
			}else if (category.equals("반민팥찍")) {
				 categoryId = 5;
			} else if (category.equals("반민팥슈")) {
				 categoryId = 6;
			}else if (category.equals("민팥찍")) {
				 categoryId = 7;
			} else if (category.equals("반민슈찍")) {
				 categoryId = 8;
			}
			

			Community board = new Community(title, content, category, categoryId);

//			if(filePart != null) {
//				
//			}
//			board.setFiles(fileName);
//			int newId = service.getLastId() + 1;
//			
//			
//			
//			String pathTemp = request.getServletContext().getRealPath("/static/community");
//			System.out.println(pathTemp);
////			request.getServletContext();
//			File path = new File("home directory/static/community");
//			if(!path.exists())
//				path.mkdirs();
//			
//			String filePath = pathTemp + File.separator + filePart.getSubmittedFileName();
//			

			// File file = new
			// File("/static/notice/2020/25"+filePart.getSubmittedFileName());
//			InputStream fis = filePart.getInputStream();
//			FileOutputStream fos = new FileOutputStream(filePath);
//			
//			byte[] buf = new byte[1024];
//			int size= 0;
//			while((size = fis.read(buf)) != -1)
//				fos.write(buf, 0, size);
//			
//			fos.close();
//			fis.close();

			// System.out.println(filePart.getSubmittedFileName());

			// 2.데이터베이스에 입력
			CommunityService service = new CommunityService();
			service.insert(board);
			String categoryName = URLEncoder.encode(category);
			System.out.println(categoryName);
			
			// 목록페이지로 이동
			response.sendRedirect("/community/all/list?c="+categoryName);
		}
	}

}
