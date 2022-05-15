package kh.semi.thduo.like.controller;

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
import kh.semi.thduo.like.model.service.LikeService;
import kh.semi.thduo.like.model.vo.LikeVo;
import kh.semi.thduo.member.vo.MemberVo;

/**
 * Servlet implementation class LikeListAjaxController
 */
@WebServlet("/likeList.ax")
public class LikeListAjaxController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LikeListAjaxController() {
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
		System.out.println("찜내역 컨트롤러 dopost");
		// ajax로 데이터 넘겨주기 위한 객체 생성
		PrintWriter out = response.getWriter();
		// 로그인 여부 확인
		MemberVo vo = (MemberVo)request.getSession().getAttribute("ssMV");
		if(vo == null) {
			response.sendRedirect("login");
		} else {
			// 넘겨줄 데이터 읽어오기, 서비스 호출
			System.out.println("찜내역 서비스 호출 mNickname:" + vo.getsNo());
			ArrayList<LikeVo> result = new LikeService().readLikeList(vo.getsNo());
			System.out.println("리스트 결과:" + result);
			// json에 담아 ajax로 넘겨줌
			Gson gobj = new GsonBuilder().setPrettyPrinting().create();
			String resStr = gobj.toJson(result);
			out.println(resStr);
			out.flush();
			out.close();
		}
	}

}
