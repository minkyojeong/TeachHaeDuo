package kh.semi.thduo.board.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.semi.thduo.board.service.BoardService;
import kh.semi.thduo.board.vo.BoardVo;

/**
 * Servlet implementation class BoardSearchController
 */
@WebServlet("/BoardSearch")
public class BoardSearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardSearchController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String bSearch = request.getParameter("boardsearch");
		String select = request.getParameter("boardOption");
		String Search = "b_title";
		if(select != null) 
			select = Search;
	
		ArrayList<BoardVo> boardList = new BoardService().boardSearch( select, bSearch);
		request.setAttribute("boardList", boardList);
		request.getRequestDispatcher("WEB-INF/view/Board/BoardList.jsp").forward(request, response);
		}
		
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
