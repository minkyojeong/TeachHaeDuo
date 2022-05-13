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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet - pencilChart 페이지 이동");
		
		AdminVo vo = (AdminVo)request.getSession().getAttribute("ssMV");
		
		// 관리자 로그인이 안되어있다면
		if(vo == null) {
			
			response.sendRedirect(request.getContextPath());
		} else { // 되어 있다면
			// 화면에 뿌려줄 매출 데이터 가져오기
			ArrayList<MemberVo> voList = new PencilService().pencilChart();
			
			// 가져온 데이터 request에 담기
			request.setAttribute("voList", voList);
			// 정보 들고 리스트 페이지 이동
			request.getRequestDispatcher("WEB-INF/view/admin/pencilChart.jsp").forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		doGet(request, response);
//	}

}
