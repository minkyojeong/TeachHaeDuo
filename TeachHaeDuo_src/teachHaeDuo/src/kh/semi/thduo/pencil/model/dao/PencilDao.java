package kh.semi.thduo.pencil.model.dao;

import static kh.semi.thduo.common.jdbc.JdbcTemplate.close;
import static kh.semi.thduo.common.jdbc.JdbcTemplate.getConnection;
import static kh.semi.thduo.common.jdbc.JdbcUtil.getSqlSession;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kh.semi.thduo.member.vo.MemberVo;
import kh.semi.thduo.pencil.model.vo.PencilVo;

public class PencilDao {
	private SqlSession sqlSessoin = null;
	private Statement stmt = null;
	private ResultSet rs = null;
	private PreparedStatement pstmt = null;

	// 연필 충전
	public int plusPencil(SqlSession session, PencilVo vo) {
		System.out.println("충전하기 dao vo:" + vo);
		int result = session.insert("pencilMapper.plusPencil", vo);
		System.out.println("DAO 결과 : " +result );
		return result;
	}

	// 연필 잔액 확인
	public int checkPencil(SqlSession session, String mId) {
		System.out.println("잔액 확인 dao vo:" + mId);
		int result = session.selectOne("pencilMapper.checkPencil",mId);
		System.out.println("DAO 결과 : " +result );
		return result;
	}

	// 연필 차감 내역 삽입
	public int minusPencil(SqlSession session, PencilVo vo) {
		System.out.println("차감 내역 삽입 dao vo:" + vo);
		int result = session.insert("pencilMapper.minusPencil", vo);
		System.out.println("DAO 결과 : " +result );
		
		return result;
	}

	// 연필 사용 내역
	public List<PencilVo> listPencil(SqlSession session, String mId) {
		System.out.println("들어오냐");
		List<PencilVo> voList = null;
		voList = session.selectList("pencilMapper.listPencil",mId);
		return voList;
	}

	// 회원가입시 기본 연필 테이블 insert
	public int insertPencilInit(SqlSession session, String mId) {
		int result = 0;
		result = session.insert("pencilMapper.insertPencilInit",mId);
		return result;
	}

	// 관리자 전체 매출 조회
	public List<MemberVo> allPencilChart(SqlSession session) {
		List<MemberVo> voList = null;
		voList = session.selectList("pencilMapper.allPencilChart");
		return voList;
	}
	
	// 관리자 달 매출 조회
	public List<MemberVo> monthPencilChart(SqlSession session, int num) {
		List<MemberVo> voList = null;
		voList = session.selectList("pencilMapper.monthPencilChart",num);
		return voList;
	}
	
	// 관리자 년도 매출 조회
	public List<MemberVo> yearPencilChart(SqlSession session, int num) {
		List<MemberVo> voList = null;
		voList = session.selectList("pencilMapper.yearPencilChart",num);
		return voList;
	}
}
