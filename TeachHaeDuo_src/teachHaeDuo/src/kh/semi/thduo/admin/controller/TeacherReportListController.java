package kh.semi.thduo.admin.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.semi.thduo.admin.vo.AdminVo;
import kh.semi.thduo.report.model.service.ReportService;
import kh.semi.thduo.report.model.vo.ReportVo;

/**
 * Servlet implementation class TeacherReportListController
 */
@WebServlet("/teacherReportList")
public class TeacherReportListController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TeacherReportListController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("선생님 신고 관리 doGet");

		// 관리자 로그인 확인
		AdminVo aVo = (AdminVo) request.getSession().getAttribute("ssMV");
		if (aVo == null) { // 관리자 로그인 안되어있다면
			request.getSession().setAttribute("msgLogin", "로그인 먼저 해주세요");
			response.sendRedirect("login");
			return;
		} else { // 되어있다면

			// 화면에 뿌려줄 데이터 가지고 오기
			ArrayList<ReportVo> voList = new ReportService().readAllReport();
			if (voList != null) {
				// 가져온 데이터 request에 담기
				request.setAttribute("voList", voList);
				// 정보 들고 리스트 페이지 이동
				request.getRequestDispatcher("WEB-INF/view/admin/teacherReportList.jsp").forward(request, response);
			} else {
				// 조회 실패
				request.getSession().setAttribute("msgTeacherReportList", "정보 조회에 실패했습니다.");
				response.sendRedirect("adminMain");
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		doGet(request, response);
//	}

}
