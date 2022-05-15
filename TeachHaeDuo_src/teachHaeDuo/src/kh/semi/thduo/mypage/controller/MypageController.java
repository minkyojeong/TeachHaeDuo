package kh.semi.thduo.mypage.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.semi.thduo.alarm.model.service.AlarmService;
import kh.semi.thduo.like.model.service.LikeService;
import kh.semi.thduo.member.vo.MemberVo;
import kh.semi.thduo.pencil.model.service.PencilService;
import kh.semi.thduo.pencil.model.vo.PencilVo;
import kh.semi.thduo.teacher.model.service.TeacherService;
import kh.semi.thduo.teacher.model.vo.TeacherVo;

/**
 * Servlet implementation class MypageController
 */
@WebServlet("/mypage")
public class MypageController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MypageController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		System.out.println("마이페이지 doget");
		
		// 로그인이 안됐을 경우
		MemberVo ssMV = (MemberVo)request.getSession().getAttribute("ssMV");
		if(ssMV == null) {
			request.getSession().setAttribute("msgLogin", "로그인 먼저 해주세요");
			response.sendRedirect("login");
			return;
		} else { // 되어있을 경우
			System.out.println(ssMV.getRoleSt());
			
			// 로그인한 회원이 학생, 선생님에 따라서 다른 페이지 진입
			if(ssMV.getRoleSt().equals("T")) {
				System.out.println("선생 마이페이지 진입");
				// 마이페이지에서 보여줄 정보들 가져오기
				TeacherVo tVo = new TeacherService().readTeacherInfo(ssMV.gettNo());
				int numberOfSendAlarm = new AlarmService().numberOfSendAlarm(ssMV.getmNickname());
				int numberOfReceiveAlarm = new AlarmService().numberOfReceiveAlarm(ssMV.getmNickname());
				int balance = new PencilService().checkPencil(ssMV.getmId());
				System.out.println(tVo);
				// 가져온 정보 담기
				request.setAttribute("tVo", tVo);
				request.setAttribute("numberOfSendAlarm", numberOfSendAlarm);
				request.setAttribute("numberOfReceiveAlarm", numberOfReceiveAlarm);
				request.setAttribute("balance", balance);
				// 담은 정보 가지고 선생님 마이페이지 진입
				request.getRequestDispatcher("WEB-INF/view/mypage/mypageTeacher.jsp").forward(request, response);
			} else if(ssMV.getRoleSt().equals("S")) {
				System.out.println("학생 마이페이지 진입");
				// 마이페이지에서 보여줄 정보들 가져오기
				int numberOfSendAlarm = new AlarmService().numberOfSendAlarm(ssMV.getmNickname());
				int numberOfReceiveAlarm = new AlarmService().numberOfReceiveAlarm(ssMV.getmNickname());
				int balance = new PencilService().checkPencil(ssMV.getmId());
				int numberOfLike = new LikeService().numberOfLike(ssMV.getsNo());
				// 가져온 정보 담기
				request.setAttribute("numberOfSendAlarm", numberOfSendAlarm);
				request.setAttribute("numberOfReceiveAlarm", numberOfReceiveAlarm);
				request.setAttribute("balance", balance);
				request.setAttribute("numberOfLike", numberOfLike);
				// 담은 정보 가지고 학생 마이페이지 진입
				request.getRequestDispatcher("WEB-INF/view/mypage/mypageStudent.jsp").forward(request, response);
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		doGet(request, response);
//	}

}
