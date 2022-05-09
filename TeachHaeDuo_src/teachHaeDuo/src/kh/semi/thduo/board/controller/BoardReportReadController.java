package kh.semi.thduo.board.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.semi.thduo.board.service.BoardService;
import kh.semi.thduo.board.vo.BoardVo;

/**
 * Servlet implementation class BoardReportReadController
 */
@WebServlet("/BoardReportRead")
public class BoardReportReadController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardReportReadController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String bNo = request.getParameter("bno");
		
		BoardVo result = new BoardService().boardRead(bNo);
		System.out.println(result);
		result.setbContent(result.getbContent().replaceAll("(\r\n|\n)", "<br>"));
		result.setbContent(result.getbContent().replaceAll(" ", "&nbsp;"));
		System.out.println(result);
		request.setAttribute("bvo", result);
		request.getRequestDispatcher("BoardReportConfirm.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
