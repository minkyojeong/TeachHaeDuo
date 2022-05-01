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
import kh.semi.thduo.member.vo.MemberVo;
import kh.semi.thduo.pencil.model.service.PencilService;
import kh.semi.thduo.pencil.model.vo.PencilVo;

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
		vo.setAlarm_receiveid(alarm_receiveid);
		
		// 로그인 여부 확인
		MemberVo ssvo = (MemberVo) request.getSession().getAttribute("ssMV");
		if(ssvo == null) {
			out.print(0);
			out.flush();
			out.close();
			return;
		} else {
			System.out.println("잔액 : " + new PencilService().checkPencil(ssvo.getmId()));
			if(new PencilService().checkPencil(ssvo.getmId()) < 500) { // 연필 내역 확인(잔액 500원 미만)
				out.print(2);
				out.flush();
				out.close();
				return;
			} else { // 잔액 500원 이상
				PencilVo pvo = new PencilVo();
				pvo.setCpContent("쪽지보내기");
				pvo.setCpCash(-500);
				pvo.setmId(ssvo.getmId());
				
				int result = new PencilService().minusPencil(pvo);
				if (result < 1) { // 연필 사용 내역 저장 실패
					out.print(-1);
					out.flush();
					out.close();
				} else { // 연필 사용 내역 저장 성공
					vo.setAlarm_sendid(ssvo.getmNickname());
					vo.setM_id(ssvo.getmId());
				}
			}
		}
		
		// DB에 저장
		int result = new AlarmService().sendAlarm(vo);
		if (result < 1) { // 쪽지전송 실패
			out.print(-1);
		} else { // 쪽지전송 성공
			out.print(1);
		}
		
		out.flush();
		out.close();
	}

}
