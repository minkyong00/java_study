package pub2504.exgui;

import javax.swing.DefaultListModel;

public class MemoModel {

	DefaultListModel<Memo> memoListModel;

	public void initModel() {
		memoListModel = new DefaultListModel<Memo>();
	}

}
