package kh.semi.thduo.report.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.semi.thduo.report.model.service.ReportService;
import kh.semi.thduo.report.model.vo.ReportVo;

/**
 * Servlet implementation class ReportInsertAjaxController
 */
@WebServlet("/reportInsert.ax")
public class ReportInsertAjaxController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ReportInsertAjaxController() {
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
		System.out.println("doPost - reportInsert.ax");
		PrintWriter out = response.getWriter();

		String m_r_receiveid = request.getParameter("m_r_receiveid");
		String m_r_category = request.getParameter("report_category");
		String m_r_content = request.getParameter("m_r_content");

		System.out.println("m_r_receiveid : " + m_r_receiveid);
		System.out.println("m_r_category : " + m_r_category);
		System.out.println("m_r_content : " + m_r_content);

		ReportVo vo = new ReportVo();
		vo.setM_r_sendid("a12345");
		vo.setM_r_receiveid(m_r_receiveid);
		vo.setM_r_category(m_r_category);
		vo.setM_r_content(m_r_content);
		vo.setM_id(m_r_receiveid);
		
		int result = new ReportService().insertReport(vo);
		if(result < 1) {
			out.print(-1);
		} else {
			out.print(1);
		}
		
		// 모두 완성 되면 아래 주석 풀고 확인
//		ReportVo vo = new ReportVo();
//		vo.setM_r_receiveid(m_r_receiveid);
//		vo.setM_r_category(m_r_category);
//		vo.setM_r_content(m_r_content);
//		vo.setM_id(m_r_receiveid);
//		// 로그인 여부 확인(이미 로그인 확인 했지만 로그아웃 했을 수도 있으니까 로그인 여부 다시 확인)
//		MemberVo ssvo = (MemberVo) request.getSession().getAttribute("ssMV");
//		if(ssvo == null) {
//			out.print(0);
//			out.flush();
//			out.close();
//			return; // DB에 저장하지 않아도 되니까
//		} else {
//			vo.setM_r_sendid(ssvo.getmId());
//		}
//		// DB에 저장
//		int result = new BoardService().writeBoard(vo);
//		if (result < 1) { // 글등록 실패(글등록으로 이동)
//			out.print("실패");
//		} else { // 글등록 성공(글목록으로 이동)
//			out.print("성공");
//		}

		out.flush();
		out.close();
	}

}
