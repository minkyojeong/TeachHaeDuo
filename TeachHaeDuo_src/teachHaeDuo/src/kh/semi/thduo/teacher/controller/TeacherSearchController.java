package kh.semi.thduo.teacher.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.semi.thduo.teacher.model.service.TeacherService;
import kh.semi.thduo.teacher.model.vo.TeacherVo;

/**
 * Servlet implementation class TeacherSearchController
 */
@WebServlet("/teacherSearch")
public class TeacherSearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TeacherSearchController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet - teacherSearch");
		
		ArrayList<TeacherVo> volist = new TeacherService().readAllTeacher();
		
		request.setAttribute("teachVolist", volist);
		request.getRequestDispatcher("WEB-INF/view/teacherSearchMain.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost - teacherSearch");
		
		String object = request.getParameter("object");
		System.out.println(object);
		
		ArrayList<TeacherVo> volist = new TeacherService().readTeacher(object);
		
		request.setAttribute("teachVolist", volist);
		request.setAttribute("object", object);
		request.getRequestDispatcher("WEB-INF/view/teacherSearchMain.jsp").forward(request, response);
	}

}
