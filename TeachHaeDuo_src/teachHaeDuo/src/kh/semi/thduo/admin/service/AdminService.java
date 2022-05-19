package kh.semi.thduo.admin.service;

import static kh.semi.thduo.common.jdbc.JdbcTemplate.close;
import static kh.semi.thduo.common.jdbc.JdbcTemplate.commit;
import static kh.semi.thduo.common.jdbc.JdbcTemplate.getConnection;
import static kh.semi.thduo.common.jdbc.JdbcTemplate.rollback;
import static kh.semi.thduo.common.jdbc.JdbcTemplate.setAutocommit;

import java.sql.Connection;

import org.apache.ibatis.session.SqlSession;

import kh.semi.thduo.admin.dao.AdminDao;
import kh.semi.thduo.admin.vo.AdminVo;
import kh.semi.thduo.alarm.model.vo.AlarmVo;
import kh.semi.thduo.common.jdbc.JdbcUtil;

public class AdminService {

	private AdminDao dao = new AdminDao();

	// 관리자 로그인 ok
	public AdminVo login(String adminId, String adminPw) {
		AdminVo retVo = null;
		Connection conn = getConnection();
		retVo = dao.login(conn, adminId, adminPw);
		close(conn);
		return retVo;
	}

	// 관리자 승인비승인 알람 보내기
	public int sendApprovalAlarm(AlarmVo vo) {
		int result = 0;
		System.out.println("sendApprovalAlarm service 진입:" + vo );
		SqlSession session = JdbcUtil.getSqlSession();
		result = dao.sendApprovalAlarm(session, vo);
		System.out.println("sendApprovalAlarm service result:" + result);
		// 2개 테이블 조작 할건데, 하나라도 실패해서 리턴값 0이 온다면 롤백
		if (result == 0) {
			session.rollback();
		} else { // 2개 다 성공하면 커밋
			session.commit();
		}
		return result;
	}

	// 관리자 자격박탈 알람 보내기
	public int sendTeacherCancelAlarm(AlarmVo vo) {
		int result = 0;
		System.out.println("sendTeacherCancelAlarm service 진입:" + vo);
		SqlSession session = JdbcUtil.getSqlSession();
		result = dao.sendTeacherCancelAlarm(session, vo);
		System.out.println("sendTeacherCancelAlarm service result:" + result);
		// 3개 테이블 조작 할건데, 하나라도 실패해서 리턴값 0이 온다면 롤백
		if (result == 0) {
			session.rollback();
		} else { // 2개 다 성공하면 커밋
			session.commit();
		}
		return result;
	}

}
