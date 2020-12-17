package com.slpl.web.dao.member;

import java.util.List;

import com.slpl.web.entity.member.Member;
import com.slpl.web.entity.member.MemberView;

// SQL의 자바 함수화
// 업무를 모르는 사람이 하는일
public interface MemberDao {
	int insert(Member member);
	int update(Member member);
	int delete(int id);

	Member get(int id);
	List<Member> getList();
	
	// ======================================= View ==========================================

	MemberView getView(int id);
	List<MemberView> getViewList();
	List<MemberView> getViewList(int startIndex, int endIndex, String field, String query);
	
	// =======================================================================================

	Member getLast();		// 마지막 요소 갖고오기
}