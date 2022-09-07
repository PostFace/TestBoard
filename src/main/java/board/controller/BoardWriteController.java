package board.controller;

import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import board.model.BoardBean;
import board.model.BoardDao;


@Controller
public class BoardWriteController {
	
	private final String command="write.brd";
	private String gotoPage="boardWriteForm";
	private String getPage="redirect:/list.brd";
	
	@Autowired
	BoardDao boardDao;
	@RequestMapping(value=command,method = RequestMethod.GET)
	public String write() {
		
		return gotoPage;
	}
	
	@RequestMapping(value=command,method = RequestMethod.POST)
	public String writeProc(@ModelAttribute("article") @Valid BoardBean article,
			BindingResult result 
			,HttpServletRequest request){
		if(result.hasErrors()) {
			return gotoPage;
		}
		article.setReg_date(new Timestamp(System.currentTimeMillis())); 	
		article.setIp(request.getRemoteAddr());
		boardDao.insertArticle(article);
		return getPage;
	}
}
