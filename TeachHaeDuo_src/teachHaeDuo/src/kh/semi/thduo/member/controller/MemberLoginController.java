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
 * Servlet implementation class MemberLoginController
 */
@WebServlet("/login")
public class MemberLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberLoginController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet - login 페이지 이동");
		request.getRequestDispatcher("WEB-INF/view/member/login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//회원가입
		String mId = request.getParameter("id");
		String pw = request.getParameter("pwd");
		
		System.out.println("doPost - login");
		System.out.println(mId);
		System.out.println(pw);
		
		
		MemberVo vo = new MemberService().login(mId, pw);
		if(vo == null) {
			response.sendRedirect("login");
		} else {
			request.getSession().setAttribute("ssMV", vo);
			response.sendRedirect(request.getContextPath()+"/");   // 절대경로를 의미하며 -context root가 없음.
//			response.sendRedirect("./");   // 상대경로
		}
		
	}

}












