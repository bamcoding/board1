package com.ktds.board.articles.dao;

import java.util.List;

import com.ktds.board.articles.vo.ArticlesVO;

public interface ArticlesDao {
	/**
	 * 리스트 보기
	 * @return
	 */
	public List<ArticlesVO> getAllArticles();
	
	/**
	 * 글쓰기
	 * @param article
	 * @return
	 */
	public int writeArticles(ArticlesVO article);
	
	/**
	 * 로우 하나를 찾아 보기
	 * @param articlesId
	 * @return
	 */
	public ArticlesVO getArticleBy(String articlesId);
}
