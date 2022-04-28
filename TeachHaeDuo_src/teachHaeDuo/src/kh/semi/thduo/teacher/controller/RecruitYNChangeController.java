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
		MemberVo ssMV = (MemberVo)request.getSession().getAttribute("ssMV");
		System.out.println(ssMV);
		String roleSt = ssMV.getRoleSt();
		MemberVo vo = new MemberVo();
		int result = 0;
		if(ssMV == null) {
			response.sendRedirect("login");
		} else {
			
			vo.settRecruitYn(ssMV.gettRecruitYn());
			vo.setmId(ssMV.getmId());
			result = new RecruitYNChangeService().recruitYNChange(vo);
		}
		
		if(result == 1) {
			if(vo.gettRecruitYn().equals("Y")) {
				vo.settRecruitYn("N");
			} else {
				vo.settRecruitYn("Y");
			}
			request.setAttribute("msgRecruit", "모집 여부가 변경되었습니다.");
			ssMV.settRecruitYn(vo.gettRecruitYn());
			System.out.println("선생 마이페이지 진입");
			request.getRequestDispatcher("WEB-INF/view/mypage/mypageTeacher.jsp").forward(request, response); 
		} else {
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
