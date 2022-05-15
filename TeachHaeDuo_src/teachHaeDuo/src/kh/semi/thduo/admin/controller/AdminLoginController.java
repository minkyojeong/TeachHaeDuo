package kh.semi.thduo.admin.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.semi.thduo.admin.service.AdminService;
import kh.semi.thduo.admin.vo.AdminVo;
import kh.semi.thduo.member.service.MemberService;
import kh.semi.thduo.member.vo.MemberVo;

/**
 * Servlet implementation class AdminLoginController
 */
@WebServlet("/adminLogin")
public class AdminLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminLoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println("doGet - adminlogin");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 관리자 로그인
		doGet(request, response);
		String adminId = request.getParameter("id");
		String adminPw = request.getParameter("pwd");

		System.out.println("doPost - adminlogin");
	
		AdminVo vo = new AdminService().login(adminId,adminPw);
        if(vo==null) {
        	request.setAttribute("login_msg", "로그인 실패했습니다.");
			request.getRequestDispatcher("WEB-INF/view/member/login.jsp").forward(request, response);
        }else {
        	System.out.println("로그인 성공");
			request.getSession().setAttribute("ssMV", vo);
			response.sendRedirect(request.getContextPath()+"/adminMain"); 
        }
	}
}
