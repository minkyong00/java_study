package pub2504.gui;

import javax.swing.SwingUtilities;

public class StudentMain {
	
	public static void main(String[] args) {
		
		StudentModel studentModel = new StudentModel();
		studentModel.initModel();
		
		StudentUI studentUI = new StudentUI(studentModel.getStudentModel());
		new StudentEvent(studentUI, new StudentRest(studentUI)).initEvent();
	}

}
