package kh.semi.thduo.member.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.Properties;
import java.util.Random;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import kh.semi.thduo.member.service.MemberService;
import kh.semi.thduo.member.vo.MemberVo;
import kh.semi.thduo.student.service.StudentService;
import kh.semi.thduo.student.vo.StudentVo;

/**
 * Servlet implementation class MemberLoginController
 */
@WebServlet("/join")
public class MemberJoinController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MemberJoinController() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("doGet - join");
		request.getRequestDispatcher("WEB-INF/view/member/join.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {

		System.out.println("doPost - join");
	

		// 파일 저장 경로
		String fileSavePath = "upload";
		// 파일 크기 10M 제한
		int uploadSizeLimit = 10 * 1024 * 1024;
		String encType = "UTF-8";
		ServletContext context = getServletContext();
		String uploadPath = context.getRealPath(fileSavePath);
		
		// 업로드 할 폴더 존재여부확인 - 없다면 생성
		File path = new File(uploadPath);
		if(!path.exists()) {
			path.mkdirs();
		}
		System.out.println("uploadPath:"+ uploadPath);
		
		MultipartRequest multi = new MultipartRequest(request, // request 객체
				uploadPath, // 서버 상 업로드 될 디렉토리
				uploadSizeLimit, // 업로드 파일 크기 제한
				encType, // 인코딩 방법
				new DefaultFileRenamePolicy() // 동일 이름 존재 시 새로운 이름 부여 방식
		);  // 파일 저장 완료
		

		// 기존 code에서 multi로 바꿔 줘여함.
		MemberVo memberVo = new MemberVo();
		
		System.out.println("client파일명"+multi.getParameter("joinupload"));   // 업로드한 클라이언트 pc에 있던 파일명
		String fileName = multi.getFilesystemName("joinupload");   // 서버에 업로드한 파일명
		System.out.println("서버 저장 파일명"+ fileName);
		String mCertificate = fileSavePath + "/" +fileName;
		memberVo.setmCertificate(mCertificate);


		memberVo.setmId(multi.getParameter("mId"));
		memberVo.setmPw(multi.getParameter("mPw"));
		memberVo.setmNickname(multi.getParameter("mNickName"));
		memberVo.setmName(multi.getParameter("mName"));
		memberVo.setmBirth(multi.getParameter("mBirth"));
		memberVo.setmPhone(multi.getParameter("mPhone"));
		memberVo.setmEmail(multi.getParameter("mEmail"));
		memberVo.setmAddress(multi.getParameter("mAddress1") + " " + request.getParameter("mAddress2"));
		memberVo.setGenderFm(multi.getParameter("genderFm"));
		memberVo.setRoleSt(multi.getParameter("roleSt"));
		
		System.out.println("memberVo: "+memberVo);
		PrintWriter out = response.getWriter();

		try {
			int i = new MemberService().insertMember(memberVo);
			
			if (i < 1) {
				// 가입페이지이동
				out.print("<script>alert('가입 실패 다시 시도해주세요.');</script>");
				out.flush();
				out.close();
				request.getRequestDispatcher("WEB-INF/view/member/join.jsp").forward(request, response);
				
				return;
			}
			
			if (memberVo.getRoleSt().equals("S")) { //받은 값이 S이면  
				
				String sNo = new StudentService().readStudentCheck();//readStudentCheck  DB가서 번호 체크 
				if(sNo.length() == 0) { // 길이가 0 같은면 S1
					sNo="S1";   
				}else {
					int no = Integer.parseInt(sNo.substring(1, sNo.length())) + 1;
					sNo = "S".concat(no+""); 
				}
				StudentVo sVo = new StudentVo(); //
				sVo.setmId(memberVo.getmId());
				sVo.setsNo(sNo);
				
				i = new StudentService().insertStudent(sVo);
				
			}if (multi.getParameter("roleSt").equals("T")) {
				
				//TO-Do 선생님 테이블 T_PROFILE  insert
			}
			
			
			if (i > 0) {
				//회원가입 성공시 로그인페이지 
				response.sendRedirect("login");
				out.print("<script>alert('가입 성공');</script>");
				out.flush();
				out.close();
			} else {
				// 가입페이지이동
				out.print("<script>alert('가입 실패 다시 시도해주세요.');</script>");
				out.flush();
				out.close();
				request.getRequestDispatcher("WEB-INF/view/member/join.jsp").forward(request, response);
				
				return;

			}
		} catch (Exception e) {
			e.printStackTrace();
			out.print("<script>alert('가입 실패 다시 시도해주세요.');</script>");
			out.flush();
			out.close();
			
			return;
		}
	}
}
