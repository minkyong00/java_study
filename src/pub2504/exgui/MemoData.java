package pub2504.exgui;

import java.util.ArrayList;
import java.util.List;

public class MemoData {
	
	List<Memo> inputMemoList; // 오른쪽 입력 데이터를 memo객체로 리스트에 넣음
	
	public MemoData() {
		this.inputMemoList = new ArrayList<>();
	}

	public MemoData(List<Memo> inputMemoList) {
		this.inputMemoList = inputMemoList;
	}

}
