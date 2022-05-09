package kh.semi.thduo.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.semi.thduo.board.service.BoardService;
import kh.semi.thduo.board.vo.BoardVo;
import kh.semi.thduo.board.vo.BoardReportVo;
import kh.semi.thduo.member.vo.MemberVo;

/**
 * Servlet implementation class BoardReportController
 */
@WebServlet("/BoardReport")
public class BoardReportController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardReportController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String bNoStr = request.getParameter("bno");
		String bRCategory = request.getParameter("b_r_category");
		String bRWriter = request.getParameter("b_r_writer");
		int bNo = 0;
		try {
			bNo = Integer.parseInt(bNoStr);
		}catch(NumberFormatException e) {
			e.printStackTrace();
		}
		System.out.println(bNo);
		System.out.println(bRCategory);
		System.out.println(bRWriter);
		MemberVo ssvo = (MemberVo)request.getSession().getAttribute("ssMV");
		if(ssvo == null)  {  // 로그아웃 상태라면 login 페이지로 진입
			response.sendRedirect("login");
			return;
		} else {  // 로그인한 상태라면 write page 진입
			int result = new BoardService().boardReport(bNo,bRWriter,bRCategory);
			if(result < 1) {   // 글등록 실패
				response.sendRedirect("BoardList");
			} else { // 글등록 성공
				response.sendRedirect("WEB-INF/view/Board/BoardReportSuc.jsp");
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
