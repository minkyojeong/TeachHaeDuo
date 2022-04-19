package test.kh.semi.thduo.member.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import test.kh.semi.thduo.member.model.vo.MemberVo;

import static kh.semi.thduo.common.jdbc.JdbcTemplate.close;



public class MemberDao {
	// 기본으로 있어야 할것들! 심화과정빼고 일단 기본기능들만!
	private Statement stmt = null;;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

//	DAO - insert / select 단일행 / select 여러행 / update / delete
	public int insertMember(Connection conn, MemberVo vo) {
		int result = 0; // 1. 리턴자료형으로 리턴변수 선언 + 초기값
		// 2. sql문 작성 - 메소드 기능을 기반으로
		// 개발 초기라면 테이블명 (컬명, 컬명,...) values (값,값,...) 컬명 꼭 적어줘~ 막 바뀌고 하니까
		String sql = "insert into member (M_ID, M_NICKNAME, EMAIL, PHONE, PASSWORD ) values (?,?,?,?,?)";

		try { // 4. try-catch
			pstmt = conn.prepareStatement(sql); // 3. pstmt / stmt 생성
			// 7. sql문에 채워줄 값들 채우기 - 2,3을 기반으로
			pstmt.setString(1, vo.getmId());
			pstmt.setString(2, vo.getmNickname());
			pstmt.setString(3, vo.getEmail());
			pstmt.setString(4, vo.getPhone());
			pstmt.setString(5, vo.getPassword());

			// 8. sql문 실행 - 2번 기반. (executeUpdate / executeQuery)메소스 선택, 리턴변수(int ,
			// ResultSet) 결정
			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally { // 5. finally
			// 6. 사용한 객체 close , rs는 select문일경우에! 나머지는 3번에 따라!
			close(pstmt);
		}
		// 리턴변수에 결과값을 채우는 것이 메소드(함수)의 목표!!!!
		return result; // 1. 리턴변수 값을 리턴함
	}
	
	public int updateNickname(Connection conn,String mId, String newName) {
		int result = 0;
		String sql = "update member set m_nickname=? where m_id = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, newName);
			pstmt.setString(2, mId);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
	public int updateEmail(Connection conn,String mId, String newEmail) {
		int result = 0;
		String sql = "update member set email=? where m_id = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, newEmail);
			pstmt.setString(2, mId);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
	public int updatePhone(Connection conn,String mId, String newPhone) {
		int result = 0;
		String sql = "update member set phone=? where m_id = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, newPhone);
			pstmt.setString(2, mId);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
	public int updatePassword(Connection conn,String mId, String newPass) {
		int result = 0;
		String sql = "update member set password=? where m_id = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, newPass);
			pstmt.setString(2, mId);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	public int deleteMember(Connection conn, String mId) { // 주로 pk를 가지고 delete를 시도해! 100%는 아니지만..
		int result = 0;
		String sql = "delete from member where m_id = ?";
		// 포린키 묶을때 on delete cascade , set null 안줬기 때문에 댓글 지우고, 게시글 지우고 그리고 멤버 지워야돼
		// 이 작업은 service에서 해줘~

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

	public int deleteAllMember(Connection conn) { //
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

//	public ArrayList<MemberVo> loginMember(Connection conn) {
//		MemberVo revo = null;
//		ArrayList<MemberVo> revolist = null;
//		String sql = "select m_id, password from member";
//		try {
//			pstmt = conn.prepareStatement(sql);
//			rs = pstmt.executeQuery();
//			if (rs.next()) {
//				revolist = new ArrayList<MemberVo>();
//				do {
//				revo = new MemberVo();
//				revo.setmId(rs.getString("m_id"));
//				revo.setPassword(rs.getString("password"));
//				revolist.add(revo);
//				} while(rs.next());
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			close(pstmt);
//		}
//		return revolist;
//	}
	public MemberVo loginMember(Connection conn, MemberVo vo) {
		MemberVo revo = null;
		String sql = "select m_id from member where m_id=? and password=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getmId());
			pstmt.setString(2, vo.getPassword());
			rs = pstmt.executeQuery();
			if (rs.next()) {
				revo = new MemberVo();
				revo.setmId(rs.getString(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return revo;
	}

	public MemberVo readOneMember(Connection conn, String mId) {
		MemberVo retVo = null; // ret 리턴하는거라고 그냥 티 내주는거야
		String sql = "select * from member where m_id = ?";

		try {
			pstmt = conn.prepareStatement(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return retVo;
	}

	public ArrayList<MemberVo> readAllMember(Connection conn) {
		ArrayList<MemberVo> retVolist = null; // 1. 리턴자료형으로 리턴변수 선언 + 초기값
		String sql = "select * from member";

		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			// 9. 리번변수의 자료형이 참조자료형이면 객체 생성 ( 기본자료형이면 x )
			retVolist = new ArrayList<MemberVo>();
			// 10. rs.next() if / while- 2번 sql 문의 결과가 단일행이면 if , 여러행이면 while
			while (rs.next()) {
				// 11. 10-while + 1-<제너릭>이 참조자료형이면 참조자료형으로 객체 생성
				// rs에 담긴걸 꺼내서 저장창고 vo에 담아야되기 때문에 , 저장창고vo 도 new 해줘야돼
				MemberVo vo = new MemberVo();
				// 12. rs.getxxx("컬럼라벨") - rs의 각 컬럼에서 값읽기
				vo.setEmail(rs.getString("email"));
				vo.setmId(rs.getString("m_Id"));
				vo.setmNickname(rs.getString("m_Nickname"));
				vo.setPassword(rs.getString("password"));
				vo.setPhone(rs.getString("phone"));

				// 리턴변수에 값 채우기
				retVolist.add(vo);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return retVolist;
	}
	
	public int countMember(Connection conn) {
		int result = 0;
		String sql = "select count(*) cnt from Member";

		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				result = rs.getInt("cnt");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}
	public ArrayList<MemberVo> listMember(Connection conn, int startRnum, int endRnum) {
		ArrayList<MemberVo> volist = null;

		String sql = "select * from " + "(select rownum r, t1.* from "
				+ "(select t1.* from "
				+ "member t1 order by m_id) t1) " + "where r between ? and ?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startRnum);
			pstmt.setInt(2, endRnum);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				volist = new ArrayList<MemberVo>();
				do {

					MemberVo vo = new MemberVo();

					vo.setmId(rs.getString("m_id"));
					vo.setEmail(rs.getString("email"));
					vo.setmNickname(rs.getString("m_nickname"));
					vo.setPassword(rs.getString("password"));
					vo.setPhone(rs.getString("phone"));

					volist.add(vo);

				} while (rs.next());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}

		return volist;

	}
	
	public MemberVo searchMemberId(Connection conn, String mId) {
		MemberVo vo = null;
		String sql = "select * from member where m_id =?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mId);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				vo = new MemberVo();
				vo.setEmail(rs.getString("email"));
				vo.setmId(rs.getString("m_Id"));
				vo.setmNickname(rs.getString("m_Nickname"));
				vo.setPassword(rs.getString("password"));
				vo.setPhone(rs.getString("phone"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return vo;
	}
	public MemberVo searchMemberNickname(Connection conn, String nickname) {
		MemberVo vo = null;
		String sql = "select * from member where m_nickname =?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, nickname);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				vo = new MemberVo();
				vo.setEmail(rs.getString("email"));
				vo.setmId(rs.getString("m_Id"));
				vo.setmNickname(rs.getString("m_Nickname"));
				vo.setPassword(rs.getString("password"));
				vo.setPhone(rs.getString("phone"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return vo;
	}
	public MemberVo searchMemberEmail(Connection conn, String email) {
		MemberVo vo = null;
		String sql = "select * from member where email =?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, email);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				vo = new MemberVo();
				vo.setEmail(rs.getString("email"));
				vo.setmId(rs.getString("m_Id"));
				vo.setmNickname(rs.getString("m_Nickname"));
				vo.setPassword(rs.getString("password"));
				vo.setPhone(rs.getString("phone"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return vo;
	}
	public MemberVo searchMemberPhone(Connection conn, String phone) {
		MemberVo vo = null;
		String sql = "select * from member where phone =?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, phone);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				vo = new MemberVo();
				vo.setEmail(rs.getString("email"));
				vo.setmId(rs.getString("m_Id"));
				vo.setmNickname(rs.getString("m_Nickname"));
				vo.setPassword(rs.getString("password"));
				vo.setPhone(rs.getString("phone"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return vo;
	}
	
	public MemberVo login(Connection conn, String mId, String pw) {
		MemberVo retVo = null; // ret 리턴하는거라고 그냥 티 내주는거야
		String sql = "select * from member where m_id = ? and M_PW=?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mId);
			pstmt.setString(2, pw);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				retVo = new MemberVo();
				retVo.setmId(rs.getString("m_Id"));
				retVo.setPassword(rs.getString("M_PW"));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return retVo;
	}

}
