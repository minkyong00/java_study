package pub2504.gui;

import java.awt.BorderLayout;
import java.awt.HeadlessException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

public class StudentUI extends JFrame {
	// 학생 성적 UI 클래스
	// - JTable 컬럼 구성 : 학번, 학생명, 국어, 영어, 수학, 총점, 평균

	DefaultTableModel studentModel;

	JTable table;
	JPanel panel;
	JButton listBtn;
	JButton addBtn;
	JButton updateBtn;
	JButton delBtn;

	public StudentUI(DefaultTableModel studentModel) {

		this.studentModel = studentModel;

		setTitle("studentscore");
		setSize(600, 600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

		table = new JTable(studentModel);
		add(new JScrollPane(table), BorderLayout.CENTER);

		// 버튼 패널
		// - 구현 기능 1) 목록 2) 등록 3) 수정 4) 삭제 5) 총점/평균 연산 (자동 연산)
		panel = new JPanel();
		listBtn = new JButton("목록");
		addBtn = new JButton("등록");
		updateBtn = new JButton("수정");
		delBtn = new JButton("삭제");
		panel.add(listBtn);
		panel.add(addBtn);
		panel.add(updateBtn);
		panel.add(delBtn);
		add(panel, BorderLayout.SOUTH);

		setVisible(true);
	}

	public StudentUI() {
	}

	public DefaultTableModel getStudentModel() {
		return studentModel;
	}

	public void setStudentModel(DefaultTableModel studentModel) {
		this.studentModel = studentModel;
	}

	public JButton getListBtn() {
		return listBtn;
	}

	public void setListBtn(JButton listBtn) {
		this.listBtn = listBtn;
	}

	public JButton getAddBtn() {
		return addBtn;
	}

	public void setAddBtn(JButton addBtn) {
		this.addBtn = addBtn;
	}

	public JButton getUpdateBtn() {
		return updateBtn;
	}

	public void setUpdateBtn(JButton updateBtn) {
		this.updateBtn = updateBtn;
	}

	public JButton getDelBtn() {
		return delBtn;
	}

	public void setDelBtn(JButton delBtn) {
		this.delBtn = delBtn;
	}

	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}

}
