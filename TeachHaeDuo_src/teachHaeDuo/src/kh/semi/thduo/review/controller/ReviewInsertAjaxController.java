package kh.semi.thduo.review.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.semi.thduo.member.vo.MemberVo;
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

		String alarm_receiveid = request.getParameter("alarm_receiveid");
		String t_no = request.getParameter("t_no");
		String t_r_content = request.getParameter("t_r_content");
		String strScore = request.getParameter("t_r_score");
		int t_r_score = 0;
		
		try {
			t_r_score = Integer.parseInt(strScore);
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("alarm_receiveid : " + alarm_receiveid);
		System.out.println("t_no : " + t_no);
		System.out.println("t_r_content : " + t_r_content);
		System.out.println("t_r_score : " + t_r_score);

		ReviewVo vo = new ReviewVo();
		vo.setT_no(t_no);
		vo.setT_r_content(t_r_content);
		vo.setT_r_score(t_r_score);
		
		// ????????? ?????? ??????
		MemberVo ssvo = (MemberVo) request.getSession().getAttribute("ssMV");
		if(ssvo == null) {
			out.print(0);
			out.flush();
			out.close();
			return;
		} else {
			// ?????? ?????? ?????? ??????
			int check = new ReviewService().checkMessage(ssvo.getmNickname(), alarm_receiveid);
			
			if(check == 0) { // ?????? ??????????????? ?????? ?????? ??? ??????
				out.print(2);
				out.flush();
				out.close();
				return;
			}
			vo.setT_r_writer(ssvo.getmNickname());
			vo.setM_id(ssvo.getmId());
		}
		// DB??? ??????
		int result = new ReviewService().insertReview(vo);
		if (result < 1) { // ???????????? ??????
			out.print(-1);
		} else { // ???????????? ??????
			out.print(1);
		}

		out.flush();
		out.close();
	}

}
