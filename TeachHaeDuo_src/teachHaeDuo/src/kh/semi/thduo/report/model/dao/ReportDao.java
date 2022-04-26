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
	
	//신고 삽입
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
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}
	
	//모든 신고 내역 읽기
	public ArrayList<ReportVo> readAllReport(Connection conn) {
		ArrayList<ReportVo> retVolist = null;
		
		return retVolist;
	}
	
	//선택한 신고 내역 읽기
	public ReportVo readOneReport(Connection conn, int m_r_no) {
		ReportVo retVo = null;
		
		return retVo;
	} 
}
