package kh.semi.thduo.cs.controller;

import java.io.IOException;
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
 * Servlet implementation class CsNoticeWriteDoController
 */
@WebServlet("/CsNoticeWriteDo")
public class CsNoticeWriteDoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CsNoticeWriteDoController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String title = request.getParameter("cs_q_q");
		String content = request.getParameter("cs_q_a");
		CsVo vo = new CsVo();
		vo.setNoticeContent(content);
		vo.setNoticeTitle(title);
		String adminid = null;
		AdminVo advo = (AdminVo)request.getSession().getAttribute("ssMV");
		if(advo == null) {
			response.sendRedirect("login");
			return;
		}else {
			adminid = advo.getAdminId();
			int result = new CsService().csNoticeWrite(title, content, adminid);
			if(result<1) {
				System.out.println("null-error");
			}else {
				request.getRequestDispatcher("CsMain").forward(request, response);
			}
		
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
