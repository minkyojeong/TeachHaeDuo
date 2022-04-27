package kh.semi.thduo.alarm.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.semi.thduo.alarm.model.service.AlarmService;
import kh.semi.thduo.alarm.model.vo.AlarmVo;
import kh.semi.thduo.review.model.service.ReviewService;
import kh.semi.thduo.review.model.vo.ReviewVo;

/**
 * Servlet implementation class SendAlarmAjaxController
 */
@WebServlet("/sendAlarm.ax")
public class SendAlarmAjaxController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SendAlarmAjaxController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost - sendAlarm.ax");
		PrintWriter out = response.getWriter();
		
		String alarm_receiveid = request.getParameter("alarm_receiveid");
		String alarm_content = request.getParameter("alarm_content");
		
		System.out.println("alarm_receiveid : " + alarm_receiveid);
		System.out.println("alarm_content : " + alarm_content);
		
		AlarmVo vo = new AlarmVo();
		vo.setAlarm_content(alarm_content);
		vo.setAlarm_sendid("a12345");
		vo.setAlarm_receiveid(alarm_receiveid);
		vo.setM_id("a12345");
		
		int result = new AlarmService().sendAlarm(vo);
		if(result < 1) {
			out.print(-1);
		} else {
			out.print(1);
		}
	
		// 모두 완성 되면 아래 주석 풀고 확인
//		AlarmVo vo = new AlarmVo();
//		vo.setAlarm_content(alarm_content);
//		vo.setAlarm_receiveid(alarm_receiveid);
//		// 로그인 여부 확인(이미 로그인 확인 했지만 로그아웃 했을 수도 있으니까 로그인 여부 다시 확인)
//		MemberVo ssvo = (MemberVo) request.getSession().getAttribute("ssMV");
//		if(ssvo == null) {
//			out.print(0);
//			out.flush();
//			out.close();
//			return; // DB에 저장하지 않아도 되니까
//		} else {
//			vo.setAlarm_sendid(ssvo.getmId());
//			vo.setM_id(ssvo.getmId());
//		}
//		// DB에 저장
//		int result = new AlarmService().sendAlarm(vo);
//		if (result < 1) { // 쪽지전송 실패
//			out.print(-1);
//		} else { // 쪽지전송 성공
//			out.print(1);
//		}
		
		out.flush();
		out.close();
	}

}
