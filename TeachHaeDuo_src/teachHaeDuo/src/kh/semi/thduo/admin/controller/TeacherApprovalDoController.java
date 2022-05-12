package kh.semi.thduo.admin.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.semi.thduo.alarm.model.service.AlarmService;
import kh.semi.thduo.alarm.model.vo.AlarmVo;

/**
 * Servlet implementation class TeacherApprovalDoController
 */
@WebServlet("/teacherApproval.do")
public class TeacherApprovalDoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TeacherApprovalDoController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("선생님 승인 컨트롤러 진입 doget");
		
		// 전달받은 데이터 가져오기
		String tNoOk = request.getParameter("tNoOk");
		String tNoNo = request.getParameter("tNoNo");
		String tNo = null;
		String nickname = request.getParameter("nickname");
		String mId = request.getParameter("mId");
		String yD = null;
		System.out.println("nickname:" + nickname);
		if(tNoOk == null || tNoOk.equals("")) {
			System.out.println("비승인버튼이야");
			tNo = tNoNo;
			AlarmVo vo = new AlarmVo();
			vo.setAlarm_content("승인이 거부되었습니다. 자세한 사항은 1:1문의 메일을 통해 문의해주세요.");
			vo.setAlarm_receiveid(nickname);
			vo.setAlarm_sendid("관리자");
			vo.setM_id(mId);
			yD = "D";
			int result = new AlarmService().sendApprovalAlarm(vo,yD,tNo);
			if(result == 0) {
				request.getSession().setAttribute("msgApproval", "처리 도중 오류가 발생했습니다. 다시 시도해주세요.");
				response.sendRedirect(request.getHeader("referer"));
			} else {
				request.getSession().setAttribute("msgApproval", "비승인 처리 되었습니다.");
				response.sendRedirect(request.getHeader("referer"));
			}
			
		} else {
			System.out.println("승인버튼이야");
			tNo = tNoOk;
			AlarmVo vo = new AlarmVo();
			vo.setAlarm_content("선생님 승인이 되었습니다. 교습 정보를 등록해주세요.");
			vo.setAlarm_receiveid(nickname);
			vo.setAlarm_sendid("관리자");
			vo.setM_id(mId);
			yD = "Y";
			int result = new AlarmService().sendApprovalAlarm(vo,yD,tNo);
			if(result == 0) {
				request.getSession().setAttribute("msgApproval", "처리 도중 오류가 발생했습니다. 다시 시도해주세요.");
				response.sendRedirect(request.getHeader("referer"));
			} else {
				request.getSession().setAttribute("msgApproval", "승인 처리 되었습니다.");
				response.sendRedirect(request.getHeader("referer"));
			}
			
		}
		
		
		
		// 전달받은 데이터 들고 승인/비승인
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//	}

}
