package pub2504.network;

import java.io.Serializable;

public class Data implements Serializable {

	private static final long serialVersionUID = 6565656532365L;

	private Response response;

	public Data() {
	}

	public Data(Response response) {
		this.response = response;
	}

	public Response getResponse() {
		return response;
	}

	public void setResponse(Response response) {
		this.response = response;
	}

	@Override
	public String toString() {
		return "Data [response=" + response + "]";
	}

}
