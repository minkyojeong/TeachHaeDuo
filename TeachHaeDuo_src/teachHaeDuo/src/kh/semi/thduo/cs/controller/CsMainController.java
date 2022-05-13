package kh.semi.thduo.cs.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.semi.thduo.admin.vo.AdminVo;
import kh.semi.thduo.cs.service.CsService;
import kh.semi.thduo.cs.vo.CsVo;
import kh.semi.thduo.member.vo.MemberVo;

/**
 * Servlet implementation class CsMainController
 */
@WebServlet("/CsMain")
public class CsMainController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CsMainController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ArrayList<CsVo> csvo = new CsService().csFaqList();
		ArrayList<CsVo> vo = new CsService().csNoticeList();
		request.setAttribute("csvo", csvo);
		request.setAttribute("vo", vo);
		request.getRequestDispatcher("WEB-INF/view/Cs/CsMain.jsp").forward(request, response);
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
