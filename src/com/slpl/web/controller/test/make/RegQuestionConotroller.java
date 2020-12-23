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
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.slpl.web.entity.member.Member;
import com.slpl.web.entity.test.Answer;
import com.slpl.web.entity.test.AnswerScore;
import com.slpl.web.entity.test.Question;
import com.slpl.web.service.test.AnswerScoreService;
import com.slpl.web.service.test.AnswerService;
import com.slpl.web.service.test.QuestionService;
import com.slpl.web.service.test.TypeService;

@WebServlet("/test/make/reg-question")
//이미지 
@MultipartConfig(fileSizeThreshold = 1024 * 1024, maxFileSize = 1024 * 1024 * 5, maxRequestSize = 1024 * 1024 * 10)
public class RegQuestionConotroller extends HttpServlet {

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
		String[] typeIds = null;

//		테스트 정보 
		if (cookies != null) {
			for (Cookie cookie : cookies)
				if ("testId".equals(cookie.getName()))
					testId = Integer.parseInt(cookie.getValue());
				//else if ("memberId".equals(cookie.getName()))
				//	memberId = Integer.parseInt(cookie.getValue());
				else if ("typeIds".equals(cookie.getName())) {
//					문자열 쿠키 인코딩
					String temp = URLDecoder.decode(cookie.getValue(), "UTF-8");
					String temp2 = temp.substring(1, temp.length() - 1);
					temp = temp2.replace(" ","");
					System.out.println("타입 아이디 배열"+temp);
					typeIds = temp.split(",");
				}
		}
		
		HttpSession session = request.getSession();
		Member m = (Member) session.getAttribute("login");
		
		if(m!=null)
			memberId=m.getId();

//	---문제 등록-----
		QuestionService queService = new QuestionService();
//		수정하기
		String questionId_ = request.getParameter("questionId");
		
		String question = request.getParameter("question");
		String no_ = request.getParameter("page");
		String file = request.getParameter("file");
		
//		파일 얻어오기
		Part filePart = request.getPart("file");

		System.out.println("filePart : " +filePart);
		int questionId = 0;
		if (question != null) {

			int no = Integer.parseInt(no_);

			Question q = new Question();
//		새로등록
			if (questionId_ == null) {
				q.setNo(no);
				q.setTestId(testId);
				q.setContent(question);
				
				String fileName = null;
//			  이미지 파일 명 얻어오기
				if (filePart != null) {
					fileName = filePart.getSubmittedFileName();
					q.setImg(fileName);
				}
				
				questionId = queService.insert(q);
				
//				  이미지 파일 저장
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
					System.out.printf("questionId : %d , file : %s\n", questionId, filePart.getSubmittedFileName());

					fos.close();
				}

			}
//		수정
			else {
			}

//			-----답안지 등록------
			AnswerService answerService = new AnswerService();
			String[] answerContent = request.getParameterValues("answer");
			String[] answerId_ = request.getParameterValues("answerId");
			

			Answer answer;
			int[] answerId = new int[answerContent.length];

//			수정인지 새로 등록인지 확인하는 방법?? 
//			문항번호?? 문제 번호로 select문으로 검색하고 일치하는 것이 있으면,??

//			새로 등록
			if (answerId_ == null)
				for (int i = 0; i < answerContent.length; i++) {
					answer = new Answer();
					answer.setNo(no);
					answer.setQuestion_id(questionId);
					answer.setContent(answerContent[i]);
					answerId[i] = answerService.insert(answer);
				}
//			수정
			else {

			}

//			성향 점수 등록
			AnswerScore score;
			AnswerScoreService scoreService = new AnswerScoreService();
			String[] typeValue = request.getParameterValues("type-value");
			int index=0;
			for (int i = 0; i < answerId.length; i++) {
				for (int j = 0; j < typeIds.length; j++) {
					score = new AnswerScore();
					score.setAnswer_id(answerId[i]);
					score.setType_id(Integer.parseInt(typeIds[j]));
					score.setScore(Integer.parseInt(typeValue[index]));
					scoreService.insert(score);
//					index =(index+loop)/(loop*loop);
					index++;
				}
			}
		}
	}
}