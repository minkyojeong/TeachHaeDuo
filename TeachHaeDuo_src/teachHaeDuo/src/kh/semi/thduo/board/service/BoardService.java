package kh.semi.thduo.board.service;

import java.sql.Connection;
import java.util.ArrayList;

import static kh.semi.thduo.common.jdbc.JdbcTemplate.close;
import static kh.semi.thduo.common.jdbc.JdbcTemplate.getConnection;
import kh.semi.thduo.board.dao.BoardDao;
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
}
