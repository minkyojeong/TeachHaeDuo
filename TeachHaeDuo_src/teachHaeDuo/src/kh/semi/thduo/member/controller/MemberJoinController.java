package kh.semi.thduo.member.controller;

import java.io.IOException;
import java.sql.Date;
import java.util.Enumeration;

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
@WebServlet("/join")
public class MemberJoinController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MemberJoinController() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("doGet - join");
		request.getRequestDispatcher("WEB-INF/view/member/join.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		System.out.println("doPost - join");
		
		Enumeration params = request.getParameterNames();
		while(params.hasMoreElements()) {
		  String name = (String) params.nextElement();
		  System.out.print(name + " : " + request.getParameter(name) + "     "); 
		}
		
		MemberVo memberVo = new MemberVo();
		
		memberVo.setmName(request.getParameter("mName"));
		memberVo.setmId(request.getParameter("mId"));
		memberVo.setmPw(request.getParameter("mPw"));
		memberVo.setmEmail(request.getParameter("mEmail"));
		memberVo.setmPhone(request.getParameter("mPhone"));
		memberVo.setmAddress(request.getParameter("mAddress1")+" "+request.getParameter("mAddress2"));
		memberVo.setGenderFm(request.getParameter("genderFm"));
		memberVo.setRoleSt(request.getParameter("roleSt"));
		memberVo.setmNickname(request.getParameter("mNickName"));
		memberVo.setmBirth(request.getParameter("mBirth"));
		
		
		int i = new MemberService().insertMember(memberVo);
		if (i > 0) {
			response.sendRedirect("login");
		} else {
			response.sendRedirect(request.getContextPath() + "/"); // 절대경로를 의미하며 -context root가 없음.

		}

	}

}
