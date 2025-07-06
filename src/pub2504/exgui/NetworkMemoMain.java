package pub2504.exgui;

public class NetworkMemoMain {

	public static void main(String[] args) {
		NetworkMemoModel memoModel = new NetworkMemoModel();
		NetworkMemoUI memoUI = new NetworkMemoUI(memoModel);
		new NetworkMemoEvent(memoUI, new NetworkMemoRest(memoUI));
	}
}
