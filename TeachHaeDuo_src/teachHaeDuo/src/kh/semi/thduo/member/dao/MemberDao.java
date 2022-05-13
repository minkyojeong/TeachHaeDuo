package kh.semi.thduo.member.dao;

import static kh.semi.thduo.common.jdbc.JdbcTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;

import kh.semi.thduo.member.vo.MemberVo;

public class MemberDao {
	private Statement stmt = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	//회원가입 
	public int insertMember(Connection conn, MemberVo vo) {
		int result = 0;  
		
		String sql = 
		"INSERT INTO THDUO.MEMBER"
		+"(M_ID, M_PW, M_NAME, M_NICKNAME, M_BIRTH, M_ADDRESS, M_PHONE, M_EMAIL, GENDER_FM, ROLE_ST, M_DATE)"
		+"VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, SYSTIMESTAMP)";	
		
		try { 
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, vo.getmId());  
			pstmt.setString(2, vo.getmPw());  
			pstmt.setString(3, vo.getmName());  
			pstmt.setString(4, vo.getmNickname());  
			pstmt.setString(5, vo.getmBirth());
            pstmt.setString(6, vo.getmAddress());
			pstmt.setString(7, vo.getmPhone());
			pstmt.setString(8, vo.getmEmail());
			pstmt.setString(9, vo.getGenderFm());
			pstmt.setString(10, vo.getRoleSt());

			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {  
			close(pstmt);
		}
		
		return result; 
	}
	
	   // 회원가입시 중복체크 로직(id, 닉네임, 이메일)
		public int readMemberCheck(Connection conn, String str, String type) { 
			
			System.out.println("str2 = "+str);
			
			int result = 0;  //1. 리턴자료형으로 리턴변수 선언 + 초기값
			String sql = "";
			if (type.equals("mId")) { //type  mId이면 sql 문 실행
				sql = "select count(*) as cnt from member where M_ID=?";
			}else if (type.equals("mEmail")) {  //type  mEmail이면 sql 문 실행
				sql = "select count(*) as cnt from member where M_EMAIL=?";
			}else if (type.equals("mNickName")) {//type  mNickName이면 sql 문 실행
				sql = "select count(*) as cnt from member where M_NickName=?";
			}
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, str);
				rs = pstmt.executeQuery();//  sql -executeQuery조회 
				if (rs.next()) {
					result = Integer.parseInt(rs.getString("cnt"));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close(rs);
				close(pstmt);
			}
			return result;
		}
	
