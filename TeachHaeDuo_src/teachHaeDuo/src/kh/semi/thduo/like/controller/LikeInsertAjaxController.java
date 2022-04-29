package kh.semi.thduo.like.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.semi.thduo.like.model.service.LikeService;
import kh.semi.thduo.member.vo.MemberVo;

/**
 * Servlet implementation class LikeInsertAjaxController
 */
@WebServlet("/likeInsert.ax")
public class LikeInsertAjaxController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LikeInsertAjaxController() {
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
		System.out.println("doPost - likeInsert.ax");
		
		PrintWriter out = response.getWriter();
		
		String m_id = request.getParameter("liked_id");
		String t_no = request.getParameter("t_no");
		
		System.out.println("m_id : " + m_id);
		System.out.println("t_no : " + t_no);
		
		// 로그인 여부 확인
		MemberVo ssvo = (MemberVo) request.getSession().getAttribute("ssMV");
		if(ssvo == null) {
			out.print(0);
			out.flush();
			out.close();
			return;
		} 
		
		// DB에 저장
		int result = new LikeService().insertLike(ssvo.getmId(), t_no);
		if (result < 1) { // 찜 실패
			out.print(-1);
		} else { // 찜 성공
			out.print(1);
		}
		
		out.flush();
		out.close();
	}

}
