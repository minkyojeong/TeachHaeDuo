package kh.semi.thduo.student.service;

import static kh.semi.thduo.common.jdbc.JdbcTemplate.close;
import static kh.semi.thduo.common.jdbc.JdbcTemplate.getConnection;

import java.sql.Connection;
import kh.semi.thduo.student.dao.StudentDao;
import kh.semi.thduo.student.vo.StudentVo;

public class StudentService {

	private StudentDao dao = new StudentDao();

	public int insertStudent(StudentVo vo) {
		int result = 0;
		Connection conn = getConnection();
		result = dao.insertStudent(conn, vo);
		close(conn);
		return result;
	}

	public String readStudentCheck() {
		String result = "";
		Connection conn = getConnection();
		result = dao.readStudentCheck(conn);
		close(conn);
		return result;
	}

}
