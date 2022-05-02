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
public class PencilListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PencilListController() {
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
		PrintWriter out = response.getWriter();
		MemberVo vo = (MemberVo)request.getSession().getAttribute("ssMV");
		String mId = "";
		if(vo == null) {
			response.sendRedirect("login");
		} else {
			mId = vo.getmId();
			System.out.println("연필 사용내역 서비스 호출 m_id:" + mId);
			ArrayList<PencilVo> result = new PencilService().listPencil(mId);
			System.out.println("리스트 결과:" + result);
			Gson gobj = new GsonBuilder().setPrettyPrinting().create();
			String resStr = gobj.toJson(result);
			out.println(resStr);
			out.flush();
			out.close();
		}
	}

}
