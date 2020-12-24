package com.slpl.web.service.member;

import java.util.List;

import com.slpl.web.dao.jdbc.JdbcMemberDao;
import com.slpl.web.dao.member.MemberDao;
import com.slpl.web.entity.member.Member;
import com.slpl.web.entity.member.MemberView;

public class MemberService {
	
	// 여기서 생성자 안만들고 외부로 뺄거임. 내부에 넣으면 결함력 강해짐.
	// 기업용은 보통 외부에 뺌. 완성인지 미완성인지 어떤거 쓸지 모르니까.
	public MemberDao memberDao;
	
	public MemberService() {
		memberDao = new JdbcMemberDao();
	}
	
	public int insert(Member member) {
		return memberDao.insert(member);
	}

	public int update(Member member) {
		return memberDao.update(member);
	}

	public int delete(int id) {
		return memberDao.delete(id);
	}

	public int deleteAll(int[] ids) {
		int result = 0;
		System.out.println("deleteAll "+ids.length);
		for(int i=0 ; i<ids.length ; i++) {
			int id = ids[i];
			result += memberDao.delete(id);
			System.out.println(i+"번째 delete 중 - "+result);
		}
		return result;
	}

	public Member get(int id) {
		return memberDao.get(id);
	}

	/*
	 * public Member get(String loginId) { // TODO Auto-generated method stub return
	 * memberDao.get(loginId); }
	 */
	
	public List<Member> getList(String field, String query) {
		// TODO Auto-generated method stub
		return memberDao.getList(field, query);
	}	
	
	public List<Member> getList() {
		return memberDao.getList();
	}

	
	// ======================================= View ==========================================

	public MemberView getView(int id) {
		// TODO Auto-generated method stub
		return memberDao.getView(id);
	}
	
	public MemberView getView(String loginId) {
		// TODO Auto-generated method stub
		return memberDao.getView(loginId);
	}

	// 회원 목록 - 페이징 X | 검색 X
	public List<MemberView> getViewList() {
		return memberDao.getViewList();
	}

	// 회원 목록 - 페이징 X | 검색 O
	public List<MemberView> getViewList(String field, String query){
		int maxSize = memberDao.getViewList().size();
		return memberDao.getViewList(1, maxSize, field, query);
	}
	
	// 회원 목록 - 페이징 O | 검색 X
	public List<MemberView> getViewList(int page, int size) {
		int startIndex = 1 + (page-1)*size;
		int endIndex = page*size;
		return memberDao.getViewList(startIndex, endIndex, null, null);
	}
	
	// 회원 목록 - 페이징 O | 검색 O
	public List<MemberView> getViewList(int page, int size, String field, String query) {
		int startIndex = 1 + (page-1)*size;
		int endIndex = page*size;
		return memberDao.getViewList(startIndex, endIndex, field, query);	
	}

	
	// ===========================================================================================
	
	
	public boolean isExistNickname(String nickname) {
		boolean result = false;
		List<Member> list = memberDao.getList();
		for(int i=0 ; i<list.size() ; i++) {
			String listNickname = list.get(i).getNickname();
			if( nickname.equals(listNickname) == true) {
				result = true;
			}
		}
		return result;
	}
	
	public boolean isExistId(String loginId) {
		boolean result = false;
		List<Member> list = memberDao.getList();
		for(int i=0 ; i<list.size() ; i++) {
			String listLoginId = list.get(i).getLoginId();
			if( loginId.equals(listLoginId) == true) {
				result = true;
			}
		}
		return result;
	}

	public int getLastId() {
		// TODO Auto-generated method stub
		Member m = memberDao.getLast();
		// 업데이트 -> 컬럼
		// 서비스에서는 공개값 업데이트/좋아요 업데이트/조회수 업데이트
		// get -> set -> update
		return m.getId();
	}

	public boolean isValid(String loginId, String pw) {
			
		MemberView member = memberDao.getView(loginId);
		
		if(member == null) {   // 회원이 아닌 경우 
			return false;
		} else if(!member.getPw().equals(pw)) {  // 회원이긴 한데 비번이 일치하지 않는 경우
			return false;
		}
		return true;
	}
}
