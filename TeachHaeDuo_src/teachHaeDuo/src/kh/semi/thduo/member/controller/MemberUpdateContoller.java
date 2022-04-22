package kh.semi.thduo.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.semi.thduo.member.service.MemberService;
import kh.semi.thduo.member.vo.MemberVo;

/**
 * Servlet implementation class MemberUpdateContoller
 */
@WebServlet("/memberUpdate")
public class MemberUpdateContoller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberUpdateContoller() {
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
		// TODOTODO 로그인 갔다오기
		String pw = request.getParameter("pw");
		
		MemberVo ssMV = (MemberVo)request.getSession().getAttribute("ssMV");
		String mId = ssMV.getmId();
		
		MemberVo vo = new MemberService().login(mId, pw);
		if(vo == null) {
			response.sendRedirect("memberUpdateLogin");
		} else {
			request.getRequestDispatcher("WEB-INF/view/mypage/memberUpdate.jsp").forward(request, response);
		}
	}

}
