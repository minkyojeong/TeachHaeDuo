package kh.semi.thduo.pencil.model.dao;

import static kh.semi.thduo.common.jdbc.JdbcTemplate.close;
import static kh.semi.thduo.common.jdbc.JdbcTemplate.getConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import kh.semi.thduo.member.vo.MemberVo;
import kh.semi.thduo.pencil.model.vo.PencilVo;

public class PencilDao {
	private Statement stmt = null;
	private ResultSet rs = null;
	private PreparedStatement pstmt = null;

	// 연필 충전
	public int plusPencil(Connection conn, PencilVo vo) {
		System.out.println("충전하기 dao vo:" + vo);
		int result = 0;
		String sql = "insert into check_pencil (cp_no, cp_content, cp_cash, cp_date,m_id) values ((select (nvl(max(cp_no)+1,0)) from check_pencil where m_id=?), '연필충전', ?, default,?)";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getmId());
			pstmt.setInt(2, vo.getCpCash());
			pstmt.setString(3, vo.getmId());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		System.out.println("충전하기 dao result:" + result);
		return result;

	}

	// 연필 잔액 확인
	public int checkPencil(Connection conn, String mId) {
		int result = 0;
		String sql = "SELECT SUM(cp_cash) cp_sum FROM check_pencil WHERE m_id = ? GROUP BY m_id";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mId);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				result = rs.getInt("cp_sum");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}

		return result;
	}

	// 연필 차감 내역 삽입
	public int minusPencil(Connection conn, PencilVo vo) {
		int result = 0;
		String sql = "INSERT INTO check_pencil(cp_no, cp_content, cp_cash, cp_date, m_id) "
				+ "VALUES((SELECT NVL(MAX(cp_no), 0) + 1 FROM check_pencil WHERE m_id = ?), ?, ?, default, ?)";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getmId());
			pstmt.setString(2, vo.getCpContent());
			pstmt.setInt(3, vo.getCpCash());
			pstmt.setString(4, vo.getmId());

			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;

	}

	// 연필 사용 내역
	public ArrayList<PencilVo> listPencil(Connection conn, String mId) {
		ArrayList<PencilVo> voList = null;
		String sql = "select cp_content, cp_cash, cp_date from check_pencil where m_id=? order by cp_date desc";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mId);
			rs = pstmt.executeQuery();

			if (rs != null) {
				voList = new ArrayList<PencilVo>();
				while (rs.next()) {
					PencilVo vo = new PencilVo();
					vo.setCpContent(rs.getString("cp_Content"));
					vo.setCpDate(rs.getTimestamp("cp_Date"));
					vo.setCpCash(rs.getInt("cp_cash"));
					voList.add(vo);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return voList;
	}

	// 회원가입시 기본 연필 테이블 insert
	public int insertPencilInit(Connection conn, String mId) {
		int result = 0;
		String sql = "insert into check_pencil(CP_NO, M_ID, CP_CONTENT, CP_cash,CP_DATE) values(0,?,'회원가입',0,default)";

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

	// 관리자 전체 매출 조회
	public ArrayList<MemberVo> allPencilChart(Connection conn) {
		ArrayList<MemberVo> voList = null;

		String sql="select cp_date, cp_cash, p.m_id, m.m_name, m.role_st, m.m_phone, m.m_email, m.gender_fm from check_pencil p join member m on p.m_id = m.m_id where cp_cash>0 order by cp_date desc";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if(rs != null) {
				voList = new ArrayList<MemberVo>();
				while(rs.next()) {
					MemberVo vo = new MemberVo();
					vo.setCpCash(rs.getString("cp_Cash"));
					vo.setCpDate(rs.getTimestamp("cp_Date"));
					vo.setGenderFm(rs.getString("gender_Fm"));
					vo.setmEmail(rs.getString("m_Email"));
					vo.setmId(rs.getString("m_Id"));
					vo.setmName(rs.getString("m_Name"));
					vo.setmPhone(rs.getString("m_Phone"));
					vo.setRoleSt(rs.getString("role_St"));
					voList.add(vo);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return voList;
	}
	
	// 관리자 이번달 매출 조회
	public ArrayList<MemberVo> monthPencilChart(Connection conn) {
		ArrayList<MemberVo> voList = null;

		String sql="select cp_date, cp_cash, p.m_id, m.m_name, m.role_st, m.m_phone, m.m_email, m.gender_fm from check_pencil p join member m on p.m_id = m.m_id where cp_cash>0 and (SUBSTR(to_char(cp_date,'yymm'),0,4))=SUBSTR(to_char(sysdate,'yymm'),0,4) order by cp_date desc";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if(rs != null) {
				voList = new ArrayList<MemberVo>();
				while(rs.next()) {
					MemberVo vo = new MemberVo();
					vo.setCpCash(rs.getString("cp_Cash"));
					vo.setCpDate(rs.getTimestamp("cp_Date"));
					vo.setGenderFm(rs.getString("gender_Fm"));
					vo.setmEmail(rs.getString("m_Email"));
					vo.setmId(rs.getString("m_Id"));
					vo.setmName(rs.getString("m_Name"));
					vo.setmPhone(rs.getString("m_Phone"));
					vo.setRoleSt(rs.getString("role_St"));
					voList.add(vo);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return voList;
	}
	
	// 관리자 이번년도 매출 조회
	public ArrayList<MemberVo> yearPencilChart(Connection conn) {
		ArrayList<MemberVo> voList = null;

		String sql="select cp_date, cp_cash, p.m_id, m.m_name, m.role_st, m.m_phone, m.m_email, m.gender_fm from check_pencil p join member m on p.m_id = m.m_id where cp_cash>0 and (to_char(cp_date,'yy'))=to_char(sysdate,'yy') order by cp_date desc";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if(rs != null) {
				voList = new ArrayList<MemberVo>();
				while(rs.next()) {
					MemberVo vo = new MemberVo();
					vo.setCpCash(rs.getString("cp_Cash"));
					vo.setCpDate(rs.getTimestamp("cp_Date"));
					vo.setGenderFm(rs.getString("gender_Fm"));
					vo.setmEmail(rs.getString("m_Email"));
					vo.setmId(rs.getString("m_Id"));
					vo.setmName(rs.getString("m_Name"));
					vo.setmPhone(rs.getString("m_Phone"));
					vo.setRoleSt(rs.getString("role_St"));
					voList.add(vo);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return voList;
	}
}
