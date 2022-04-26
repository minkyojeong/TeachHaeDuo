package kh.semi.thduo.teacher.model.service;

import static kh.semi.thduo.common.jdbc.JdbcTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;

import kh.semi.thduo.teacher.model.dao.TeacherDao;
import kh.semi.thduo.teacher.model.vo.TeacherVo;

public class TeacherService {
	
	private TeacherDao dao = new TeacherDao();
	
	// 선생님 교습정보 삽입
	public int insertTeacher(TeacherVo vo) {
		int result = 0;
		Connection conn = getConnection();
		
		result = dao.insertTeacher(conn, vo);
		
		close(conn);
		
		return result;
	}
	
	// 모든 선생님 정보 읽기
	public ArrayList<TeacherVo> readAllTeacher(){
		ArrayList<TeacherVo> retVolist = null;
		Connection conn = getConnection();
		
		retVolist = dao.readAllTeacher(conn);
		
		close(conn);
		
		return retVolist;
	} 
	
	// 검색한 과목에 맞는 선생님 정보 읽기
	public ArrayList<TeacherVo> readTeacher(String object) {
		ArrayList<TeacherVo> retVolist = null;
		Connection conn = getConnection();
		
		retVolist = dao.readTeacher(conn, object);
		
		close(conn);
		
		return retVolist;
	} 
	
	// 성별에 맞는 선생님 정보 읽기
	public ArrayList<TeacherVo> readGenderTeacher(String genderFm){
		ArrayList<TeacherVo> retVolist = null;
		Connection conn = getConnection();
		
		retVolist = dao.readGenderTeacher(conn, genderFm);
		
		close(conn);
		
		return retVolist;
	}
	
	// 활동지역에 맞는 선생님 정보 읽기
	public ArrayList<TeacherVo> readAreaTeacher(String area){
		ArrayList<TeacherVo> retVolist = null;
		Connection conn = getConnection();
		
		retVolist = dao.readAreaTeacher(conn, area);
		
		close(conn);
		
		return retVolist;
	}
	
	// 성별 , 활동지역 맞는 선생님 정보 읽기
	public ArrayList<TeacherVo> readAreaGenderTeacher(String genderFm, String area){
		ArrayList<TeacherVo> retVolist = null;
		Connection conn = getConnection();
		
		retVolist = dao.readAreaGenderTeacher(conn, genderFm, area);
		
		close(conn);
		
		return retVolist;
	}
	
	// 온-오프 여부에 맞는 선생님 정보 읽기
	public ArrayList<TeacherVo> readOnlineTeacher(String onlineYna){
		ArrayList<TeacherVo> retVolist = null;
		Connection conn = getConnection();
		
		retVolist = dao.readOnlineTeacher(conn, onlineYna);
		
		close(conn);
		
		return retVolist;
	}
	
	// 통화허용 여부에 맞는 선생님 정보 읽기
	public ArrayList<TeacherVo> readCallTeacher(String tPermitYn){
		ArrayList<TeacherVo> retVolist = null;
		Connection conn = getConnection();
		
		retVolist = dao.readCallTeacher(conn, tPermitYn);
		
		close(conn);
		
		return retVolist;
	}
	
	// 모집 여부에 맞는 선생님 정보 읽기
	public ArrayList<TeacherVo> readRecruitTeacher(String tRecruitYn){
		ArrayList<TeacherVo> retVolist = null;
		Connection conn = getConnection();
		
		retVolist = dao.readRecruitTeacher(conn, tRecruitYn);
		
		close(conn);
		
		return retVolist;
	}
	
	// 찜 여부에 맞는 선생님 정보 읽기
	public ArrayList<TeacherVo> readLikeTeacher(String sNo){
		ArrayList<TeacherVo> retVolist = null;
		Connection conn = getConnection();
		
		retVolist = dao.readLikeTeacher(conn, sNo);
		
		close(conn);
		
		return retVolist;
	}
	
	// 선생님 상세정보 읽기
	public TeacherVo readTeacherInfo(String tNo){
		TeacherVo retVo = null;
		Connection conn = getConnection();
		
		retVo = dao.readTeacherInfo(conn, tNo);
		
		close(conn);
		
		return retVo;
	}
	
	// 선생님 교습정보 수정
	public int updateTeacher(TeacherVo vo){
		int retsult = 0;
		Connection conn = getConnection();
		
		retsult = dao.updateTeacher(conn, vo);
		
		close(conn);
		
		return retsult;
	}
	
	// 선생님 통화허용 여부 변경
	public int updateTeacherPermit(String tNo){
		int retsult = 0;
		Connection conn = getConnection();
		
		retsult = dao.updateTeacherPermit(conn, tNo);
		
		close(conn);
		
		return retsult;
	}
}
