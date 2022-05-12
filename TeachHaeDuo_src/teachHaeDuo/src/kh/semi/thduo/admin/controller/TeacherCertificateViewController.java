package kh.semi.thduo.admin.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.semi.thduo.member.service.MemberService;
import kh.semi.thduo.member.vo.MemberVo;
import kh.semi.thduo.teacher.model.service.TeacherService;
import kh.semi.thduo.teacher.model.vo.TeacherVo;

/**
 * Servlet implementation class TeacherListController
 */
@WebServlet("/teacherCertificate")
public class TeacherCertificateViewController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TeacherCertificateViewController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet - teacherList 페이지 이동");
		
		// 선생님 증명서 데이터 가져오기
		String filePath = request.getParameter("file");
		// 선생님 증명서 경로 담기
		request.setAttribute("filePath", filePath);
		// 선생님 증명서 보는 페이지로 이동
		request.getRequestDispatcher("WEB-INF/view/admin/teacherCertificate.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//	}

}
