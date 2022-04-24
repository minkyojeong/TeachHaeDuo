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
		PrintWriter out = response.getWriter();
		String mId= "";
		
		// 로그인 상태 확인
		MemberVo ssvo = (MemberVo)request.getSession().getAttribute("ssMV");
		if(ssvo == null) {  
			out.print("로그인 먼저 해주세요.");
			out.flush();
			out.close();
			return;
		} else {
			mId = ssvo.getmId();
			System.out.println(mId);
		}
		
		int result = new MemberService().deleteMember(mId);
		if(result < 1 ) { // 회원탈퇴 실패
			out.print("회원탈퇴가 실패했습니다.");
		} else { // 회원 탈퇴 성공
			out.print("회원탈퇴 성공. 이용해주셔서 감사합니다.");
		}
		out.flush();
		out.close();
	}

}
