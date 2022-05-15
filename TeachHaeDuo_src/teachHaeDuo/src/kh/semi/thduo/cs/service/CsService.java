package kh.semi.thduo.cs.service;

import static kh.semi.thduo.common.jdbc.JdbcTemplate.close;
import static kh.semi.thduo.common.jdbc.JdbcTemplate.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import kh.semi.thduo.cs.dao.CsDao;
import kh.semi.thduo.cs.vo.CsVo;

public class CsService {

	public ArrayList<CsVo> csFaqList(int startRnum, int endRnum){
		Connection conn = null;
		conn = getConnection();
		ArrayList<CsVo> csvo = new CsDao().csFaqList(conn,startRnum,endRnum);
		close(conn);
		return csvo;
		
		
	}
	public int csFaqCount() {
		Connection conn=null;
		conn = getConnection();
		int result = new CsDao().faqCount(conn);
		close(conn);
		return result;
	}
	public int csNoticeCount() {
		Connection conn=null;
		conn = getConnection();
		int result = new CsDao().noticeCount(conn);
		close(conn);
		return result;
	}
	public int csFaqWrite(String faqQuestion, String faqAnswer, String adminId) {
		Connection conn = null;
		conn = getConnection();
		int result = new CsDao().csFaqWrite(conn, faqQuestion, faqAnswer, adminId);
		close(conn);
		return result;
	}
	
	public int csFaqDelete(String faqNo) {
		Connection conn = null;
		conn = getConnection();
		int result = new CsDao().csFaqDelete(conn, faqNo);
		close(conn);
		return result;
	}
	public ArrayList<CsVo> csNoticeList(int startRnum, int endRnum){
		Connection conn = null;
		conn = getConnection();
		ArrayList<CsVo> csvo = new CsDao().csNoticeList(conn,startRnum, endRnum);
		close(conn);
		return csvo;
		
		
	}
	
	public int csNoticeWrite(String noticeTitle, String noticeContent, String adminId) {
		Connection conn = null;
		conn = getConnection();
		int result = new CsDao().csNoticeWrite(conn, noticeTitle, noticeContent, adminId);
		close(conn);
		return result;
	}
	
	public int csNoticeDelete(String noticeNo) {
		Connection conn = null;
		conn = getConnection();
		int result = new CsDao().csNoticeDelete(conn, noticeNo);
		close(conn);
		return result;
	}
	
}
