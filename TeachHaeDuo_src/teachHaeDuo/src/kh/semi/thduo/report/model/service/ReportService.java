package kh.semi.thduo.report.model.service;

import static kh.semi.thduo.common.jdbc.JdbcTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;

import kh.semi.thduo.report.model.dao.ReportDao;
import kh.semi.thduo.report.model.vo.ReportVo;

public class ReportService {
	private ReportDao dao = new ReportDao(); 
	//신고 삽입
//	public int insertReport(ReportVo vo) {
//		int result = 0;
//		Connection conn = getConnection();
//		
//		result = dao.insertReport(conn, vo);
//
//		close(conn);
//		
//		return result;
//	}
	
	//신고 삽입(mybatis 사용)
	public int insertReport(ReportVo setVo) {
		int result = dao.insertReport(setVo);
		System.out.println(result);
		return result;
	}
	
	//모든 신고 내역 읽기
	public ArrayList<ReportVo> readAllReport() {
		ArrayList<ReportVo> voList = null;
		Connection conn = getConnection();
		voList = dao.readAllReport(conn);
		close(conn);
		return voList;
	}
	
	//선택한 신고 내역 읽기
	public ReportVo readOneReport(int rNo) {
		ReportVo rVo = null;
		Connection conn = getConnection();
		rVo = dao.readOneReport(conn, rNo);
		close(conn);
		return rVo;
	}
}
