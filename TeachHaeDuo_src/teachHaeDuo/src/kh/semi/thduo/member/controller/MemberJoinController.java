package kh.semi.thduo.member.controller;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import kh.semi.thduo.member.service.MemberService;
import kh.semi.thduo.member.vo.MemberVo;

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
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

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
		

		// 기존 code에서 바꿔 줘여함.
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

		int i = new MemberService().insertMember(memberVo);
		if (i > 0) {
			response.sendRedirect("login");
		} else {
			response.sendRedirect(request.getContextPath() + "/"); // 절대경로를 의미하며 -context root가 없음.

		}

	}

}
