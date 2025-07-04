package pub2504.gui;

import javax.swing.JFrame;

import okhttp3.OkHttpClient;

public class StudentRest extends JFrame {

	private final String URL = "http://localhost:7777/studentscore";

	private final OkHttpClient client = new OkHttpClient();

	public StudentRest(StudentUI studentUI) {
	}

	public String getURL() {
		return URL;
	}

	public OkHttpClient getClient() {
		return client;
	}

}
