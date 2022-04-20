package kh.semi.thduo.member.service;

import static kh.semi.thduo.common.jdbc.JdbcTemplate.close;
import static kh.semi.thduo.common.jdbc.JdbcTemplate.getConnection;

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
		// id찾기-ok
				public MemberVo readFindId(String mEmail, String mName) {
					MemberVo retVo = null;
					Connection conn = getConnection();
					retVo = dao.readFindId(conn, mEmail, mName);
					close(conn);
					return retVo;
				}
				
				
		//전체회원 조회 (관리자 회원전체 조회)
		public ArrayList<MemberVo> readAllMember() {
			ArrayList<MemberVo> retVolist = null;
			Connection conn = getConnection();
			retVolist = dao.readAllMember(conn);
			close(conn);
			return retVolist;
		}	
		//회원삭제 (관리자 강퇴)
		public int deleteMember(String mId) {
			int result = 0;
			Connection conn = getConnection();
			result = dao.deleteMember(conn, mId);
			close(conn);
			return result;
		}
		//회원수정 
		public int updateMember(MemberVo vo) {
			int result = 0;
			Connection conn = getConnection();
			result = dao.updateMember(conn, vo);
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
		
	
}
