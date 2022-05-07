package kh.semi.thduo.member.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import kh.semi.thduo.member.service.MemberService;
import kh.semi.thduo.member.vo.MemberVo;

/**
 * Servlet implementation class MemberLoginController
 */
@WebServlet("/findStr")
public class MemberFindStrAjaxController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MemberFindStrAjaxController() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("doGet -findStr");
		request.getRequestDispatcher("").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int result = 0;
		System.out.println("doPost - findStr");

		Enumeration params = request.getParameterNames(); //??
		while (params.hasMoreElements()) {
			String name = (String) params.nextElement();
			System.out.print(name + " : " + request.getParameter(name) + "     ");
		}
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		MemberService memberService = new MemberService(); //멤버 서비스 이동 
		String str = request.getParameter("str"); //?
		String type = request.getParameter("type"); //?
		result = memberService.readMemberCheck(str, type);
		if (result > 0) {
			out.print("not-usable");
		} else {
			out.print("usable");
		}
	}

}
