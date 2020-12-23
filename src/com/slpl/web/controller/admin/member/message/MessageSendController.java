package com.slpl.web.controller.admin.member.message;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.slpl.web.entity.member.Member;
import com.slpl.web.entity.member.Message;
import com.slpl.web.entity.member.MessageSend;
import com.slpl.web.service.member.MemberService;
import com.slpl.web.service.member.MessageSendService;
import com.slpl.web.service.member.MessageService;

@WebServlet("/admin/member/message/send")
public class MessageSendController extends HttpServlet {

	MessageService service;
	MemberService memberService;
	MessageSendService sendService;
	
	public MessageSendController() {
		service = new MessageService();
		memberService = new MemberService();
		sendService = new MessageSendService();
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String sendAllMemberParam = request.getParameter("sendAllMember");
		boolean sendAllMember = false;
		List<Member> list = new ArrayList<Member>();
		
		if(sendAllMemberParam != null) {
			if(sendAllMemberParam.equals("n") == true) {
				String[] checkMembers = request.getParameterValues("checkMember");
				if(checkMembers != null) {
					for(int i=0 ; i<checkMembers.length ; i++) {
						System.out.printf("[i]checkMembers - %s\n",i+1, checkMembers[i]);
						int id = Integer.parseInt(checkMembers[i]);
						Member m = memberService.get(id);
						list.add(m);	
						System.out.println("id : "+m.getId());
					}
				} 
				System.out.println("선택 회원 메세지 보내기");
			} else {
				if(sendAllMemberParam != null) {
					sendAllMember = true;
					list = memberService.getList();
				}
				
				System.out.println("전체 보내기");
			}
		}

		
		StringBuilder sb = new StringBuilder();
		for(int i=0 ; i<list.size() ; i++) {
			Member m = list.get(i);
			sb.append(m.getName());
			if(i<list.size()-1) {
				sb.append(", ");
			}
		}
		
		
		request.setAttribute("list", list);
		request.setAttribute("sendAllMember", sendAllMember);
		request.setAttribute("memberNames", sb.toString());
		request.getRequestDispatcher("send.jsp").forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 로그인 되어 있는지 확인
		Member loginMember = (Member) request.getSession().getAttribute("login");
		if(loginMember == null) {
			request.getRequestDispatcher("login.jsp").forward(request, response);
			return;
		}
		
		String sendAllMember = request.getParameter("sendAllMember");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String type = request.getParameter("type");
		int adminId = loginMember.getId();          // 로그인 된 관리자 계정 아이디를 갖고옴
		int[] memberIds = null;
		
		if(sendAllMember != null) {
			System.out.println("sendAllMember : "+sendAllMember);
			if(sendAllMember.equals("n") == true) {
				String[] ids = request.getParameterValues("id");
				if(ids != null) {
					memberIds = new int[ids.length];
					for(int i=0 ; i<ids.length ; i++) {
						System.out.printf("[i]ids - %s\n",i+1, ids[i]);
						int id = Integer.parseInt(ids[i]);
						memberIds[i] = id;	
					}
				} 
			} else {
				if(sendAllMember != null) {
					List<Member> list = memberService.getList();
					if(list.size() > 0) {
						memberIds = new int[list.size()];
						for(int i=0 ; i<list.size() ; i++) {
							Member member = list.get(i);
							memberIds[i] = member.getId();
						}
					}
				}
			}

			System.out.println("memberIds[0] : "+memberIds[0]);
			
			if(memberIds.length > 0) {
				Message m = new Message(title, content, type);
				int result = service.insert(m);
				int messageId = service.getLastId();
				if(result > 0) {
					for(int i=0 ; i<memberIds.length ; i++) {
						MessageSend ms = new MessageSend(adminId, memberIds[i], messageId);
						int sendResult = sendService.insert(ms);
						System.out.printf("member[%d] 보냄 : %d\n",i, sendResult);
					}
				}
				System.out.println("다보냄!~!~~!~ / memberIds.length : "+memberIds.length);
			}
		}
		
		response.sendRedirect("list");
	}
	
	
}
