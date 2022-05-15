package kh.semi.thduo.pencil.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import static kh.semi.thduo.common.jdbc.JdbcTemplate.*;

import kh.semi.thduo.alarm.model.dao.AlarmDao;
import kh.semi.thduo.alarm.model.vo.AlarmVo;
import kh.semi.thduo.member.vo.MemberVo;
import kh.semi.thduo.pencil.model.dao.PencilDao;
import kh.semi.thduo.pencil.model.vo.PencilVo;

public class PencilService {
	private PencilDao dao = new PencilDao();

	// 연필 충전
	public int plusPencil(PencilVo vo) {
		System.out.println("충전하기 서비스 vo:" + vo);
		int result = 0;
		Connection conn = getConnection();
		result = dao.plusPencil(conn, vo);
		close(conn);
		System.out.println("충전하기 서비스 result:" + result);
		return result;
	}

	// 연필 잔액 확인
	public int checkPencil(String mId) {
		int result = 0;
		Connection conn = getConnection();

		result = dao.checkPencil(conn, mId);

		close(conn);

		return result;
	}

	// 연필 차감 내역 삽입
	public int minusPencil(PencilVo vo) {
		int result = 0;
		Connection conn = getConnection();

		result = dao.minusPencil(conn, vo);

		close(conn);

		return result;
	}

	// 연필 차감 내역 삽입(쪽지 보내기 할 때)
	public int minusPencil(PencilVo vo, AlarmVo avo) {
		int result = 0;
		Connection conn = getConnection();
		setAutocommit(conn, false);

		result = dao.minusPencil(conn, vo);
		if (result < 1) {
			rollback(conn);
		} else {
			result = new AlarmDao().sendAlarm(conn, avo);
			if(result < 1) {
				rollback(conn);
			} else {
				commit(conn);
			}
		}

		close(conn);

		return result;
	}

	// 연필 사용 내역
	public ArrayList<PencilVo> listPencil(String mId) {
		ArrayList<PencilVo> result = null;

		Connection conn = getConnection();
		result = dao.listPencil(conn, mId);

		close(conn);

		return result;

	}

	// 회원가입시 기본 연필 테이블 insert
	public int insertPencilInit(String mId) {
		int result = 0;
		Connection conn = null;

		conn = getConnection();
		result = dao.insertPencilInit(conn, mId);
		if (result == 1) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);

		return result;
	}

	// 관리자 전체 매출 조회
	public ArrayList<MemberVo> allPencilChart() {
		ArrayList<MemberVo> result = null;

		Connection conn = getConnection();
		result = dao.allPencilChart(conn);

		close(conn);

		return result;
	}

	// 관리자 달 매출 조회
	public ArrayList<MemberVo> monthPencilChart(int num) {
		ArrayList<MemberVo> result = null;

		Connection conn = getConnection();
		result = dao.monthPencilChart(conn, num);

		close(conn);

		return result;
	}

	// 관리자 년도 매출 조회
	public ArrayList<MemberVo> yearPencilChart(int num) {
		ArrayList<MemberVo> result = null;

		Connection conn = getConnection();
		result = dao.yearPencilChart(conn,num);

		close(conn);

		return result;
	}
}
