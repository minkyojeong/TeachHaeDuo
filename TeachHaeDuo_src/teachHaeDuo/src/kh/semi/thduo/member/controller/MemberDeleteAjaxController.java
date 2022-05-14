package kh.semi.thduo.member.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.semi.thduo.member.service.MemberService;
import kh.semi.thduo.member.vo.MemberVo;



/**
 * Servlet implementation class MemberDeleteAjaxController
 */
@WebServlet("/memberDelete.ax")
public class MemberDeleteAjaxController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberDeleteAjaxController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("회원탈퇴컨트롤러");
//		String mId = request.getParameter("mId");
//		System.out.println(mId);
		
		// ajax에 보내기 위한 객체 생성
		PrintWriter out = response.getWriter();
		
		// 사용할 변수 선언
		String mId= null;
		
		// 세션에 담긴 정보 가져오기
		MemberVo ssMV = (MemberVo)request.getSession().getAttribute("ssMV");
		System.out.println("회원탈퇴컨트롤러 ssMV:" + ssMV);
		// 로그인이 안되어있으면
		if(ssMV == null) {  
			out.print("로그인 먼저 해주세요.");
			out.flush();
			out.close();
			return;
		} else { // 되어있으면
			mId = ssMV.getmId();
			System.out.println(mId);
		}
		
		// 설정한 변수 들고 서비스 호출
		int result = new MemberService().deleteMember(mId);
		if(result < 1 ) { // 회원탈퇴 실패
			out.print("회원탈퇴가 실패했습니다.");
		} else { // 회원 탈퇴 성공
			request.getSession().removeAttribute("ssMV");
			out.print("회원탈퇴 성공. 이용해주셔서 감사합니다.");
		}
		out.flush();
		out.close();
	}

}
