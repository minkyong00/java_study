package pub2504.exgui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.stream.JsonReader;

public class MemoEvent {

	MemoData memoData;
	MemoUI memoUI;

	public MemoEvent() {
	}

	public MemoEvent(MemoData memoData, MemoUI memoUI) {
		this.memoData = memoData;
		this.memoUI = memoUI;

		addActionListener(memoUI.addButton, memoUI.editButton, memoUI.deleteButton);
		saveFile(memoData);
		openFile();
		memoUI.memoList.addListSelectionListener(e -> displaySelectedMemo());
		getInfoMessage();
		
	}

	// 메모 등록 메소드
	private void addMemo() {
		String memoTitle = memoUI.memoTextField.getText().trim();
		if (memoTitle.isEmpty()) {
			JOptionPane.showMessageDialog(memoUI, "메모 제목을 입력하세요.");
			return;
		}

		// 동일한 제목 등록 불가
		for (Memo memo : memoData.inputMemoList) {
			if (memo.getTitle().equals(memoTitle)) {
				JOptionPane.showMessageDialog(memoUI, "메모 제목 중복입니다!");
				return;
			}
		}

		String memoContent = memoUI.memoTextArea.getText().trim();
		if (!memoContent.isEmpty()) {
			
			// 메모 객체 id값
			int idx = memoData.inputMemoList.size() + 1;
			
			// 메모 객체 생성
			Memo newMemo = new Memo(String.valueOf(idx++), memoTitle, memoContent);
			memoData.inputMemoList.add(newMemo);
			// memoListModel에도 새로운 memo객체 추가되면서 UI바뀜
			memoUI.memoModel.memoListModel.addElement(newMemo);

			// memo객체 추가되고 텍스트 입력창 초기화
			memoUI.memoTextArea.setText("");
			memoUI.memoTextField.setText("");
			JOptionPane.showMessageDialog(memoUI, "메모가 등록되었습니다.");
		} else {
			JOptionPane.showMessageDialog(memoUI, "메모 내용을 입력하세요.");
		}
	} // addMemo

	// 메모 수정 메서드
	private void editMemo() {
		int selectedIndex = memoUI.memoList.getSelectedIndex();
		if (selectedIndex != -1) {
			String memoTitle = memoUI.memoTextField.getText().trim();
			
			if (memoTitle.isEmpty()) {
				JOptionPane.showMessageDialog(memoUI, "메모 제목을 입력하세요.");
				return;
			}
			
			String memoContent = memoUI.memoTextArea.getText().trim();
			
			if (!memoContent.isEmpty()) {
				Memo newMemo = memoData.inputMemoList.get(selectedIndex);
				newMemo.setTitle(memoTitle);
				newMemo.setContent(memoContent);
				memoData.inputMemoList.set(selectedIndex, newMemo);
				memoUI.memoModel.memoListModel.set(selectedIndex, newMemo);
				JOptionPane.showMessageDialog(memoUI, "메모가 수정되었습니다.");
			} else {
				JOptionPane.showMessageDialog(memoUI, "메모 내용을 입력하세요.");
			}
			
		} else {
			JOptionPane.showMessageDialog(memoUI, "수정할 메모를 선택하세요.");
		}
		
	} // editMemo

	// 메모 삭제 메서드
	private void deleteMemo() {
		int selectedIndex = memoUI.memoList.getSelectedIndex();
		if (selectedIndex != -1) {
			memoData.inputMemoList.remove(selectedIndex);
			memoUI.memoModel.memoListModel.remove(selectedIndex);
			memoUI.memoTextField.setText("");
			memoUI.memoTextArea.setText("");
			JOptionPane.showMessageDialog(memoUI, "메모가 삭제되었습니다.");
		} else {
			JOptionPane.showMessageDialog(memoUI, "삭제할 메모를 선택하세요.");
		}
	} // deleteMemo

	// 선택된 메모를 화면에 표시
	private void displaySelectedMemo() {
		int selectedIndex = memoUI.memoList.getSelectedIndex();
		if (selectedIndex != -1) {
			memoUI.memoTextField.setText(memoData.inputMemoList.get(selectedIndex).getTitle());
			memoUI.memoTextArea.setText(memoData.inputMemoList.get(selectedIndex).getContent());
		}
	} // displaySelectedMemo

