package kh.semi.thduo.member.service;

import static kh.semi.thduo.common.jdbc.JdbcTemplate.close;
import static kh.semi.thduo.common.jdbc.JdbcTemplate.commit;
import static kh.semi.thduo.common.jdbc.JdbcTemplate.getConnection;
import static kh.semi.thduo.common.jdbc.JdbcTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import kh.semi.thduo.member.dao.MemberDao;
import kh.semi.thduo.member.vo.MemberVo;


public class MemberService {
	
		private MemberDao dao = new MemberDao(); 
		
		// 회원가입 ok
		public int insertMember(MemberVo vo) {
			int result = 0;
			Connection conn = getConnection();
			result = dao.insertMember(conn, vo);
			close(conn);
			return result;
		}
	
		// 회원 로그인 ok
		public MemberVo login(String mId, String pw) {
			MemberVo retVo = null;
			Connection conn = getConnection();
			retVo = dao.login(conn, mId, pw);
			close(conn);
			return retVo;
		}
		//체크로직 ok
		public int readMemberCheck(String str, String type) {
			int i = 0;
			System.out.println("str1 = "+str);
			Connection conn = getConnection();
			i = dao.readMemberCheck(conn, str, type);
			close(conn);
			return i;
			
		}
		
		
		// pw찾기 - id, email 확인
		public int readFindPw(String mId, String mEmail) {

			int result = 0;
			Connection conn = getConnection();
			result = dao.readFindPw(conn, mId, mEmail);
			close(conn);
			System.out.println("MemberService result: id,이메일일 확인  " + result);
			return result;
		}
		// id찾기-ok
		public MemberVo readFindId(String mEmail, String mName) {
			MemberVo retVo = null;
			Connection conn = getConnection();
			retVo = dao.readFindId(conn, mEmail, mName);
			close(conn);
			return retVo;
		}
		
		// 새(임시) 비밀번호
		public int updateRandomPw(String mPw, String mId) {
			int result = 0;
			Connection conn = getConnection();
			result = dao.updateRandomPw(conn, mPw, mId); // TODO
			close(conn);
			return result;
		}	
		
		//회원 전체조회 (관리자 회원전체 조회)
		public ArrayList<MemberVo> readAllMember() {
			ArrayList<MemberVo> retVolist = null;
			Connection conn = getConnection();
			retVolist = dao.readAllMember(conn);
			close(conn);
			return retVolist;
		}	
		
		//회원삭제 (관리자 강퇴)
		public int deleteMember(String mId) {
			System.out.println("회원탈퇴 service, 아이디: " + mId);
			
			int result = 0;
			Connection conn = getConnection();
			result = dao.deleteMember(conn, mId);
			close(conn);
			System.out.println("회원탈퇴 service, result" + result);
			return result;
		}
		//회원수정 
		public int updateMember(MemberVo vo) {
			int result = 0;
			Connection conn = getConnection();
			result = dao.updateMember(conn, vo);
			if (result == 1) {
				commit(conn);
			} else {
				rollback(conn);
			}
			close(conn);
			return result;
			}
		//회원 전체 삭제 
		public int deleteAllMember() {
			int result = 0;
			Connection conn = getConnection();
			result = dao.deleteAllMember(conn);
			close(conn);
			return result;
		}
		// 로그인시 id 확인작업 
		public MemberVo readFindId(String mId) {
			MemberVo retVo = null;
			Connection conn = getConnection();
			retVo = dao.readFindId(conn, mId);
			close(conn);
			return retVo;
		}
	
}
