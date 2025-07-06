package pub2504.exgui;

public class MemoMain {
	
	public static void main(String[] args) {
		MemoModel memoModel = new MemoModel();
		MemoUI memoUI = new MemoUI(memoModel);
		MemoData memoData = new MemoData();
		new MemoEvent(memoData, memoUI);
		
	}

}
