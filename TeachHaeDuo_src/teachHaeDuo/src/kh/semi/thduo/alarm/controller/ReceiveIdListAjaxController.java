package kh.semi.thduo.alarm.controller;

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

import kh.semi.thduo.alarm.model.service.AlarmService;
import kh.semi.thduo.alarm.model.vo.AlarmVo;
import kh.semi.thduo.member.vo.MemberVo;

/**
 * Servlet implementation class ReceiveIdListAjaxController
 */
@WebServlet("/receiveIdList.ax")
public class ReceiveIdListAjaxController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ReceiveIdListAjaxController() {
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
		System.out.println("받은 알람 아이디 리스트 컨트롤러 dopost");
		// ajax로 데이터 보내기 위한 객체 생성
		PrintWriter out = response.getWriter();
		// 세션에 담긴 정보 가져오기
		MemberVo vo = (MemberVo) request.getSession().getAttribute("ssMV");
		// 사용할 변수 선언
		String mNickname = "";

		// 로그인이 안되어있다면
		if (vo == null) {
			request.getSession().setAttribute("msgLogin", "로그인 먼저 해주세요");
			response.sendRedirect("login");
			return;
		} else {// 되어있다면
			// 세션에서 받아온 정보 변수에 담기
			mNickname = vo.getmNickname();
			if (mNickname != null) {
				System.out.println("받은 알람 서비스 호출 mNickname:" + mNickname);
				// 서비스 호출
				ArrayList<AlarmVo> result = new AlarmService().receiveIdList(mNickname);
				System.out.println("리스트 결과:" + result);
				// 리턴값 세션에 저장
				request.getSession().setAttribute("nicknameList", result);
			}
		}
	}

}
