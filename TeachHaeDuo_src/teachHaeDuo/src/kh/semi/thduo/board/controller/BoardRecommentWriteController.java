package kh.semi.thduo.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.semi.thduo.board.service.BoardService;
import kh.semi.thduo.board.vo.BoardReCommentVo;
import kh.semi.thduo.member.vo.MemberVo;

/**
 * Servlet implementation class BoardRecommentWriteController
 */
@WebServlet("/BoardReCommentWrite")
public class BoardRecommentWriteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardRecommentWriteController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String rContent = request.getParameter("reComment");
		String bNo = request.getParameter("bno");
		String rWriter = request.getParameter("rWriter");
		System.out.println(rContent);
		System.out.println(bNo);
		System.out.println(rWriter);
		
		MemberVo ssvo = (MemberVo)request.getSession().getAttribute("ssMV");
		if(ssvo == null)  {  // 로그아웃 상태라면 login 페이지로 진입
			response.sendRedirect("login");
			return;
		} else {  // 로그인한 상태라면 write page 진입
			int result = new BoardService().boardReCommentWrite(bNo, rWriter,rContent);
			if(result < 1) {   // 글등록 실패
				response.sendRedirect("BoardFail");
			} else { // 글등록 성공
				response.sendRedirect("BoardRead");
			}
				
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
	
	}

}
