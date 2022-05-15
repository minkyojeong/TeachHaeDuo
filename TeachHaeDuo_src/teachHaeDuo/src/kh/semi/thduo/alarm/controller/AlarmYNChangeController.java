package kh.semi.thduo.alarm.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.semi.thduo.alarm.model.service.AlarmService;
import kh.semi.thduo.member.vo.MemberVo;

/**
 * Servlet implementation class AlarmYNChange
 */
@WebServlet("/alarmYNChange")
public class AlarmYNChangeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AlarmYNChangeController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("알람 수신거부 doget");
		// 세션에 담긴 정보 가져오기
		MemberVo ssMV = (MemberVo) request.getSession().getAttribute("ssMV");
		System.out.println(ssMV);
		// 사용할 객체 선언
		MemberVo vo = new MemberVo();
		int result = 0;
		// 로그인이 안되어있을때
		if (ssMV == null) {
			request.getSession().setAttribute("msgLogin", "로그인 먼저 해주세요");
			response.sendRedirect("login");
			return;
		} else { // 되어있을때
			// 세션에서 가져온 정보 변수, 객체에 담기
			vo.setmAlarmYn(ssMV.getmAlarmYn());
			vo.setmId(ssMV.getmId());
			// 담은 정보 가지고 서비스 호출
			result = new AlarmService().alarmYNChange(vo);
		}
		// 알람 수신거부 여부 변경 성공
		if (result == 1) {
			// 알람 수신이 원래 Y 였다면 vo N으로 변경
			if (vo.getmAlarmYn().equals("Y")) {
				vo.setmAlarmYn("N");
			} else { // 알람 수신이 원래 N이 였다면 vo Y로 변경
				vo.setmAlarmYn("Y");
			}
			// 알럿으로 띄울 메세지 담기
			request.getSession().setAttribute("msgAlarm", "알람 수신 여부가 변경되었습니다.");
			// 새로 변경된 정보 세션에 다시 담기
			ssMV.setmAlarmYn(vo.getmAlarmYn());
			response.sendRedirect("mypage");
		} else { // 알람 수신거부 여부 변경 실패
			request.getSession().setAttribute("msgAlarm", "알람 수신 여부 변경이 실패했습니다.");
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
