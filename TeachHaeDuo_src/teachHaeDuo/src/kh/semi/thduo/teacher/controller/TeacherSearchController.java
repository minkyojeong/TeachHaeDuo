package kh.semi.thduo.teacher.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.semi.thduo.teacher.model.dao.TeacherDao;
import kh.semi.thduo.teacher.model.service.TeacherService;
import kh.semi.thduo.teacher.model.vo.TeacherSearchSettingVo;
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
		
		ArrayList<TeacherVo> volist = new TeacherService().readAllTeacher();
		
//		TeacherSearchSettingVo setVo = new TeacherSearchSettingVo();  // 아무 값도 넣지 않고.. 넣어주기
//		request.setAttribute("searchSetVo", setVo);
		System.out.println("여기 volist"+ volist);
		request.setAttribute("teachVolist", volist);
//		request.setAttribute("teachVolist", TeacherDao.readTeacher(object));
		request.getRequestDispatcher("WEB-INF/view/teacherSearchMain.jsp").forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		doGet(request, response);
//	}

}
