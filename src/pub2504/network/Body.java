package pub2504.network;

import java.io.Serializable;

public class Body implements Serializable {

	private static final long serialVersionUID = 3254655451566545435L;

	private String dataType;
	private Items items;

	public Body() {
	}

	public Body(String dataType, Items items) {
		this.dataType = dataType;
		this.items = items;
	}

	public String getDataType() {
		return dataType;
	}

	public void setDataType(String dataType) {
		this.dataType = dataType;
	}

	public Items getItems() {
		return items;
	}

	public void setItems(Items items) {
		this.items = items;
	}

	@Override
	public String toString() {
		return "Body [dataType=" + dataType + ", items=" + items + "]";
	}

}
