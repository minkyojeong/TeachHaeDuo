package kh.semi.thduo.student.dao;

import static kh.semi.thduo.common.jdbc.JdbcTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import kh.semi.thduo.student.vo.StudentVo;

public class StudentDao {
	private Statement stmt = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	// 회원가입시 학생S_no insert 
	public int insertStudent(Connection conn, StudentVo vo) {
		int result = 0;

		String sql = "INSERT INTO THDUO.MEMBER_STUDENT" + "(M_ID, S_NO)" + "VALUES(?, ?)";

		try {

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, vo.getmId());
			pstmt.setString(2, vo.getsNo());

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			close(pstmt);
		}

		return result;
	}

	// 학생S_no 체크
	public String readStudentCheck(Connection conn) {

		
		String result = "";
		String sql = "";
		sql = "select max(s_no) as s_no from MEMBER_STUDENT";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				result = rs.getString("s_no");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return result;
	}

}
