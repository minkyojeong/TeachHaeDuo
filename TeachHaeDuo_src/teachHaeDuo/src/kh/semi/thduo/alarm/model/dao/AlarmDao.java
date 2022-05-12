package kh.semi.thduo.alarm.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import kh.semi.thduo.alarm.model.vo.AlarmVo;
import kh.semi.thduo.member.vo.MemberVo;

import static kh.semi.thduo.common.jdbc.JdbcTemplate.close;

public class AlarmDao {
	private Statement stmt = null;
	private ResultSet rs = null;
	private PreparedStatement pstmt = null;
	
	// 쪽지보내기
	public int sendAlarm(Connection conn, AlarmVo vo) {
		int result = 0;
		String sql = "INSERT INTO alarm VALUES((SELECT NVL(MAX(alarm_no), 0) + 1 FROM alarm), ?, DEFAULT, ?, ?, ?)";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getAlarm_content());
			pstmt.setString(2, vo.getAlarm_sendid());
			pstmt.setString(3, vo.getAlarm_receiveid());
			pstmt.setString(4, vo.getM_id());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}
	
	// 보낸 알람 리스트
	public ArrayList<AlarmVo> sendListAlarm(Connection conn, String mNickname){
		ArrayList<AlarmVo> voList = null;
		// 최근 30일 조회
		String sql = "select a.alarm_content, a.alarm_date,a.ALARM_sendID, a.ALARM_RECEIVEID,t.t_no from alarm a join member m on a.ALARM_RECEIVEID = m.m_nickname left outer join t_profile t on t.m_id = m.m_id where alarm_sendid = ? and alarm_date between (sysdate-30) and sysdate order by alarm_date desc";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mNickname);
			rs = pstmt.executeQuery();
			
			if(rs != null) {
				voList = new ArrayList<AlarmVo>();
				while(rs.next()) {
					AlarmVo vo = new AlarmVo();
					vo.setAlarm_content(rs.getString("alarm_content"));
					vo.setAlarm_date(rs.getTimestamp("alarm_date"));
					vo.setAlarm_receiveid(rs.getString("alarm_receiveid"));
					vo.setAlarm_sendid(rs.getString("alarm_sendid"));
					vo.setT_no(rs.getString("t_no"));
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
	
	// 보낸 알람 횟수
	public int numberOfSendAlarm(Connection conn, String mNickname) {
		int result = 0;
		String sql = "select count(*) cnt from alarm where alarm_sendid=? and alarm_date between (sysdate-30) and sysdate order by alarm_date desc";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mNickname);
			
			rs = pstmt.executeQuery();
			
			if(rs != null) {
				while(rs.next()) {
					result = rs.getInt("cnt");
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}
	
	//받은 알람 리스트
	public ArrayList<AlarmVo> receiveListAlarm(Connection conn, String mNickname){
		ArrayList<AlarmVo> voList = null;
		String sql = "select a.alarm_content, a.alarm_date,a.ALARM_sendID, a.ALARM_RECEIVEID,t.t_no from alarm a join member m on a.ALARM_RECEIVEID = m.m_nickname left outer join t_profile t on t.m_id = m.m_id where alarm_receiveid = ? and alarm_date between (sysdate-30) and sysdate order by alarm_date desc";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mNickname);
			rs = pstmt.executeQuery();
			
			if(rs != null) {
				voList = new ArrayList<AlarmVo>();
				while(rs.next()) {
					AlarmVo vo = new AlarmVo();
					vo.setAlarm_content(rs.getString("alarm_content"));
					vo.setAlarm_date(rs.getTimestamp("alarm_date"));
					vo.setAlarm_sendid(rs.getString("alarm_sendid"));
					vo.setAlarm_receiveid(rs.getString("alarm_receiveid"));
					vo.setT_no(rs.getString("t_no"));
					voList.add(vo);
				}
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return voList;
	}
	
	// 받은 알람 횟수
	public int numberOfReceiveAlarm(Connection conn, String mNickname) {
		int result = 0;
		String sql = "select count(*) cnt from alarm where alarm_receiveid=? and alarm_date between (sysdate-30) and sysdate order by alarm_date desc";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mNickname);
			
			rs = pstmt.executeQuery();
			if(rs != null) {
				while(rs.next()) {
					result = rs.getInt("cnt");
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}
	
	// 모든 알람 리스트
	public ArrayList<AlarmVo> allListAlarm(Connection conn, String mNickname){
		ArrayList<AlarmVo> voList = null;
		String sql = "select a.alarm_content, a.alarm_date,a.ALARM_sendID, a.ALARM_RECEIVEID,t.t_no from alarm a join member m on a.ALARM_RECEIVEID = m.m_nickname left outer join t_profile t on t.m_id = m.m_id where alarm_receiveid = ? or alarm_sendid=? order by alarm_date desc";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mNickname);
			pstmt.setString(2, mNickname);
			rs = pstmt.executeQuery();
			
			if(rs != null) {
				voList = new ArrayList<AlarmVo>();
				while(rs.next()) {
					AlarmVo vo = new AlarmVo();
					vo.setAlarm_content(rs.getString("alarm_content"));
					vo.setAlarm_date(rs.getTimestamp("alarm_date"));
					vo.setAlarm_sendid(rs.getString("alarm_sendid"));
					vo.setAlarm_receiveid(rs.getString("alarm_receiveid"));
					vo.setT_no(rs.getString("t_no"));
					voList.add(vo);
				}
				
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return voList;
	}
	
	// 알람 수신거부
	public int alarmYNChange(Connection conn, MemberVo vo) {
		int result = 0;
		String sql = "";
		String yn = vo.getmAlarmYn();
		if(yn.equals("Y")) {
			sql = "update member set M_ALARM_YN = " + "'N' where m_id =? ";
		} else {
			sql = "update member set M_ALARM_YN = " + "'Y' where m_id =? ";
		}
		
		if(sql != "") {
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, vo.getmId());
				result = pstmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close(pstmt);
			}
		}
		return result;
	}
	
	// 받은 알람 아이디 리스트
	
	public ArrayList<AlarmVo> receiveIdList(Connection conn, String mNickname){
		ArrayList<AlarmVo> voList = null;
		String sql = "select DISTINCT a.ALARM_sendID, a.alarm_receiveid from alarm a where alarm_receiveid = ? and alarm_date between (sysdate-30) and sysdate";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mNickname);
			rs = pstmt.executeQuery();
			
			if(rs != null) {
				voList = new ArrayList<AlarmVo>();
				while(rs.next()) {
					AlarmVo vo = new AlarmVo();
					vo.setAlarm_sendid(rs.getString("alarm_sendid"));
					vo.setAlarm_receiveid(rs.getString("alarm_receiveid"));
					voList.add(vo);
				}
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return voList;
	}
	
	// 관리자 승인비승인 알람 보내기
	public int sendApprovalAlarm(Connection conn, AlarmVo vo, String yD,String tNo) {
		int result = 0;
		System.out.println("sendApprovalAlarm dao 진입:"+vo+yD+tNo);
		String sql = "INSERT INTO alarm VALUES((SELECT NVL(MAX(alarm_no), 0) + 1 FROM alarm), ?, DEFAULT, ?, ?, ?)";
		String sql2 = "update t_profile set T_APPROVAL=? where t_no=?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getAlarm_content());
			pstmt.setString(2, vo.getAlarm_sendid());
			pstmt.setString(3, vo.getAlarm_receiveid());
			pstmt.setString(4, vo.getM_id());
			
			result = pstmt.executeUpdate();
			System.out.println("dao result1:" + result);
			if(result == 0) {
				System.out.println("알람 테이블 넣기 실패 result:"+ result);
				return result;
			} else {
				System.out.println("알람 테이블 넣기 성공 result:"+ result);
				pstmt = conn.prepareStatement(sql2);
				pstmt.setString(1, yD);
				pstmt.setString(2, tNo);
				result = pstmt.executeUpdate();
				System.out.println("dao result2:"+ result);
				if(result == 0) {
					System.out.println("선생님 테이블 넣기 실패 result:"+ result);
					return result;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}
}






