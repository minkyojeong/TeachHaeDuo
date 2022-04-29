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

/**
 * Servlet implementation class ReviewDeleteAjaxController
 */
@WebServlet("/reviewDelete.ax")
public class ReviewDeleteAjaxController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReviewDeleteAjaxController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost - reviewDelete.ax");
		PrintWriter out = response.getWriter();
		
		String strT_r_no = request.getParameter("t_r_no");
		int t_r_no = 0;
		
		try {
			t_r_no = Integer.parseInt(strT_r_no);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("t_r_no : " + t_r_no);
		
		// 로그인 여부 확인
		MemberVo ssvo = (MemberVo) request.getSession().getAttribute("ssMV");
		if(ssvo == null) {
			out.print(0);
			out.flush();
			out.close();
			return;
		}
		
		int result = new ReviewService().deleteReview(t_r_no);
		if(result < 1) {
			out.print(-1);
		} else {
			out.print(1);
		}
		
		out.flush();
		out.close();
	}

}
