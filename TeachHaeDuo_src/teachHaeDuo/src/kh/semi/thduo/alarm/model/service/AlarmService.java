package kh.semi.thduo.alarm.model.service;


import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kh.semi.thduo.alarm.model.dao.AlarmDao;
import kh.semi.thduo.alarm.model.vo.AlarmVo;
import kh.semi.thduo.common.jdbc.JdbcUtil;
import kh.semi.thduo.member.vo.MemberVo;
import kh.semi.thduo.teacher.model.service.TeacherService;

public class AlarmService {
	private AlarmDao dao = new AlarmDao();

	// 쪽지보내기
	public int sendAlarm(AlarmVo vo) {
		int result = 0;
		SqlSession session = JdbcUtil.getSqlSession();
		result = dao.sendAlarm(session, vo);
		return result;
	}

	// 보낸 알람 리스트
	public List<AlarmVo> sendListAlarm(String mNickname) {
		SqlSession session = JdbcUtil.getSqlSession();
		List<AlarmVo> voList = dao.sendListAlarm(session, mNickname);
		return voList;
	}

	// 보낸 알람 횟수
	public int numberOfSendAlarm(String mNickname) {
		System.out.println("보낸 건수 서비스 mNickname:" + mNickname);
		SqlSession session = JdbcUtil.getSqlSession();
		int result = dao.numberOfSendAlarm(session, mNickname);
		System.out.println("보낸 건수 서비스 result:" + result);
		return result;
	}

	// 받은 알람 리스트
	public List<AlarmVo> receiveListAlarm(String mNickname) {
		SqlSession session = JdbcUtil.getSqlSession();
		List<AlarmVo> voList = dao.receiveListAlarm(session, mNickname);
		return voList;
	}

	// 받은 알람 횟수
	public int numberOfReceiveAlarm(String mNickname) {
		int result = 0;
		SqlSession session = JdbcUtil.getSqlSession();
		result = dao.numberOfReceiveAlarm(session, mNickname);
		return result;
	}

	// 모든 알람 리스트
	public List<AlarmVo> allListAlarm(String mNickname) {
		SqlSession session = JdbcUtil.getSqlSession();
		List<AlarmVo> voList = dao.allListAlarm(session, mNickname);
		return voList;
	}

	// 알람 수신거부
	public int alarmYNChange(MemberVo vo) {
		int result = 0;
		SqlSession session = JdbcUtil.getSqlSession();
		result = dao.alarmYNChange(session, vo);
		return result;
	}

	// 받은 알람 아이디 리스트
	public List<AlarmVo> receiveIdList(String mNickname) {
		SqlSession session = JdbcUtil.getSqlSession();
		List<AlarmVo> idList = dao.receiveIdList(session, mNickname);
		return idList;
	}

	
}
