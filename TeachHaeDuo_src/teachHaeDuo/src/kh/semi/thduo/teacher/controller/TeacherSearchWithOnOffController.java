package kh.semi.thduo.teacher.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

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
 * Servlet implementation class TeacherSearchWithOnOffController
 */
@WebServlet("/TeacherSearchWithOnOff")
public class TeacherSearchWithOnOffController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TeacherSearchWithOnOffController() {
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
		System.out.println("TeacherSearchWithOnOff ");
		
		TeacherVo setVo = new TeacherVo();
		String sNo = null;  // 찜 기능을 원했을 경우에만 로그인한 sNo를 넣어줘야함.
		
		String online = request.getParameter("online");
		System.out.println("online :"+ online);
		
		String offline = request.getParameter("offline");
		System.out.println("offline :"+ offline);
		
		String onlineYna = null;   // 초기 값 꼭 null
		if(online != null && !online.equals("")) {
			onlineYna = "Y";
		} else if (offline != null && !offline.equals("")) {
			onlineYna = "N";
		}
		
//		ArrayList<TeacherVo> retVolist = new TeacherService().searchTeacher(setVo, sNo);
		
		PrintWriter out = response.getWriter();
				

		Gson gobj = new GsonBuilder().setPrettyPrinting().create();
//		String resStr = gobj.toJson(retVolist);
		
//		System.out.println(resStr);
		// response로 전달할 데이터 채우기	
//		out.println(resStr);
		out.flush();
		out.close();

//		request.setAttribute("teachVolist", retVolist);
//		request.getRequestDispatcher("WEB-INF/view/teacherSearchMain.jsp").forward(request, response);
	}


}
