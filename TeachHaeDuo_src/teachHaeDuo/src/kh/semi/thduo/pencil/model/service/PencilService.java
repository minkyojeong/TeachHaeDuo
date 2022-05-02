package kh.semi.thduo.pencil.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import static kh.semi.thduo.common.jdbc.JdbcTemplate.*;
import kh.semi.thduo.pencil.model.dao.PencilDao;
import kh.semi.thduo.pencil.model.vo.PencilVo;

public class PencilService {
	private PencilDao dao = new PencilDao();

	public int plusPencil(PencilVo vo) {
		System.out.println("충전하기 서비스 vo:"+ vo);
		int result = 0;
		
		Connection conn = getConnection();
		result = dao.plusPencil(conn, vo);
		if (result == 1) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);
		System.out.println("충전하기 서비스 result:"+ result);
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
		if (result == 0) {
			rollback(conn);
		} else {
			commit(conn);
		}
		
		close(conn);

		return result;

	}

	public ArrayList<PencilVo> listPencil(String mId) {
		ArrayList<PencilVo> result = null;

		return result;

	}
}
