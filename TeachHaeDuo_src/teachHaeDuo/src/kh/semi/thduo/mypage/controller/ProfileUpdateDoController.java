package kh.semi.thduo.mypage.controller;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
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
//		// cloudinary 사용을 위해 등록
//		Cloudinary cloudinary = new Cloudinary(ObjectUtils.asMap(
//				"cloud_name", "digbnfogm",
//				"api_key", "722949753961794",
//				"api_secret", "ABLvztU8OQBbyionGwED-nJieYE",
//				"secure", true));
//		
//		String tNo = "";
//		TeacherVo tVo = null;
//		MemberVo ssMV = (MemberVo) request.getSession().getAttribute("ssMV");
//		if (ssMV == null) { // 로그아웃 상태라면 로그인 페이지로
//			response.sendRedirect("login");
//			return; // 아래 db 저장을 할 필요가 없으니..
//		} else {
//			tNo = ssMV.gettNo();
//			tVo = new TeacherService().readTeacherInfo(tNo);
//		}
//
//		System.out.println(request.getContextPath());
//		String fileSavePath = "uploadProfile";
//		String uploadPath = getServletContext().getRealPath(fileSavePath);
//		System.out.println("uploadPath: " + uploadPath);
//		String rootPath = getServletContext().getRealPath("/");
//		System.out.println("rootPath: " + rootPath);
//		// 업로드 할 폴더 존재 여부 확인 - > 없다면 생성해줘야됨
//		File path = new File(uploadPath);
//		if (!path.exists()) {
//			path.mkdirs();
//		}
//
//		int maxFileSize = 10 * 1024 * 1024;
//		MultipartRequest multi = new MultipartRequest(request, uploadPath, maxFileSize, "UTF-8",
//				new DefaultFileRenamePolicy()); // 받아온 파일(request)를 뒤에 경로에 저장하겠다 // 파일 업로드 완료
//
//		String pFilePathParam = tVo.getT_picture();
//		System.out.println("pFilePathParam:" + pFilePathParam);
//		String orgFileName = multi.getOriginalFileName("uploadProfile"); // 전송되어오기전 client에서 파일이름
//		String type = multi.getContentType("uploadProfile"); // 전송된 파일의 타입
//		String upload = multi.getFilesystemName("uploadProfile"); // 서버에 저장된 파일이름
//		if (upload == null && orgFileName != null) { // 파일 저장 실패
//
//			response.sendRedirect("mypage");
//			return;
//		}
//		String pFilePath = "";
//		if (upload != null && pFilePathParam != null) { // 기존사진 있음 + 새사진이 있는경우
//			// 기존사진 서버에서 파일 삭제
//			String[] existFile = pFilePathParam.split("/");
//			for(int i = 0; i < existFile.length; i++) {
//				pFilePathParam = existFile[i];
//			}
//			System.out.println("pFilePathParam : " + pFilePathParam);
//			
//			File file = new File(uploadPath + "/" + pFilePathParam);
//			if (file.exists()) { // 파일명까지 적었기 때문에, 파일 존재여부 확인
//				file.delete();
//				cloudinary.uploader().destroy("profile/" + pFilePathParam.replace(".png", ""), ObjectUtils.emptyMap());
//				System.out.println("파일삭제");
//			} // 파일 없다면.. 아무 행동하지 않고 db 저장하러 감
//			// 새 파일을 db에 저장
//			File newFile = new File(uploadPath + "/" + upload);
//			// 이미지 업로드 시, 파일 이름을 업로드 이름으로 하고 저장 폴더를 profile로 함
//			Map uploadResult = cloudinary.uploader().upload(newFile, ObjectUtils.asMap(
//					"public_id", upload.replace(".png", ""),
//					"folder", "profile"));
//			System.out.println("업로드 된 주소 : " + uploadResult.get("url"));
//			pFilePath = (String) uploadResult.get("url"); // 새파일을 DB에 저장
//			
////			pFilePath = fileSavePath + "/" + upload; // 새파일을 db에 저장
//		} else if (upload != null) { // 사진 처음 업로드하는 경우
//			System.out.println("프로필 등록");
//			
//			File uploadFile = new File(uploadPath + '/' + upload);
//			// 이미지 업로드 시, 파일 이름을 업로드 이름으로 하고 저장 폴더를 profile로 함
//			Map uploadResult = cloudinary.uploader().upload(uploadFile, ObjectUtils.asMap(
//					"public_id", upload.replace(".png", "") , 
//					"folder", "profile"));
//			
//			System.out.println("업로드 된 주소 : " + uploadResult.get("url"));
//			System.out.println("이미지 이름 : " + uploadResult.get("public_id"));
//			pFilePath = (String) uploadResult.get("url"); // 새파일을 DB에 저장
//			
////			pFilePath = fileSavePath + "/" + upload;
//		}
//
//		
//		System.out.println("pFilePath: " + pFilePath);
//
//	
//		
////		// db저장
//		int result = 0;
//		tVo.setT_picture(pFilePath);
//		result = new TeacherService().updateProfilePicture(tVo);
//		
//		if (result == 1) {
//			request.setAttribute("rootPath", rootPath);
//			request.setAttribute("tVo", tVo);
//			request.getSession().setAttribute("msgProfile", "프로필 변경이 완료되었습니다.");
//			response.sendRedirect("mypage");
//		} else {
//			request.getSession().setAttribute("msgProfile", "프로필 변경에 실패했습니다.");
//			response.sendRedirect("mypage");
//		}
//

		// 업로드한 사진 파일 url 가져오기
		String fileUrl = request.getParameter("fileUrl");
		System.out.println(fileUrl);

		// 사용할 변수, 객체 선언
		TeacherVo tVo = new TeacherVo();
		int result = 0;

		// 세션에 담긴 정보 가져오기
		MemberVo ssMV = (MemberVo) request.getSession().getAttribute("ssMV");

		// 로그인이 안되어있다면
		if (ssMV == null) {
			request.getSession().setAttribute("msgLogin", "로그인 먼저 해주세요");
			response.sendRedirect("login");
			return;
		} else { // 되어있다면

			// 변수에 잘 담겼나 확인
			if (ssMV.gettNo() != null) {
				// tVo에 데이터 담아서 db 다녀오기
				tVo.setT_no(ssMV.gettNo());
				tVo.setT_picture(fileUrl);
				// 서비스 호출
				System.out.println("controller tVo"+tVo);
				result = new TeacherService().updateProfilePicture(tVo);
				System.out.println("controller result"+result);
				// 성공
				if (result == 1) {
					request.setAttribute("tVo", tVo);
					request.getSession().setAttribute("msgProfile", "프로필 변경이 완료되었습니다.");
					response.sendRedirect("mypage");
				} else { // 실패
					request.getSession().setAttribute("msgProfile", "프로필 변경에 실패했습니다.");
					response.sendRedirect("mypage");
				}
			} else { // 변수에 안담김
				request.getSession().setAttribute("msgProfile", "프로필 변경에 실패했습니다.");
				response.sendRedirect("mypage");
			}
		}
	}

}
