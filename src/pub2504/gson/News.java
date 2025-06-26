package pub2504.gson;

import java.io.Serializable;
import java.util.List;

public class News implements Serializable {

	private String status;
	private int totalResults;
	private List<Articles> articles;

	public News() {
	}

	public News(String status, int totalResults, List<Articles> articles) {
		this.status = status;
		this.totalResults = totalResults;
		this.articles = articles;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getTotalResults() {
		return totalResults;
	}

	public void setTotalResults(int totalResults) {
		this.totalResults = totalResults;
	}

	public List<Articles> getArticles() {
		return articles;
	}

	public void setArticles(List<Articles> articles) {
		this.articles = articles;
	}

	@Override
	public String toString() {
		return "News [status=" + status + ", totalResults=" + totalResults + ", articles=" + articles + "]";
	}

}
