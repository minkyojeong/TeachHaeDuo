package kh.semi.thduo.member.service;

import static kh.semi.thduo.common.jdbc.JdbcTemplate.close;
import static kh.semi.thduo.common.jdbc.JdbcTemplate.commit;
import static kh.semi.thduo.common.jdbc.JdbcTemplate.getConnection;
import static kh.semi.thduo.common.jdbc.JdbcTemplate.rollback;
import static kh.semi.thduo.common.jdbc.JdbcTemplate.setAutocommit;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;

import kh.semi.thduo.common.jdbc.JdbcUtil;
import kh.semi.thduo.member.dao.MemberDao;
import kh.semi.thduo.member.vo.MemberVo;
import kh.semi.thduo.pencil.model.dao.PencilDao;
import kh.semi.thduo.pencil.model.service.PencilService;
import kh.semi.thduo.student.dao.StudentDao;
import kh.semi.thduo.student.service.StudentService;
import kh.semi.thduo.student.vo.StudentVo;
import kh.semi.thduo.teacher.model.dao.TeacherDao;

public class MemberService {

	private MemberDao dao = new MemberDao();
	private StudentDao stuDao = new StudentDao();
	private TeacherDao teacherDao = new TeacherDao();
	private PencilDao penDao = new PencilDao();

	// 회원가입 ok
	public int insertMember(MemberVo vo) {
		int result = 0;
		Connection conn = getConnection();
		setAutocommit(conn, false);

		System.out.println("회원가입 시작");
		
		result = dao.insertMember(conn, vo);
		System.out.println("member 테이블 insert 결과 : " + result);
		
		if (result < 1) {
			rollback(conn);
			close(conn);
			return 0;
		}

		System.out.println("member 테이블 insert 결과 : " + result);
		if (vo.getRoleSt().equals("S")) { // 받은 값이 S이면
			System.out.println("학생입니다.");
			
			String sNo = new StudentService().readStudentCheck();// readStudentCheck DB가서 번호 체크
			if (sNo == null) { // 수정 요청으로 수정 
				sNo = "S1";
			} else {
				int no = Integer.parseInt(sNo) + 1;
				sNo = "S".concat(no + "");
			}
			StudentVo sVo = new StudentVo(); //
			sVo.setmId(vo.getmId());
			sVo.setsNo(sNo);
			result = stuDao.insertStudent(conn, sVo);  
			
			if (result < 1) {
				rollback(conn);
				close(conn);
				return 0;
			}
		}
		if (vo.getRoleSt().equals("T")) {
			System.out.println("선생님 입니다.");

			result = teacherDao.insertTeacherInit(conn, vo.getmId());

			if (result < 1) {
				rollback(conn);
				close(conn);
				return 0;
			}
		}
			
			
		if (result == 1) {
			// 연필 테이블에 기본 insert
			SqlSession session = JdbcUtil.getSqlSession();
			result = penDao.insertPencilInit(session, vo.getmId());
			
			if (result < 1) {
				rollback(conn);
				close(conn);
				return 0;
			} 
		}

		commit(conn);
		close(conn);

		return result;
	}

	// 회원 로그인 ok
	public MemberVo login(String mId, String pw) {
		MemberVo retVo = null;
		Connection conn = getConnection();
		retVo = dao.login(conn, mId, pw);
		close(conn);
		return retVo;
	}

	// 체크로직 ok
	public int readMemberCheck(String str, String type) {
		int i = 0;
		System.out.println("str1 = " + str);
		Connection conn = getConnection();
		i = dao.readMemberCheck(conn, str, type);
		close(conn);
		return i;

	}

	// pw찾기 - id, email 확인
	public int readFindPw(String mId, String mEmail) {

		int result = 0;
		Connection conn = getConnection();
		result = dao.readFindPw(conn, mId, mEmail);
		close(conn);
		System.out.println("MemberService result: id,이메일일 확인  " + result);
		return result;
	}

	// id찾기-ok
	public MemberVo readFindId(String mEmail, String mName) {
		MemberVo retVo = null;
		Connection conn = getConnection();
		retVo = dao.readFindId(conn, mEmail, mName);
		close(conn);
		return retVo;
	}

	// 새(임시) 비밀번호
	public int updateRandomPw(String mPw, String mId) {
		int result = 0;
		Connection conn = getConnection();
		result = dao.updateRandomPw(conn, mPw, mId); // TODO
		close(conn);
		return result;
	}

	// 회원 전체조회 (관리자 회원전체 조회)
	public ArrayList<MemberVo> readAllMember() {
		ArrayList<MemberVo> retVolist = null;
		Connection conn = getConnection();
		retVolist = dao.readAllMember(conn);
		close(conn);
		return retVolist;
	}

	// 회원삭제 (관리자 강퇴)
	public int deleteMember(String mId) {
		System.out.println("회원탈퇴 service, 아이디: " + mId);

		int result = 0;
		SqlSession session = JdbcUtil.getSqlSession();
		result = dao.deleteMember(session, mId);
		System.out.println("회원탈퇴 service, result" + result);
		session.close();
		return result;
	}

	// 회원수정
	public int updateMember(MemberVo vo) {
		int result = 0;
		SqlSession session = JdbcUtil.getSqlSession();
		result = dao.updateMember(session, vo);
		session.close();
		return result;
	}

	// 회원 전체 삭제
	public int deleteAllMember() {
		int result = 0;
		Connection conn = getConnection();
		result = dao.deleteAllMember(conn);
		close(conn);
		return result;
	}

	// 로그인시 id 확인작업
	public MemberVo readFindId(String mId) {
		MemberVo retVo = null;
		Connection conn = getConnection();
		retVo = dao.readFindId(conn, mId);
		close(conn);
		return retVo;
	}

}
