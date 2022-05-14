package kh.semi.thduo.mypage.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.semi.thduo.member.service.MemberService;
import kh.semi.thduo.member.vo.MemberVo;

/**
 * Servlet implementation class MemberUpdateDoController
 */
@WebServlet("/memberUpdate.do")
public class MemberUpdateDoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberUpdateDoController() {
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
		System.out.println("회원정보수정 컨트롤러 doPost");

		// 세션에 담긴 정보 가져오기
		MemberVo ssMV = (MemberVo)request.getSession().getAttribute("ssMV");
		// 사용할 변수 선언
		String mId = null;
		String mPw = null;
		String initPw = null;
		String mEmail = null;
		String mPhone = null;
		String mAddress = null;
		MemberVo vo = null;
		int result = 0;
		// 로그인이 안되있으면
		if(ssMV == null) {
			request.getSession().setAttribute("msgLogin", "로그인 먼저 해주세요");
			response.sendRedirect("login");
			return;
		} else {
			mId = ssMV.getmId();
		// client가 입력한 정보 받아오기
			mPw = request.getParameter("mPw");
			initPw = request.getParameter("initPw");
			mEmail = request.getParameter("mEmail");
			mPhone = request.getParameter("mPhone");
			mAddress = request.getParameter("mAddress1")+" "+request.getParameter("mAddress2");
		}
		
		// 입력 받은 정보 vo에 담기
			vo = new MemberVo();
			vo.setmId(mId);
			vo.setmEmail(mEmail);
			vo.setmPhone(mPhone);
			vo.setmAddress(mAddress);
			
		// 비밀 번호 변경은 안하는 경우
		if(mPw == null || mPw.equals("")) {
			vo.setmPw(initPw);
		} else { // 비밀번호 변경도 하는 경우
			vo.setmPw(mPw);
		}
		
		// 회원 정보 업데이트
		System.out.println("회원정보수정 컨트롤러 vo:" + vo);
		result = new MemberService().updateMember(vo);
		System.out.println("회원정보수정 컨트롤러 result:" + result);
		// 업데이트 실패
		if(result == 0) {
			request.getSession().setAttribute("msgUpdate", "회원 정보 변경에 실패했습니다. 다시 시도해주세요");
			response.sendRedirect("mypage");
		} else { // 업데이트 성공
			request.getSession().setAttribute("msgUpdate", "회원 정보 변경에 성공했습니다.");
			response.sendRedirect("mypage");
		}
		
		
	}

}
