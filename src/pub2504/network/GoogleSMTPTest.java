package pub2504.network;

import java.util.Properties;

import jakarta.mail.Authenticator;
import jakarta.mail.Message;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

/*
 	[Google 무료 SMTP서버를 활용한 이메일 보내기]
 	1. 필요한 라이브러리
 	  jakarta.mail(메일발송), jakarta.activation(메일계정인증) jar 필요(mvnrepository.com)
 	2. Google SMTP 사용 설정
 	  1) 2단계 인증 설정
 	     Google계정 로그인 > 계정관리 > 보안 > 2단계인증 활성화
 	  2) 앱비밀번호 생성
 	     Google계정 로그인 > 검색 > 앱 비밀번호 > 앱 이름 지정 > 생성된 앱 비밀번호 저장
 	     fasz rggb qqfs yudy
*/

public class GoogleSMTPTest {

	public static void main(String[] args) {
		
		String username = "minkyong131@gmail.com"; // 구글 계정명
		String password = "fasz rggb qqfs yudy"; // 앱 비밀번호
		
		// SMTP 서버 설정
		Properties props = new Properties(); // 키, 값이 문자열인 맵, 설정정보 저장 시 자주 사용
		props.put("mail.smtp.auth", "true"); // SMTP서버 인증 여부
		props.put("mail.smtp.starttls.enable", "true"); // TLS 서비스 사용 여부
		props.put("mail.smtp.host", "smtp.gmail.com"); // SMTP 서버 도메인 or 아이피
		props.put("mail.smtp.port", "587"); // SMTP 포트 번호
		
		// 메일세션(연결) 생성
		// 계정명과 앱비밀번호로 메일서버 인증 처리
		Session session = Session.getInstance(props, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});
		
		try {
			
			// 이메일 메세지 작성
			Message message = new MimeMessage(session);
			
			// 발신자 이메일
			message.setFrom(new InternetAddress("minkyong131@gmail.com"));
			
			// 수신자 이메일
			message.setRecipients(
				Message.RecipientType.TO,
				InternetAddress.parse("minkyong131@naver.com")
			);
			
			// 이메일 제목
			message.setSubject("Google SMTP 테스트용 이메일");

			// 이메일 내용
			message.setText("안녕 하이 구글 SMTP 서버에서 보낸 이메일");
			
			// 이메일 발송
			Transport.send(message);
			System.out.println("이메일 발송 완료!");
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
	} // main
	
} // class
