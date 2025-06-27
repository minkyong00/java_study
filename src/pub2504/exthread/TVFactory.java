package pub2504.exthread;

public class TVFactory {

	private String name; // 이름
	private String panel; // 패널(LCD, LED,...)
	private String mainBoard; // 메인보드

	public TVFactory() {
	}

	public TVFactory(String name, String panel, String mainBoard) {
		this.name = name;
		this.panel = panel;
		this.mainBoard = mainBoard;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPanel() {
		return panel;
	}

	public void setPanel(String panel) {
		this.panel = panel;
	}

	public String getMainBoard() {
		return mainBoard;
	}

	public void setMainBoard(String mainBoard) {
		this.mainBoard = mainBoard;
	}

	@Override
	public String toString() {
		return "TVFactory [name=" + name + ", panel=" + panel + ", mainBoard=" + mainBoard + "]";
	}

}
