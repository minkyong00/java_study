package pub2504.gui;

import java.awt.BorderLayout;
import java.awt.Dialog;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okio.BufferedSink;

/*

- 구현 기능
      1) 목록
      2) 등록
      3) 수정
      4) 삭제
      5) 총점/평균 연산 (자동 연산)

*/

public class StudentEvent {

	private static StudentRest studentRest;
	private static StudentUI studentUI;

	static Gson gson = new Gson().newBuilder().setPrettyPrinting().create();
	static JTable table;

	public StudentEvent() {
	}

	public StudentEvent(StudentUI studentUI, StudentRest studentRest) {
		this.studentUI = studentUI;
		this.studentRest = studentRest;
	}

	public StudentRest getStudentRest() {
		return studentRest;
	}

	public void setStudentRest(StudentRest studentRest) {
		this.studentRest = studentRest;
	}

	public StudentUI getStudentUI() {
		return studentUI;
	}

	public void setStudentUI(StudentUI studentUI) {
		this.studentUI = studentUI;
	}

	public void initEvent() {
		studentUI.listBtn.addActionListener(e -> listLoad());
		studentUI.addBtn.addActionListener(e -> addList());
		studentUI.updateBtn.addActionListener(e -> updateList());
		studentUI.delBtn.addActionListener(e -> deleteList());
	}

	// 목록
	public void listLoad() {

		Request resquest = new Request.Builder().url(studentRest.getURL()).build();

		studentRest.getClient().newCall(resquest).enqueue(new Callback() {

			@Override
			public void onResponse(Call call, Response response) throws IOException {
				String json = Objects.requireNonNull(response.body()).string();
				List<Student> students = gson.fromJson(json, new TypeToken<List<Student>>() {
				}.getType());
				SwingUtilities.invokeLater(() -> {
					studentUI.getStudentModel().setRowCount(0);

					for (Student student : students) {
						int sum = student.getScore().getMath() + student.getScore().getKor()
								+ student.getScore().getEng();
						studentUI.getStudentModel()
								.addRow(new Object[] { student.getId(), student.getName(), student.getScore().getKor(),
										student.getScore().getMath(), student.getScore().getEng(), sum, sum / 3 });
					}
				});
			}

			@Override
			public void onFailure(Call call, IOException ioe) {
				showError("리스트 로딩 실패! " + ioe.getMessage());
			}
		});

	}

	// 등록
	public void addList() {

		Dialog dialog = new Dialog(studentUI, "학생 점수 추가", true);
		dialog.setSize(400, 450);
		dialog.setLayout(new GridLayout(5, 3));

		JTextField tfname = new JTextField();
		JTextField tfkor = new JTextField();
		JTextField tfmath = new JTextField();
		JTextField tfeng = new JTextField();

		dialog.add(new JLabel("name: "));
		dialog.add(tfname);
		dialog.add(new JLabel("국어: "));
		dialog.add(tfkor);
		dialog.add(new JLabel("수학: "));
		dialog.add(tfmath);
		dialog.add(new JLabel("영어: "));
		dialog.add(tfeng);

		JButton ok = new JButton("추가");
		JButton cancel = new JButton("취소");

		dialog.add(ok);
		dialog.add(cancel);

		ok.addActionListener(e -> {

			int i = studentUI.getTable().getRowCount() + 1;
			Student student = new Student(i++ + "", tfname.getText(), new Score(Integer.parseInt(tfkor.getText()),
					Integer.parseInt(tfmath.getText()), Integer.parseInt(tfeng.getText())));

			RequestBody body = RequestBody.create(MediaType.get("application/json"), gson.toJson(student));

			Request request = new Request.Builder().url(studentRest.getURL()).post(body).build();

			studentRest.getClient().newCall(request).enqueue(new Callback() {

				@Override
				public void onResponse(Call call, Response response) throws IOException {
					SwingUtilities.invokeLater(() -> {
						JOptionPane.showMessageDialog(studentUI, "학생 추가 완료!");
						dialog.dispose();
						listLoad();
					});
				}

				@Override
				public void onFailure(Call call, IOException ioe) {
					showError("학생 등록 실패!: " + ioe.getMessage());
				}
			});

		});

		cancel.addActionListener(e -> dialog.dispose());
		dialog.setLocationRelativeTo(studentUI);
		dialog.setVisible(true);

	}

	// 수정
	public void updateList() {

		int row = studentUI.getTable().getSelectedRow();

		if (row == -1) {
			showError("수정할 행을 선택하세요!");
			return;
		}

		DefaultTableModel model = studentUI.getStudentModel();
		Student student = new Student(model.getValueAt(row, 0).toString(), model.getValueAt(row, 1).toString(),
				new Score(Integer.parseInt(model.getValueAt(row, 2).toString()),
						Integer.parseInt(model.getValueAt(row, 3).toString()),
						Integer.parseInt(model.getValueAt(row, 4).toString())));

		RequestBody body = RequestBody.create(MediaType.get("application/json"), gson.toJson(student));

		Request request = new Request.Builder().url(studentRest.getURL() + "/" + student.getId()).put(body).build();

		studentRest.getClient().newCall(request).enqueue(new Callback() {

			@Override
			public void onResponse(Call call, Response response) throws IOException {
				SwingUtilities.invokeLater(() -> {
					JOptionPane.showMessageDialog(studentUI, "수정 완료!");
					listLoad();
				});
			}

			@Override
			public void onFailure(Call call, IOException ioe) {
				showError("수정 실패!: " + ioe.getMessage());
			}
		});

	}

	// 삭제
	public void deleteList() {

		int row = studentUI.getTable().getSelectedRow() + 1;

		if (row == -1) {
			showError("삭제할 행이 없습니다");
			return;
		}

		Request request = new Request.Builder()
			.url(studentRest.getURL() + "/" + row)
			.delete()
			.build();
		
		studentRest.getClient().newCall(request).enqueue(new Callback() {

			@Override
			public void onResponse(Call call, Response response) throws IOException {
				SwingUtilities.invokeLater(() -> {
					JOptionPane.showMessageDialog(studentUI, "삭제 완료!");
					listLoad();
				});
			}

			@Override
			public void onFailure(Call call, IOException ioe) {
				showError("삭제 실패!: " + ioe.getMessage());
			}
		});

	}

	// 에러메세지 출력 메소드
	private static void showError(String msg) {
		SwingUtilities.invokeLater(() -> {
			// 부모컴포넌트(JFrame), 메세지, 제목, 에러메세지 타입 상수
			JOptionPane.showMessageDialog(studentUI, msg, "오류", JOptionPane.ERROR_MESSAGE);
		});
	} // showError

}
