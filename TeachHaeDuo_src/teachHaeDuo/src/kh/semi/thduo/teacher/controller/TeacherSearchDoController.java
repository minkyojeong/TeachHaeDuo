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
import kh.semi.thduo.teacher.model.vo.TeacherSearchSettingVo;
import kh.semi.thduo.teacher.model.vo.TeacherVo;

/**
 * Servlet implementation class TeacherSearchDoController
 */
@WebServlet("/TeacherSearchDo")
public class TeacherSearchDoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TeacherSearchDoController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
////		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//
//	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("TeacherSearchDo ajax 부분임");
		
		TeacherSearchSettingVo setVo = new TeacherSearchSettingVo();
		String sNo = null;  // 찜 기능을 원했을 경우에만 로그인한 sNo를 넣어줘야함.
		
		String online_yna = request.getParameter("online_yna");  // Y, N, A, ""null 전체보기
		String t_permit_yn = request.getParameter("t_permit_yn");   // Y, ""null 전체보기
		String t_recruit_yn = request.getParameter("t_recruit_yn");   // Y, ""null 전체보기
		String object_list = request.getParameter("object_list");   // '국어', ""null 전체보기
		String area_list = request.getParameter("area_list");   // '강남', ""null 전체보기
		String gender_fm = request.getParameter("gender_fm");   // 'M','F', ""null 전체보기
		String liked = request.getParameter("liked");    // true, false 전체보기
		setVo.setOnline_yna(online_yna);
		setVo.setT_permit_yn(t_permit_yn);
		setVo.setT_recruit_yn(t_recruit_yn);
		setVo.setObject_list(object_list);
		setVo.setArea_list(area_list);
		setVo.setGender_fm(gender_fm);
		setVo.setLiked(liked);
		setVo.setsNo(sNo);
		System.out.println(setVo);
		ArrayList<TeacherVo> retVolist = new TeacherService().searchTeacher(setVo);
		
		PrintWriter out = response.getWriter();
		Gson gobj = new GsonBuilder().setPrettyPrinting().create();
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("retVolist", retVolist);
		map.put("searchSetVo", setVo);
		
		String resStr = gobj.toJson(map);
		
		System.out.println(resStr);
		// response로 전달할 데이터 채우기	
		out.println(resStr);
		out.flush();
		out.close();
	}

}
