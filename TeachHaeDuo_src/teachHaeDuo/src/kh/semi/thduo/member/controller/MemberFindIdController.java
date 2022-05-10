package kh.semi.thduo.member.controller;

import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet("/findid")
public class MemberFindIdController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberFindIdController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet - findId 페이지 이동");
		request.getRequestDispatcher("WEB-INF/view/member/findid.jsp").forward(request, response);
	}

	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// ajax로 들어옴
				PrintWriter out = response.getWriter();
				// 아이디 찾기
				String mEmail = request.getParameter("mEmail");
				String mName = request.getParameter("mName");
				
				
				Enumeration params = request.getParameterNames();
				while(params.hasMoreElements()) {
				  String name = (String) params.nextElement();
				  System.out.print(name + " : " + request.getParameter(name) + "     "); 
				}
				
				System.out.println("doPost - findId  아이디찾기");
				System.out.println(mEmail);
				System.out.println(mName);
				
				
				MemberVo vo = new MemberService().readFindId(mEmail, mName);
				System.out.println(vo );
				
				if(vo == null) {
					out.print("");
//					response.sendRedirect("findid");
				} else {
					//request.getSession().setAttribute("ssMV", vo);
//					request.setAttribute("mId", vo.getmId());
					out.print(vo.getmId());
//					response.sendRedirect("findid");   // 절대경로>>>request.getContextPath()
//					response.sendRedirect("./");   // 상대경로
				}
				out.flush();
				out.close();
			}

		}