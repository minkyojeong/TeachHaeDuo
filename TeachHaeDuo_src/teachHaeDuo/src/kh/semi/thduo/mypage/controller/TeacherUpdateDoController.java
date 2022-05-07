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
		String[] studentArr = request.getParameterValues("student");
		for(int i = 0 ; i < studentArr.length ; i ++) {
			System.out.println("student :" + studentArr[i]);
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
		
		
		MemberVo ssMV = (MemberVo)request.getSession().getAttribute("ssMV");
		String tNo = null;
		String mId = null;
		int result = 0;
		int balance = 0;
		String profileYn = null;
		
		if(ssMV == null) {
			response.sendRedirect("login");
			return;
		} else {
			tNo = ssMV.gettNo();
			profileYn = new TeacherService().checkProfile(tNo);
			System.out.println("프로필 등록 여부: " + profileYn);
			
			if(profileYn.equals('N')) {
				System.out.println("최초등록이야~");
				mId = ssMV.getmId();
				balance = new PencilService().checkPencil(mId);
				System.out.println("잔액 확인:" + balance);
				if(balance < 5000) {
					request.setAttribute("msgTeacherUpdate", "잔액이 부족합니다. 충전 후 이용해주세요.");
					request.getRequestDispatcher("WEB-INF/view/mypage/mypageTeacher.jsp").forward(request, response);
				} else {
//					PencilVo vo = new PencilVo();
//					vo.setCpCash(-5000);
//					vo.setCpContent("교습 정보 최초 등록");
//					vo.setmId(mId);
//					result = new PencilService().minusPencil(vo);
					if(result == 0) {
						request.setAttribute("msgTeacherUpdate", "교습 정보 등록이 실패했습니다.");
						request.getRequestDispatcher("WEB-INF/view/mypage/mypageTeacher.jsp").forward(request, response);
					} else {
						TeacherVo tVo = new TeacherVo();
						tVo.setT_no(tNo);
						tVo.setT_major(major);
						tVo.setT_intro(tIntro);
						int resultObject = new TeacherService().insertObject(object,tNo);
						if(resultObject == 0) {
							System.out.println("담당과목 넣기 실패");
							request.setAttribute("msgTeacherUpdate", "교습 정보 등록이 실패했습니다.");
							request.getRequestDispatcher("WEB-INF/view/mypage/mypageTeacher.jsp").forward(request, response);
						}
						int resultArea = new TeacherService().insertactiveArea(activeArea, tNo);
						if(resultArea == 0) {
							System.out.println("활동지역 넣기 실패");
							request.setAttribute("msgTeacherUpdate", "교습 정보 등록이 실패했습니다.");
							request.getRequestDispatcher("WEB-INF/view/mypage/mypageTeacher.jsp").forward(request, response);
						}
						tVo.setOnline_yna(onlineYn);
						tVo.setT_tcnt(tCnt);
						tVo.setT_tprice(tPrice);
						tVo.setT_wantstud(Arrays.toString(studentArr));
						tVo.setT_language(Arrays.toString(languageScore));
					}
				}
			} else {
				System.out.println("등록된 교습정보있어~");
			}
		}
		// 회원가입시 선생님 번호 생성 후 해야될거같음..
//		if(ssMV == null) {
//			response.sendRedirect("login");
//			return;
//		} else if(ssMV.gettNo() == null){ // 최초등록
//			mId = ssMV.getmId();
//			balance = new PencilService().checkPencil(mId);
//			if(balance > 5000) {
//				PencilVo vo = new PencilVo();
//				vo.setCpCash(-5000);
//				vo.setCpContent("교습 정보 최초 등록");
//				vo.setmId(mId);
//				result = new PencilService().minusPencil(vo);
//				if(result == 1) {
					// 이거 여따 쓰는거 아니야 나중에 옮겨야돼
//					request.setAttribute("msgTeacherUpdate", "교습 정보가 등록되었습니다.");
//					request.getRequestDispatcher("WEB-INF/view/mypage/mypageTeacher.jsp").forward(request, response);
//				} else {
//					request.setAttribute("msgTeacherUpdate", "교습 정보가 등록에 실패하였습니다.");
//					request.getRequestDispatcher("WEB-INF/view/mypage/mypageTeacher.jsp").forward(request, response);
//				}
//			} else {
//				request.setAttribute("msgTeacherUpdate", "잔액이 부족합니다. 충전 후 이용해주세요.");
//				request.getRequestDispatcher("WEB-INF/view/mypage/mypageTeacher.jsp").forward(request, response);
//			}
//		} else if (ssMV.gettNo() != null) { // 교습 정보 수정
//			
//		}
		
		
	}

}


























