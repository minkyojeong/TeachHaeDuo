package kh.semi.thduo.member.controller;

import java.io.IOException;
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
@WebServlet("/findpwnew")
public class MemberFindPwNewController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberFindPwNewController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet - findpwnew 비밀번호 재설정 페이지 이동");
		request.getRequestDispatcher("WEB-INF/view/member/findpwnew.jsp").forward(request, response);
	}

	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 비밀번호 재설정 
		String mEmail = request.getParameter("");
		String mName = request.getParameter("");
		
		
		Enumeration params = request.getParameterNames();
		while(params.hasMoreElements()) {
		  String name = (String) params.nextElement();
		  System.out.print(name + " : " + request.getParameter(name) + "     "); 
		}
		
		System.out.println("doPost - findpwnew 비밀번호 재설정");
		System.out.println(mEmail);
		System.out.println(mName);
		
		
		MemberVo vo = new MemberService().readFindId(mEmail, mName);
		System.out.println(vo);
		if(vo == null) {
			response.sendRedirect(" findpwnew ");
		} else {
			//request.getSession().setAttribute("ssMV", vo);
			request.setAttribute("", vo.getmId());
			
			response.sendRedirect("findpwnew");   // 절대경로>>>request.getContextPath()
//			response.sendRedirect("./");   // 상대경로
		}
		
	}

}












