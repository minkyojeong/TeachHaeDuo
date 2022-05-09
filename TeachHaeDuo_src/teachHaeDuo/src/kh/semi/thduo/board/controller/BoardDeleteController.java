package kh.semi.thduo.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.semi.thduo.member.vo.MemberVo;
import kh.semi.thduo.board.service.BoardService;

/**
 * Servlet implementation class BoardDeleteController
 */
@WebServlet("/BoardDelete")
public class BoardDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardDeleteController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stubString bNoStr = request.getParameter("bno");
		String bNoStr = request.getParameter("bno");
		int bNo = 0;
		bNo = Integer.parseInt(bNoStr);
		System.out.println(bNo);
		MemberVo ssvo = (MemberVo)request.getSession().getAttribute("ssMV");
		if(ssvo == null)  {  // 로그아웃 상태라면 login 페이지로 진입
			response.sendRedirect("login");
			return;
		} else {  // 로그인한 상태라면 write page 진입
			
			new BoardService().boardDelete(bNo);
			response.sendRedirect("BoardList");
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
