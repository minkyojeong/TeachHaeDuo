package test.kh.semi.thduo.login.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.kh.semi.thduo.member.model.service.MemberService;
import test.kh.semi.thduo.member.model.vo.MemberVo;





/**
 * Servlet implementation class MemberLoginController
 */
@WebServlet("/TestLogin")
public class MemberLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberLoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("WEB-INF/view/TestLogin.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String pw = request.getParameter("pwd");
		System.out.println("id : " + id);
		System.out.println("pw : " + pw);
		
		MemberVo vo = new MemberService().login(id,pw);
		if(vo==null) {
			response.sendRedirect("TestLogin");  // method 방식 안적으면 무조건 get 방식으로 가
			
		} else {
			request.getSession().setAttribute("ssMV", vo);
			// Maincontroller로 이동할거야, 근데 거기 맵핑이 / 이거라 아무것도 안적어줘, "/" 적어주면 절대경로를 의미해
			// 절대경로: context root가 없음. 
//			response.sendRedirect(""); 
			response.sendRedirect(request.getContextPath()+"/");  // contextroot 추가해서 써준것.
//			response.sendRedirect("./");   //상대 경로! 
		}
	}

}
