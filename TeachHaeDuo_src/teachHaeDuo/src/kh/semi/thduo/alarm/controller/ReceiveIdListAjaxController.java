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
		System.out.println("받은 알람 아이디 리스트 컨트롤러 dopost");
		PrintWriter out = response.getWriter();
		MemberVo vo = (MemberVo)request.getSession().getAttribute("ssMV");
		String mNickname = "";
		if(vo == null) {
			response.sendRedirect("login");
		} else {
			mNickname = vo.getmNickname();
			System.out.println("받은 알람 서비스 호출 mNickname:" + mNickname);
			ArrayList<AlarmVo> result = new AlarmService().receiveIdList(mNickname);
			System.out.println("리스트 결과:" + result);
			request.getSession().setAttribute("nicknameList", result);
		}
	}

}
