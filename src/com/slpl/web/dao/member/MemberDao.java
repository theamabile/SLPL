package com.slpl.web.dao.member;

import java.util.List;

import com.slpl.web.entity.member.Member;

public interface MemberDao {
	int insert(Member member);
	int update(Member member);
	int delete(int id);
	
	Member get(int id);
	List<Member> getList();
	
	/* ------------------------------------ 회원 목록 ----------------------------------------- */
	// 전체리스트 + 페이지 전환
	List<Member> getList(int page);
	// 검색
	List<Member> getList(int page, String category, String keyword);	
	// 다수 삭제
	int delete(int[] ids);

	/* ------------------------------------ 회원 추가 ----------------------------------------- */
	// 아이디 중복 체크
	int getByLoginId(String loginId);   		// 같은 로그인 ID를 갖고 있는 회원 수를 반환
	// 닉네임 중복 체크
	int getByNickname(String nickname);
}