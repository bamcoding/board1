package com.ktds.board.articles.biz;

import java.util.List;

import com.ktds.board.articles.dao.ArticlesDao;
import com.ktds.board.articles.dao.ArticlesDaoImpl;
import com.ktds.board.articles.vo.ArticlesVO;

public class ArticlesBizImpl implements ArticlesBiz{

	ArticlesDao dao;
	public ArticlesBizImpl() {
		super();
		dao = new ArticlesDaoImpl();
		// TODO Auto-generated constructor stub
	}
	
	public List<ArticlesVO> getAllArticles(){
		return dao.getAllArticles();
		
	}
	
	public boolean writeArticles(ArticlesVO article) {
		return dao.writeArticles(article) > 0;
	}

	@Override
	public ArticlesVO getArticleBy(String articlesId) {
		return dao.getArticleBy(articlesId);
		// TODO Auto-generated method stub
		
	}
	public static void main(String[] args) {
		ArticlesBiz dao = new ArticlesBizImpl();
		ArticlesVO artcles = dao.getArticleBy("AR-20160930-000001");
		System.out.println(artcles.getArticleSubject());
		artcles = dao.getArticleBy("AR-20160930-000002");
		System.out.println(artcles.getArticleSubject());
		artcles = dao.getArticleBy("AR-20160930-000003");
		System.out.println(artcles.getArticleSubject());
	}
}
