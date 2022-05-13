package kh.semi.thduo.mypage.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.semi.thduo.member.vo.MemberVo;
import kh.semi.thduo.teacher.model.service.TeacherService;

/**
 * Servlet implementation class TeacherUpdateLoginController
 */
@WebServlet("/teacherUpdateLogin")
public class TeacherUpdateLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TeacherUpdateLoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberVo ssMV = (MemberVo)request.getSession().getAttribute("ssMV");
		String tNo = ssMV.gettNo();
		String approvalYn = new TeacherService().checkApproval(tNo);
		System.out.println("승인여부: " +approvalYn);
		
		if(approvalYn.equals("Y")) {
			request.getRequestDispatcher("WEB-INF/view/mypage/teacherUpdateLogin.jsp").forward(request, response);
		} else {
			request.getSession().setAttribute("msgApproval", "관리자의 승인 후 교습 정보 등록이 가능합니다.");
			response.sendRedirect("mypage");
			return;
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
