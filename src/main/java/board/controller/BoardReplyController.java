package board.controller;

import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import board.model.BoardBean;
import board.model.BoardDao;

@Controller
public class BoardReplyController {
	private final String command="reply.brd";
	private String gotoPage="boardReplyForm";
	private String getPage="redirect:/list.brd";
	
	@Autowired
	BoardDao boardDao;
	@RequestMapping(value=command,method = RequestMethod.GET)
	public String write(@RequestParam("ref") String ref,
			@RequestParam("re_step") String re_step,
			@RequestParam("re_level") String re_level,
			@RequestParam("pageNumber") String pageNumber,
			Model model) {
		model.addAttribute("ref", ref);
		model.addAttribute("re_step", re_step);
		model.addAttribute("re_level", re_level);
		model.addAttribute("pageNumber", pageNumber);
		
		return gotoPage;
	}
	@RequestMapping(value=command,method = RequestMethod.POST)
	public String writeProc(
			@ModelAttribute("article") BoardBean article,
			@RequestParam("pageNumber") String pageNumber,
			HttpServletRequest request) {
		//System.out.println(1);
		article.setReg_date(new Timestamp(System.currentTimeMillis())); 	
		article.setIp(request.getRemoteAddr());
		boardDao.replyArticle(article);
		return getPage+"?pageNumber="+pageNumber;
	}
}
