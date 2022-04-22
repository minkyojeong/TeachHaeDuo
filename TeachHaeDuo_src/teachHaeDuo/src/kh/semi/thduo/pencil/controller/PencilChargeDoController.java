package kh.semi.thduo.pencil.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.semi.thduo.member.vo.MemberVo;
import kh.semi.thduo.pencil.model.service.PencilService;
import kh.semi.thduo.pencil.model.vo.PencilVo;


/**
 * Servlet implementation class PencilChargeDoController
 */
@WebServlet("/pencilCharge.do")
public class PencilChargeDoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PencilChargeDoController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		
//	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String wonStr = request.getParameter("won");
		PencilVo vo = new PencilVo();
		int wonInt = 0;
		try {
			wonInt = Integer.parseInt(wonStr);
		}catch(NumberFormatException e) {
			e.printStackTrace();
		}
		// 로그인 연동 시키고 풀자 TODOTODO
		MemberVo ssvo = (MemberVo)request.getSession().getAttribute("ssMV");
		if(ssvo == null) {  
			response.sendRedirect("login");
			return;  
		} else {  
			vo.setmId(ssvo.getmId());
		}
		
		vo.setCmContent("연필충전");
		vo.setCmPencil(wonInt);
		int result = new PencilService().plusPencil(vo);
		// 로그인 후 정보를 불러오지 못함 확인 후 열자 TODOTODO
//		if(result < 1 ) { 
//			request.getSession().setAttribute("mag", "충전이 실패했습니다.");
//			if(ssvo.getRoleSt() == "S") {
//				response.sendRedirect("mypageStudent");
//			} else if(ssvo.getRoleSt() == "T") {
//				response.sendRedirect("mypageTeacher");
//			}
//			
//		} else { 
//			request.getSession().setAttribute("mag", "충전이 완료되었습니다.");
//			if(ssvo.getRoleSt() == "S") {
//				response.sendRedirect("mypageStudent");
//			} else if(ssvo.getRoleSt() == "T") {
//				response.sendRedirect("mypageTeacher");
//			}
//		}
		
		
		
	}

}
