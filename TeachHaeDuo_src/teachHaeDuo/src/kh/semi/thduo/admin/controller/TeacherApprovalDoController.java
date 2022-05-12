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
		String nickname = request.getParameter("nickname");
		String mId = request.getParameter("mId");
		System.out.println("nickname:" + nickname);
		if(tNoOk == null || tNoOk.equals("")) {
			System.out.println("비승인버튼이야");
			AlarmVo vo = new AlarmVo();
			vo.setAlarm_content("승인이 거부되었습니다. 자세한 사항은 1:1문의 메일을 통해 문의해주세요.");
			vo.setAlarm_receiveid(nickname);
			vo.setAlarm_sendid("관리자");
			vo.setM_id(mId);
			int result = new AlarmService().sendAlarm(vo);
			request.getSession().setAttribute("msgNo", "비승인 처리 되었습니다.");
			response.sendRedirect(request.getHeader("referer"));
		} else {
			System.out.println("승인버튼이야");
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
