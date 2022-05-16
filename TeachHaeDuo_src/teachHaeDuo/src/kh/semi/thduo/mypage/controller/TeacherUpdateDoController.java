package kh.semi.thduo.mypage.controller;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.semi.thduo.member.vo.MemberVo;
import kh.semi.thduo.pencil.model.service.PencilService;
import kh.semi.thduo.pencil.model.vo.PencilVo;
import kh.semi.thduo.teacher.model.service.TeacherService;
import kh.semi.thduo.teacher.model.vo.TeacherVo;

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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("교습정보 수정 doPost");
		
		// client가 입력한 데이터 가져올때 한글깨짐 방지
		request.setCharacterEncoding("UTF-8");
		// client가 입력한 데이터 받아오기
		// 학력
		String major = request.getParameter("major");
		System.out.println("major :" + major);

		// 교습 소개
		String tIntro = request.getParameter("tIntro");
		System.out.println("tIntro :" + tIntro);

		// 교습 과목
		String[] objectArr = request.getParameterValues("object");
		for (int i = 0; i < objectArr.length; i++) {
			System.out.println("object :" + objectArr[i]);
		}

		// 교습 가능 지역
		String[] activeAreaArr = request.getParameterValues("activeArea");
		for (int i = 0; i < activeAreaArr.length; i++) {
			System.out.println("activeArea :" + activeAreaArr[i]);
		}

		// 온라인 교습 여부
		String onlineYn = request.getParameter("online_yna");
		System.out.println("onlineYn: " + onlineYn);

		// 교습 횟수
		String tCnt = request.getParameter("tCnt");
		System.out.println("tCnt: " + tCnt);
		if (tCnt == null || tCnt.trim().equals("")) {
			tCnt = "협의";
		}
		System.out.println("tCnt: " + tCnt);

		// 비용
		String tPrice = request.getParameter("tprice");
		System.out.println("tPrice: " + tPrice);
		if (tPrice == null || tPrice.trim().equals("")) {
			tPrice = "협의";
		}
		System.out.println("tPrice: " + tPrice);

		// 희망 학생
		String[] studentArr = request.getParameterValues("student");
		String totalStudent = "";
		for (int i = 0; i < studentArr.length; i++) {
			System.out.println("student :" + studentArr[i]);
			totalStudent += studentArr[i] + " ";
		}
		System.out.println("totalStudent :" + totalStudent);

		// 어학
		String[] language = request.getParameterValues("language");
		String[] score = request.getParameterValues("score");
		String languageScore = "";
		System.out.println("language.length :" + language.length);
		if (language != null && score != null) {
			for (int i = 0; i < language.length; i++) {
				System.out.println("language :" + language[i]);
				System.out.println("score :" + score[i]);
				languageScore += language[i] + " " + score[i] + " ";
			}
		}
		System.out.println("languageScore :" + languageScore);

		// 개인 교습 경력
		String tCareer = request.getParameter("tCareer");
		System.out.println("tCareer: " + tCareer);
		if (tCareer == null || tCareer.trim().equals("")) {
			tCareer = "없음";
		}
		System.out.println("tCareer: " + tCareer);

		// 특이사항
		String tSpecial = request.getParameter("tSpecial");
		System.out.println("tSpecial: " + tSpecial);
		if (tSpecial == null || tSpecial.trim().equals("")) {
			tSpecial = "없음";
		}
		System.out.println("tSpecial: " + tSpecial);

		// 사용할 변수 선언, 객체 선언
		int result = 0;
		PencilVo pVo = new PencilVo();
		TeacherVo tVo = new TeacherVo();
		// 로그인 여부 확인
		MemberVo ssMV = (MemberVo) request.getSession().getAttribute("ssMV");
		if (ssMV == null) {
			request.getSession().setAttribute("msgLogin", "로그인 먼저 해주세요");
			response.sendRedirect("login");
			return;
		}

		// 기존에 프로필 등록 여부 확인
		String profileYn = new TeacherService().checkProfile(ssMV.gettNo());
		System.out.println("프로필 등록 여부: " + profileYn);

		// 기존에 등록된 프로필이 없다면
		if (profileYn.equals("N")) {
			System.out.println("최초등록이야~");
			// 잔액 확인
			int balance = new PencilService().checkPencil(ssMV.getmId());
			System.out.println("잔액 확인:" + balance);
			// 잔액이 모자라면
			if (balance < 5000) {
				request.setAttribute("msgTeacherUpdate", "잔액이 부족합니다. 충전 후 이용해주세요.");
				request.getRequestDispatcher("WEB-INF/view/mypage/mypageTeacher.jsp").forward(request, response);
			} else { // 잔액이 충분하면
				
				// vo 세팅
				tVo.setOnline_yna(onlineYn);
				tVo.setT_tcnt(tCnt);
				tVo.setT_tprice(tPrice);
				tVo.setT_wantstud(totalStudent);
				tVo.setT_language(languageScore);
				tVo.setT_career(tCareer);
				tVo.setT_special(tSpecial.replace("\r\n", "<br>"));

				pVo = new PencilVo();
				pVo.setCpCash(-5000);
				pVo.setCpContent("교습 정보 최초 등록");
				pVo.setmId(ssMV.getmId());
				
				tVo.setT_no(ssMV.gettNo());
				tVo.setT_major(major);
				tVo.setT_intro(tIntro.replace("\r\n", "<br>"));

				// 데이터 가지고 서비스 호출
				System.out.println("컨트롤러 tVo :" + tVo);
				result = new TeacherService().updateTeacherInit(tVo, pVo, objectArr, activeAreaArr);
				// 실패
				if (result == 0) {
					System.out.println("t_profile 넣기 실패");
					request.setAttribute("msgTeacherUpdate", "교습 정보 등록이 실패했습니다.");
					request.getRequestDispatcher("WEB-INF/view/mypage/mypageTeacher.jsp").forward(request, response);
				} else { // 성공
					System.out.println("t_profile update 성공");
					request.setAttribute("msgTeacherUpdate", "교습 정보가 변경되었습니다.");
					request.getRequestDispatcher("WEB-INF/view/mypage/mypageTeacher.jsp").forward(request, response);
				}
			}

			// 기존에 등록된 프로필이 있다면
		} else if (profileYn.equals("Y")) {
			System.out.println("등록된 교습정보있어~");
			// 잔액 확인
			int balance = new PencilService().checkPencil(ssMV.getmId());
			System.out.println("잔액 확인:" + balance);
			// 잔액이 모자라면
			if (balance < 500) {
				request.setAttribute("msgTeacherUpdate", "잔액이 부족합니다. 충전 후 이용해주세요.");
				request.getRequestDispatcher("WEB-INF/view/mypage/mypageTeacher.jsp").forward(request, response);
				// 잔액이 충분하면
			} else {
				
				// 변수 세팅
				tVo.setOnline_yna(onlineYn);
				tVo.setT_tcnt(tCnt);
				tVo.setT_tprice(tPrice);
				tVo.setT_wantstud(totalStudent);
				tVo.setT_language(languageScore);
				tVo.setT_career(tCareer);
				tVo.setT_special(tSpecial.replace("\r\n", "<br>"));
				
				pVo = new PencilVo();
				pVo.setCpCash(-500);
				pVo.setCpContent("교습 정보 변경");
				pVo.setmId(ssMV.getmId());
				
				tVo.setT_no(ssMV.gettNo());
				tVo.setT_major(major);
				tVo.setT_intro(tIntro.replace("\r\n", "<br>"));

				// 변수 가지고 서비스 호출
				result = new TeacherService().updateTeacher(tVo, pVo, objectArr, activeAreaArr);
				// 실패
				if (result == 0) {
					System.out.println("t_profile 넣기 실패");
					request.setAttribute("msgTeacherUpdate", "교습 정보 등록이 실패했습니다.");
					request.getRequestDispatcher("WEB-INF/view/mypage/mypageTeacher.jsp").forward(request, response);
				} else { // 성공
					System.out.println("t_profile update 성공");
					request.setAttribute("msgTeacherUpdate", "교습 정보가 변경되었습니다.");
					request.getRequestDispatcher("WEB-INF/view/mypage/mypageTeacher.jsp").forward(request, response);
				}
			}

		}
	}

}
