package kh.semi.thduo.pencil.model.dao;

import static kh.semi.thduo.common.jdbc.JdbcTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import kh.semi.thduo.pencil.model.vo.PencilVo;

public class PencilDao {
	private Statement stmt = null;
	private ResultSet rs = null;
	private PreparedStatement pstmt = null;
	
	public int plusPencil(Connection conn, PencilVo vo) {
		System.out.println("충전하기 dao vo:"+ vo);
		int result = 0;
		String sql ="insert into check_pencil (cp_no, cp_content, cp_cash, cp_date,m_id) values ((select (nvl(max(cp_no)+1,0)) from check_pencil where m_id=?), '연필충전', ?, default,?)";
		
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
		
		System.out.println("충전하기 dao result:"+ result);
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
			
			if(rs.next()) {
				result = rs.getInt("cp_sum");
			}
			
		} catch(SQLException e) {
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
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
		
	}
	public ArrayList<PencilVo> listPencil(Connection conn, String mId) {
		ArrayList<PencilVo> voList = null;
		String sql = "select cp_content, cp_cash, cp_date from check_pencil where m_id=? order by cp_date desc";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mId);
			rs = pstmt.executeQuery();
			
			if(rs != null) {
				voList = new ArrayList<PencilVo>();
				while(rs.next()) {
					PencilVo vo = new PencilVo();
					vo.setCpContent(rs.getString("cp_Content"));
					vo.setCpDate(rs.getTimestamp("cp_Date"));
					vo.setCpCash(rs.getInt("cp_cash"));
					voList.add(vo);
				}
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		
		return voList;
		
	}
}
