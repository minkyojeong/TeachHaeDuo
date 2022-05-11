package kh.semi.thduo.teacher.model.service;

import static kh.semi.thduo.common.jdbc.JdbcTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;

import kh.semi.thduo.like.model.vo.LikeVo;
import kh.semi.thduo.teacher.model.dao.TeacherDao;
import kh.semi.thduo.teacher.model.vo.TeacherSearchSettingVo;
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
	public ArrayList<TeacherVo> readAllTeacher(int startRnum, int endRnum) {
		ArrayList<TeacherVo> retVolist = null;
		Connection conn = getConnection();

		retVolist = dao.readAllTeacher(conn, startRnum, endRnum);

		close(conn);

		return retVolist;
	}

	// 선생님 세기
	public int countReadAllTeacher() {
		int result = 0;
		Connection conn = getConnection();

		result = dao.countReadAllTeacher(conn);

		close(conn);

		return result;
	}

	// 검색한 과목에 맞는 선생님 정보 읽기
	public ArrayList<TeacherVo> readTeacher(String object,int startRnum,int endRnum) {
		ArrayList<TeacherVo> retVolist = null;
		Connection conn = getConnection();

		retVolist = dao.readTeacher(conn, object, startRnum, endRnum);

		close(conn);

		return retVolist;
	}

	// 검색한 과목에 맞는 선생님 정보 개수 읽기
	public int countReadTeacher(String object) {
		int result = 0;
		Connection conn = getConnection();

		result = dao.countReadTeacher(conn, object);

		close(conn);

		return result;
	}

	// 성별 , 활동지역 맞는 선생님 정보 읽기
	public ArrayList<TeacherVo> readAreaGenderTeacher(String genderFm, String area) {
		ArrayList<TeacherVo> retVolist = null;
		Connection conn = getConnection();

		retVolist = dao.readAreaGenderTeacher(conn, genderFm, area);

		close(conn);

		return retVolist;
	}

	// 찜 여부 체크
	public LikeVo checkLike(String m_id, String t_no) {
		LikeVo retVo = null;
		Connection conn = getConnection();

		retVo = dao.checkLike(conn, m_id, t_no);

		close(conn);

		return retVo;
	}

	// 선생님 통합 검색
	public ArrayList<TeacherVo> searchTeacher(TeacherSearchSettingVo setVo, int startRnum, int entRnum) {
		ArrayList<TeacherVo> retVoList = null;
		Connection conn = getConnection();
		retVoList = dao.searchTeacher(conn, setVo, startRnum, entRnum);
		close(conn);
		return retVoList;
	}

	public int countTeacher(TeacherSearchSettingVo setVo) {
		int result = 0;
		Connection conn = getConnection();
		result = dao.countTeacher(conn, setVo);
		close(conn);
		return result;
	}

	// 선생님 상세정보 읽기
	public TeacherVo readTeacherInfo(String tNo) {
		TeacherVo retVo = null;
		Connection conn = getConnection();

		retVo = dao.readTeacherInfo(conn, tNo);

		close(conn);

		return retVo;
	}

	// 선생님 교습정보 수정
	public int updateTeacher(TeacherVo tVo) {
		int retsult = 0;
		Connection conn = getConnection();

		retsult = dao.updateTeacher(conn, tVo);

		close(conn);

		return retsult;
	}

	// 선생님 승인여부 체크
	public String checkApproval(String tNo) {
		String result = null;
		Connection conn = getConnection();

		result = dao.checkApproval(conn, tNo);
		close(conn);

		return result;
	}

	// 선생님 교습정보 등록 여부 확인
	public String checkProfile(String tNo) {
		String result = null;
		Connection conn = getConnection();

		result = dao.checkProfile(conn, tNo);
		close(conn);

		return result;
	}

	// 선생님 담당 과목 넣기
	public int insertObject(String[] objectArr, String tNo) {
		int result = 0;
		Connection conn = getConnection();
		System.out.println("담당 과목 서비스 objectArr: " + objectArr);
		String object = null;

		for (int i = 0; i < objectArr.length; i++) {
			object = objectArr[i];
			System.out.println("activeArea" + i + ":" + object);
			result = dao.insertObject(conn, object, tNo);
			System.out.println("활동지역 서비스 result: " + i + ":" + result);
			if (result == 1) {
				commit(conn);
			} else {
				rollback(conn);
			}
		}
		close(conn);

		return result;
	}

	// 선생님 담당 과목 삭제
	public int deleteObject(String tNo) {
		int result = 0;
		Connection conn = getConnection();

		result = dao.deleteObject(conn, tNo);
		if (result == 1) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);

		return result;
	}

	// 선생님 활동지역 넣기
	public int insertActiveArea(String[] activeAreaArr, String tNo) {
		int result = 0;
		Connection conn = getConnection();
		System.out.println("활동지역 서비스 activeArea: " + activeAreaArr);
		String activeArea = null;
		System.out.println("활동지역 서비스 result: " + result);
		for (int i = 0; i < activeAreaArr.length; i++) {
			activeArea = activeAreaArr[i];
			System.out.println("activeArea" + i + ":" + activeArea);
			result = dao.insertActiveArea(conn, activeArea, tNo);
			if (result == 1) {
				commit(conn);
			} else {
				rollback(conn);
			}
		}
		close(conn);

		return result;
	}

	// 선생님 활동지역 삭제
	public int deleteActiveArea(String tNo) {
		int result = 0;
		Connection conn = getConnection();
		result = dao.deleteActiveArea(conn, tNo);
		if (result == 1) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);

		return result;
	}
	// 성별에 맞는 선생님 정보 읽기
