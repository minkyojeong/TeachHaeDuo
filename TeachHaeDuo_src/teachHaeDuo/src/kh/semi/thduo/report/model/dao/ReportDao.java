package kh.semi.thduo.report.model.dao;

import static kh.semi.thduo.common.jdbc.JdbcTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import kh.semi.thduo.report.model.vo.ReportVo;

public class ReportDao {
	private Statement stmt = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	// 신고 삽입
	public int insertReport(Connection conn, ReportVo vo) {
		int result = 0;
		String sql = "INSERT INTO member_report(M_R_NO, M_R_SENDID, M_R_RECEIVEID, M_R_CATEGORY, M_R_CONTENT, M_R_DATE, M_ID) "
				+ "VALUES((SELECT NVL(MAX(m_r_no), 0) + 1 FROM member_report), ?, ?, ?, ?, default, ?)";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getM_r_sendid());
			pstmt.setString(2, vo.getM_r_receiveid());
			pstmt.setString(3, vo.getM_r_category());
			pstmt.setString(4, vo.getM_r_content());
			pstmt.setString(5, vo.getM_id());

			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}

	// 모든 신고 내역 읽기
	public ArrayList<ReportVo> readAllReport(Connection conn) {
		ArrayList<ReportVo> voList = null;
		String sql = "select t.t_no t_no, m_r_no, M_R_SENDID, m1.m_name send_name, M_R_RECEIVEID, m2.m_name receive_name, m2.m_nickname m_nickname, M_R_CATEGORY, M_R_CONTENT, M_R_DATE from member_report mr join member m1 on mr.m_r_sendid=m1.m_id join member m2 on mr.m_r_receiveid=m2.m_id join t_profile t on t.m_id=mr.m_r_receiveid";

		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs != null) {
				voList = new ArrayList<ReportVo>();
				while (rs.next()) {
					ReportVo vo = new ReportVo();
					vo.setM_r_category(rs.getString("m_r_category"));
					vo.setM_r_content(rs.getString("m_r_content"));
					vo.setM_r_receiveid(rs.getString("m_r_receiveid"));
					vo.setM_r_receiveName(rs.getString("receive_name"));
					vo.setM_r_sendid(rs.getString("m_r_sendid"));
					vo.setM_r_sendName(rs.getString("send_name"));
					vo.setT_r_date(rs.getTimestamp("m_r_date"));
					vo.setM_r_no(rs.getInt("m_r_no"));
					vo.setT_no(rs.getString("t_no"));
					vo.setM_r_receiveNickname(rs.getString("m_nickname"));
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

	// 선택한 신고 내역 읽기
	public ReportVo readOneReport(Connection conn, int rNo) {
		ReportVo rVo = null;
		String sql = "select m_r_no, M_R_SENDID, m1.m_name send_name, M_R_RECEIVEID, m2.m_name receive_name, M_R_CATEGORY, M_R_CONTENT, M_R_DATE from member_report mr join member m1 on mr.m_r_sendid=m1.m_id join member m2 on mr.m_r_receiveid=m2.m_id where m_r_no=?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, rNo);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				rVo = new ReportVo();
				rVo.setM_r_category(rs.getString("m_r_category"));
				rVo.setM_r_content(rs.getString("m_r_content"));
				rVo.setM_r_receiveid(rs.getString("m_r_receiveid"));
				rVo.setM_r_receiveName(rs.getString("receive_name"));
				rVo.setM_r_sendid(rs.getString("m_r_sendid"));
				rVo.setM_r_sendName(rs.getString("send_name"));
				rVo.setT_r_date(rs.getTimestamp("m_r_date"));
				rVo.setM_r_no(rs.getInt("m_r_no"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return rVo;
	}
}
