package kh.semi.thduo.cs.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.semi.thduo.cs.service.CsService;
import kh.semi.thduo.member.vo.MemberVo;

/**
 * Servlet implementation class CsFaqWriteDoController
 */
@WebServlet("/CsFaqWriteDoController")
public class CsFaqWriteDoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CsFaqWriteDoController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String question = request.getParameter("cs_q_q");
			String answer = request.getParameter("cs_q_a");
		/*	관리자 아이디가 되야됌 */	MemberVo ssvo = (MemberVo)request.getSession().getAttribute("ssMV");
			if(ssvo == null)  {  
				response.sendRedirect("login");
			}else {
				String adminid = null;
				new CsService().csFaqWrite(question, answer, adminid);
				response.sendRedirect("CsMain");
				
			}
			
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
