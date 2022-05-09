package kh.semi.thduo.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.semi.thduo.member.vo.MemberVo;
import kh.semi.thduo.board.service.BoardService;
import kh.semi.thduo.board.vo.BoardVo;

/**
 * Servlet implementation class BoardWriteDoController
 */
@WebServlet("/BoardWriteDo")
public class BoardWriteDoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardWriteDoController() {
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
		
		System.out.println(bTitle);
		System.out.println(bContent);
		System.out.println(bCategory);

		
		
		BoardVo vo = new BoardVo();
		vo.setbContent(bContent);
		vo.setbTitle(bTitle);
		vo.setbCategory(bCategory);

		// 로그인 상태 확인
		MemberVo ssvo = (MemberVo)request.getSession().getAttribute("ssMV");
		if(ssvo == null)  {  // 로그아웃 상태라면 login 페이지로 진입
			response.sendRedirect("login");
			return;
		} else {  // 로그인한 상태라면 write page 진입
			vo.setmId(ssvo.getmId());
			vo.setbWriter(ssvo.getmNickname());
		}
		// db저장
		int result = new BoardService().boardWriteDo(vo);
		if(result < 1) {   // 글등록 실패
			response.sendRedirect("BoardWrite");
		} else { // 글등록 성공
			response.sendRedirect("BoardList");
		}
		
	

	}
}
