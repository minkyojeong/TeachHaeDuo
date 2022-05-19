package kh.semi.thduo.admin.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.semi.thduo.admin.service.AdminService;
import kh.semi.thduo.admin.vo.AdminVo;
import kh.semi.thduo.alarm.model.service.AlarmService;
import kh.semi.thduo.alarm.model.vo.AlarmVo;
import kh.semi.thduo.report.model.service.ReportService;
import kh.semi.thduo.report.model.vo.ReportVo;

/**
 * Servlet implementation class TeacherReportAlarmController
 */
@WebServlet("/teacherCancel")
public class TeacherCancelController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TeacherCancelController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("선생님 자격박탈 doGet");
		
		// 전달받은 데이터 가져오기
		String mId = request.getParameter("mId");
		String mNickname = request.getParameter("mNickname");
		String tNo = request.getParameter("tNo");
		// 사용할 변수 선언
		int result = 0;
		// 관리자 로그인 확인
		AdminVo aVo = (AdminVo) request.getSession().getAttribute("ssMV");
		if (aVo == null) { // 관리자 로그인 안되어있다면
			request.getSession().setAttribute("msgLogin", "로그인 먼저 해주세요");
			response.sendRedirect("login");
			return;
		} else { // 되어있다면
			// 자격 박탈 알람 보내기 and t_profile update
			AlarmVo vo = new AlarmVo();
			vo.setAlarm_content("신고로 인해 선생님 자격이 박탈되었습니다. 자세한 사항은 1:1문의 메일을 통해 문의해주세요.");
			vo.setAlarm_receiveid(mNickname);
			vo.setAlarm_sendid("관리자");
			vo.setM_id(mId);
			vo.setT_no(tNo);
			vo.setApprovalStr("D");
			if (vo != null) {
				result = new AdminService().sendTeacherCancelAlarm(vo);
			}
			// 실패
			if (result == 0) {
				request.getSession().setAttribute("msgTeacherCancel", "처리 도중 오류가 발생했습니다. 다시 시도해주세요.");
				response.sendRedirect(request.getHeader("referer"));
			} else { // 성공
				request.getSession().setAttribute("msgTeacherCancel", "자격박탈 처리 되었습니다.");
				response.sendRedirect(request.getHeader("referer"));
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
