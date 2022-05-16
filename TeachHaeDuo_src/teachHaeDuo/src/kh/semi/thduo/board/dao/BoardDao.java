package kh.semi.thduo.board.dao;

import static kh.semi.thduo.common.jdbc.JdbcTemplate.close;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import kh.semi.thduo.board.vo.BoardReCommentVo;
import kh.semi.thduo.board.vo.BoardReportVo;
import kh.semi.thduo.board.vo.BoardVo;


public class BoardDao {

	
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private Statement stmt = null;
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
	public ArrayList<BoardVo> boardList(Connection conn, int startRnum, int endRnum) {
		ArrayList<BoardVo> boardList = null;
		String sql = "select * from" 
				+"(select rownum r, t1.* from" 
				+"(select b1.*" 
				+"from q_board b1 order by b_write_date desc, b_no desc) t1)"
				+"where r between ? and ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startRnum);
			pstmt.setInt(2, endRnum);
			rs = pstmt.executeQuery();
			
			if(rs!=null) {
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
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(conn);
		}
		return boardList;
	}
	public int boardCount(Connection conn) {
		int count = 0;
		String sql = "select count(*) from q_board";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				
				count = rs.getInt(1);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(conn);
		}
		
		return count;
	}
	
	public int boardReCommentWrite(Connection conn, String bNo, String rContent, String rWriter) {
		int result = 0;
		String sql = "insert into q_recomment values (b_r_c_no_sequence.nextval,?,?,default,default,?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, rContent);
			pstmt.setString(2, rWriter);
			pstmt.setString(3, bNo);
			result = pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(conn);
		}
		return result;
	}
	public int boardReport(Connection conn, int bNo, String bRWriter, String bRCategory) {
		int result = 0;
		String sql = "insert into board_report values ( b_r_no_sequence.nextval, ?, ?, ?, default)";
		try {
			pstmt = conn.prepareStatement(sql);	
			pstmt.setInt(1, bNo);
			pstmt.setString(2, bRCategory);
			pstmt.setString(3, bRWriter);
			result = pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(conn);
		}
		
		
		return result;
		
	}
	public void boardUpdateCnt(Connection conn, String bNo) {
		String sql = "update q_board set b_cnt=b_cnt+1 where b_no=?"; 
				try {
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, bNo);
					pstmt.executeUpdate();
				}catch(Exception e) {
					e.printStackTrace();
				}finally {
					close(pstmt);
					close(conn);
				}
		
		
	}
	public int boardWriteDo(Connection conn, BoardVo vo) {
		// TODO: member 로그인 완료 후 수정
		
		
		// sequence
		// (select nvl(max(b_no),0) from board)
		// (select nickname from member where m_id='aaa')
		
		int result = 0;
		String sql = "insert into q_board values ( b_no_sequence.nextval, '"+vo.getbCategory() +"','"+vo.getbTitle() +"','"+vo.getbContent()
		+"',(select m_nickname from"
		+ " member where m_id='"+vo.getmId()+"') ,default, default,'"+vo.getmId()+"')";
		
		// java String
//		String temp = "안녕하세요."+mId+"aa여기 "
//				+ "변수"+mId+"a";
//		String temp2= "select * from board"
//				+ " insert into board";
		
		try {
			stmt = conn.createStatement();

//java.sql.SQLSyntaxErrorException: ORA-00904: "NICKNAME": invalid identifier
//NICKNAME이라는 컬럼 없어
			result = stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(stmt);
		}
		return result;
	}
	public BoardVo boardRead(Connection conn, String bNo) {
		BoardVo vo = null;  // 1 : 리턴 자료형으로 변수 선언
		String sql ="select * from q_board where b_no=?";  // 2: sql문
		String sql2 ="update q_board set b_cnt=b_cnt+1 where b_no=?";  
		try {   // 4
			pstmt = conn.prepareStatement(sql);  // 3
			pstmt.setString(1, bNo);  // 7 : 위 2 ?
			rs = pstmt.executeQuery();  // 8
			vo = new BoardVo();  // 9 : 위 1 자료형에 따라서 생성(기본자료형이면 안해도됨)
			if(rs.next()) {   // 10 : 위 2번의 조건식 pk- 결과는 1행.  while 반복x
				//11. !!!!!리턴 변수 값 채우기!!!!
				vo.setbContent(rs.getString("b_Content"));
				vo.setbCategory(rs.getString("b_Category"));
				vo.setbCnt(rs.getString("b_Cnt"));
				vo.setbNo(rs.getString("b_No"));
				vo.setbTitle(rs.getString("b_Title"));
				vo.setbWriteDate(rs.getString("b_Write_Date"));
				vo.setbWriter(rs.getString("b_Writer"));
				vo.setmId(rs.getString("m_Id"));
				
				close(rs);
				close(pstmt);
				try {
				pstmt = conn.prepareStatement(sql2); 
				pstmt.setString(1, bNo);
				rs = pstmt.executeQuery();
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs); // 5 : 위 2 select
			close(pstmt); // 6
		}
		return vo; // 1 : 리턴함
	}
	
	public ArrayList<BoardReCommentVo> boardReCommentRead(Connection conn, String bNo){
		ArrayList<BoardReCommentVo> volist = null;
		String sql = "select * from q_recomment where b_no=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bNo);
			rs = pstmt.executeQuery();
			volist = new ArrayList<BoardReCommentVo>();
			while(rs.next()) { // 10 : 위 2번의 조건식 fk- 결과는 0행이상.  while 사용
				BoardReCommentVo rvo = new BoardReCommentVo();
				rvo.setrContent(rs.getString("r_Content"));
				rvo.setrWriter(rs.getString("r_writer"));
				rvo.setrNo(rs.getString("r_No"));
				rvo.setrWriteDate(rs.getString("r_Write_Date"));
				volist.add(rvo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return volist;
	}
	public int boardDelete(Connection conn, int bNo) {
		int result = 0;
		String sql = "delete from q_board where b_no=?";
		try { 
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bNo);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {  
			close(pstmt);
		}
		return result;
	}
	public int boardReCommentDelete(Connection conn, String bNo, String rNo) {
		int result = 0;
		String sql = "delete from q_recomment where b_no=? and r_no=?";
		try { 
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bNo);
			pstmt.setString(2, rNo);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {  
			close(pstmt);
		}
		return result;
	}
	public int boardUpdate(Connection conn,String content, String title, String category, int bno) {
		int result = 0;
		String sql = "update q_board set b_content=?, b_title=?, b_category=? where b_no=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,content);
			pstmt.setString(2,title);
			pstmt.setString(3,category);
			pstmt.setInt(4,bno);
			result = pstmt.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(conn);
		}
		return result;
		
	}
	public BoardVo boardModify(Connection conn, int bNo) {
		BoardVo vo = null;  // 1 : 리턴 자료형으로 변수 선언
		String sql ="select * from q_board where b_no=?";  // 2: sql문
		try {   // 4
			pstmt = conn.prepareStatement(sql);  // 3
			pstmt.setInt(1, bNo);  // 7 : 위 2 ?
			rs = pstmt.executeQuery();  // 8
			vo = new BoardVo();  // 9 : 위 1 자료형에 따라서 생성(기본자료형이면 안해도됨)
			if(rs.next()) {   // 10 : 위 2번의 조건식 pk- 결과는 1행.  while 반복x
				//11. !!!!!리턴 변수 값 채우기!!!!
				vo.setbContent(rs.getString("b_Content"));
				vo.setbCategory(rs.getString("b_Category"));
				vo.setbCnt(rs.getString("b_Cnt"));
				vo.setbNo(rs.getString("b_No"));
				vo.setbTitle(rs.getString("b_Title"));
				vo.setbWriteDate(rs.getString("b_Write_Date"));
				vo.setbWriter(rs.getString("b_Writer"));
				vo.setmId(rs.getString("m_Id"));
				close(rs);
				close(pstmt);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs); // 5 : 위 2 select
			close(pstmt); // 6
		}
		return vo; // 1 : 리턴함
	}
	public ArrayList<BoardVo> boardSearchCt(Connection conn, String bContent) {
		ArrayList<BoardVo> boardList = null;
		String sql = "select * from q_board where b_content like %?%";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bContent);
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
	public ArrayList<BoardVo> boardSearchTt(Connection conn, String bContent) {
		ArrayList<BoardVo> boardList = null;
		String sql = "select * from q_board where b_title like %?%";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bContent);
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
	public ArrayList<BoardVo> boardSearchWt(Connection conn, String bContent) {
		ArrayList<BoardVo> boardList = null;
		String sql = "select * from q_board where b_writer like %?%";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bContent);
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
	
	public ArrayList<BoardReportVo> boardReportList(Connection conn){
		ArrayList<BoardReportVo> reportList = null;
		String sql = "select * from board_report";
		try {
			pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();
		reportList = new ArrayList<BoardReportVo>();
		while(rs.next()) {
			BoardReportVo vo = new BoardReportVo();
			vo.setbNo(rs.getString("b_no"));
			vo.setbRCategory(rs.getString("b_r_category"));
			vo.setbRNo(rs.getString("b_r_no"));
			vo.setbRWriteDate(rs.getString("b_r_write_date"));
			vo.setbRWriter(rs.getString("b_r_writer"));
			reportList.add(vo);
		}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(conn);
			
		}
		return reportList;
	}
	public ArrayList<BoardReportVo> boardReportList(Connection conn, int startRnum, int entRnum){
		ArrayList<BoardReportVo> reportList = null;
		String sql = "select * from" 
				+"(select rownum r, t1.* from" 
				+"(select b1.*" 
				+"from board_report b1 order by b_r_write_date desc, b_no desc) t1)"
				+"where r between ? and ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startRnum);
			pstmt.setInt(2, entRnum);
			rs = pstmt.executeQuery();
		if(rs!=null) {
			reportList = new ArrayList<BoardReportVo>();
		while(rs.next()) {
			BoardReportVo vo = new BoardReportVo();
			vo.setbRNo(rs.getString("b_r_no"));
			vo.setbNo(rs.getString("b_no"));
			vo.setbRCategory(rs.getString("b_r_category"));
			vo.setbRWriter(rs.getString("b_r_writer"));
			vo.setbRWriteDate(rs.getString("b_r_write_date"));
			reportList.add(vo);
				}
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(conn);
			
		}
		return reportList;
	}
	public int reportCount(Connection conn) {
		int count = 0;
		String sql = "select count(*) from board_report";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				
				count = rs.getInt(1);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(conn);
		}
		
		return count;
	}
	public ArrayList<BoardVo> boardSearch(Connection conn, String select, String bSearch) {
		ArrayList<BoardVo> boardList = null;
		String sql = "select * from q_board where " +select+ " like '%'||?||'%'";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,bSearch);
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

	public ArrayList<BoardVo> boardSearchtt(Connection conn, String bSearch) {
		ArrayList<BoardVo> boardList = null;
		String sql = "select * from q_board where b_title like '%'||?||'%'";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,bSearch);
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
