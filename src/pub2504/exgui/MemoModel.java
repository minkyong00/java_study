package pub2504.exgui;

import javax.swing.DefaultListModel;
import javax.swing.ListModel;

public class MemoModel {

	private ListModel<Memo> memoListModel;

	public MemoModel() {
	}

	public MemoModel(ListModel<Memo> memoListModel) {
		this.memoListModel = memoListModel;
	}

	public void initModel() {
		memoListModel = new DefaultListModel<Memo>();
	}
	
	public ListModel<Memo> getMemoListModel() {
		return memoListModel;
	}

}
