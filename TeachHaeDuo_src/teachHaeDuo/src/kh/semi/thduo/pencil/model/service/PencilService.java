package kh.semi.thduo.pencil.model.service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import static kh.semi.thduo.common.jdbc.JdbcTemplate.*;

import kh.semi.thduo.alarm.model.dao.AlarmDao;
import kh.semi.thduo.alarm.model.vo.AlarmVo;
import kh.semi.thduo.common.jdbc.JdbcUtil;
import kh.semi.thduo.member.vo.MemberVo;
import kh.semi.thduo.pencil.model.dao.PencilDao;
import kh.semi.thduo.pencil.model.vo.PencilVo;

public class PencilService {
	private PencilDao dao = new PencilDao();

	// 연필 충전
	public int plusPencil(PencilVo vo) {
		System.out.println("충전하기 서비스 vo:" + vo);
		int result = 0;
		SqlSession session = JdbcUtil.getSqlSession();
		result = dao.plusPencil(session, vo);
		if (result < 0) {
			System.out.println("롤백");
			session.rollback();
		} else {
			System.out.println("커밋");
			session.commit();
		}
		System.out.println("충전하기 서비스 result:" + result);
		return result;
	}

	// 연필 잔액 확인
	public int checkPencil(String mId) {
		int result = 0;
		SqlSession session = JdbcUtil.getSqlSession();
		result = dao.checkPencil(session, mId);

		return result;
	}

	// 연필 차감 내역 삽입
	public int minusPencil(PencilVo pVo) {
		System.out.println("{{{{{{{{{{{{{{{{들어오냐}}}}}}}}}}");
		int result = 0;
		SqlSession session = JdbcUtil.getSqlSession();
		System.out.println("dao pVo :" + pVo);
		result = dao.minusPencil(session,pVo);
		System.out.println("dao result" + result);
		return result;
	}

	// 연필 차감 내역 삽입(쪽지 보내기 할 때)
	public int minusPencil(PencilVo vo, AlarmVo avo) {
		int result = 0;
		SqlSession session = JdbcUtil.getSqlSession();
		result = dao.minusPencil(session,vo);
		if (result < 1) {
			session.rollback();
		} else {
			result = new AlarmDao().sendAlarm(session, avo);
			if (result < 1) {
				session.rollback();
			} else {
				session.commit();
			}
		}


		return result;
	}

	// 연필 사용 내역
	public List<PencilVo> listPencil(String mId) {
		List<PencilVo> result = null;
		SqlSession session = JdbcUtil.getSqlSession();
		result = dao.listPencil(session,mId);

		return result;

	}

	// 회원가입시 기본 연필 테이블 insert
	public int insertPencilInit(String mId) {
		int result = 0;
		SqlSession session = JdbcUtil.getSqlSession();
		result = dao.insertPencilInit(session,mId);

		return result;
	}

	// 관리자 전체 매출 조회
	public List<MemberVo> allPencilChart() {
		List<MemberVo> result = null;
		SqlSession session = JdbcUtil.getSqlSession();
		result = dao.allPencilChart(session);
		return result;
	}

	// 관리자 달 매출 조회
	public List<MemberVo> monthPencilChart(int num) {
		List<MemberVo> result = null;
		SqlSession session = JdbcUtil.getSqlSession();
		result = dao.monthPencilChart(session,num);
		return result;
	}

	// 관리자 년도 매출 조회
	public List<MemberVo> yearPencilChart(int num) {
		List<MemberVo> result = null;
		SqlSession session = JdbcUtil.getSqlSession();
		result = dao.yearPencilChart(session,num);
		return result;
	}
}
