package kh.semi.thduo.like.model.dao;

import static kh.semi.thduo.common.jdbc.JdbcTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import kh.semi.thduo.like.model.vo.LikeVo;

public class LikeDao {
	private Statement stmt = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	// 찜하기 삽입
	public int insertLike(Connection conn, String m_id, String t_no) {
		int result = 0;
		String sql = "INSERT INTO dibs(s_no, t_no) "
				+ "SELECT (SELECT s_no FROM member_student WHERE m_id = ?), ? "
				+ "FROM dual";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, m_id);
			pstmt.setString(2, t_no);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	// 찜하기 취소
	public int deleteLike(Connection conn, String s_no, String t_no) {
		int result = 0;
		String sql = "DELETE FROM dibs WHERE s_no = ? AND t_no = ?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, s_no);
			pstmt.setString(2, t_no);
			
			result = pstmt.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	// 자기가 찜한 선생님 리스트 모두 보기
	public ArrayList<LikeVo> readLikeList(Connection conn, String s_no) {
		ArrayList<LikeVo> retVolist = null;
		String sql = "select s_no, t_no, m_nickname from dibs "
				+ "join t_profile using(t_no) "
				+ "join member using(m_id)where s_no=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, s_no);
			rs = pstmt.executeQuery();
			if(rs != null) {
				retVolist = new ArrayList<LikeVo>();
				while(rs.next()) {
					LikeVo vo = new LikeVo();
					vo.setS_no(rs.getString("s_no"));
					vo.setT_no(rs.getString("t_no"));
					vo.setmNickname(rs.getString("m_Nickname"));
					retVolist.add(vo);
				}
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return retVolist;
	}
	
	public int numberOfLike(Connection conn, String sNo) {
		int result = 0 ;
		String sql = "select count(*) cnt from dibs where s_no=?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, sNo);
			rs = pstmt.executeQuery();
			
			if(rs != null) {
				while(rs.next()) {
					result = rs.getInt("cnt");
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return result;
	}
}
