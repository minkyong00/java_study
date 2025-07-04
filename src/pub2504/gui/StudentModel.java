package pub2504.gui;

import javax.swing.table.DefaultTableModel;

public class StudentModel {

	private DefaultTableModel studentModel;

	public StudentModel() {

	}

	public void initModel() {

		studentModel = new DefaultTableModel(new String[] { "id", "name", "kor", "math", "eng", "총점", "평균" }, 0) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return column != 0; // id는 수정 불가
			}
		};

	}

	public DefaultTableModel getStudentModel() {
		return studentModel;
	}

}
