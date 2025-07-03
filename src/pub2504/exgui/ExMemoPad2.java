package pub2504.exgui;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.Border;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

//[실습 : UI 추가]
//메뉴 : 파일(새메모, 열기, 저장), 정보
//정보메뉴 클릭 시 "Copyright 2025 minkyong" 메세지창 보여주기
//우측에 메모제목과 내용 분리

public class ExMemoPad2 extends JFrame {

	DefaultListModel<String> memoListModel; // 메모리스트 데이터
	DefaultListModel<String> memoTitleModel; // 메모타이틀 데이터
	JList<String> memoList; // 메모리스트 UI
	JTextArea memoTextArea; // 메모 입력란
	JTextField memoTextField; // 메모 제목 입력란
	
	// 초기화 메모드
	private void init() {
		
		// 프레임 설정
		setTitle("메모장 프로그램");
		setSize(600, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		
		// 왼쪽 메모 목록
		memoListModel = new DefaultListModel<String>(); // 리스트모델(데이터) 생성
		memoTitleModel = new DefaultListModel<String>();
		memoList = new JList<String>(memoListModel); // 리스트모델을 가진 리스트UI 생성
		memoList = new JList<String>(memoTitleModel);
		memoList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION); // 리스트 단일 선택
		JScrollPane listScrollPane = new JScrollPane(memoList); // 리스트UI를 붙일 스크롤페인
		
		// 오른쪽 메모 내용
		JScrollPane rightPane = new JScrollPane();
		memoTextArea = new JTextArea();
		JScrollPane textScrollPane = new JScrollPane(memoTextArea);
		// 오른쪽 메모 제목
		memoTextField = new JTextField();
		JScrollPane textScrollPane2 = new JScrollPane(memoTextField);
		
		// 아래쪽 버튼
		JPanel buttonPanel = new JPanel();
		JButton addButton = new JButton("메모 등록");
		JButton editButton = new JButton("메모 수정");
		JButton deleteButton = new JButton("메모 삭제");
		
		// 메뉴
		JMenuBar menuBar = new JMenuBar();
		JMenu menu = new JMenu("파일");
		menu.add(new JMenuItem("열기"));
		menu.add(new JMenuItem("저장"));
		menu.addSeparator();
		menu.add(new JMenuItem("종료"));
		menuBar.add(menu, 0);
		
		JMenu info = new JMenu("정보");
		menuBar.add(info, 1);
		info.addMenuListener(new MenuListener() {
			
			@Override
			public void menuSelected(MenuEvent e) {
				JOptionPane.showMessageDialog(info, "Copyright 2025 minkyong");
			}
			
			@Override
			public void menuDeselected(MenuEvent e) {
			}
			
			@Override
			public void menuCanceled(MenuEvent e) {
			}
		});
		
		setJMenuBar(menuBar);
		
		buttonPanel.add(addButton);
		buttonPanel.add(editButton);
		buttonPanel.add(deleteButton);
		
		addButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				addMemo();
			}
		});

		editButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				editMemo();
			}
		});
		
		deleteButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				deleteMemo();
			}
		});
		
		memoList.addListSelectionListener(e -> displaySelectedMemo());
		
		add(buttonPanel, BorderLayout.SOUTH);
		add(listScrollPane, BorderLayout.WEST);
		
		add(rightPane, BorderLayout.CENTER);
		
		
		
		setVisible(true);
		
	} // init
	
	// 메모 등록 메소드
	private void addMemo() {
		// 메모편집창에 작성한 내용의 앞뒤 공백을 제거
		String newMemoTitie = memoTextField.getText().trim();
		String newMemo = memoTextArea.getText().trim();
		if(!newMemo.isEmpty() && !newMemoTitie.isEmpty()) { // 내용이 있다면
			memoListModel.addElement(newMemo); // 모델에 추가
			memoTitleModel.addElement(newMemoTitie);
			memoTextArea.setText(""); // 메모편집창 내용 지우기
			memoTextField.setText("");
			// 등록완료 메세지 보여주는 선택창, this:부모창
			JOptionPane.showMessageDialog(this, "메모가 등록되었습니다!");
		} else {
			JOptionPane.showMessageDialog(this, "메모 내용을 입력해 주세요!");
		}
	} // add
	
	// 메모 수정 메소드
	private void editMemo() {
		int selectedIndex = memoList.getSelectedIndex(); // 선택한 메모의 인덱스
		if(selectedIndex != -1) { // 메모를 선택했다면
			String updateTitleMemo = memoTextField.getText().trim();
			String updatedMemo = memoTextArea.getText().trim();
			if(!updatedMemo.isEmpty()) {
				memoListModel.set(selectedIndex, updatedMemo);
				memoListModel.set(selectedIndex, updateTitleMemo);
				memoTextArea.setText("");
				memoTextField.setText("");
				JOptionPane.showMessageDialog(this, "메모가 수정되었습니다!");
			} else {
				JOptionPane.showMessageDialog(this, "메모 내용을 입력해 주세요!");
			}
		} else {
			JOptionPane.showMessageDialog(this, "수정할 메모를 선택해 주세요!");
		}
	} // edit
	
	private void deleteMemo() {
		int selectedIndex = memoList.getSelectedIndex();
		if(selectedIndex != -1) {
			memoListModel.remove(selectedIndex);
			JOptionPane.showMessageDialog(this, "메모가 삭제되었습니다!");
		} else {
			JOptionPane.showMessageDialog(this, "삭제할 메모를 선택해 주세요!");
		}
	} // delete
	
	
	// 선택한 메모를 메모편집영역에 표시
	private void displaySelectedMemo() {
		int selectedindext = memoList.getSelectedIndex();
		if(selectedindext != -1) {
			memoTextArea.setText(memoListModel.get(selectedindext));
		}
	} // displaySelectedMemo
	
	public static void main(String[] args) {
		new ExMemoPad2().init();
	}
	
}
