package com.slpl.web.controller.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.slpl.web.entity.community.CommunityCategory;
import com.slpl.web.entity.member.Admin;
import com.slpl.web.entity.member.Member;
import com.slpl.web.service.community.CommunityCategoryService;
import com.slpl.web.service.member.AdminService;
import com.slpl.web.service.member.MemberService;

@WebServlet("/common/join")
@MultipartConfig(        
	    fileSizeThreshold=1024*1024, 
	    maxFileSize=1024*1024*5, 
	    maxRequestSize=1024*1024*5*5)
public class JoinController extends HttpServlet {

	MemberService service;
	AdminService adminService;
	CommunityCategoryService categoryService;
	
	public JoinController() {
		service = new MemberService();
		adminService = new AdminService();
		categoryService = new CommunityCategoryService();
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 혜영이쪽 구현 다 되면 여기서 호출
		List<CommunityCategory> categorys = categoryService.getList();
		
		request.setAttribute("categorys", categorys);
		request.getRequestDispatcher("join.jsp").forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String loginId = request.getParameter("loginId");
		String pw= request.getParameter("pw");
		String name = request.getParameter("name");
		String nickname = request.getParameter("nickname");
		String phoneNumber = request.getParameter("phoneNumber");

		String emailId = request.getParameter("emailId");
		String emailAddress = request.getParameter("emailAddress");
		if(emailAddress.equals("none")) {
			String customAddress = request.getParameter("customAddress");
			emailAddress = customAddress;
		}
		
		String email = emailId+"@"+emailAddress;
		

		String yearStr = request.getParameter("year");
		String monthStr = request.getParameter("month");
		String dayStr = request.getParameter("day");
		Date birthday = null;   // Date형식으로 변환
		if(yearStr.equals("") == false && monthStr.equals("") == false && dayStr.equals("") == false ) {
			int year = Integer.parseInt(yearStr);
			int month = Integer.parseInt(monthStr);
			int day = Integer.parseInt(dayStr);
			String birthdayStr = String.format("%s-%s-%s", year, month, day);
			birthday = Date.valueOf(birthdayStr);   // Date형식으로 변환
		}
		
		String gender = request.getParameter("gender");

		int categoryId = Integer.parseInt(request.getParameter("category"));   // id가 반환됨
		
		Part filePart = request.getPart("profile");
		String profileImgName = "default.png";
		if(filePart != null && filePart.getSize() > 0) {   // 파일 첨부 input이 여러개면 다 name을 file로 하면 한번에 갖고와짐
			System.out.println("name : "+filePart.getName()+ " / fileName : "+filePart.getSubmittedFileName());

			int newId = service.getLastId() + 1;

			profileImgName = filePart.getSubmittedFileName();
            
			// 경로 받아오기
			String pathTemp = request.getServletContext().getRealPath("/static/member/2020/"+newId+"/");   // 실제 서블릿 있는 경로를 알아내고, 인자로 넣은 경로의 실제 물리경로를 알아내주는 녀석.
			
			// 디렉토리 만들기
			File path = new File(pathTemp);
			if(!path.exists()) {
				path.mkdirs();		// s 붙은 놈은 저 경로중 없는 폴더를 모두 만들고, 안붙은 놈은 끝 폴더만 만듬	
			}

			// 파일 저장 디렉토리 : /static/member/2020/?(아이디)/ 
			// 파일 저장은 톰캣 디렉토리에 됨.(동적으로 만들어진건 다 저기에 되는듯)
			String filePath = pathTemp + File.separator + profileImgName;
			System.out.println("filePath : "+filePath);  // 전송된 파일의 이름 갖고오기
		
			InputStream fis = filePart.getInputStream();
			FileOutputStream fos = new FileOutputStream(filePath);
			
			byte[] buf = new byte[1024];
			int size = 0;
			while((size = fis.read(buf)) != -1) {
				fos.write(buf, 0, size);
			}

			
			fos.close();
			fis.close();
		}

		Member member = new Member(loginId, pw, name, nickname, gender,
				birthday, phoneNumber, email, profileImgName, categoryId);
		service.insert(member);
		
		response.sendRedirect("main");
	}
	
}
	
