package test.kh.semi.thduo.member.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import test.kh.semi.thduo.member.model.dao.MemberDao;
import test.kh.semi.thduo.member.model.vo.MemberVo;

import static kh.semi.thduo.common.jdbc.JdbcTemplate.*;



public class MemberService {
	// DB 접속/해제, transaction commit/rollback -> JdbcTemplate 사용할거니까 import에 static .*
	
	
	private MemberDao dao = new MemberDao();  //  어차피 뉴 할거니까 미리 필드변수로 빼줘
	
	
	// dao 에서 복붙해와서 작업
	public int insertMember(MemberVo vo) {
		int result = 0;
		Connection conn = null;
		conn = getConnection();
		result = dao.insertMember(conn, vo);
		close(conn);
		return result;
	}

	public int updateNickname(String mId, String newName) {
		int result = 0;
		Connection conn = null;
		conn = getConnection();
		result = dao.updateNickname(conn, mId, newName);
		close(conn);
		return result;
	}
	public int updateEmail(String mId, String newEmail) {
		int result = 0;
		Connection conn = null;
		conn = getConnection();
		result = dao.updateEmail(conn, mId, newEmail);
		close(conn);
		return result;
	}
	public int updatePhone(String mId, String newPhone) {
		int result = 0;
		Connection conn = null;
		conn = getConnection();
		result = dao.updatePhone(conn, mId, newPhone);
		close(conn);
		return result;
	}
	public int updatePassword(String mId, String newPass) {
		int result = 0;
		Connection conn = null;
		conn = getConnection();
		result = dao.updatePassword(conn, mId, newPass);
		close(conn);
		return result;
	}
	public int deleteMember(String mId) {  // 주로 pk를 가지고 delete를 시도해! 100%는 아니지만..
		int result = 0;
		Connection conn = null;
		conn = getConnection();
		result = dao.deleteMember(conn, mId);
		close(conn);
		return result;
	}
	public int deleteAllMember() { 
		int result = 0;
		Connection conn = null;
		conn = getConnection();
		result = dao.deleteAllMember(conn);
		close(conn);
		return result;
	}
	
//	public ArrayList<MemberVo> loginMember() {
//		ArrayList<MemberVo> revolist = null;
//		Connection conn = null;
//		conn = getConnection();
//		revolist = dao.loginMember(conn);
//		close(conn);
//		return revolist;
//	}
	
	public MemberVo loginMember(MemberVo vo) {
		MemberVo revo = null;
		Connection conn = null;
		conn = getConnection();
		revo = dao.loginMember(conn, vo);
		close(conn);
		return revo;
	}
	
	public MemberVo readOneMember(String mId) { 
		MemberVo retVo = null; 
		Connection conn = null;
		conn = getConnection();
		retVo = dao.readOneMember(conn, mId);
		close(conn);
		return retVo;
	}
	public ArrayList<MemberVo> readAllMember() { 
		ArrayList<MemberVo> retVolist = null;
		Connection conn = null;
		conn = getConnection();
		retVolist = dao.readAllMember(conn);
		close(conn);
		return retVolist;
	}
	
	public int countMember() {
		Connection conn = null;
		conn = getConnection();
		
		int result = dao.countMember(conn);
		close(conn);
		return result;
	}
	public ArrayList<MemberVo> listMember(int startRnum, int endRnum){
		Connection conn = null;
		conn = getConnection();
		
		ArrayList<MemberVo> result = dao.listMember(conn, startRnum, endRnum);
		close(conn);
		return result;
	}
	
	public MemberVo searchMemberId(String mId) {
		MemberVo vo = null;
		Connection conn = null;
		conn = getConnection();
		
		vo = dao.searchMemberId(conn, mId);
		close(conn);
		return vo;
	}
	public MemberVo searchMemberNickname(String nickname) {
		MemberVo vo = null;
		Connection conn = null;
		conn = getConnection();
		
		vo = dao.searchMemberNickname(conn, nickname);
		close(conn);
		return vo;
	}
	public MemberVo searchMemberEmail(String email) {
		MemberVo vo = null;
		Connection conn = null;
		conn = getConnection();
		
		vo = dao.searchMemberEmail(conn, email);
		close(conn);
		return vo;
	}
	public MemberVo searchMemberPhone(String phone) {
		MemberVo vo = null;
		Connection conn = null;
		conn = getConnection();
		
		vo = dao.searchMemberPhone(conn, phone);
		close(conn);
		return vo;
	}
	public MemberVo login(String mId, String pw) { 
		MemberVo retVo = null; 
		Connection conn = null;
		conn = getConnection();
		retVo = dao.login(conn, mId, pw);
		close(conn);
		return retVo;

}
}
