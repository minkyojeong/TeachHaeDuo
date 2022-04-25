package kh.semi.thduo.teacher.model.dao;

import static kh.semi.thduo.common.jdbc.JdbcTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import kh.semi.thduo.review.model.vo.ReviewVo;
import kh.semi.thduo.teacher.model.vo.TeacherVo;

public class TeacherDao {
	private Statement stmt = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	// 선생님 교습정보 삽입
	public int insertTeacher(Connection conn, TeacherVo vo) {
		int result = 0;
		
		return result;
	}
	
	// 모든 선생님 정보 읽기
	public ArrayList<TeacherVo> readAllTeacher(Connection conn){
		ArrayList<TeacherVo> retVolist = null;
		String sql = "select  pro.t_major, pro.t_picture, m.m_nickname, tre.t_r_score avg_Rscore, o.ob_name object_List, a.area_name area_List"
				+ "  FROM t_profile pro JOIN member m"
				+ "			      ON pro.m_id = m.m_id"
				+ "  JOIN T_REVIEW tre"
				+ "      ON pro.t_no = tre.t_no"
				+ "  JOIN teach_object olist"
				+ "      ON pro.t_no = olist.t_no"
				+ "  JOIN object o"
				+ "      ON olist.ob_code = o.ob_code"
				+ "  JOIN acti_area acti"
				+ "      ON pro.t_no = acti.t_no"
				+ "  JOIN area a"
				+ "      ON acti.area_code = a.area_code";
		return retVolist;
	} 
	
	// 검색한 과목에 맞는 선생님 정보 읽기
	public ArrayList<TeacherVo> readTeacher(Connection conn, String object) {
		ArrayList<TeacherVo> retVolist = null;
		
		return retVolist;
	} 
	
	// 성별에 맞는 선생님 정보 읽기
	public ArrayList<TeacherVo> readGenderTeacher(Connection conn, String genderFm){
		ArrayList<TeacherVo> retVolist = null;
		
		return retVolist;
	}
	
	// 활동지역에 맞는 선생님 정보 읽기
	public ArrayList<TeacherVo> readAreaTeacher(Connection conn, String area){
		ArrayList<TeacherVo> retVolist = null;
		
		return retVolist;
	}
	
	// 온-오프 여부에 맞는 선생님 정보 읽기
	public ArrayList<TeacherVo> readOnlineTeacher(Connection conn, String onlineYna){
		ArrayList<TeacherVo> retVolist = null;
		
		return retVolist;
	}
	
	// 통화허용 여부에 맞는 선생님 정보 읽기
	public ArrayList<TeacherVo> readCallTeacher(Connection conn, String tPermitYn){
		ArrayList<TeacherVo> retVolist = null;
		
		return retVolist;
	}
	
	// 모집 여부에 맞는 선생님 정보 읽기
	public ArrayList<TeacherVo> readRecruitTeacher(Connection conn, String tRecruitYn){
		ArrayList<TeacherVo> retVolist = null;
		
		return retVolist;
	}
	
	// 찜 여부에 맞는 선생님 정보 읽기
	public ArrayList<TeacherVo> readLikeTeacher(Connection conn, String sNo){
		ArrayList<TeacherVo> retVolist = null;
		
		return retVolist;
	}
	
	// 선생님 상세정보 읽기
	public TeacherVo readTeacherInfo(Connection conn, String tNo){
		TeacherVo retVo = null;
		String sql = "SELECT pro.*, olist.object_list, alist.area_list, rscore.avg_rscore, SUBSTR(m.m_name,1,1) || LPAD('*',LENGTH(m.m_name)-1, '*') m_name, TRUNC(MONTHS_BETWEEN(TRUNC(SYSDATE,'YEAR'), m.m_birth)/12)+2 t_age, m.m_nickname, m.gender_fm, m.m_address "
				+ "FROM t_profile pro JOIN member m ON pro.m_id = m.m_id "
				+ "JOIN view_teacher_rscroe_avg rscore ON rscore.m_nickname = m.m_nickname "
				+ "JOIN view_teacher_object olist ON olist.m_nickname = m.m_nickname "
				+ "JOIN view_teacher_area alist ON alist.m_nickname = m.m_nickname "
				+ "WHERE t_no = ?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, tNo);
			rs = pstmt.executeQuery();
//			private ArrayList<ReviewVo> tReview;
			
			if (rs.next()) {
				retVo = new TeacherVo();
				retVo.setTNo(rs.getString("t_no"));
				retVo.setTMajor(rs.getString("t_Major"));
				retVo.setOnlineYna(rs.getString("online_Yna"));
				retVo.setTTcnt(rs.getString("t_Tcnt"));
				retVo.setTTprice(rs.getString("t_Tprice"));
				retVo.setTWantstud(rs.getString("t_Wantstud"));
				retVo.setTCareer(rs.getString("t_Career"));
				retVo.setTLanguage(rs.getString("t_Language"));
				retVo.setTSpecial(rs.getString("t_Special"));
				retVo.setTApproval(rs.getString("t_Approval"));
				retVo.setTPermitYn(rs.getString("t_Permit_Yn"));
//				retVo.setTPicture(rs.getString("t_Picture"));
				retVo.setTIntro(rs.getString("t_Intro"));
				retVo.setTRecruitYn(rs.getString("t_Recruit_Yn"));
				retVo.setObjectList(rs.getString("object_List"));
				retVo.setAreaList(rs.getString("area_List"));
				retVo.setAvgRscore(rs.getDouble("avg_Rscore"));
				retVo.setMId(rs.getString("m_Id"));
				retVo.setTAge(rs.getInt("t_Age"));
				retVo.setMName(rs.getString("m_Name"));
				retVo.setMNickname(rs.getString("m_Nickname"));
				retVo.setGenderFm(rs.getString("gender_Fm"));
				retVo.setMAddress(rs.getString("m_Address"));
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return retVo;
	}
	
	// 선생님 교습정보 수정
	public int updateTeacher(Connection conn, TeacherVo vo){
		int retsult = 0;
		
		return retsult;
	}
	
	// 선생님 통화허용 여부 변경
	public int updateTeacherPermit(Connection conn, String tNo){
		int retsult = 0;
		
		return retsult;
	}
}
