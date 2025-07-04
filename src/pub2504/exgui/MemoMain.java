package pub2504.exgui;

public class MemoMain {
	
	public static void main(String[] args) {
		MemoModel memoModel = new MemoModel();
		memoModel.initModel();
		
		MemoUI memoUI = new MemoUI(memoModel.getMemoListModel());
		
	}

}
