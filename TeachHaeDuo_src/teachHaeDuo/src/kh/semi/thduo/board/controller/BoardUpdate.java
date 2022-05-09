

package kh.semi.thduo.board.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.semi.thduo.board.service.BoardService;
import kh.semi.thduo.board.vo.BoardVo;
import kh.semi.thduo.member.vo.MemberVo;

/**
 * Servlet implementation class BoardUpdate
 */
@WebServlet("/BoardUpdate")
public class BoardUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardUpdate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String bTitle = request.getParameter("bTitle");
		String bContent = request.getParameter("editor1");
		String bCategory = request.getParameter("bCategory");
		String bNoStr = request.getParameter("bNo");
		int bNo = 0;
		try {
			bNo = Integer.parseInt(bNoStr);
		}catch(NumberFormatException e) {
			e.printStackTrace();
		}
		
		System.out.println(bTitle);
		System.out.println(bContent);
		System.out.println(bCategory);
		System.out.println(bNo);

		// 로그인 상태 확인
		MemberVo ssvo = (MemberVo)request.getSession().getAttribute("ssMV");
		if(ssvo == null)  {  // 로그아웃 상태라면 login 페이지로 진입
			response.sendRedirect("login");
			return;
		} else {  // 로그인한 상태라면 write page 진입
			int result = new BoardService().boardUpdate(bContent, bTitle, bCategory, bNo);
			if(result < 1) {   // 글등록 실패
				response.sendRedirect("BoardRead");
			} else { // 글등록 성공
				response.sendRedirect("BoardList");
			}
		}
		// db저장
		
	}

}
