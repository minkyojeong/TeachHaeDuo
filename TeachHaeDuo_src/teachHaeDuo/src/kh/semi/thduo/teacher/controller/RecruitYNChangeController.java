package kh.semi.thduo.teacher.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.semi.thduo.alarm.model.service.AlarmService;
import kh.semi.thduo.member.vo.MemberVo;
import kh.semi.thduo.teacher.model.service.RecruitYNChangeService;

/**
 * Servlet implementation class AlarmYNChange
 */
@WebServlet("/recruitYNChange")
public class RecruitYNChangeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RecruitYNChangeController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("모집중 doget");
		
		// 로그인 정보 받아오기
		MemberVo ssMV = (MemberVo)request.getSession().getAttribute("ssMV");
		System.out.println(ssMV);
		// 사용할 변수 선언
		String roleSt = null;
		MemberVo vo = new MemberVo();
		int result = 0;
		
		// 로그인이 안되어있다면
		if(ssMV == null) {
			request.getSession().setAttribute("msgLogin", "로그인 먼저 해주세요");
			response.sendRedirect("login");
			return;
		} else { // 되어 있다면
			// 변수에 데이터 담기
			roleSt = ssMV.getRoleSt();
			vo.settRecruitYn(ssMV.gettRecruitYn());
			vo.setmId(ssMV.getmId());
			// 서비스 호출
			result = new RecruitYNChangeService().recruitYNChange(vo);
		}
		
		// 성공
		if(result == 1) {
			// 그전에 알람 수신여부가 y 였으면 n으로
			if(vo.gettRecruitYn().equals("Y")) {
				vo.settRecruitYn("N");
			} else { // 그전에 알람 수신여부가 n 였으면 y로
				vo.settRecruitYn("Y");
			}
			// 새 데이터를 세션에 담고 알럿 띄울 메세지 request에 담아 페이지 이동
			request.setAttribute("msgRecruit", "모집 여부가 변경되었습니다.");
			ssMV.settRecruitYn(vo.gettRecruitYn());
			System.out.println("선생 마이페이지 진입");
			request.getRequestDispatcher("WEB-INF/view/mypage/mypageTeacher.jsp").forward(request, response); 
		} else { // 실패
			request.setAttribute("msgRecruit", "모집 여부 변경이 실패했습니다.");
			System.out.println("선생 마이페이지 진입");
			request.getRequestDispatcher("WEB-INF/view/mypage/mypageTeacher.jsp").forward(request, response);
			 
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
