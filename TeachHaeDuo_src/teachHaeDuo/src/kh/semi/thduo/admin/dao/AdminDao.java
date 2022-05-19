package kh.semi.thduo.admin.dao;

import static kh.semi.thduo.common.jdbc.JdbcTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.ibatis.session.SqlSession;

import kh.semi.thduo.admin.vo.AdminVo;
import kh.semi.thduo.alarm.model.vo.AlarmVo;
import kh.semi.thduo.member.vo.MemberVo;

public class AdminDao {
	private Statement stmt = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	// 관리자 로그인 (DB id,pw 확인)
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

	// 관리자 승인비승인 알람 보내기
	public int sendApprovalAlarm(SqlSession session, AlarmVo vo) {
		int result = 0;
		System.out.println("sendApprovalAlarm dao 진입:" + vo);
		// 알람 테이블에 삽입, T_PROFILE 테이블엔 업데이트
		result = session.insert("adminMapper.sendApprovalAlarm", vo);
		if (result < 1) {
			System.out.println("알람 테이블 넣기 실패 result:" + result);
			return 0;
		} else { // 알람 테이블에 삽입 성공했다면 t_profile 업데이트
			result = session.update("adminMapper.updateApproval", vo);
			if (result == 0) { // t_profile 업데이트 실패
				System.out.println("선생님 테이블 넣기 실패 result:" + result);
				return 0;
			}
		}
		return result;
	}

	// 관리자 자격박탈 알람 보내기
	public int sendTeacherCancelAlarm(SqlSession session, AlarmVo vo) {
		int result = 0;
		System.out.println("sendTeacherCancelAlarm dao 진입:" + vo);
		// 알람 테이블에 삽입, T_PROFILE 테이블엔 업데이트, 신고 테이블에서는 삭제
		result = session.insert("adminMapper.sendTeacherCancelAlarm", vo);
		System.out.println("dao result1:" + result);
		// 알람 테이블에 삽입 실패했다면
		if (result < 1) {
			System.out.println("알람 테이블 넣기 실패 result:" + result);
			return 0;
		} else { // 알람 테이블에 삽입 성공했다면 t_profile 업데이트
			result = session.update("adminMapper.updateApproval", vo);
			System.out.println("dao result2:" + result);
			if (result == 0) { // t_profile 업데이트 실패시
				System.out.println("선생님 테이블 넣기 실패 result:" + result);
				return 0;
			} else { // t_profile 업데이트도 성공했다면 신고 테이블에 delete
				System.out.println("선생님 테이블 넣기 성공 result:" + result);
				result = session.delete("adminMapper.deleteReport", vo);
				System.out.println("dao result3:" + result);
				if (result == 0) { // 신고 테이블 delete 실패시
					System.out.println("신고테이블 테이블 삭제 실패 result:" + result);
					return 0;
				}
			}
		}
		return result;
	}
}