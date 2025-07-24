package pub2504.jdbc.board.service.impl;

import java.util.List;

import pub2504.jdbc.board.dao.ArticleDao;
import pub2504.jdbc.board.model.Article;
import pub2504.jdbc.board.service.ArticleService;

public class ArticleServiceImpl implements ArticleService{

	private ArticleDao articleDao;
	
	@Override
	public List<Article> listArticle() {
		return articleDao.listArticle();
	}

	@Override
	public Article getArticle(int aid) {
		return articleDao.getArticle(aid);
	}

	@Override
	public int registArticle(Article article) {
		return articleDao.registArticle(article);
	}

	@Override
	public int modifyArticle(Article article) {
		return articleDao.modifyArticle(article);
	}

	@Override
	public int removeArticle(int aid) {
		return articleDao.removeArticle(aid);
	}

}
