package project;

import java.awt.Color;
import java.awt.EventQueue;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import com.toedter.calendar.JCalendar;
import javax.swing.JTextPane;

public class Calendar2 extends JFrame {

	// windowBuilder 라이브러리 사용해서 만들었음
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Calendar2 frame = new Calendar2();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Calendar2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 781, 502);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		// JCalendar 라이브러리(화면에 나오는 calendar)
		JCalendar calendar = new JCalendar();
		calendar.setBounds(127, 10, 515, 308);
		contentPane.add(calendar);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(328, 370, 107, 27);
		contentPane.add(textPane);
		
		// calendar 날짜 클릭 시 day라는 프라퍼티에 리스너 추가
		calendar.getDayChooser().addPropertyChangeListener("day", e -> {
			textPane.setText(""); // text 초기화
			
			// 화면에 선택된 연도, 월, 날짜값
			int selectedYear = calendar.getYearChooser().getYear();
			int selectedMonth = calendar.getMonthChooser().getMonth() + 1;
			int selectedDay = calendar.getDayChooser().getDay();
			
			// api의 배당락일 가져와서
			for(Date date : new StockAPI_2(new SearchisinCd()).getExDate("dvdnBasDt", "삼성전자")) {
				
				// 배당락일 Calendar 생성
				Calendar exDateCalendar = Calendar.getInstance();
				exDateCalendar.setTime(date); // api 배당락일 넣음 
				
				exDateCalendar.add(Calendar.DATE, -2); // 배당기준일 이틀전
				
				int dayOfWeek = exDateCalendar.get(Calendar.DAY_OF_WEEK); // 요일
				
				// 배당락일 주말일 경우 영업일에 포함되지 않기 때문에
				// 토요일이면(배당기준일이 월요일이여서 배당락일이 토요일인 경우)
				if(dayOfWeek == Calendar.SATURDAY) { 
					exDateCalendar.add(Calendar.DATE, -1); // 하루 더 뺌
				// 일요일이면(배당기준일이 화요일이여서 배당락일이 일요일인 경우)
				} else if(dayOfWeek == Calendar.SUNDAY) { 
					exDateCalendar.add(Calendar.DATE, -2); // 이틀 더 뺌 
				} 
				
				// api 배당락일의 연도, 월, 날짜값
				int exYear = exDateCalendar.get(Calendar.YEAR);
				int exMonth = exDateCalendar.get(Calendar.MONTH) + 1;
				// 배당기준일의 이틀전이 배당락일이므로 2를 빼줌
				int exDay = exDateCalendar.get(Calendar.DATE);
				
				// 화면에서 선택한 연도, 월, 날짜가 배당락일과 같을 경우
				if(selectedYear == exYear && selectedMonth == exMonth
						&& selectedDay == exDay
						) {
					// 해당 회사의 배당락일이라는 text를 textPane에 출력
					textPane.setText(StockAPI.getApi("isinCdNm").get(0) + " 배당락일");
				}
			}
			
		});

	}
}
