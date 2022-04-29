package kh.semi.thduo.teacher.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.semi.thduo.member.vo.MemberVo;
import kh.semi.thduo.teacher.model.service.TeacherService;
import kh.semi.thduo.teacher.model.vo.TeacherVo;

/**
 * Servlet implementation class TeacherInfoController
 */
@WebServlet("/teacherInfo")
public class TeacherInfoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TeacherInfoController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet - teacherInfo");
		
		String tNo = request.getParameter("tNo");
		TeacherVo result = new TeacherService().readTeacherInfo(tNo);
		
		if(result == null) {
			System.out.println("TeacherVo : " + result);
			System.out.println("선생님 정보가 없습니다.");
//			response.sendRedirect("teacherSearch");
		} else {
			// 로그인 여부 확인
			MemberVo ssvo = (MemberVo) request.getSession().getAttribute("ssMV");
			if(ssvo == null) {
				result.setLike(null);
			} else {
				result.setLike(new TeacherService().checkLike(ssvo.getmId(), tNo));
			}
			
			System.out.println("TeacherVo : " + result);
			request.setAttribute("tvo", result);
			request.getRequestDispatcher("WEB-INF/view/teacher/teacherInfo.jsp").forward(request, response);
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
