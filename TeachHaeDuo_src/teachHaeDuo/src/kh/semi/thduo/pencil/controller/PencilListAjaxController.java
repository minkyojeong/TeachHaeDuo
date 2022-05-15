package kh.semi.thduo.pencil.controller;

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
import kh.semi.thduo.pencil.model.service.PencilService;
import kh.semi.thduo.pencil.model.vo.PencilVo;

/**
 * Servlet implementation class PencilListController
 */
@WebServlet("/listPencil.ax")
public class PencilListAjaxController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PencilListAjaxController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		
//		
//	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("연필 사용내역 컨트롤러 dopost");
		// ajax로 데이터 보내기 위한 객체 생성
		PrintWriter out = response.getWriter();
		
		// 사용할 변수 선언
		String mId = null;
		// 로그인 확인
		MemberVo vo = (MemberVo)request.getSession().getAttribute("ssMV");
		if(vo == null) { // 로그인 안되어있다면
			request.getSession().setAttribute("msgLogin", "로그인 먼저 해주세요");
			response.sendRedirect("login");
			return;
		} else { // 되어있다면
			mId = vo.getmId();
			System.out.println("연필 사용내역 서비스 호출 m_id:" + mId);
			// 서비스 호출
			ArrayList<PencilVo> result = new PencilService().listPencil(mId);
			System.out.println("리스트 결과:" + result);
			// gson에 담아 ajax로 데이터 넘겨주기
			Gson gobj = new GsonBuilder().setPrettyPrinting().create();
			String resStr = gobj.toJson(result);
			out.println(resStr);
			out.flush();
			out.close();
		}
	}

}
