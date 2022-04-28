package kh.semi.thduo.review.model.service;

import static kh.semi.thduo.common.jdbc.JdbcTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;

import kh.semi.thduo.review.model.dao.ReviewDao;
import kh.semi.thduo.review.model.vo.ReviewVo;

public class ReviewService {
	private ReviewDao dao = new ReviewDao();

	// 해당 선생님에게 쪽지전송 여부 확인
	public int checkMessage(String alarm_sendid, String alarm_receiveid) {
		int result = 0;
		Connection conn = getConnection();
		
		result = dao.checkMessage(conn, alarm_sendid, alarm_receiveid);
		
		close(conn);
		
		return result;
	}

	// 리뷰 삽입
	public int insertReview(ReviewVo vo) {
		int result = 0;
		Connection conn = getConnection();

		result = dao.insertReview(conn, vo);

		close(conn);

		return result;
	}

	// 리뷰 삭제
	public int deleteReview(int t_r_no) {
		int result = 0;
		Connection conn = getConnection();

		result = dao.deleteReview(conn, t_r_no);

		close(conn);

		return result;
	}

	// 리뷰 모두 읽기
	public ArrayList<ReviewVo> readAllReview() {
		ArrayList<ReviewVo> retVolist = null;
		Connection conn = getConnection();

		retVolist = dao.readAllReview(conn);

		close(conn);

		return retVolist;
	}
}
