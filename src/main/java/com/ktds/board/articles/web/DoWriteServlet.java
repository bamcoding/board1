package com.ktds.board.articles.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ktds.board.articles.biz.ArticlesBiz;
import com.ktds.board.articles.biz.ArticlesBizImpl;
import com.ktds.board.articles.vo.ArticlesVO;
import com.ktds.board.constants.Session;
import com.ktds.board.support.Param;
import com.ktds.board.user.vo.UserVO;

public class DoWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ArticlesBiz biz;
	
    public DoWriteServlet() {
        super();
        biz = new ArticlesBizImpl();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String articleSubject = Param.getStringParam(request, "articleSubject");
		String articleContent = Param.getStringParam(request, "articleContent");
		if(articleSubject.length()==0){
			response.sendRedirect("/Board/board/write?errorCode=2");
			return;
		}
		if(articleContent.length()==0){			
			response.sendRedirect("/Board/board/write?errorCode=3");
			return;
		}
		
		HttpSession session = request.getSession(); 
		UserVO userInfo = (UserVO)session.getAttribute(Session.USER_INFO);
		String userNickname = userInfo.getUserNickname();
				
		ArticlesVO article = new ArticlesVO();
		article.setArticleSubject(articleSubject);
		article.setArticleContent(articleContent);
		article.setUserId(userNickname);
		
		boolean isSuccess = biz.writeArticles(article);
		if(isSuccess){
			response.sendRedirect("/Board/board/list");
		}	
		else{
			response.sendRedirect("Board/board/write?errorCode=1");
		}
	}

}
