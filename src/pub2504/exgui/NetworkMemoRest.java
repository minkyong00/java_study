package pub2504.exgui;

import javax.swing.JFrame;

import okhttp3.OkHttpClient;
import pub2504.gui.StudentUI;

public class NetworkMemoRest extends JFrame {

	private final String URL = "http://localhost:7777/memo";

	private final OkHttpClient client = new OkHttpClient();

	public NetworkMemoRest(NetworkMemoUI networkMemoUI) {
	}

	public String getURL() {
		return URL;
	}

	public OkHttpClient getClient() {
		return client;
	}

}
