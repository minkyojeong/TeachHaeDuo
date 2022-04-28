package kh.semi.thduo.review.model.dao;

import static kh.semi.thduo.common.jdbc.JdbcTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import kh.semi.thduo.review.model.vo.ReviewVo;

public class ReviewDao {
	private Statement stmt = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	// 해당 선생님에게 쪽지전송 여부 확인
	public int checkMessage(Connection conn, String alarm_sendid, String alarm_receiveid) {
		int result = 0;
		String sql = "SELECT COUNT(*) cnt FROM alarm where alarm_sendid = ? AND alarm_receiveid = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, alarm_sendid);
			pstmt.setString(2, alarm_receiveid);
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result = rs.getInt("cnt");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return result;
	}
	
	// 리뷰 삽입
	public int insertReview(Connection conn, ReviewVo vo) {
		int result = 0;
		String sql = "INSERT INTO t_review(T_R_NO, T_NO, T_R_CONTENT, T_R_DATE, T_R_SCORE, T_R_WRITER, M_ID) "
				+ "VALUES((SELECT NVL(MAX(t_r_no), 0) + 1 FROM t_review), ?, ?, default, ?, ?, ?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getT_no());
			pstmt.setString(2, vo.getT_r_content());
			pstmt.setInt(3, vo.getT_r_score());
			pstmt.setString(4, vo.getT_r_writer());
			pstmt.setString(5, vo.getM_id());
			
			result = pstmt.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	} 
	
	// 리뷰 삭제
	public int deleteReview(Connection conn, int t_r_no) {
		int result = 0;
		String sql = "DELETE FROM t_review WHERE t_r_no = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, t_r_no);
			
			result = pstmt.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}
	
	// 리뷰 모두 읽기
	public ArrayList<ReviewVo> readAllReview(Connection conn) {
		ArrayList<ReviewVo> retVolist = null;
		String sql = "SELECT t_r_no, t_r_writer, m_id, t_no, t_r_content, TO_CHAR(t_r_date, 'YYYY-MM-DD HH24:MI:SS') t_r_date, t_r_score "
				+ "FROM t_review";
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				retVolist = new ArrayList<ReviewVo>();
				do {
					ReviewVo rvo = new ReviewVo();
					rvo.setT_r_no(rs.getInt("t_r_no"));
					rvo.setT_no(rs.getString("t_no"));
					rvo.setT_r_content(rs.getString("t_r_content"));
					rvo.setT_r_date(rs.getTimestamp("t_r_date"));
					rvo.setT_r_score(rs.getInt("t_r_score"));
					rvo.setT_r_writer(rs.getString("t_r_writer"));
					rvo.setM_id(rs.getString("m_id"));
					retVolist.add(rvo);
				} while(rs.next());
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return retVolist;
	}
}
