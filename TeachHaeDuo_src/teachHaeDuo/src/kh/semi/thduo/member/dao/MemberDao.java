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
	
	   // 체크
		public int readMemberCheck(Connection conn, String str, String type) { 
			
			System.out.println("str2 = "+str);
			
			int result = 0;
			String sql = "";
			if (type.equals("mId")) {
				sql = "select count(*) as cnt from member where M_ID=?";
			}else if (type.equals("mEmail")) {
				sql = "select count(*) as cnt from member where M_EMAIL=?";
			}else if (type.equals("mNickName")) {
				sql = "select count(*) as cnt from member where M_NickName=?";
			}
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, str);
				rs = pstmt.executeQuery();
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
		String sql = "SELECT M_ID, M_PW, M_NAME, M_NICKNAME, M_BIRTH, M_ADDRESS, M_PHONE, M_EMAIL, GENDER_FM, ROLE_ST, M_DATE, M_CERTIFICATE, M_ALARM_YN FROM MEMBER where M_ID=? and M_PW=?";
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
		String sql = "update member set M_NICKNAME=?, m_EMAIL=?, m_PHONE=?, m_PW=?  where m_id=?";
		try {
			pstmt = conn.prepareStatement(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
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
		ArrayList<MemberVo> retVolist = null; // 1. 리턴자료형으로 리턴변수 선언 + 초기값
		// 2. sql문 작성 - 메소드 기능을 기반으로 - 개발초기라면 테이블명 (컬명, 컬명,..) values (값,...)
		String sql = "select * from member";
		try { // 4. try-catch
				// 3. pstmt/stmt 생성 - 2sql문 pstmt(?, 없는경우) / stmt(없는경우) 선택
			pstmt = conn.prepareStatement(sql);
			// 7. sql문에 채워줄 값들 채우기 - 2,3기반으로 ?확인. 컬럼자료형 pstmt.setXxx(1, 값); 주로 pstmt.setInt
			// /setString / setDate /...
			// 8. sql문 실행 - 2기반으로 메소드(executeUpdate / executeQuery)결정, 리턴변수(int / ResultSet)
			// 결정
			rs = pstmt.executeQuery();
			// 9. 리턴변수의 자료형이 참조자료형이면 객체생성 (기본자료형x)
			retVolist = new ArrayList<MemberVo>();
			// 10. rs.next() - if / while -2sql문의 결과가 단일행이면 if / 결과가 여러행이면 while
			while (rs.next()) {
				// 11. 10-while + 1-<제너릭>-참조자료형 - 객체생성
				MemberVo vo = new MemberVo();
				// 12. rs.getXxx("컬럼라벨") -rs의 각컬럼에서 값 읽기 - 읽씹no - 11또는9변수넣어주기
				vo.setmEmail(rs.getString("m_email"));
				vo.setmId(rs.getString("m_Id"));
				vo.setmNickname(rs.getString("m_NickName"));
				vo.setmPw(rs.getString("m_pw"));
				vo.setmPhone(rs.getString("m_phone"));
				// 13. 리턴변수에 값 넣기
				// 목표 완료 - 리턴변수에 값 채움
				retVolist.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally { // 5. finally
			// 6. 사용한 객체 close - 2sql문기반 rs(select경우), 3 stmt/pstmt - import close 메소드 추가
			close(pstmt);
		}
		// result = 값; // 리턴변수에 결과값을 채우는 것이 메소드(함수)의 목표!!!
		return retVolist; // 1. 리턴변수 값을 리턴함.
	}

	
}
