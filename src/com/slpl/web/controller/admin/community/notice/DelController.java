package com.slpl.web.controller.admin.community.notice;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.slpl.web.service.community.CommunityNoticeService;

@WebServlet("/admin/community/notice/delete")
public class DelController extends HttpServlet {
   
   @Override
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

      CommunityNoticeService service = new CommunityNoticeService();
      
      String[] checkIds = request.getParameterValues("checkMember");      

      if(checkIds != null) {
         int[] ids = new int[checkIds.length];
         for(int i=0 ; i<ids.length ; i++) {
            ids[i] = Integer.parseInt(checkIds[i]);
         }
         
         service.deleteAll(ids);
      }
      

      response.sendRedirect("list");
   }
   
}


