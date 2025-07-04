package pub2504.exgui;

import java.awt.HeadlessException;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.ListModel;

public class MemoUI extends JFrame {

	private ListModel<Memo> memoModel;
	private List<Memo> inputMemoList;
	
	
	
	public MemoUI() {
	}

	public MemoUI(ListModel<Memo> memoModel) throws HeadlessException {
		this.memoModel = memoModel;
		
		
	}
	
	
}
