package kh.semi.thduo.alarm.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kh.semi.thduo.alarm.model.vo.AlarmVo;
import kh.semi.thduo.common.jdbc.JdbcUtil;
import kh.semi.thduo.member.vo.MemberVo;

import static kh.semi.thduo.common.jdbc.JdbcTemplate.close;

public class AlarmDao {
	private Statement stmt = null;
	private ResultSet rs = null;
	private PreparedStatement pstmt = null;

	// 쪽지보내기
	public int sendAlarm(SqlSession session, AlarmVo vo) {
		int result = session.insert("alarmMapper.sendAlarm",vo);
		return result;
	}

	// 보낸 알람 리스트
	public List<AlarmVo> sendListAlarm(SqlSession session, String mNickname) {
		List<AlarmVo> voList = JdbcUtil.getSqlSession().selectList("alarmMapper.sendListAlarm",mNickname);
		return voList;
	}

	// 보낸 알람 횟수
	public int numberOfSendAlarm(SqlSession session, String mNickname) {
		int result = JdbcUtil.getSqlSession().selectOne("alarmMapper.numberOfSendAlarm",mNickname);
		return result;
	}

	// 받은 알람 리스트
	public List<AlarmVo> receiveListAlarm(SqlSession session, String mNickname) {
		List<AlarmVo> voList = JdbcUtil.getSqlSession().selectList("alarmMapper.receiveListAlarm",mNickname);
		return voList;
	}

	// 받은 알람 횟수
	public int numberOfReceiveAlarm(SqlSession session, String mNickname) {
		int result = JdbcUtil.getSqlSession().selectOne("alarmMapper.numberOfReceiveAlarm",mNickname);
		return result;
	}

	// 모든 알람 리스트
	public List<AlarmVo> allListAlarm(SqlSession session, String mNickname) {
		List<AlarmVo> voList = JdbcUtil.getSqlSession().selectList("alarmMapper.allListAlarm",mNickname);
		return voList;
	}

	// 알람 수신거부
	public int alarmYNChange(SqlSession session, MemberVo vo) {
		System.out.println("dao vo:"+vo);
		int result = JdbcUtil.getSqlSession().update("alarmMapper.alarmYNChange", vo);
		System.out.println("dao result:"+result);
		return result;
	}

	// 받은 알람 아이디 리스트
	public List<AlarmVo> receiveIdList(SqlSession session, String mNickname) {
		List<AlarmVo> voList = JdbcUtil.getSqlSession().selectList("alarmMapper.receiveIdList",mNickname);
		return voList;
	}

	
}
