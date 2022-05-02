package kh.semi.thduo.member.controller;

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

//		미완성 TODOTODO
//		MemberVo ssMV = (MemberVo)request.getSession().getAttribute("ssMV");
//		String mId = null;
//		String mNickname = null;
//		String mEmail = null;
//		String mPhone = null;
//		String mAddress = null;
//		
//		if(ssMV == null) {
//			response.sendRedirect("login");
//		} else {
//			mId = ssMV.getmId();
//			mNickname = request.getParameter("mNickName");
//			mEmail = request.getParameter("mEmail");
//			mPhone = request.getParameter("mPhone");
//			mAddress = request.getParameter("mAddress1")+" "+request.getParameter("mAddress2");
//		}
//		
//		MemberVo vo = new MemberVo();
//		vo.setmId(mId);
//		vo.setmNickname(mNickname);
//		vo.setmEmail(mEmail);
//		vo.setmPhone(mPhone);
//		vo.setmAddress(mAddress);
		
		int result = 0;
//		int result = new MemberService().updateMember(vo);
		
		if(result == 0) {
			request.getSession().setAttribute("msgUpdate", "회원 정보 변경에 실패했습니다. 다시 시도해주세요");
			response.sendRedirect("mypage");
		} else {
//			ssMV.setmNickname(vo.getmNickname());
			request.getSession().setAttribute("msgUpdate", "회원 정보 변경에 성공했습니다.");
			response.sendRedirect("mypage");
		}
		
		
	}

}
