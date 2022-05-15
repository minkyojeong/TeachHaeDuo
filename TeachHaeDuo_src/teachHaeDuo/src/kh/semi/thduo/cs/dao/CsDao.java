package kh.semi.thduo.cs.dao;

import static kh.semi.thduo.common.jdbc.JdbcTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import kh.semi.thduo.cs.vo.CsVo;

public class CsDao {
		private Connection conn = null;
		private Statement stmt = null;
		private PreparedStatement pstmt = null;
		private ResultSet rs = null;
		
		public ArrayList<CsVo> csFaqList(Connection conn, int startRnum, int endRnum){
			ArrayList<CsVo> csvo = null;
			String sql = "select * from" 
					+"(select rownum r, t1.* from" 
					+"(select b1.*" 
					+"from cs_faq b1 order by faq_no desc) t1)"
					+"where r between ? and ?";
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, startRnum);
				pstmt.setInt(2, endRnum);
				rs = pstmt.executeQuery();
				csvo = new ArrayList<CsVo>();
				while(rs.next()) {
					CsVo vo = new CsVo();
					vo.setAdminId(rs.getString("admin_id"));
					vo.setFaqNo(rs.getString("faq_no"));
					vo.setFaqAnswer(rs.getString("faq_answer"));
					vo.setFaqCnt(rs.getString("faq_cnt"));
					vo.setFaqQuestion(rs.getString("faq_question"));
					csvo.add(vo);
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}finally {
				close(pstmt);
				close(conn);
			}
			
			return csvo;
			
		}
		public int csFaqWrite(Connection conn, String faqQuestion, String faqAnswer, String adminId) {
			
			int result = 0;
			String sql = "insert into cs_faq values (faq_no_sequence.nextval, ?,?,?,default)";
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1,faqQuestion);
				pstmt.setString(2, faqAnswer);
				pstmt.setString(3, adminId);
				result = pstmt.executeUpdate();
			}
				catch(SQLException e) {
					e.printStackTrace();
				}finally {
					close(pstmt);
					close(conn);
				}
			
			return result;
			
		}
		public int csFaqDelete(Connection conn, String faqNo) {
			int result = 0;
			String sql = "delete from cs_faq where faq_no=?";
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1,faqNo);
				result = pstmt.executeUpdate();
				
			}catch(SQLException e) {
				e.printStackTrace();
			}finally {
				close(pstmt);
				close(conn);
			}
			return result;
			
		}
		public int faqCount(Connection conn) {
			int count = 0;
			String sql = "select count(*) from cs_faq";
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
		public int noticeCount(Connection conn) {
			int count = 0;
			String sql = "select count(*) from cs_notice";
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
		public ArrayList<CsVo> csNoticeList(Connection conn, int startRnum, int endRnum){
			ArrayList<CsVo> csvo = null;
			String sql = "select * from" 
					+"(select rownum r, t1.* from" 
					+"(select b1.*" 
					+"from cs_notice b1 order by notice_no desc) t1)"
					+"where r between ? and ?";
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, startRnum);
				pstmt.setInt(2, endRnum);
				rs = pstmt.executeQuery();
				csvo = new ArrayList<CsVo>();
				while(rs.next()) {
					CsVo vo = new CsVo();
					vo.setNoticeCnt(rs.getString("notice_cnt"));
					vo.setNoticeContent(rs.getString("notice_content"));
					vo.setNoticeNo(rs.getString("notice_no"));
					vo.setNoticeTitle(rs.getString("notice_title"));
					vo.setNoticeWriteDate(rs.getString("notice_write_date"));
					csvo.add(vo);
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}finally {
				close(pstmt);
				close(conn);
			}
			
			return csvo;
			
		}
		public int csNoticeWrite(Connection conn, String noticeTitle, String noticeContent, String adminId) {
			
			int result = 0;
			String sql = "insert into cs_faq values (notice_no_sequence.nextval, ?,?,default,default,?)";
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1,noticeTitle);
				pstmt.setString(2,noticeContent);
				pstmt.setString(3, adminId);
				result = pstmt.executeUpdate();
			}
				catch(SQLException e) {
					e.printStackTrace();
				}finally {
					close(pstmt);
					close(conn);
				}
			
			return result;
			
		}
		public int csNoticeDelete(Connection conn, String noticeNo) {
			int result = 0;
			String sql = "delete from cs_notice where notice_no=?";
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1,noticeNo);
				result = pstmt.executeUpdate();
				
			}catch(SQLException e) {
				e.printStackTrace();
			}finally {
				close(pstmt);
				close(conn);
			}
			return result;
			
		}
		
}
