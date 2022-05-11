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
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("마이페이지 doget");
		
		// 세션에 담긴 정보 가져오기
		MemberVo ssMV = (MemberVo)request.getSession().getAttribute("ssMV");
		
		// 사용할 변수 선언
		String mId = null;;
		String roleSt = null;
		String mNickname = null;
		String sNo = null;
		String tNo = null;
		
		// 로그인이 안됐을 경우
		if(ssMV == null) {
			response.sendRedirect("login");
		} else {
			mId = ssMV.getmId();
			roleSt = ssMV.getRoleSt();
			mNickname = ssMV.getmNickname();
			sNo = ssMV.getsNo();
			tNo = ssMV.gettNo();
			System.out.println(roleSt);
			
			// 로그인한 회원이 학생, 선생님에 따라서 다른 페이지 진입
			if(roleSt == null) {
				response.sendRedirect("login");
			} else if(roleSt.equals("T")) {
				System.out.println("선생 마이페이지 진입");
				// 마이페이지에서 보여줄 정보들 가져오기
				TeacherVo tVo = new TeacherService().readTeacherInfo(tNo);
				int numberOfSendAlarm = new AlarmService().numberOfSendAlarm(mNickname);
				int numberOfReceiveAlarm = new AlarmService().numberOfReceiveAlarm(mNickname);
				int balance = new PencilService().checkPencil(mId);
				System.out.println(tVo);
				// 가져온 정보 담기
				request.setAttribute("tVo", tVo);
				request.setAttribute("numberOfSendAlarm", numberOfSendAlarm);
				request.setAttribute("numberOfReceiveAlarm", numberOfReceiveAlarm);
				request.setAttribute("balance", balance);
				// 담은 정보 가지고 선생님 마이페이지 진입
				request.getRequestDispatcher("WEB-INF/view/mypage/mypageTeacher.jsp").forward(request, response);
			} else if(roleSt.equals("S")) {
				System.out.println("학생 마이페이지 진입");
				// 마이페이지에서 보여줄 정보들 가져오기
				int numberOfSendAlarm = new AlarmService().numberOfSendAlarm(mNickname);
				int numberOfReceiveAlarm = new AlarmService().numberOfReceiveAlarm(mNickname);
				int balance = new PencilService().checkPencil(mId);
				int numberOfLike = new LikeService().numberOfLike(sNo);
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
