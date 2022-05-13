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
		for (int i = 0; i < studentArr.length; i++) {
			System.out.println("student :" + studentArr[i]);
		}
		// TODOTODO 배열 바꾸기 []
		System.out.println("student toString :" + Arrays.toString(studentArr));
		

		// 어학
		String[] language = request.getParameterValues("language");
		String[] score = request.getParameterValues("score");
		String[] languageScore = new String[language.length];
		System.out.println("language.length :" + language.length);
		if (language != null && score != null) {
			for (int i = 0; i < language.length; i++) {
				System.out.println("language :" + language[i]);
				System.out.println("score :" + score[i]);
				languageScore[i] = language[i] + " " + score[i];
				System.out.println("languageScore :" + languageScore[i]);
			}
		}
		System.out.println("languageScore toString :" + Arrays.toString(languageScore));

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

		MemberVo ssMV = (MemberVo) request.getSession().getAttribute("ssMV");
		String tNo = null;
		String mId = null;
		int result = 0;
		int balance = 0;
		String profileYn = null;
		if (ssMV == null) {
			response.sendRedirect("login");
			return;
		}
		tNo = ssMV.gettNo();
		mId = ssMV.getmId();
		String approvalYn = new TeacherService().checkApproval(tNo);
		System.out.println("승인여부: " + approvalYn);

		profileYn = new TeacherService().checkProfile(tNo);
		System.out.println("프로필 등록 여부: " + profileYn);

		if (profileYn.equals("N")) {
			System.out.println("최초등록이야~");
			balance = new PencilService().checkPencil(mId);
			System.out.println("잔액 확인:" + balance);
			if (balance < 5000) {
				request.setAttribute("msgTeacherUpdate", "잔액이 부족합니다. 충전 후 이용해주세요.");
				request.getRequestDispatcher("WEB-INF/view/mypage/mypageTeacher.jsp").forward(request, response);
			} else {
				PencilVo vo = new PencilVo();
				vo.setCpCash(-5000);
				vo.setCpContent("교습 정보 최초 등록");
				vo.setmId(mId);
				int resultPencil = new PencilService().minusPencil(vo);
				if (resultPencil == 0) {
					request.setAttribute("msgTeacherUpdate", "교습 정보 등록이 실패했습니다.");
					request.getRequestDispatcher("WEB-INF/view/mypage/mypageTeacher.jsp").forward(request, response);
				} else {
					TeacherVo tVo = new TeacherVo();
					tVo.setT_no(tNo);
					tVo.setT_major(major);
					tVo.setT_intro(tIntro.replace("\r\n", "<br>"));
					int resultObject = new TeacherService().insertObject(objectArr, tNo);
					if (resultObject == 0) {
						System.out.println("담당과목 넣기 실패");
						request.setAttribute("msgTeacherUpdate", "교습 정보 등록이 실패했습니다.");
						request.getRequestDispatcher("WEB-INF/view/mypage/mypageTeacher.jsp").forward(request,
								response);
					}
					int resultArea = new TeacherService().insertActiveArea(activeAreaArr, tNo);
					if (resultArea == 0) {
						System.out.println("활동지역 넣기 실패");
						request.setAttribute("msgTeacherUpdate", "교습 정보 등록이 실패했습니다.");
						request.getRequestDispatcher("WEB-INF/view/mypage/mypageTeacher.jsp").forward(request,
								response);
					}
					tVo.setOnline_yna(onlineYn);
					tVo.setT_tcnt(tCnt);
					tVo.setT_tprice(tPrice);
					tVo.setT_wantstud(Arrays.toString(studentArr));
					tVo.setT_language(Arrays.toString(languageScore));
					tVo.setT_career(tCareer);
					tVo.setT_special(tSpecial.replace("\r\n", "<br>"));

					result = new TeacherService().updateTeacher(tVo);
					if (result == 0) {
						System.out.println("t_profile 넣기 실패");
						request.setAttribute("msgTeacherUpdate", "교습 정보 등록이 실패했습니다.");
						request.getRequestDispatcher("WEB-INF/view/mypage/mypageTeacher.jsp").forward(request,
								response);
					} else {
						System.out.println("t_profile update 성공");
						request.setAttribute("msgTeacherUpdate", "교습 정보가 변경되었습니다.");
						request.getRequestDispatcher("WEB-INF/view/mypage/mypageTeacher.jsp").forward(request,
								response);
					}
				}
			}
		} else if (profileYn.equals("Y")) {
			System.out.println("등록된 교습정보있어~");
			PencilVo vo = new PencilVo();
			vo.setCpCash(-500);
			vo.setCpContent("교습 정보 변경");
			vo.setmId(mId);
			int resultPencil = new PencilService().minusPencil(vo);
			if (resultPencil == 0) {
				request.setAttribute("msgTeacherUpdate", "교습 정보 등록이 실패했습니다.");
				request.getRequestDispatcher("WEB-INF/view/mypage/mypageTeacher.jsp").forward(request, response);
			} else {
				TeacherVo tVo = new TeacherVo();
				tVo.setT_no(tNo);
				tVo.setT_major(major);
				tVo.setT_intro(tIntro.replace("\r\n", "<br>"));
				int resultObjectDelete = new TeacherService().deleteObject(tNo);
				if(resultObjectDelete == 0) {
					System.out.println("존재하는 담당과목 삭제 실패");
					request.setAttribute("msgTeacherUpdate", "교습 정보 등록이 실패했습니다.");
					request.getRequestDispatcher("WEB-INF/view/mypage/mypageTeacher.jsp").forward(request, response);
				}
				int resultObject = new TeacherService().insertObject(objectArr, tNo);
				if (resultObject == 0) {
					System.out.println("담당과목 넣기 실패");
					request.setAttribute("msgTeacherUpdate", "교습 정보 등록이 실패했습니다.");
					request.getRequestDispatcher("WEB-INF/view/mypage/mypageTeacher.jsp").forward(request, response);
				}
				int resultAreaDelete = new TeacherService().deleteActiveArea(tNo);
				if(resultAreaDelete == 0) {
					System.out.println("존재하는 활동지역 삭제 실패");
					request.setAttribute("msgTeacherUpdate", "교습 정보 등록이 실패했습니다.");
					request.getRequestDispatcher("WEB-INF/view/mypage/mypageTeacher.jsp").forward(request, response);
				}
				int resultArea = new TeacherService().insertActiveArea(activeAreaArr, tNo);
				if (resultArea == 0) {
					System.out.println("활동지역 넣기 실패");
					request.setAttribute("msgTeacherUpdate", "교습 정보 등록이 실패했습니다.");
					request.getRequestDispatcher("WEB-INF/view/mypage/mypageTeacher.jsp").forward(request, response);
				}
				tVo.setOnline_yna(onlineYn);
				tVo.setT_tcnt(tCnt);
				tVo.setT_tprice(tPrice);
				tVo.setT_wantstud(Arrays.toString(studentArr));
				tVo.setT_language(Arrays.toString(languageScore));
				tVo.setT_career(tCareer);
				tVo.setT_special(tSpecial.replace("\r\n", "<br>"));
				

				result = new TeacherService().updateTeacher(tVo);
				if (result == 0) {
					System.out.println("t_profile 넣기 실패");
					request.setAttribute("msgTeacherUpdate", "교습 정보 등록이 실패했습니다.");
					request.getRequestDispatcher("WEB-INF/view/mypage/mypageTeacher.jsp").forward(request, response);
				} else {
					System.out.println("t_profile update 성공");
					request.setAttribute("msgTeacherUpdate", "교습 정보가 변경되었습니다.");
					request.getRequestDispatcher("WEB-INF/view/mypage/mypageTeacher.jsp").forward(request, response);
				}
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
