package kh.semi.thduo.alarm.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import kh.semi.thduo.alarm.model.vo.AlarmVo;
import static kh.semi.thduo.common.jdbc.JdbcTemplate.close;

public class AlarmDao {
	private Statement stmt = null;
	private ResultSet rs = null;
	private PreparedStatement pstmt = null;
	
	public int sendAlarm(Connection conn, AlarmVo vo) {
		int result = 0;
		String sql = "insert into ALARM VALUES(?, ?, DEFAULT, ?, ?, ?);";
//		ALARM_NO        NOT NULL NUMBER        
//		ALARM_CONTENT   NOT NULL VARCHAR2(600) 
//		ALARM_DATE      NOT NULL TIMESTAMP(6)  
//		ALARM_SENDID    NOT NULL VARCHAR2(15)  
//		ALARM_RECEIVEID NOT NULL VARCHAR2(15)  
//		M_ID            NOT NULL VARCHAR2(15)
		try {
			pstmt = conn.prepareStatement(sql);
			//TODO
//			pstmt.setInt(parameterIndex, x);
//			pstmt.setString(parameterIndex, x);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
	
	public ArrayList<AlarmVo> sendListAlarm(Connection conn, String mId){
		ArrayList<AlarmVo> voList = null;
		String sql = "select alarm_content,alarm_date,alarm_receiveid from ALARM where ALARM_SENDID = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mId);
			rs = pstmt.executeQuery();
			
			if(rs != null) {
				voList = new ArrayList<AlarmVo>();
				while(rs.next()) {
					AlarmVo vo = new AlarmVo();
					vo.setAlarm_content(rs.getString("alarm_content"));
					vo.setAlarm_date(rs.getTimestamp("alarm_date"));
					vo.setAlarm_receiveid(rs.getString("alarm_receiveid"));
					voList.add(vo);
				}
				
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return voList;
	}
	public ArrayList<AlarmVo> receiveListAlarm(Connection conn, String mId){
		ArrayList<AlarmVo> voList = null;
		String sql = "select * from ALARM where ALARM_RECEIVEID = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mId);
			rs = pstmt.executeQuery();
			
			if(rs != null) {
				voList = new ArrayList<AlarmVo>();
				// TODO
				
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return voList;
	}
	
	
}
