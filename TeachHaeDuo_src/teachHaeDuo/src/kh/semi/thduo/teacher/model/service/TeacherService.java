package kh.semi.thduo.teacher.model.service;

import static kh.semi.thduo.common.jdbc.JdbcTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;

import kh.semi.thduo.common.jdbc.JdbcUtil;
import kh.semi.thduo.like.model.vo.LikeVo;
import kh.semi.thduo.member.vo.MemberVo;
import kh.semi.thduo.pencil.model.service.PencilService;
import kh.semi.thduo.pencil.model.vo.PencilVo;
import kh.semi.thduo.teacher.model.dao.TeacherDao;
import kh.semi.thduo.teacher.model.vo.TeacherSearchSettingVo;
import kh.semi.thduo.teacher.model.vo.TeacherVo;

public class TeacherService {

	private TeacherDao dao = new TeacherDao();

	// 선생님 교습정보 삽입
	public int insertTeacherInit(String mId) {
		int result = 0;
		Connection conn = getConnection();

		result = dao.insertTeacherInit(conn, mId);

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
	public ArrayList<TeacherVo> readTeacher(String object, int startRnum, int endRnum) {
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
	public int updateTeacher(TeacherVo tVo, PencilVo pVo, String[] objectArr, String[] activeAreaArr,
			String profileYn) {
		int result = 0;
		System.out.println("서비스 tVo:" + tVo);

		SqlSession session = JdbcUtil.getSqlSession();
		result = dao.updateTeacher(session, tVo);
		if (result < 1) { // 실패
			System.out.println("교습 정보 업데이트 실패");
			session.rollback();
			return 0;
		} else { // 성공
			System.out.println("교습 정보 업데이트 성공");
			System.out.println("서비스 pVo:" + pVo);
			result = new PencilService().minusPencil(pVo);
			System.out.println("서비스 연필 테이블 result :" + result);
			if (result < 1) { // 실패
				System.out.println("연필 정보 업데이트 실패");
				session.rollback();
				return 0;
			} else { // 성공
				System.out.println("연필 정보 업데이트 성공");
				if (profileYn.equals("Y")) { // 기존 프로필이 있다면 담당 과목 삭제
					result = dao.deleteObject(session, tVo.getT_no());
					if (result < 1) { // 실패
						System.out.println("담당과목 삭제 실패");
						session.rollback();
						return 0;
					} else { // 성공 담당과목 넣기
						System.out.println("담당과목 삭제 성공");
						for (int i = 0; i < objectArr.length; i++) {
							String object = objectArr[i];
							System.out.println("activeArea" + i + ":" + object);
							result = dao.insertObject(session, object, tVo.getT_no());
							System.out.println("활동지역 서비스 result: " + i + ":" + result);
							if (result == 0) {
								// insert에 실패했다면 더 이상 지역 서비스를 insert할 필요 없으므로
								break;
							}
						}
						// 하나라도 insert 실패했다면
						if (result == 0) {
							System.out.println("담당과목 삽입 실패");
							session.rollback();
							return 0;
						} else { // 전부 성공했다면 기존 활동지역 삭제
							System.out.println("담당과목 삽입 성공");
							result = dao.deleteActiveArea(session, tVo.getT_no());
							if (result < 1) { // 실패
								System.out.println("활동지역 삭제 실패");
								session.rollback();
								return 0;
							} else { // 성공 활동지역 삽입
								System.out.println("활동지역 삭제 성공");
								for (int i = 0; i < activeAreaArr.length; i++) {
									String activeArea = activeAreaArr[i];
									System.out.println("activeArea" + i + ":" + activeArea);
									result = dao.insertActiveArea(session, activeArea, tVo.getT_no());
									if (result == 0) {
										System.out.println("활동지역 삽입 실패");
										// insert에 실패했다면 더 이상 지역 서비스를 insert할 필요 없으므로
										break;
									}
								}
								if (result == 0) { // 하나라도 실패했다면
									session.rollback();
									return 0;
								}
							}
						}
					}
				} else if (profileYn.equals("N")) { // 교습서 최초등록
					result = dao.updateTeacher(session, tVo);
					if (result < 1) { // 실패
						session.rollback();
						return 0;
					} else { // 성공 했다면 연필 차감
						result = new PencilService().minusPencil(pVo);
						if (result < 1) { // 실패
							session.rollback();
							return 0;
						} else { // 성공 했다면 담당 과목 넣기
							for (int i = 0; i < objectArr.length; i++) {
								String object = objectArr[i];
								System.out.println("activeArea" + i + ":" + object);
								result = dao.insertObject(session, object, tVo.getT_no());
								System.out.println("활동지역 서비스 result: " + i + ":" + result);
								if (result == 0) {
									// insert에 실패했다면 더 이상 지역 서비스를 insert할 필요 없으므로
									break;
								}
							}
							// 하나라도 insert 실패했다면
							if (result == 0) {
								session.rollback();
								return 0;
							} else { // 성공 했다면 활동 지역 넣기
								for (int i = 0; i < activeAreaArr.length; i++) {
									String activeArea = activeAreaArr[i];
									System.out.println("activeArea" + i + ":" + activeArea);
									result = dao.insertActiveArea(session, activeArea, tVo.getT_no());
									if (result == 0) {
										// insert에 실패했다면 더 이상 지역 서비스를 insert할 필요 없으므로
										break;
									}
								}
								if (result == 0) { // 하나라도 실패했다면
									session.rollback();
									return 0;
								}
							}
						}
					}
				}
			}
		}
		System.out.println("커밋!!!!!!!");
		session.commit();
		return result;
	}

	// 선생님 승인여부 체크
	public String checkApproval(String tNo) {
		String result = null;
		SqlSession session = JdbcUtil.getSqlSession();
		result = dao.checkApproval(session, tNo);

		return result;
	}

	// 선생님 교습정보 등록 여부 확인
	public String checkProfile(String tNo) {
		String result = null;
		SqlSession session = JdbcUtil.getSqlSession();
		result = dao.checkProfile(session, tNo);

		return result;
	}

	// 선생님 프로필 사진 등록/변경
	public int updateProfilePicture(TeacherVo tVo) {
		int result = 0;
		SqlSession session = JdbcUtil.getSqlSession();
		System.out.println("service vo:"+tVo);
		result = dao.updateProfilePicture(session, tVo);
		System.out.println("service result:"+result);
		if(result > 0) {
			session.commit();
		}
		return result;
	}

	// 선생님 모집여부 변경
	public int recruitYNChange(MemberVo vo) {
		int result = 0;
		SqlSession session = JdbcUtil.getSqlSession();
		System.out.println("service vo:"+vo);
		result = dao.recruitYNChange(session, vo);
		System.out.println("service result:"+result);
		if(result > 0) {
			session.commit();
		}
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

//	// 선생님 담당 과목 넣기
//		public int insertObject(String[] objectArr, String tNo) {
//			int result = 0;
//			Connection conn = getConnection();
//			System.out.println("담당 과목 서비스 objectArr: " + objectArr);
//			String object = null;
//
//			for (int i = 0; i < objectArr.length; i++) {
//				object = objectArr[i];
//				System.out.println("activeArea" + i + ":" + object);
//				result = dao.insertObject(conn, object, tNo);
//				System.out.println("활동지역 서비스 result: " + i + ":" + result);
//				if (result == 0) {
//					// insert에 실패했다면 더 이상 지역 서비스를 insert할 필요 없으므로
//					break;
//				}
//			}
//			// 하나라도 insert 실패했다면
//			if (result == 0) {
//				rollback(conn);
//			} else { // 전부 성공했다면
//				commit(conn);
//			}
//			close(conn);
//
//			return result;
//		}
//
//		// 선생님 담당 과목 삭제
//		public int deleteObject(String tNo) {
//			int result = 0;
//			Connection conn = getConnection();
//
//			result = dao.deleteObject(conn, tNo);
//			if (result == 1) {
//				commit(conn);
//			} else {
//				rollback(conn);
//			}
//			close(conn);
//
//			return result;
//		}
//
//		// 선생님 활동지역 넣기
//		public int insertActiveArea(String[] activeAreaArr, String tNo) {
//			int result = 0;
//			Connection conn = getConnection();
//			setAutocommit(conn, false);
//			System.out.println("활동지역 서비스 activeArea: " + activeAreaArr);
//			String activeArea = null;
//			System.out.println("활동지역 서비스 result: " + result);
//			for (int i = 0; i < activeAreaArr.length; i++) {
//				activeArea = activeAreaArr[i];
//				System.out.println("activeArea" + i + ":" + activeArea);
//				result = dao.insertActiveArea(conn, activeArea, tNo);
//				if (result == 0) {
//					// insert에 실패했다면 더 이상 지역 서비스를 insert할 필요 없으므로
//					break;
//				}
//			}
//			// 하나라도 insert 실패했다면
//			if (result == 0) {
//				rollback(conn);
//			} else { // 전부 성공했다면
//				commit(conn);
//			}
//			close(conn);
//
//			return result;
//		}
//
//		// 선생님 활동지역 삭제
//		public int deleteActiveArea(String tNo) {
//			int result = 0;
//			Connection conn = getConnection();
//			result = dao.deleteActiveArea(conn, tNo);
//			if (result == 1) {
//				commit(conn);
//			} else {
//				rollback(conn);
//			}
//			close(conn);
//
//			return result;
//		}

	// 선생님 교습정보 최초 등록
//		public int updateTeacherInit(TeacherVo tVo, PencilVo pVo, String[] objectArr, String[] activeAreaArr) {
//			int result = 0;
//			Connection conn = getConnection();
//			setAutocommit(conn, false);
//			System.out.println("서비스 tVo:" + tVo);
//			result = dao.updateTeacherInit(conn, tVo, pVo, objectArr, activeAreaArr);
	//
//			if (result < 1) { // 쿼리문 여러개 중에 하나라도 실패하면
//				rollback(conn);
//			} else { // 모두 다 성공한다면
//				commit(conn);
//			}
//			close(conn);
	//
//			return result;
//		}
}
