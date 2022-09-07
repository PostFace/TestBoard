package board.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import board.model.BoardBean;
import board.model.BoardDao;
import utility.Paging;

@Controller
public class BoardListController {
	private final String command="list.brd";
	private String getPage="boardList";
	
	@Autowired
	BoardDao boardDao;
	
	@RequestMapping(command)
	public ModelAndView getList(@RequestParam(value="whatColumn",required = false) String whatColumn,
			@RequestParam(value="keyword",required = false) String keyword,
			@RequestParam(value="pageNumber",required = false) String pageNumber,
			HttpServletRequest request) {
		ModelAndView mav= new ModelAndView();
		Map<String, String> map=new HashMap<String, String>();//검색어 담기위한 map
		map.put("whatColumn", whatColumn);
		map.put("keyword", "%"+keyword+"%");
		
		int totalCount=boardDao.getTotalCount(map);
		String url=request.getContextPath()+"/"+command;
		Paging pageInfo = new Paging(pageNumber, null, totalCount, url, whatColumn, keyword, null);
		
		List<BoardBean> lists=new ArrayList<BoardBean>();
		lists=boardDao.selectLists(pageInfo, map);
		mav.setViewName(getPage);
		mav.addObject("lists", lists);
		mav.addObject("totalCount", totalCount);
		mav.addObject("pageInfo", pageInfo);
		
		return mav;
		
	}
}
