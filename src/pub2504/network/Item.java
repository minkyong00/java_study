package pub2504.network;

import java.io.Serializable;

public class Item implements Serializable {

	private static final long serialVersionUID = 456465464546546544L;

	private String tm;
	private String ta;

	public Item() {
	}

	public Item(String tm, String ta) {
		this.tm = tm;
		this.ta = ta;
	}

	public String getTm() {
		return tm;
	}

	public void setTm(String tm) {
		this.tm = tm;
	}

	public String getTa() {
		return ta;
	}

	public void setTa(String ta) {
		this.ta = ta;
	}

	@Override
	public String toString() {
		return "Item [tm=" + tm + ", ta=" + ta + "]";
	}

}
