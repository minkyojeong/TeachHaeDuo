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

import kh.semi.thduo.member.vo.MemberVo;
import kh.semi.thduo.teacher.model.service.TeacherService;
import kh.semi.thduo.teacher.model.vo.TeacherSearchSettingVo;
import kh.semi.thduo.teacher.model.vo.TeacherVo;

/**
 * Servlet implementation class TeacherSearchDoController
 */
@WebServlet("/teacherSearch.ax")
public class TeacherSearchAjaxController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TeacherSearchAjaxController() {
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
		System.out.println("teacherSearch.ax 실행");
		
		TeacherSearchSettingVo setVo = new TeacherSearchSettingVo();
		String sNo = " ";
		
		String online_yna = request.getParameter("online_yna");  // Y, N, A, ""null 전체보기
		String t_permit_yn = request.getParameter("t_permit_yn");   // Y, ""null 전체보기
		String t_recruit_yn = request.getParameter("t_recruit_yn");   // Y, ""null 전체보기
		String object_list = request.getParameter("object_list");   // '과목명', ""null 전체보기
		String area_list = request.getParameter("area_list");   // '활동지역', ""null 전체보기
		String gender_fm = request.getParameter("gender_fm");   // 'M','F', ""null 전체보기
		String liked = request.getParameter("liked");    // 'Y' ""null전체보기
		
		MemberVo ssvo = (MemberVo) request.getSession().getAttribute("ssMV");
		// 찜 기능을 원했을 경우, 로그인한 sNo를 넣어줌
		if(liked.equals("Y") && ssvo != null && ssvo.getsNo() != null) {
			sNo = ssvo.getsNo();
		}
		
		setVo.setOnline_yna(online_yna);
		setVo.setT_permit_yn(t_permit_yn);
		setVo.setT_recruit_yn(t_recruit_yn);
		setVo.setObject_list(object_list);
		setVo.setArea_list(area_list);
		setVo.setGender_fm(gender_fm);
		setVo.setLiked(liked);
		setVo.setsNo(sNo);
		
		System.out.println(setVo);
		
		
		
		int currentPage = 1;
		
		String currentPageStr = request.getParameter("page");
		try {
			if(currentPageStr !=null && !currentPageStr.equals(""))
				currentPage = Integer.parseInt(currentPageStr);
		}catch (NumberFormatException e) {
			e.printStackTrace();
		}
		
		final int pageSize = 5;  // 한페이지에 보여줄 행
		final int pageBlock = 3;  // 페이징에 나타날 페이지수
		int startPage=0;
		int endPage=0;
		int startRnum=0;
		int endRnum=0;
		
		int totalCnt = 0; // 총 글 수
		totalCnt = new TeacherService().countTeacher(setVo);
		
		System.out.println("총"+totalCnt);
		// select count(*) from board
		
		/* Paging 처리 */
//		int totalPageCnt = (int)Math.ceil(totalCnt/pageSize); 
		int totalPageCnt = (totalCnt/pageSize) + (totalCnt%pageSize==0 ? 0 : 1);
		if(currentPage%pageBlock == 0) {
			startPage = ((currentPage/pageBlock)-1)*pageBlock + 1;
		} else {
			startPage = (currentPage/pageBlock)*pageBlock + 1;
		}
		endPage = startPage + pageBlock - 1;
		if(endPage>totalPageCnt) {
			endPage = totalPageCnt;
		}
		System.out.println("page:"+ startPage +"~"+endPage);
		
		/* rownum 처리 */
		startRnum = (currentPage-1)*pageSize + 1;
		endRnum = startRnum + pageSize -1;
		if(endRnum>totalCnt) {
			endRnum = totalCnt;
		}
		System.out.println("rnum:"+ startRnum +"~"+endRnum);
				
		ArrayList<TeacherVo> retVolist = new TeacherService().searchTeacher(setVo, startRnum, endRnum);
		
		PrintWriter out = response.getWriter();
		Gson gobj = new GsonBuilder().setPrettyPrinting().create();
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("retVolist", retVolist);
		map.put("searchSetVo", setVo);
		map.put("startPage", startPage);
		map.put("endPage", endPage);
		map.put("totalPageCnt", totalPageCnt);
		map.put("currentPage", currentPage);
		String resStr = gobj.toJson(map);
		
		System.out.println(resStr);
		
		// response로 전달할 데이터 채우기
		out.println(resStr);
		out.flush();
		out.close();
	}

}
