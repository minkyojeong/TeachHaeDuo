package kh.semi.thduo.mypage.controller;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import kh.semi.thduo.member.vo.MemberVo;
import kh.semi.thduo.teacher.model.service.TeacherService;
import kh.semi.thduo.teacher.model.vo.TeacherVo;

/**
 * Servlet implementation class ProfileUpdateDoController
 */
@WebServlet("/profileUpdate.do")
public class ProfileUpdateDoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ProfileUpdateDoController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("프로필 사진 등록 doPost");
		String tNo = "";
		TeacherVo tVo = null;
		MemberVo ssMV = (MemberVo) request.getSession().getAttribute("ssMV");
		if (ssMV == null) { // 로그아웃 상태라면 로그인 페이지로
			response.sendRedirect("login");
			return; // 아래 db 저장을 할 필요가 없으니..
		} else {
			tNo = ssMV.gettNo();
			tVo = new TeacherService().readTeacherInfo(tNo);
		}

		System.out.println(request.getContextPath());
		String fileSavePath = "uploadProfile";
		String uploadPath = getServletContext().getRealPath(fileSavePath);
		System.out.println("uploadPath: " + uploadPath);
		String rootPath = getServletContext().getRealPath("/");
		System.out.println("rootPath: " + rootPath);
		// 업로드 할 폴더 존재 여부 확인 - > 없다면 생성해줘야됨
		File path = new File(uploadPath);
		if (!path.exists()) {
			path.mkdirs();
		}

		int maxFileSize = 10 * 1024 * 1024;
		MultipartRequest multi = new MultipartRequest(request, uploadPath, maxFileSize, "UTF-8",
				new DefaultFileRenamePolicy()); // 받아온 파일(request)를 뒤에 경로에 저장하겠다 // 파일 업로드 완료

		// 구현중 TODOTODO
		String pFilePathParam = tVo.getT_picture();
		System.out.println("pFilePathParam:" + pFilePathParam);
		String orgFileName = multi.getOriginalFileName("uploadProfile"); // 전송되어오기전 client에서 파일이름
		String type = multi.getContentType("uploadProfile"); // 전송된 파일의 타입
		String upload = multi.getFilesystemName("uploadProfile"); // 서버에 저장된 파일이름
		if (upload == null && orgFileName != null) { // 파일 저장 실패

			response.sendRedirect("mypage");
			return;
		}
		String pFilePath = "";
		if (upload != null && pFilePathParam != null) {
			// 기존사진 있음 + 새사진이 있는경우
			// 기존사진 서버에서 파일 삭제
			File file = new File(rootPath + pFilePathParam);
			if (file.exists()) { // 파일명까지 적었기 때문에, 파일 존재여부 확인
				file.delete();
				System.out.println("파일삭제");
			} // 파일 없다면.. 아무 행동하지 않고 db 저장하러 감
				// 새 파일을 db에 저장
			pFilePath = fileSavePath + "/" + upload; // 새파일을 db에 저장

		} else if (upload != null) {
			System.out.println("프로필 등록");
			pFilePath = fileSavePath + "/" + upload;
		}
//		System.out.println(bTitle);
//		System.out.println(bContent);
//		System.out.println("upload:" + upload);
//		System.out.println("type:" + type);
//		System.out.println("orgFileName:" + orgFileName);
//		
//		
//		
//		
//		BoardVo vo = new BoardVo();
		
		System.out.println("pFilePath: " + pFilePath);

//		vo.setbNo(bNo);
//		vo.setbContent(bContent);
//		vo.setbTitle(bTitle); 
//		System.out.println("bFilePath: " + bFilePath);
//		vo.setbFilePath(bFilePath);
//		// 글쓰기 버튼 누를때 로그인 상태 확인했는데, 이때도 또 해줘! 왜냐면 그 사이에 로그아웃 됐을수도 있자나

//		if (ssMV == null) { // 로그아웃 상태라면 로그인 페이지로
//			response.sendRedirect("login");
//			return; // 아래 db 저장을 할 필요가 없으니..
//		} else { // 로그인한 상태라면 write page 진입
//			tVo.setT_no(ssMV.gettNo());
//			
//		}
//		
		
//		// db저장
		int result = 0;
		tVo.setT_picture(pFilePath);
		result = new TeacherService().updateProfile(tVo);
		
		if (result == 1) {
			request.setAttribute("rootPath", rootPath);
			request.setAttribute("tVo", tVo);
			request.getSession().setAttribute("msgProfile", "프로필 변경이 완료되었습니다.");
			response.sendRedirect("mypage");
		} else {
			request.getSession().setAttribute("msgProfile", "프로필 변경에 실패했습니다.");
			response.sendRedirect("mypage");
		}
//		if(bNo>0) {
//			result = new BoardService().updateBoard(vo);
//		} else {
//			result = new BoardService().writeBoard(vo);
//			if(result < 1 ) { // 글등록 실패
//				// 기존 저장된 파일이 있다면 삭제
//				
//				response.sendRedirect("boardwrite");
//			} else { // 글등록 성공
//				response.sendRedirect("boardlist");
//			}
//		}
	}

}
