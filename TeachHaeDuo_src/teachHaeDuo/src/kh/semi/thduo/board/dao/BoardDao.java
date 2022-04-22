package kh.semi.thduo.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import static kh.semi.thduo.common.jdbc.JdbcTemplate.close;
import kh.semi.thduo.board.vo.BoardVo;

public class BoardDao {

	
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	public ArrayList<BoardVo> boardList(Connection conn) {
		ArrayList<BoardVo> boardList = null;
		String sql = "select * from q_board";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			boardList = new ArrayList<BoardVo>();
			while(rs.next()) {
				BoardVo vo = new BoardVo();
				vo.setbNo(rs.getString("b_no"));
				vo.setbCategory(rs.getString("b_category"));
				vo.setbTitle(rs.getString("b_title"));
				vo.setbContent(rs.getString("b_content"));
				vo.setbWriter(rs.getString("b_writer"));
				vo.setbWriteDate(rs.getString("b_write_date"));
				vo.setbCnt(rs.getString("b_cnt"));
				vo.setmId(rs.getString("m_id"));
				boardList.add(vo);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return boardList;
	}
}
