package kh.semi.thduo.teacher.model.service;

import static kh.semi.thduo.common.jdbc.JdbcTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;

import kh.semi.thduo.alarm.model.dao.AlarmDao;
import kh.semi.thduo.alarm.model.vo.AlarmVo;
import kh.semi.thduo.member.vo.MemberVo;
import kh.semi.thduo.teacher.model.vo.RecruitYNChangeDao;

public class RecruitYNChangeService {
	private RecruitYNChangeDao dao = new RecruitYNChangeDao();
	
	
	public int recruitYNChange(MemberVo vo) {
		int result = 0;
		Connection conn = null;

		conn = getConnection();
		result = dao.recruitYNChange(conn, vo);
		if(result == 1) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);

		return result;
	}
	
}
