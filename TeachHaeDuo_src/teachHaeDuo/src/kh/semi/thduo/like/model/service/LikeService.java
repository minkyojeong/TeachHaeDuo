package kh.semi.thduo.like.model.service;

import static kh.semi.thduo.common.jdbc.JdbcTemplate.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import kh.semi.thduo.like.model.dao.LikeDao;
import kh.semi.thduo.like.model.vo.LikeVo;

public class LikeService {
	private LikeDao dao = new LikeDao();
	
	// 찜하기 삽입
	public int insertLike(String m_id, String t_no) {
		int result = 0;
		Connection conn = getConnection();
		
		result = dao.insertLike(conn, m_id, t_no);
		
		close(conn);

		return result;
	}

	// 찜하기 취소
	public int deleteLike(String s_no, String t_no) {
		int result = 0;
		Connection conn = getConnection();
		
		result = dao.deleteLike(conn, s_no, t_no);
		
		close(conn);

		return result;
	}

	// 자기가 찜한 선생님 리스트 모두 보기
	public ArrayList<LikeVo> readLikeList(String m_id) {
		ArrayList<LikeVo> retVolist = null;
		Connection conn = getConnection();

		retVolist = dao.readLikeList(conn, m_id);
		
		close(conn);
		
		return retVolist;
	}
}
