package kh.semi.thduo.report.model.service;

import static kh.semi.thduo.common.jdbc.JdbcTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;

import kh.semi.thduo.report.model.dao.ReportDao;
import kh.semi.thduo.report.model.vo.ReportVo;

public class ReportService {
	private ReportDao dao = new ReportDao(); 
	//신고 삽입
	public int insertReport(ReportVo vo) {
		int result = 0;
		Connection conn = getConnection();
		
		result = dao.insertReport(conn, vo);
		if (result == 0) {
			rollback(conn);
		} else {
			commit(conn);
		}

		close(conn);
		
		return result;
	}
	
	//모든 신고 내역 읽기
	public ArrayList<ReportVo> readAllReport() {
		ArrayList<ReportVo> retVolist = null;
		Connection conn = getConnection();
		
		retVolist = dao.readAllReport(conn);
		
		close(conn);
		
		return retVolist;
	}
	
	//선택한 신고 내역 읽기
	public ReportVo readOneReport(int m_r_no) {
		ReportVo retVo = null;
		Connection conn = getConnection();
		
		retVo = dao.readOneReport(conn, m_r_no);
		
		close(conn);
		
		return retVo;
	}
}
