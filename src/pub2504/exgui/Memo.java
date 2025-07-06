package pub2504.exgui;

import java.io.Serializable;

public class Memo implements Serializable {

	private String id;
	private String title;
	private String content;

	public Memo() {
	}

	public Memo(String title, String content) {
		this.title = title;
		this.content = content;
	}

	public Memo(String id, String title, String content) {
		this.id = id;
		this.title = title;
		this.content = content;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return title;
	}

}
