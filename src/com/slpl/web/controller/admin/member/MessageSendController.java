package com.slpl.web.controller.admin.member;

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

@WebServlet("/admin/member/messageSend")
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
		request.getRequestDispatcher("message_send.jsp").forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String sendAllMember = request.getParameter("sendAllMember");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String type = request.getParameter("type");
		int adminId = 64;          // @@@@ 로그인 기능 생기기 전까지는 일단 임시값
		int[] memberIds = null;
		
		if(sendAllMember != null) {
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
			
			if(memberIds.length > 0) {
				Message m = new Message(title, content, type);
				int result = service.insert(m);
				int messageId = service.getLastId();
				if(result > 0) {
					for(int i=0 ; i<memberIds.length ; i++) {
						MessageSend ms = new MessageSend(adminId, memberIds[i], messageId);
						sendService.insert(ms);
					}
				}
			}
		}
		
		response.sendRedirect("messageList");
	}
	
	
}
