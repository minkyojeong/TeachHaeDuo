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
 * Servlet implementation class BoardListController
 */
@WebServlet("/BoardList")
public class BoardListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardListController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
int currentPage = 1;
		
		String currentPageStr = request.getParameter("page");
		try {
			currentPage = Integer.parseInt(currentPageStr);
		}catch (NumberFormatException e) {
			e.printStackTrace();
		}
		
		final int pageSize = 10;  // 한페이지에 보여줄 행
		final int pageBlock = 3;  // 페이징에 나타날 페이지수
		int startPage=0;
		int endPage=0;
		int startRnum=0;
		int entRnum=0;
		
		int totalCnt = 0; // 총 글 수
		totalCnt = new BoardService().boardCount();
		
		System.out.println("총"+totalCnt);
		// select count(*) from board
		
		/* Paging 처리 */
//		int totalPageCnt = (int)Math.ceil(totalCnt/pageSize); 
		int totalPageCnt = (totalCnt/pageSize) + (totalCnt%pageSize==0 ? 0 : 1);
		if(currentPage%pageBlock == 0) {
			startPage = ((currentPage/pageBlock)-1)*pageBlock + 1;
		} else {
			startPage = (currentPage/pageBlock)*pageBlock + 1;
		}
		endPage = startPage + pageBlock - 1;
		if(endPage>totalPageCnt) {
			endPage = totalPageCnt;
		}
		System.out.println("page:"+ startPage +"~"+endPage);
		
		/* rownum 처리 */
		startRnum = (currentPage-1)*pageSize + 1;
		entRnum = startRnum + pageSize -1;
		if(entRnum>totalCnt) {
			entRnum = totalCnt;
		}
		System.out.println("rnum:"+ startRnum +"~"+entRnum);
		
		ArrayList<BoardVo> boardList = new BoardService().boardList(startRnum, entRnum);
		System.out.println(boardList);
		
		request.setAttribute("boardlist", boardList);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("totalPageCnt", totalPageCnt);
		request.getRequestDispatcher("WEB-INF/view/Board/boardList.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String bContent = request.getParameter("boardSearch");
		String select = request.getParameter("boardOption");
		String option1 = request.getParameter("select1");
		String option2 = request.getParameter("select2");
		String option3 = request.getParameter("select3");
		if(select == option1) {
			ArrayList<BoardVo> boardList = new BoardService().boardSearchTt(bContent);
			request.setAttribute("boardList", boardList);
			request.getRequestDispatcher("WEB-INF/view/Board/BoardList.jsp").forward(request, response);;
		}
		else if(select == option2) {
			ArrayList<BoardVo> boardList = new BoardService().boardSearchCt(bContent);
			request.setAttribute("boardList", boardList);
			request.getRequestDispatcher("WEB-INF/view/Board/BoardList.jsp").forward(request, response);;
		}else if(select == option3){
			ArrayList<BoardVo> boardList = new BoardService().boardSearchWt(bContent);
			request.setAttribute("boardList", boardList);
			request.getRequestDispatcher("WEB-INF/view/Board/BoardList.jsp").forward(request, response);;
		}

	}

}
