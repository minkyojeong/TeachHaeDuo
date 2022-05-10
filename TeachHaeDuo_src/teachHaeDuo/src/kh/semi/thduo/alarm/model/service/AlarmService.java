package kh.semi.thduo.alarm.model.service;

import static kh.semi.thduo.common.jdbc.JdbcTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;

import kh.semi.thduo.alarm.model.dao.AlarmDao;
import kh.semi.thduo.alarm.model.vo.AlarmVo;
import kh.semi.thduo.member.vo.MemberVo;

public class AlarmService {
	private AlarmDao dao = new AlarmDao();

	// 쪽지보내기
	public int sendAlarm(AlarmVo vo) {
		int result = 0;
		Connection conn = null;

		conn = getConnection();
		
		result = dao.sendAlarm(conn, vo);
		if (result == 0) {
			rollback(conn);
		} else {
			commit(conn);
		}

		close(conn);

		return result;
	}

	// 보낸 알람 리스트
	public ArrayList<AlarmVo> sendListAlarm(String mNickname) {

		Connection conn = null;
		conn = getConnection();
		ArrayList<AlarmVo> voList = dao.sendListAlarm(conn, mNickname);
		close(conn);

		return voList;
	}
	
	// 보낸 알람 횟수
	public int numberOfSendAlarm(String mNickname) {
		System.out.println("보낸 건수 서비스 mNickname:" + mNickname);
		int result = 0;
		Connection conn = null;
		conn = getConnection();
		result = dao.numberOfSendAlarm(conn, mNickname);
		System.out.println("보낸 건수 서비스 result:" + result);
		close(conn);

		return result;
	}

	// 받은 알람 리스트
	public ArrayList<AlarmVo> receiveListAlarm(String mNickname) {

		Connection conn = null;
		conn = getConnection();
		ArrayList<AlarmVo> voList = dao.receiveListAlarm(conn, mNickname);
		close(conn);

		return voList;
	}
	
	// 받은 알람 횟수
	public int numberOfReceiveAlarm(String mNickname) {
		int result = 0;
		Connection conn = null;
		conn = getConnection();
		result = dao.numberOfReceiveAlarm(conn, mNickname);
		close(conn);

		return result;
	}

	// 모든 알람 리스트
	public ArrayList<AlarmVo> allListAlarm(String mNickname) {

		Connection conn = null;
		conn = getConnection();
		ArrayList<AlarmVo> voList = dao.allListAlarm(conn, mNickname);
		close(conn);

		return voList;
	}

	// 알람 수신거부
	public int alarmYNChange(MemberVo vo) {
		int result = 0;
		Connection conn = null;

		conn = getConnection();
		result = dao.alarmYNChange(conn, vo);
		if (result == 1) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);

		return result;
	}
	
	// 받은 알람 아이디 리스트
	public ArrayList<AlarmVo> receiveIdList(String mNickname) {

		Connection conn = null;
		conn = getConnection();
		ArrayList<AlarmVo> idList = dao.receiveIdList(conn, mNickname);
		close(conn);

		return idList;
	}
}
