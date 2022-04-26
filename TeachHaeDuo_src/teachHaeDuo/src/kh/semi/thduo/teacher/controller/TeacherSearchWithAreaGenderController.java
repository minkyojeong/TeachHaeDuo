package kh.semi.thduo.teacher.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import kh.semi.thduo.teacher.model.service.TeacherService;
import kh.semi.thduo.teacher.model.vo.TeacherVo;

/**
 * Servlet implementation class TeacherSearchWithAreaController
 */
@WebServlet("/TeacherSearchWithAreaGender.ajax")
public class TeacherSearchWithAreaGenderController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TeacherSearchWithAreaGenderController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("TeacherSearchWithAreaGenderController ");
	
		String gender = request.getParameter("gender");
				System.out.println("gender :"+ gender);
		
		String area = request.getParameter("area");
		System.out.println("area :"+ area);
		
		ArrayList<TeacherVo> retVolist = new TeacherService().readAreaGenderTeacher(gender, area);
		
		PrintWriter out = response.getWriter();
				
// 예시 2,3,4 는 gson 사용
		Gson gobj = new GsonBuilder().setPrettyPrinting().create();
// 예시 2 - java참조자료형 객체 1개 전달 
// 주로 정말 많아요~ 
		String resStr = gobj.toJson(retVolist);
		
		System.out.println(resStr);
		// response로 전달할 데이터 채우기	
		out.println(resStr);
		out.flush();
		out.close();

//		request.setAttribute("teachVolist", retVolist);
//		request.getRequestDispatcher("WEB-INF/view/teacherSearchMain.jsp").forward(request, response);
	}

}
