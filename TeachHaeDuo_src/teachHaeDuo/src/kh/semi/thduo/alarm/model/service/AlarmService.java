package kh.semi.thduo.alarm.model.service;

import static kh.semi.thduo.common.jdbc.JdbcTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;

import kh.semi.thduo.alarm.model.dao.AlarmDao;
import kh.semi.thduo.alarm.model.vo.AlarmVo;

public class AlarmService {
	private AlarmDao dao = new AlarmDao();
	
	public int sendAlarm(AlarmVo vo) {
		int result = 0;
		Connection conn = null;

		conn = getConnection();
		result = dao.sendAlarm(conn, vo);

		close(conn);

		return result;
	}
	
	public ArrayList<AlarmVo> sendListAlarm(String mNickname){
		
		Connection conn = null;
		conn = getConnection();
		ArrayList<AlarmVo> voList = dao.sendListAlarm(conn, mNickname);
		close(conn);
		
		return voList;
	}
	public ArrayList<AlarmVo> receiveListAlarm(String mNickname){
		
		Connection conn = null;
		conn = getConnection();
		ArrayList<AlarmVo> voList = dao.receiveListAlarm(conn, mNickname);
		close(conn);
		
		return voList;
	}
	
}
