package kh.semi.thduo.admin.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.semi.thduo.admin.vo.AdminVo;
import kh.semi.thduo.member.vo.MemberVo;
import kh.semi.thduo.pencil.model.service.PencilService;
import kh.semi.thduo.teacher.model.service.TeacherService;

/**
 * Servlet implementation class PencilChartController
 */
@WebServlet("/pencilChart")
public class PencilChartController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PencilChartController() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("doGet - pencilChart 페이지 이동");
		// 받아온 데이터값 변수에 넣기
		String type = request.getParameter("type");
		String numStr = request.getParameter("num");
		int num = -1;
		// 파싱이 안될경우 대비
		try {
			if (numStr != null) {
				num = Integer.parseInt(numStr);
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		System.out.println(type);
		System.out.println(num);
		// 관리자 세션 정보 받아오기
		AdminVo aVo = (AdminVo) request.getSession().getAttribute("ssMV");
		// 관리자 로그인이 안되어있다면
		if (aVo == null) {
			request.getSession().setAttribute("msgLogin", "로그인 먼저 해주세요");
			response.sendRedirect("login");
			return;
		} else { // 되어 있다면
			ArrayList<MemberVo> voList = null;
			// 전체 매출 조회
			if (type != null) {
				if (type.equals("A")) {
					// 화면에 뿌려줄 매출 데이터 가져오기
					voList = new PencilService().allPencilChart();
					// 데이터 들고 페이지 이동
					voListRequestForward(request, response, voList);
				}
				if (type.equals("M")) {
					// 화면에 뿌려줄 매출 데이터 가져오기
					voList = new PencilService().monthPencilChart(num);
					// 데이터 들고 페이지 이동
					voListRequestForward(request, response, voList);
				}
				if (type.equals("Y")) {
					// 화면에 뿌려줄 매출 데이터 가져오기
					voList = new PencilService().yearPencilChart(num);
					// 데이터 들고 페이지 이동
					voListRequestForward(request, response, voList);
				}
			} else {
				// 조회 실패
				request.getSession().setAttribute("msgPencilChart", "정보 조회에 실패했습니다.");
				response.sendRedirect("adminMain");
			}
		}
	}

	private void voListRequestForward(HttpServletRequest request, HttpServletResponse response,
			ArrayList<MemberVo> voList) throws ServletException, IOException {
		if (voList != null) {
			// 가져온 데이터 request에 담기
			request.setAttribute("voList", voList);
			// 정보 들고 리스트 페이지 이동
			request.getRequestDispatcher("WEB-INF/view/admin/pencilChart.jsp").forward(request, response);
		} else {
			// 조회 실패
			request.getSession().setAttribute("msgPencilChart", "정보 조회에 실패했습니다.");
			response.sendRedirect("adminMain");
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