//		private String 			mId;			
//		private String 			mPw; 	
//		private String 			mName;	
//		private String 			mNickname;	
//		private String 			mBirth;		
//		private String 			mAddress;	
//		private String 			mPhone;		
//		private String 			mEmail;		
//		private String 			genderFm;	
//		private String 			roleSt;		
//		private Timestamp 		mDate;	
//		private String 			mCertificate;
//		private String 			mAlarmYn;
//		
		
		
	// 회원 로그인 
	public MemberVo login(Connection conn, String mId, String pw) { 
		MemberVo retVo = null;
		String sql = "SELECT m.M_ID, M_PW, M_NAME, M_NICKNAME, M_BIRTH, M_ADDRESS, M_PHONE, M_EMAIL, GENDER_FM, ROLE_ST, M_DATE, M_CERTIFICATE, M_ALARM_YN, t_no,s_no, T_RECRUIT_YN FROM MEMBER m left outer join t_profile t on m.m_id = t.m_id full outer join member_student ms on m.m_id = ms.m_id where m.M_ID=? and m_pw=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mId);
			pstmt.setString(2, pw);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				retVo = new MemberVo();
				
				retVo.setmId(rs.getString("m_Id"));
				retVo.setmPw(rs.getString("m_pw"));
				retVo.setmName(rs.getString("M_NAME"));
				retVo.setmNickname(rs.getString("m_Nickname"));
				retVo.setmBirth(rs.getString("m_Birth"));
				retVo.setmAddress(rs.getString("m_Address"));
				retVo.setmPhone(rs.getString("m_phone"));
				retVo.setmEmail(rs.getString("m_email"));
				retVo.setGenderFm(rs.getString("gender_Fm"));
				retVo.setRoleSt(rs.getString("role_St"));
				retVo.setmDate(rs.getTimestamp("m_Date"));
				retVo.setmCertificate(rs.getString("M_CERTIFICATE"));
				retVo.setmAlarmYn(rs.getString("M_ALARM_YN"));
				retVo.settNo(rs.getString("t_no"));
				retVo.settRecruitYn(rs.getString("t_Recruit_Yn"));
				retVo.setsNo(rs.getString("s_no"));
				
				System.out.println(retVo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return retVo;
	}
	// 로그인시 id 확인작업 
			public MemberVo readFindId(Connection conn, String mId) { 
				MemberVo retVo = null;
				String sql = "select * from member where M_ID = ?";
				try {
					pstmt = conn.prepareStatement(sql);//연결
					pstmt.setString(1, mId); //
					rs = pstmt.executeQuery();//실행 
					if (rs.next()) {
						retVo = new MemberVo();
						retVo.setmId(rs.getString("m_Id"));
					}
				} catch (SQLException e) {
					e.printStackTrace();
				} finally {
					close(rs);
					close(pstmt);
				}
				return retVo;
			}
	
	// id찾기
	public MemberVo readFindId(Connection conn, String mEmail, String mName) { 
		MemberVo retVo = null;
		String sql = "select * from member where M_EMAIL = ? and M_NAME =?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mEmail);
			pstmt.setString(2, mName);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				retVo = new MemberVo();
				retVo.setmId(rs.getString("m_Id"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return retVo;
	}
	
	// pw찾기 - id, email 확인
		public int readFindPw(Connection conn, String mId, String mEmail) { 
			int result = 0;
			String sql = "select count(*) from member where M_ID = ? and M_EMAIL =?";
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, mId);
				pstmt.setString(2, mEmail);
				rs = pstmt.executeQuery();
				if (rs.next()) {
					
					result = (rs.getInt(1)); 
				
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close(rs);
				close(pstmt);
			}
			System.out.println("MemberDao result: ID,이메일 확인 "+ result);
			return result;
		}
		// 새(임시) 비밀번호 업데이트 
		public int updateRandomPw(Connection conn, String mPw , String mId) {
			int result = 0;
			String sql = "update member set  m_PW=?  where m_id=?";
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, mPw);
				pstmt.setString(2, mId);
				
				result = pstmt.executeUpdate();
				
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close(pstmt);
			}
			return result;
		}
	
	
	
 //회원 수정
	public int updateMember(Connection conn, MemberVo vo) {
		int result = 0;
		String sql = "update member set m_pw=?, m_PHONE=?, m_address=?  where m_id=?";
		System.out.println("회원정보수정 dao vo:" + vo);
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getmPw());
			pstmt.setString(2, vo.getmPhone());
			pstmt.setString(3, vo.getmAddress());
			pstmt.setString(4, vo.getmId());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		System.out.println("회원정보수정 dao result:" + result);
			return result;
	}

	// 한 회원 삭제(강제 삭제)
	public int deleteMember(Connection conn, String mId) { 
		System.out.println("회원탈퇴 Dao, 아이디: " + mId);
		int result = 0;
		String sql = "delete from member where m_id=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mId);
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
	
	// 회원전체 삭제
	public int deleteAllMember(Connection conn) { 
		int result = 0;
		String sql = "delete from member";
		try {
			pstmt = conn.prepareStatement(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	// 회원 전체 읽기
	public ArrayList<MemberVo> readAllMember(Connection conn) { 
		ArrayList<MemberVo> retVolist = null; 
		String sql = "select * from member";
		try { 
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			retVolist = new ArrayList<MemberVo>();
			while (rs.next()) {
				MemberVo vo = new MemberVo();
				vo.setmId(rs.getString("m_Id"));
				vo.setmPw(rs.getString("m_pw"));
				vo.setmName(rs.getString("M_NAME"));
				vo.setmNickname(rs.getString("m_Nickname"));
				vo.setmBirth(rs.getString("m_Birth"));
				vo.setmAddress(rs.getString("m_Address"));			
				vo.setmPhone(rs.getString("m_phone"));
			    vo.setmEmail(rs.getNString("m_Email"));
				vo.setGenderFm(rs.getNString("gender_Fm"));
				vo.setRoleSt(rs.getString("role_St"));
				vo.setmDate(rs.getTimestamp("m_Date"));
				vo.setmAlarmYn(rs.getString("M_ALARM_YN"));
				
				retVolist.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally { 
			close(pstmt);
		}
		return retVolist;
	}
}
