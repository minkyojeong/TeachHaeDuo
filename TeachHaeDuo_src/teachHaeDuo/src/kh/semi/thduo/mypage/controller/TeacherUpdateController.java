package kh.semi.thduo.mypage.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.semi.thduo.member.service.MemberService;
import kh.semi.thduo.member.vo.MemberVo;

/**
 * Servlet implementation class TeacherUpdateController
 */
@WebServlet("/teacherUpdate")
public class TeacherUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TeacherUpdateController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 입력받은 데이터 가져오기
		String pw = request.getParameter("pw");

		// 로그인 상태 확인
		MemberVo ssMV = (MemberVo) request.getSession().getAttribute("ssMV");

		// 로그인 안되어있다면
		if (ssMV == null) {
			request.getSession().setAttribute("msgLogin", "로그인 먼저 해주세요");
			response.sendRedirect("login");
			return;
		}
		// 아이디 비밀번호 확인
		MemberVo vo = new MemberService().login(ssMV.getmId(), pw);

		// 입력된 정보 다르다면
		if (vo == null) {
			request.getSession().setAttribute("msgPw", "비밀번호가 틀렸습니다. 다시 로그인해주세요");
			response.sendRedirect("teacherUpdateLogin");
		} else { // 입력된 정보가 맞으면
			request.getRequestDispatcher("WEB-INF/view/mypage/teacherUpdate.jsp").forward(request, response);
		}
	}

}
