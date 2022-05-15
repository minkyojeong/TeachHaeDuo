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
 * Servlet implementation class ReceiveAlarmListAjaxController
 */
@WebServlet("/receiveAlarmList.ax")
public class ReceiveAlarmListAjaxController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ReceiveAlarmListAjaxController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		
//	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("받은알람 컨트롤러 dopost");

		// ajax로 데이터 보내기 위한 객체 생성
		PrintWriter out = response.getWriter();
		// 세션에 담긴 정보 가져오기
		MemberVo vo = (MemberVo) request.getSession().getAttribute("ssMV");

		// 로그인이 안되어있다면
		if (vo == null) {
			request.getSession().setAttribute("msgLogin", "로그인 먼저 해주세요");
			response.sendRedirect("login");
			return;
		} else { // 되어있다면
			System.out.println("받은 알람 서비스 호출 mNickname:" + vo.getmNickname());

			if (vo.getmNickname() != null) {
				// 서비스 호출
				ArrayList<AlarmVo> voList = new AlarmService().receiveListAlarm(vo.getmNickname());
				System.out.println("리스트 결과:" + voList);
				// 데이터를 잘 받아왔는지
				if (voList != null) {
				// 리턴 값을 gson에 담아 ajax에 넘기기
					Gson gobj = new GsonBuilder().setPrettyPrinting().create();
					String resStr = gobj.toJson(voList);
					out.println(resStr);
					out.flush();
					out.close();
				} else {
					Gson gobj = new GsonBuilder().setPrettyPrinting().create();
					String resStr = gobj.toJson("F");
					out.println(resStr);
					out.flush();
					out.close();
				}
			}
		}
	}
}
