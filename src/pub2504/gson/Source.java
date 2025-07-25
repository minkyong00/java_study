package pub2504.gson;

import java.io.Serializable;

public class Source implements Serializable {

	private String id;
	private String name;

	public Source() {
	}

	public Source(String id, String name) {
		this.id = id;
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Source [id=" + id + ", name=" + name + "]";
	}

}
