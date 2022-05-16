package kh.semi.thduo.board.service;

import static kh.semi.thduo.common.jdbc.JdbcTemplate.close;
import static kh.semi.thduo.common.jdbc.JdbcTemplate.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import kh.semi.thduo.board.dao.BoardDao;
import kh.semi.thduo.board.vo.BoardReCommentVo;
import kh.semi.thduo.board.vo.BoardReportVo;
import kh.semi.thduo.board.vo.BoardVo;

public class BoardService {

	private BoardDao dao = new BoardDao();
	
	public ArrayList<BoardVo> boardList(){
		ArrayList<BoardVo> boardList = null;
		Connection conn = null;
		conn = getConnection();
		boardList = dao.boardList(conn);
		close(conn);
		return boardList;
	}
	public ArrayList<BoardVo> boardSearch(String select,String bSearch){
		ArrayList<BoardVo> boardList = null;
		Connection conn = null;
		conn = getConnection();
		boardList = dao.boardSearch(conn,select, bSearch);
		close(conn);
		return boardList;
	}
	public ArrayList<BoardReportVo> boardReportList(){
		ArrayList<BoardReportVo> boardList = null;
		Connection conn = getConnection();
		boardList = dao.boardReportList(conn);
		close(conn);
		return boardList;
	}
	public ArrayList<BoardReportVo> boardReportList(int startRnum, int entRnum){
		ArrayList<BoardReportVo> boardList = null;
		Connection conn = getConnection();
		boardList = dao.boardReportList(conn,startRnum, entRnum);
		close(conn);
		return boardList;
	}
	public ArrayList<BoardVo> boardSearchtt(String bSearch){
		ArrayList<BoardVo> boardList = null;
		Connection conn = null;
		conn = getConnection();
		boardList = dao.boardSearchtt(conn, bSearch);
		close(conn);
		return boardList;
	}

	public ArrayList<BoardVo> boardList(int startRnum, int endRnum){
		Connection conn=null;
		conn = getConnection();
		ArrayList<BoardVo> result = dao.boardList(conn, startRnum, endRnum);
		close(conn);
		return result;
	}
	public ArrayList<BoardReCommentVo> boardReCommentRead(String bNo){
		Connection conn=null;
		conn = getConnection();
		ArrayList<BoardReCommentVo> result = dao.boardReCommentRead(conn, bNo);
		close(conn);
		return result;
	}
	public int boardReport(int bNo, String bRWriter, String bRCategory) {
		Connection conn = null;
		conn = getConnection();
		int result = dao.boardReport(conn, bNo, bRWriter, bRCategory);
		close(conn);
		return result;
	}
	public int boardReCommentWrite(String bNo, String rContent, String rWriter) {
		Connection conn = null;
		conn = getConnection();
		int result = dao.boardReCommentWrite(conn,bNo, rContent, rWriter);
		close(conn);
		return result;
	}
	public int boardWriteDo(BoardVo vo) {
		Connection conn=null;
		// DB연결
		conn = getConnection();
		
		// DAO 호출
		int result = dao.boardWriteDo(conn, vo);
		
		// commit/rollback
		// DB해제
		close(conn);
		
		return result;
	}
	public BoardVo boardRead(String bNo) {
		Connection conn=null;
		conn = getConnection();
		BoardVo result = dao.boardRead(conn, bNo);
		close(conn);
		return result;
	}
	public int boardDelete(int bNo) {
		Connection conn = null;
		conn = getConnection();
		int result = dao.boardDelete(conn,bNo);
		close(conn);
		return result;
		
	}
	public int boardUpdate(String content, String title, String category, int bno) {
		Connection conn = null;
		conn = getConnection();
		int result = dao.boardUpdate(conn, content, title, category, bno);
		close(conn);
		return result;
	}
	public int boardReCommentDelete(String bNo, String rNo) {
		Connection conn = null;
		conn = getConnection();
		int result = dao.boardReCommentDelete(conn,bNo,rNo);
		close(conn);
		return result;
		
	}
	public BoardVo boardModify(int bNo) {
		Connection conn = null;
		conn = getConnection();
		BoardVo result = dao.boardModify(conn,bNo);
		close(conn);
		return result;
	}
	public int boardCount() {
		Connection conn=null;
		conn = getConnection();
		int result = dao.boardCount(conn);
		close(conn);
		return result;
	}
	public int reportCount() {
		Connection conn=null;
		conn = getConnection();
		int result = dao.reportCount(conn);
		close(conn);
		return result;
	}
}

