package kh.semi.thduo.admin.dao;

import static kh.semi.thduo.common.jdbc.JdbcTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import kh.semi.thduo.admin.vo.AdminVo;
import kh.semi.thduo.member.vo.MemberVo;

public class AdminDao {
	private Statement stmt = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	public AdminVo login(Connection conn, String adminId, String adminPw) { 
		AdminVo retVo = null;
		String sql = "SELECT ADMIN_ID, ADMIN_PW FROM ADMIN where ADMIN_ID=? and ADMIN_PW=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, adminId);
			pstmt.setString(2, adminPw);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				retVo = new AdminVo();
				
				retVo.setAdminId(rs.getString("admin_Id"));
				retVo.setAdminPw(rs.getString("admin_pw"));
				
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
}