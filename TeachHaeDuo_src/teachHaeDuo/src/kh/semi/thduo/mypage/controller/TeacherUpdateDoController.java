package kh.semi.thduo.mypage.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TeacherUpdateDoController
 */
@WebServlet("/teacherUpdate.do")
public class TeacherUpdateDoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TeacherUpdateDoController() {
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
		System.out.println("교습정보 수정 doPost");
		
		//학력
		String major = request.getParameter("major");
		System.out.println("major :" + major);
		
		// 교습 소개
		String tIntro = request.getParameter("tIntro");
		System.out.println("tIntro :" + tIntro);
		
		//교습 과목
		String[] object = request.getParameterValues("object");
		for(int i = 0 ; i < object.length ; i ++) {
			System.out.println("object :" + object[i]);
		}
		
		//교습 가능 지역
		String[] activeArea = request.getParameterValues("activeArea");
		for(int i = 0 ; i < activeArea.length ; i ++) {
			System.out.println("activeArea :" + activeArea[i]);
		}
		
		//온라인 교습 여부
		String onlineYn = request.getParameter("online_yna");
		System.out.println("onlineYn: "+onlineYn);
		
		// 교습 횟수
		String tCnt = request.getParameter("tCnt");
		System.out.println("tCnt: "+tCnt);
		if(tCnt == null || tCnt.equals("")) {
			tCnt = "default";
		}
		System.out.println("tCnt: "+tCnt);
		
		// 비용
		String tPrice = request.getParameter("tprice");
		System.out.println("tPrice: "+tPrice);
		if(tPrice == null || tPrice.equals("")) {
			tPrice = "default";
		}
		System.out.println("tPrice: "+tPrice);
		
		// 희망 학생
		String[] student = request.getParameterValues("student");
		for(int i = 0 ; i < student.length ; i ++) {
			System.out.println("student :" + student[i]);
		}
		
		// 어학
		String[] language = request.getParameterValues("language");
		String[] score = request.getParameterValues("score");
		String[] languageScore = null;
		if(language != null && score != null) {
			for(int i = 0 ; i < language.length ; i ++) {
				System.out.println("language :" + language[i]);
				System.out.println("score :" + score[i]);
				languageScore = new String[language.length];
				languageScore[i] = language[i]+" "+score[i];
				System.out.println("languageScore :" + languageScore[i]);
			}
		} 
		
		// 개인 교습 경력
		String tCareer = request.getParameter("tCareer");
		System.out.println("tCareer: "+ tCareer);
		if(tCareer == null || tCareer.equals("")) {
			tCareer = "default";
		}
		System.out.println("tCareer: "+ tCareer);
		
		// 특이사항
		String tSpecial = request.getParameter("tSpecial");
		System.out.println("tSpecial: "+ tSpecial);
		if(tSpecial == null || tSpecial.equals("")) {
			tSpecial = "default";
		}
		System.out.println("tSpecial: "+ tSpecial);
	}

}






