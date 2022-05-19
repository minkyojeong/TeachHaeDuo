package kh.semi.thduo.member.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.semi.thduo.alarm.model.service.AlarmService;
import kh.semi.thduo.alarm.model.vo.AlarmVo;
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("doGet - login 페이지 이동");

		request.getRequestDispatcher("WEB-INF/view/member/login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("doPost - login");
		// 로그인시 id, pw 받기 
		String mId = request.getParameter("id");
		String pw = request.getParameter("pwd");
		System.out.println(mId);
		System.out.println(pw);
		MemberVo vo = new MemberService().readFindId(mId);

		if (vo == null) {
            //로그인시 id 확인 작업 
			request.setAttribute("login_msg", "아이디가 없습니다.");
			request.getRequestDispatcher("WEB-INF/view/member/login.jsp").forward(request, response);
			return;
		}
            // 로그인  id 와 pw 확인 시  없으면 
		MemberVo vo2 = new MemberService().login(mId, pw);
		if (vo2 == null) {
			request.setAttribute("login_msg", "비밀번호가 틀렸습니다.");
			request.getRequestDispatcher("WEB-INF/view/member/login.jsp").forward(request, response);
			return;
		} else {
            // 로그인  id와 pw 맞으면 메인이동 
			request.getSession().setAttribute("ssMV", vo2);
			String mNickname = vo2.getmNickname();
			System.out.println("받은 알람 서비스 호출 mNickname:" + mNickname);
			List<AlarmVo> result = new AlarmService().receiveIdList(mNickname);
			System.out.println("리스트 결과:" + result);
			request.getSession().setAttribute("nicknameList", result);
			response.sendRedirect(request.getContextPath() + "/"); // 절대경로를 의미하며 -context root가 없음.
			return;
		}
	}
}
