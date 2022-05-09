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
 * Servlet implementation class BoardModifyController
 */
@WebServlet("/BoardModify")
public class BoardModifyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardModifyController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String bNoStr = request.getParameter("bno");
		System.out.println(bNoStr);
		int bNo = 0;
		try {
			bNo = Integer.parseInt(bNoStr);
		}catch(NumberFormatException e) {
			e.printStackTrace();
		}
		BoardVo result = new BoardService().boardModify(bNo);
		System.out.println(result);
		result.setbContent(result.getbContent().replaceAll("(\r\n|\n)", "<br>"));
		result.setbContent(result.getbContent().replaceAll(" ", "&nbsp;"));
		System.out.println(result);
		request.setAttribute("bvo", result);
		request.getRequestDispatcher("WEB-INF/vew/Board/BoardModify.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 수정하고 싶은 내용 불러오는 컨트롤러 => modify.jsp로 이
		
	}

}
