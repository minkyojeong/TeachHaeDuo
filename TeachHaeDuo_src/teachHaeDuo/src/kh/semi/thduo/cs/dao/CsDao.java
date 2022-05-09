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
		
		public ArrayList<CsVo> csFaqList(Connection conn){
			ArrayList<CsVo> csvo = null;
			String sql = "select * from cs_faq";
			try {
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();
				csvo = new ArrayList<CsVo>();
				while(rs.next()) {
					CsVo vo = new CsVo();
					vo.setAdminId(rs.getString("admin_id"));
					vo.setFaqNo(rs.getString("faq_no"));
					vo.setFaqAnswer(rs.getString("faq_answer"));
					vo.setFaqCnt(rs.getString("faq_cnt"));
					vo.setFaqQuestion(rs.getString("faq_question"));
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
		public ArrayList<CsVo> csNoticeList(Connection conn){
			ArrayList<CsVo> csvo = null;
			String sql = "select * from cs_notice";
			try {
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();
				csvo = new ArrayList<CsVo>();
				while(rs.next()) {
					CsVo vo = new CsVo();
					//vo.setAdminId(rs.getString("admin_id"));
					//vo.setFaqNo(rs.getString("faq_no"));
					//vo.setFaqAnswer(rs.getString("faq_answer"));
					//vo.setFaqCnt(rs.getString("faq_cnt"));
					//vo.setFaqQuestion(rs.getString("faq_question"));
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