//		public ArrayList<TeacherVo> readGenderTeacher(String genderFm) {
//			ArrayList<TeacherVo> retVolist = null;
//			Connection conn = getConnection();
	//
//			retVolist = dao.readGenderTeacher(conn, genderFm);
	//
//			close(conn);
	//
//			return retVolist;
//		}
	//
//		// 활동지역에 맞는 선생님 정보 읽기
//		public ArrayList<TeacherVo> readAreaTeacher(String area) {
//			ArrayList<TeacherVo> retVolist = null;
//			Connection conn = getConnection();
	//
//			retVolist = dao.readAreaTeacher(conn, area);
	//
//			close(conn);
	//
//			return retVolist;
//		}

	// 온-오프 여부에 맞는 선생님 정보 읽기
//		public ArrayList<TeacherVo> readOnlineTeacher(String onlineYna) {
//			ArrayList<TeacherVo> retVolist = null;
//			Connection conn = getConnection();
	//
//			retVolist = dao.readOnlineTeacher(conn, onlineYna);
	//
//			close(conn);
	//
//			return retVolist;
//		}

	// 통화허용 여부에 맞는 선생님 정보 읽기
//		public ArrayList<TeacherVo> readCallTeacher(String tPermitYn){
//			ArrayList<TeacherVo> retVolist = null;
//			Connection conn = getConnection();
//			
//			retVolist = dao.readCallTeacher(conn, tPermitYn);
//			
//			close(conn);
//			
//			return retVolist;
//		}

	// 모집 여부에 맞는 선생님 정보 읽기
//		public ArrayList<TeacherVo> readRecruitTeacher(String tRecruitYn) {
//			ArrayList<TeacherVo> retVolist = null;
//			Connection conn = getConnection();
	//
//			retVolist = dao.readRecruitTeacher(conn, tRecruitYn);
	//
//			close(conn);
	//
//			return retVolist;
//		}
	//
//		// 찜 여부에 맞는 선생님 정보 읽기
//		public ArrayList<TeacherVo> readLikeTeacher(String sNo) {
//			ArrayList<TeacherVo> retVolist = null;
//			Connection conn = getConnection();
	//
//			retVolist = dao.readLikeTeacher(conn, sNo);
	//
//			close(conn);
	//
//			return retVolist;
//		}
	// 선생님 통화허용 여부 변경
//	public int updateTeacherPermit(String tNo) {
//		int retsult = 0;
//		Connection conn = getConnection();
//
//		retsult = dao.updateTeacherPermit(conn, tNo);
//
//		close(conn);
//
//		return retsult;
//	}
//
//	// 선생님 프로필 사진 등록/변경
//	public int updateProfilePicture(TeacherVo tVo) {
//		int result = 0;
//		Connection conn = getConnection();
//
//		result = dao.updateProfilePicture(conn, tVo);
//		if (result == 1) {
//			commit(conn);
//		} else {
//			rollback(conn);
//		}
//		close(conn);
//
//		return result;
//	}
}
