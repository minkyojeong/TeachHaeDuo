package kh.semi.thduo.admin.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.semi.thduo.admin.vo.AdminVo;
import kh.semi.thduo.member.service.MemberService;
import kh.semi.thduo.member.vo.MemberVo;
import kh.semi.thduo.teacher.model.service.TeacherService;
import kh.semi.thduo.teacher.model.vo.TeacherVo;

/**
 * Servlet implementation class TeacherListController
 */
@WebServlet("/teacherApprovalList")
public class TeacherApprovalListController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TeacherApprovalListController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("doGet - teacherList 페이지 이동");

		AdminVo aVo = (AdminVo) request.getSession().getAttribute("ssMV");

		// 관리자 로그인이 안되어있다면
		if (aVo == null) {
			request.getSession().setAttribute("msgLogin", "로그인 먼저 해주세요");
			response.sendRedirect("login");
			return;
		} else {
			// 화면에 뿌려줄 선생님 데이터 가져오기
			ArrayList<MemberVo> voList = new TeacherService().readTeacherApprovalList();
			// 데이터 잘 가져왔다면
			if (voList != null) {
				// 가져온 데이터 request에 담기
				request.setAttribute("voList", voList);
				// 정보 들고 리스트 페이지 이동
				request.getRequestDispatcher("WEB-INF/view/admin/teacherApprovalList.jsp").forward(request, response);
			} else {
				// 조회 실패
				request.getSession().setAttribute("msgApprovalList", "정보 조회에 실패했습니다.");
				response.sendRedirect("adminMain");
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//	}

}
