package kh.semi.thduo.mypage.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.semi.thduo.member.vo.MemberVo;
import kh.semi.thduo.teacher.model.service.TeacherService;

/**
 * Servlet implementation class TeacherUpdateLoginController
 */
@WebServlet("/teacherUpdateLogin")
public class TeacherUpdateLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TeacherUpdateLoginController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 로그인 정보 확인
		MemberVo ssMV = (MemberVo) request.getSession().getAttribute("ssMV");
		// 로그인 안되어있다면
		if (ssMV == null) {
			request.getSession().setAttribute("msgLogin", "로그인 먼저 해주세요");
			response.sendRedirect("login");
			return;
		}
		String tNo = ssMV.gettNo();
		// 변수에 잘 담겼다면
		if (tNo != null) {
			// 승인 여부 알아오기
			String approvalYn = new TeacherService().checkApproval(tNo);
			System.out.println("승인여부: " + approvalYn);
			
			// 관리자 승인이 된 경우
			if (approvalYn.equals("Y")) {
				request.getRequestDispatcher("WEB-INF/view/mypage/teacherUpdateLogin.jsp").forward(request, response);
			} else { // 안된 경우
				request.getSession().setAttribute("msgApproval", "관리자의 승인 후 교습 정보 등록이 가능합니다.");
				response.sendRedirect("mypage");
			}
		} else { // 변수에 잘 안담김
			request.getSession().setAttribute("msgApproval", "정보를 찾을 수 없습니다. 다시 시도해주세요.");
			response.sendRedirect("mypage");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		doGet(request, response);
//	}

}
