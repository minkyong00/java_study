package pub2504.jdbc.board.dao;

import java.util.List;

import pub2504.jdbc.board.model.Article;

public interface ArticleDao {

	public abstract List<Article> listArticle();

	public abstract Article getArticle(int aid);

	public abstract int registArticle(Article article);

	public abstract int modifyArticle(Article article);

	public abstract int removeArticle(int aid);

}
