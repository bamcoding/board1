package com.ktds.board.articles.biz;

import java.util.List;

import com.ktds.board.articles.vo.ArticlesVO;

public interface ArticlesBiz {
	public List<ArticlesVO> getAllArticles();
	public boolean writeArticles(ArticlesVO article);
	public ArticlesVO getArticleBy(String articlesId);
}
