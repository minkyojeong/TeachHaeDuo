package kh.semi.thduo.teacher.model.vo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import kh.semi.thduo.alarm.model.vo.AlarmVo;
import kh.semi.thduo.member.vo.MemberVo;

import static kh.semi.thduo.common.jdbc.JdbcTemplate.close;

public class RecruitYNChangeDao {
	private Statement stmt = null;
	private ResultSet rs = null;
	private PreparedStatement pstmt = null;
	
	
	public int recruitYNChange(Connection conn, MemberVo vo) {
		int result = 0;
		String sql = "";
		String yn = vo.gettRecruitYn();
		if(yn.equals("Y")) {
			sql = "update t_profile set T_RECRUIT_YN = " + "'N' where m_id =? ";
		} else {
			sql = "update t_profile set T_RECRUIT_YN = " + "'Y' where m_id =? ";
		}
		
		if(sql != "") {
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, vo.getmId());
				result = pstmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close(pstmt);
			}
		}
		return result;
	}
	
	
}






