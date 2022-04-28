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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("알람 수신거부 doget");
		MemberVo ssMV = (MemberVo)request.getSession().getAttribute("ssMV");
		System.out.println(ssMV);
		String roleSt = "";
		MemberVo vo = new MemberVo();
		int result = 0;
		if(ssMV == null) {
			response.sendRedirect("login");
		} else {
			roleSt = ssMV.getRoleSt();
			vo.setmAlarmYn(ssMV.getmAlarmYn());
			vo.setmId(ssMV.getmId());
			result = new AlarmService().alarmYNChange(vo);
		}
		
		if(result == 1) {
			if(vo.getmAlarmYn().equals("Y")) {
				vo.setmAlarmYn("N");
			} else {
				vo.setmAlarmYn("Y");
			}
			request.setAttribute("msgAlarm", "알람 수신 여부가 변경되었습니다.");
			ssMV.setmAlarmYn(vo.getmAlarmYn());
			if(roleSt.equals("T")) {
				System.out.println("선생 마이페이지 진입");
				request.getRequestDispatcher("WEB-INF/view/mypage/mypageTeacher.jsp").forward(request, response);
			} else if(roleSt.equals("S")) {
				System.out.println("학생 마이페이지 진입");
				request.getRequestDispatcher("WEB-INF/view/mypage/mypageStudent.jsp").forward(request, response);
			}
		} else {
			request.setAttribute("msgAlarm", "알람 수신 여부 변경이 실패했습니다.");
			if(roleSt.equals("T")) {
				System.out.println("선생 마이페이지 진입");
				request.getRequestDispatcher("WEB-INF/view/mypage/mypageTeacher.jsp").forward(request, response);
			} else if(roleSt.equals("S")) {
				System.out.println("학생 마이페이지 진입");
				request.getRequestDispatcher("WEB-INF/view/mypage/mypageStudent.jsp").forward(request, response);
			}
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		doGet(request, response);
//	}

}
