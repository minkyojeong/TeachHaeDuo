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
 * Servlet implementation class MemberUpdateContoller
 */
@WebServlet("/memberUpdate")
public class MemberUpdateContoller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberUpdateContoller() {
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
		
		// 세션에 담긴 정보 가져오기
		MemberVo ssMV = (MemberVo)request.getSession().getAttribute("ssMV");
		String mId = ssMV.getmId();
		
		// 입력받은 데이터 가져오기
		String pw = request.getParameter("pw");
		
		// 아이디 비밀번호 확인
		MemberVo vo = new MemberService().login(mId, pw);
		
		// 입력한 정보가 다르다면
		if(vo == null) {
			request.getSession().setAttribute("msgPw", "비밀번호가 틀렸습니다. 다시 로그인해주세요");
			response.sendRedirect("memberUpdateLogin"); // memberUpdateLogin.jsp 이동하게 하는 컨트롤러 url매핑
		} else { // 입력한 정보가 맞다면
			request.getRequestDispatcher("WEB-INF/view/mypage/memberUpdate.jsp").forward(request, response);
		}
	}

}
