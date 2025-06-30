package pub2504.network;

import java.io.Serializable;
import java.util.List;

public class Items implements Serializable {

	private static final long serialVersionUID = 456465464546546544L;

	private List<Item> item;

	public Items() {
	}

	public Items(List<Item> item) {
		this.item = item;
	}

	public List<Item> getItem() {
		return item;
	}

	public void setItem(List<Item> item) {
		this.item = item;
	}

	@Override
	public String toString() {
		return "Items [item=" + item + "]";
	}

}
