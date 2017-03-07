package com.ktds.board.articles.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ktds.board.articles.vo.ArticlesVO;
import com.ktds.board.support.DaoSupport;
import com.ktds.board.support.Query;
import com.ktds.board.support.QueryAndResult;
import com.ktds.board.user.vo.UserVO;

public class ArticlesDaoImpl extends DaoSupport implements ArticlesDao {

	@Override
	public int writeArticles(ArticlesVO article) {
		return insert(new Query(){
			@Override
			public PreparedStatement query(Connection conn) throws SQLException {
				
				StringBuffer query = new StringBuffer();
				query.append(" INSERT INTO ARTICLES.ARTICLES (                                                               ");
				query.append("    ATCL_ID, ATCL_SUBJECT, ATCL_CONTENT,                                                       ");
				query.append("    CRT_DT, HIT_CNT, RCMD_CNT,                                                                 ");
				query.append("    USR_ID )                                                                                   ");
				query.append(" VALUES (                                                                                      ");
				query.append("     'AR-' || TO_CHAR(SYSDATE,'YYYYMMDD') || '-' || LPAD(ARTICLES_ID_SEQ.NEXTVAL,6,0)          ");
				query.append("     , ?                                                                                  ");
				query.append("     , ?                                                                                ");
				query.append("     , SYSDATE                                                                                 ");
				query.append("     , 0                                                                                       ");
				query.append("     , 0                                                                                       ");
				query.append("     , ?                                                                                     ");    
				query.append("  )                                                                                            ");
				PreparedStatement pstmt = conn.prepareStatement(query.toString());
				pstmt.setString(1, article.getArticleSubject());
				pstmt.setString(2, article.getArticleContent());
				pstmt.setString(3, article.getUserId());
				return pstmt;
			}		
		});
	}

	@Override
	public List<ArticlesVO> getAllArticles() {
		return selectList(new QueryAndResult(){

			@Override
			public PreparedStatement query(Connection conn) throws SQLException {
				// TODO Auto-generated method stub
				StringBuffer query =new StringBuffer();
				query.append(" SELECT ATCL_ID, ATCL_SUBJECT, ATCL_CONTENT ");
				query.append(" 		 , CRT_DT, HIT_CNT, RCMD_CNT, USR_ID, FILE_NM ");
				query.append(" FROM ARTICLES								");
				PreparedStatement pstmt =conn.prepareStatement(query.toString());
				return pstmt;
			}

			@Override
			public Object makeObject(ResultSet rs) throws SQLException {
				List<ArticlesVO> articles = new ArrayList<ArticlesVO>();
				ArticlesVO article;
				while(rs.next()){
					article = new ArticlesVO();
					article.setUserVO(new UserVO());
					article.setArticleId(rs.getString("ATCL_ID"));
					article.setArticleSubject(rs.getString("ATCL_SUBJECT"));
					article.setArticleContent(rs.getString("ATCL_CONTENT"));
					article.setCreatedDate(rs.getString("CRT_DT"));
					article.setHitCount(rs.getInt("HIT_CNT"));
					article.setRecommendCount(rs.getInt("RCMD_CNT"));
					article.getUserVO().setUserNickname(rs.getString("USR_ID"));
					article.setFileName(rs.getString("FILE_NM"));
					
					articles.add(article);
				}
				return articles;
			}
			
		});
	}

	@Override
	public ArticlesVO getArticleBy(String articlesId) {
		return (ArticlesVO)selectOne(new QueryAndResult(){

			@Override
			public PreparedStatement query(Connection conn) throws SQLException {
				StringBuffer query = new StringBuffer();
				query.append(" SELECT 								");
				query.append(" ATCL_ID, ATCL_SUBJECT, ATCL_CONTENT, ");
				query.append("    CRT_DT, HIT_CNT, RCMD_CNT, 		");
				query.append("    USR_ID, FILE_NM					");
				query.append(" FROM ARTICLES						");
				query.append(" WHERE ATCL_ID = ?					");
				PreparedStatement pstmt = conn.prepareStatement(query.toString());
				pstmt.setString(1, articlesId);
				return pstmt;
			}

			@Override
			public Object makeObject(ResultSet rs) throws SQLException {
				ArticlesVO article = null;
				if(rs.next()){
				article = new ArticlesVO();
				article.setUserVO(new UserVO());
				article.setArticleId(rs.getString("ATCL_ID"));
				article.setArticleSubject(rs.getString("ATCL_SUBJECT"));
				article.setArticleContent(rs.getString("ATCL_CONTENT"));
				article.setCreatedDate(rs.getString("CRT_DT"));
				article.setHitCount(rs.getInt("HIT_CNT"));
				article.setRecommendCount(rs.getInt("RCMD_CNT"));
				article.getUserVO().setUserNickname(rs.getString("USR_ID"));
				article.setFileName(rs.getString("FILE_NM"));
				}
				return article;
			}
			
		});
	}
}
