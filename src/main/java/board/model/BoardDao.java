package board.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import utility.Paging;

@Component("BoardDao")
public class BoardDao {
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	String namespace="board.model.Board";

	public int getTotalCount(Map<String, String> map) {
		int totalCount=sqlSessionTemplate.selectOne(namespace+".GetCount", map);
		return totalCount;
	}

	public List<BoardBean> selectLists(Paging pageInfo, Map<String, String> map) {
		List<BoardBean> lists= new ArrayList<BoardBean>();
		RowBounds rowBounds = new RowBounds(pageInfo.getOffset(),pageInfo.getLimit());
		
		lists=sqlSessionTemplate.selectList(namespace+".SelectLists",map,rowBounds);
		return lists;
	}

	public void deleteArticle(String num) {
		sqlSessionTemplate.delete(namespace+".DeleteArticle", num);
		
	}
	public void updateReadCount(String num) {
		sqlSessionTemplate.update(namespace+".UpdateReadCount", num);
		
	}
	public BoardBean selectArticle(String num) {
		BoardBean board=sqlSessionTemplate.selectOne(namespace+".SelectArticle", num);
		return board;
	}

	public void insertArticle(BoardBean article) {
		sqlSessionTemplate.insert(namespace+".InsertArticle", article);
		
	}

	public void replyArticle(BoardBean article) {
		//System.out.println(2);
		sqlSessionTemplate.update(namespace+".BeforeReplyArticle",article);
		//System.out.println(3);
		article.setRe_step(article.getRe_step()+1);
		article.setRe_level(article.getRe_level()+1);
		sqlSessionTemplate.insert(namespace+".ReplyArticle",article);
		
	}

	public void updateArticle(BoardBean article) {
		sqlSessionTemplate.update(namespace+".UpdateArticle",article);
		
	}



}