	// 버튼에 리스너 추가
	private void addActionListener(JButton... jbuttons) {
		for (JButton jbutton : jbuttons) {
			jbutton.addActionListener(e -> {
				switch (((JButton) e.getSource()).getText()) {
				case "메모 등록":
					addMemo();
					break;
				case "메모 수정":
					editMemo();
					break;
				case "메모 삭제":
					deleteMemo();
				}
			});
		}
	} // addActionListener

	// 정보 클릭 시 메세지 나옴
	public void getInfoMessage() {

		memoUI.infoMenu.addMenuListener(new MenuListener() {

			@Override
			public void menuSelected(MenuEvent e) {
				JLabel message = new JLabel("Copyright 2025 minkyoung");
				message.setHorizontalAlignment(SwingConstants.CENTER);
				JOptionPane.showMessageDialog(memoUI, message);
			}

			@Override
			public void menuDeselected(MenuEvent e) {
			}

			@Override
			public void menuCanceled(MenuEvent e) {
			}
		});

	}; // getInfoMessage

	// 저장 클릭 시 파일 json형태로 저장
	public void saveFile(MemoData memoData) {

		memoUI.fileMenuItemSave.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new File("C:\\pub2504\\memojson").mkdir();
				Gson gson = new GsonBuilder().setPrettyPrinting().create();

				// List<Memo> -> json문자열
				String memo = gson.toJson(memoData.inputMemoList);
				
				// 데이터 년도월일시분초로 포맷
				Date date = new Date();
				SimpleDateFormat sdf = new SimpleDateFormat("YYMMddHHmmss");

				PrintWriter pw = null;

				try {
					if (memo.isEmpty()) {
						JOptionPane.showMessageDialog(memoUI, "저장할 json파일이 없습니다!");
						return;
					}
					
					pw = new PrintWriter("C:\\pub2504\\memojson\\memo_" + sdf.format(date) + ".json");
					pw.append(memo);
					pw.flush();

					JOptionPane.showMessageDialog(memoUI, "memo_" + sdf.format(date) + ".json 파일 저장 완료!");

				} catch (Exception ex) {
					ex.printStackTrace();
				} finally {
					pw.close();
				}
			}
		});
	} // saveFile

	// memo.json 파일 열기
	public void openFile() {

		memoUI.fileMenuItemOpen.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// 부모창에서 첨부파일 열기
				JFileChooser chooseFile = new JFileChooser();
				int returnVal = chooseFile.showOpenDialog(memoUI);
				if (returnVal == JFileChooser.APPROVE_OPTION) {
					JsonReader reader = null;
					String title = null;
					String content = null;
					
					// 선택한 파일을 열면 이전 메모리스트 제거
					memoUI.memoModel.memoListModel.removeAllElements();
					memoData.inputMemoList.clear();

					try {
						// gson의 jsonReader로 json 파일 읽어옴
						reader = new JsonReader(new FileReader(chooseFile.getSelectedFile()));
						// json 배열 시작 [
						reader.beginArray();
						while (reader.hasNext()) { // 배열 다음 요소가 있는 경우
							reader.beginObject(); // 객체 시작 {

							while (reader.hasNext()) { // 객체 다음 요소 있는 경우
								String name = reader.nextName(); // key값
								if (name.equals("title")) { // key값이 title이면
									title = reader.nextString(); // String 다음 토큰 value을 title에 넣음
								} else if (name.equals("content")) { // key값이 content이면
									content = reader.nextString(); // String 다음 토큰 value을 content에 넣음
								} else {
									reader.skipValue(); // 다음 value로 스킵
								}
							}
							reader.endObject(); // 객체 끝 }
							
							// 객체 하나가 끝날 때마다
							// UI에 반영될 memoListModel에 memo객체를 넣음
							memoUI.memoModel.memoListModel.addElement(new Memo(title, content));

							// 불러온 파일의 선택하면 파일이 보여지게 하기 위해
							// 실제 데이터 리스트 inputMemoList에 memo객체를 넣음
							memoData.inputMemoList.add(new Memo(title, content));
							
						}
						reader.endArray(); // 배열 끝 ]

					} catch (IOException ioe) {
						ioe.printStackTrace();
					}
				}
			}
		});

	} // openFile

}
