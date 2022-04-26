package kh.semi.thduo.review.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.semi.thduo.review.model.service.ReviewService;
import kh.semi.thduo.review.model.vo.ReviewVo;

/**
 * Servlet implementation class ReviewInsertAjaxController
 */
@WebServlet("/reviewInsert.ax")
public class ReviewInsertAjaxController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ReviewInsertAjaxController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("doPost - reviewInsert.ax");
		PrintWriter out = response.getWriter();

		String t_no = request.getParameter("t_no");
		String t_r_content = request.getParameter("t_r_content");
		String strScore = request.getParameter("t_r_score");
		int t_r_score = 0;

		try {
			t_r_score = Integer.parseInt(strScore);
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("t_no : " + t_no);
		System.out.println("t_r_content : " + t_r_content);
		System.out.println("t_r_score : " + t_r_score);

		ReviewVo vo = new ReviewVo();
		vo.setT_no(t_no);
		vo.setT_r_content(t_r_content);
		vo.setT_r_score(t_r_score);
		vo.setT_r_writer("홍기");
		vo.setM_id("a12345");
		
		int result = new ReviewService().insertReview(vo);
		if(result < 1) {
			out.print(-1);
		} else {
			out.print(1);
		}

		// 모두 완성 되면 아래 주석 풀고 확인
//		ReportVo vo = new ReportVo();
//		vo.setT_no(t_no);
//		vo.setT_r_content(t_r_content);
//		vo.setT_r_score(t_r_score);
//		// 로그인 여부 확인(이미 로그인 확인 했지만 로그아웃 했을 수도 있으니까 로그인 여부 다시 확인)
//		MemberVo ssvo = (MemberVo) request.getSession().getAttribute("ssMV");
//		if(ssvo == null) {
//			out.print(0);
//			out.flush();
//			out.close();
//			return; // DB에 저장하지 않아도 되니까
//		} else {
//			vo.setT_r_writer(ssvo.getmNickName);
//			vo.setM_id(ssvo.getmId());
//		}
//		// DB에 저장
//		int result = new BoardService().writeBoard(vo);
//		if (result < 1) { // 글등록 실패(글등록으로 이동)
//			out.print("실패");
//		} else { // 글등록 성공(글목록으로 이동)
//			out.print("성공");
//		}

		out.flush();
		out.close();
	}

}
