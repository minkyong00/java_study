package stockProject;

public class JsonStock {
	// json 서버 주식 객체

	private int id; // 아이디
	private String name; // 주식종목명
	private boolean isLike; // 즐겨찾기여부
	private int count; // 가지고 있는 주 수

	public JsonStock() {
	}

	public JsonStock(int id, String name, boolean isLike, int count) {
		this.id = id;
		this.name = name;
		this.isLike = isLike;
		this.count = count;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isLike() {
		return isLike;
	}

	public void setLike(boolean isLike) {
		this.isLike = isLike;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "Stock [id=" + id + ", name=" + name + ", isLike=" + isLike + ", count=" + count + "]";
	}

}
