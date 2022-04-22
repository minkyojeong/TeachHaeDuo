package kh.semi.thduo.alarm.model.service;

import static kh.semi.thduo.common.jdbc.JdbcTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;

import kh.semi.thduo.alarm.model.dao.AlarmDao;
import kh.semi.thduo.alarm.model.vo.AlarmVo;

public class AlarmService {
	private AlarmDao dao = new AlarmDao();
	
	public int sendAlarm(AlarmVo vo) {
		
		Connection conn = null;
		conn = getConnection();
		int result = dao.sendAlarm(conn, vo);
		close(conn);
		
		return result;
	}
	
	public ArrayList<AlarmVo> sendListAlarm(String mId){
		
		Connection conn = null;
		conn = getConnection();
		ArrayList<AlarmVo> voList = dao.sendListAlarm(conn, mId);
		close(conn);
		
		return voList;
	}
	public ArrayList<AlarmVo> receiveListAlarm(String mId){
		
		Connection conn = null;
		conn = getConnection();
		ArrayList<AlarmVo> voList = dao.sendListAlarm(conn, mId);
		close(conn);
		
		return voList;
	}
	
}