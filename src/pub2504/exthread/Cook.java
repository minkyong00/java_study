package pub2504.exthread;

import java.util.List;

public class Cook {

	private List<String> cookName;
	private boolean flag;
	private int num = 1;

	public Cook() {
	}

	public Cook(List<String> cookName) {
		this.cookName = cookName;
	}

	public List<String> getCookName() {
		return cookName;
	}

	public void setCookName(List<String> cookName) {
		this.cookName = cookName;
	}

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

}
