package pub2504.exgui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import pub2504.exmodeling.Sleep;

public class NetworkMemoEvent {

	private static NetworkMemoRest memoRest;
	private static NetworkMemoUI memoUI;
	Gson gson = new GsonBuilder().setPrettyPrinting().create();

	public NetworkMemoEvent() {
	}

	public NetworkMemoEvent(NetworkMemoUI memoUI, NetworkMemoRest memoRest) {
		this.memoUI = memoUI;
		this.memoRest = memoRest;

		memoUI.loadButton.addActionListener(e -> loadMemo());
		memoUI.addButton.addActionListener(e -> addMemo());
		memoUI.editButton.addActionListener(e -> updateMemo());
		memoUI.deleteButton.addActionListener(e -> deleteMemo());
		memoUI.memoList.addListSelectionListener(e -> displaySelectedMemo());

		getInfoMessage();
		saveFile(memoUI.memoModel.memoListModel);
		openFile();
	}

	public static NetworkMemoRest getMemoRest() {
		return memoRest;
	}

	public static NetworkMemoUI getMemoUI() {
		return memoUI;
	}

	public static void setMemoUI(NetworkMemoUI memoUI) {
		NetworkMemoEvent.memoUI = memoUI;
	}

	// 메모리스트 불러오기
	public void loadMemo() {

		Request request = new Request.Builder().url(memoRest.getURL()).build();

		memoRest.getClient().newCall(request).enqueue(new Callback() {

			@Override
			public void onResponse(Call call, Response response) throws IOException {
				String json = Objects.requireNonNull(response.body()).string();
				List<Memo> memos = gson.fromJson(json, new TypeToken<List<Memo>>() {
				}.getType());
				SwingUtilities.invokeLater(() -> {
					memoUI.memoModel.memoListModel.removeAllElements();

					for (Memo memo : memos) {
						memoUI.memoModel.memoListModel.addElement(memo);
					}
				});
			}

			@Override
			public void onFailure(Call call, IOException ioe) {
				showError("메모 리스트 로딩 실패! " + ioe.getMessage());
			}
		});
	} // loadMemo

	// 메모 저장
	public void addMemo() {
		int idx = memoUI.memoModel.memoListModel.size() + 1;

		Memo memo = new Memo(String.valueOf(idx++), memoUI.memoTextField.getText(), memoUI.memoTextArea.getText());

		RequestBody body = RequestBody.create(MediaType.get("application/json"), gson.toJson(memo));

		Request request = new Request.Builder().url(memoRest.getURL()).post(body).build();

		memoRest.getClient().newCall(request).enqueue(new Callback() {

			@Override
			public void onResponse(Call call, Response response) throws IOException {
				SwingUtilities.invokeLater(() -> {
					JOptionPane.showMessageDialog(memoUI, "메모 추가 완료!");
					memoUI.memoModel.memoListModel.addElement(memo);
				});
			}

			@Override
			public void onFailure(Call call, IOException ioe) {
				showError("메모 추가 실패! " + ioe.getMessage());
			}
		});

	} // addMemo

	// 메모 수정
	public void updateMemo() {
		int selectedIndex = memoUI.memoList.getSelectedIndex();
		if (selectedIndex == -1) {
			showError("수정할 메모를 선택하세요!");
			return;
		}

		DefaultListModel<Memo> model = memoUI.memoModel.memoListModel;
		Memo selectedMemo = model.getElementAt(selectedIndex);
		int idx = Integer.parseInt(selectedMemo.getId());

		Memo memo = new Memo();
		memo.setId(idx + "");
		memo.setTitle(memoUI.memoTextField.getText());
		memo.setContent(memoUI.memoTextArea.getText());

		RequestBody body = RequestBody.create(MediaType.get("application/json"), gson.toJson(memo));

		Request request = new Request.Builder().url(memoRest.getURL() + "/" + idx).put(body).build();

		memoRest.getClient().newCall(request).enqueue(new Callback() {

			@Override
			public void onResponse(Call call, Response response) throws IOException {
				SwingUtilities.invokeLater(() -> {
					JOptionPane.showMessageDialog(memoUI, "메모 수정 완료!");
					loadMemo();
				});
			}

			@Override
			public void onFailure(Call call, IOException ioe) {
				showError("메모 수정 실패! " + ioe.getMessage());
			}
		});
	} // updateMemo

	// 메모 삭제
	public void deleteMemo() {
		int selectedIndex = memoUI.memoList.getSelectedIndex();

		if (selectedIndex == -1) {
			showError("삭제할 메모를 선택하세요!");
			return;
		}

		Memo selectedMemo = memoUI.memoModel.memoListModel.getElementAt(selectedIndex);
		int idx = Integer.parseInt(selectedMemo.getId());
		Request request = new Request.Builder().url(memoRest.getURL() + "/" + idx).delete().build();

		memoRest.getClient().newCall(request).enqueue(new Callback() {

			@Override
			public void onResponse(Call call, Response response) throws IOException {
				SwingUtilities.invokeLater(() -> {
					JOptionPane.showMessageDialog(memoUI, "메모 삭제 완료!");
					loadMemo();
					memoUI.memoTextArea.setText("");
					memoUI.memoTextField.setText("");
				});
			}

			@Override
			public void onFailure(Call call, IOException ioe) {
				showError("메모 삭제 실패! " + ioe.getMessage());
			}
		});

	} // deleteMemo

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
	public void saveFile(DefaultListModel<Memo> memoListModel) {

		memoUI.fileMenuItemSave.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new File("C:\\pub2504\\memojson").mkdir();
				Gson gson = new GsonBuilder().setPrettyPrinting().create();

				List<Memo> memoList = new ArrayList<>();
				for (int i = 0; i < memoListModel.getSize(); i++) {
					memoList.add(memoListModel.getElementAt(i));
				}

				// List<Memo> -> json문자열
				String memo = gson.toJson(memoList);

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

	public void openFile() {

		memoUI.fileMenuItemOpen.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser chooseFile = new JFileChooser();
				int returnVal = chooseFile.showOpenDialog(memoUI);
				if (returnVal == JFileChooser.APPROVE_OPTION) {
					JsonReader reader = null;
					String title = null;
					String content = null;

					// 선택한 파일을 열면 이전 메모리스트 제거
					memoUI.memoModel.memoListModel.removeAllElements();
					

					try {
						// gson의 jsonreader로 json 파일 읽어옴
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
//							memoUI.memoList.add

						}
						reader.endArray(); // 배열 끝 ]

					} catch (IOException ioe) {
						ioe.printStackTrace();
					}
				}
			}
		});

	} // openFile

	// 선택된 메모를 화면에 표시
	private void displaySelectedMemo() {
		int selectedIndex = memoUI.memoList.getSelectedIndex();
		if (selectedIndex != -1) {
			memoUI.memoTextField.setText(memoUI.memoModel.memoListModel.get(selectedIndex).getTitle());
			memoUI.memoTextArea.setText(memoUI.memoModel.memoListModel.get(selectedIndex).getContent());
		}
	} // displaySelectedMemo

	// 에러메세지 출력 메소드
	private static void showError(String msg) {
		SwingUtilities.invokeLater(() -> {
			JOptionPane.showMessageDialog(memoUI, msg, "오류", JOptionPane.ERROR_MESSAGE);
		});
	} // showError

}
