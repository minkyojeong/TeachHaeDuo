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
		
		// 데이터 받아오기
		String wonStr = request.getParameter("won");
		System.out.println(wonStr);
		// 사용할 변수, 객체 선언
		PencilVo vo = new PencilVo();
		int wonInt = 0;
		int result = 0;
		// 파싱 실패할 경우 대비
		try {
			wonInt = Integer.parseInt(wonStr);
			System.out.println(wonInt);
		}catch(NumberFormatException e) {
			e.printStackTrace();
		}
		// 로그인 확인
		MemberVo ssMV = (MemberVo)request.getSession().getAttribute("ssMV");
		if(ssMV == null) {  
			request.getSession().setAttribute("msgLogin", "로그인 먼저 해주세요");
			response.sendRedirect("login");
			return;  
		} else {  
			vo.setmId(ssMV.getmId());
			vo.setCpContent("연필충전");
			vo.setCpCash(wonInt);
			// 서비스 호출
			result = new PencilService().plusPencil(vo);
			// 충전 실패
			if(result < 1 ) { 
				request.getSession().setAttribute("msgCharge", "충전이 실패했습니다.");
				response.sendRedirect("mypage");
			} else {  // 충전 성공
				request.getSession().setAttribute("msgCharge", "충전이 완료되었습니다.");
				response.sendRedirect("mypage");
			}
		}
		
		
	}

}
