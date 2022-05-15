package kh.semi.thduo.member.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Properties;
import java.util.Random;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import kh.semi.thduo.member.service.MemberService;
import kh.semi.thduo.member.vo.MemberVo;

/**
 * Servlet implementation class MemberLoginController
 */
@WebServlet("/certEmail")
public class MemberJoinEmailAjaxController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MemberJoinEmailAjaxController() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("doGet -");
		request.getRequestDispatcher("").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		System.out.println("doPost - Checkemail 이메일 인증 ");

		// ajax로 들어옴
		PrintWriter out = response.getWriter();
		// 
		String mEmail = request.getParameter("mEmail");
		
		// 인증 번호 생성기
		StringBuffer temp = new StringBuffer();
		Random rnd = new Random();
		for (int i = 0; i < 10; i++) {
			int rIndex = rnd.nextInt(3);
			switch (rIndex) {
			case 0:
				// a-z
				temp.append((char) ((int) (rnd.nextInt(26)) + 97));
				break;
			case 1:
				// A-Z
				temp.append((char) ((int) (rnd.nextInt(26)) + 65));
				break;
			case 2:
				// 0-9
				temp.append((rnd.nextInt(10)));
				break;
			}
		}
		String random = temp.toString();

		System.out.println("random " + random);

		
		// mail server 설정
		String host = "smtp.gmail.com";
		String user = "testminkyotest@gmail.com"; // 자신의 구글 계정
		String password = "wjdalsry1212";// 자신의 구글 패스워드

		// 메일 받을 주소
		//String to_email = m.getEmail(); 
		String to_email = mEmail;
		//String to_email = "sunea24@naver.com";

		// SMTP 서버 정보를 설정한다.
		Properties props = new Properties();
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.port", 465);
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.ssl.enable", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.debug", "true");
		
		// 이메일 보내기
		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(user, password);
			}
		});
		

		try {
			MimeMessage msg = new MimeMessage(session);
			msg.setFrom(new InternetAddress(user, "VISITOR"));
			
			InternetAddress to = new InternetAddress(to_email);   
			msg.setRecipient(Message.RecipientType.TO, to);    

			// 메일 제목
			msg.setSubject("홈페이지 방문해주셔서 감사합니다.  인증번호 발송 메일입니다.");
			// 메일 내용
			msg.setText("인증번호 :" + random+"입니다."+"<br>"+"해당 인증번호 확인란에 기입하여 주세요");

			
			Transport.send(msg);
			System.out.println("인증번호 이메일 전송");

		} catch (Exception e) {
			e.printStackTrace();// TODO: handle exception
		}
		
		HttpSession saveKey = request.getSession();
		saveKey.setAttribute("AuthenticationKey", random); 
		
		out.print(random);
		out.flush();
		out.close();

		
	}
}		

