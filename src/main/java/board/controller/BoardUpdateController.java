package board.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import board.model.BoardBean;
import board.model.BoardDao;

@Controller
public class BoardUpdateController {
	private final String command="update.brd";
	private String gotoPage="boardUpdateForm";
	private String getPage="redirect:/list.brd";
	
	@Autowired
	BoardDao boardDao;
	@RequestMapping(value=command,method = RequestMethod.GET)
	public String update(Model model,
			@RequestParam("num") String num,
			@RequestParam("pageNumber") String pageNumber) {
		BoardBean article= boardDao.selectArticle(num);
		model.addAttribute("pageNumber", pageNumber);
		model.addAttribute("article", article);
		
		return gotoPage;
	}
	@RequestMapping(value=command,method = RequestMethod.POST)
	public ModelAndView updateProc(@ModelAttribute("article") @Valid BoardBean article,
			BindingResult result,
			@RequestParam("pageNumber") String pageNumber,
			HttpServletResponse response) throws IOException {
		//System.out.println(1);
		
		ModelAndView mav= new ModelAndView();
		mav.addObject("pageNumber",pageNumber);
		if(result.hasErrors()) {
			mav.setViewName(gotoPage);
			return mav;
		}
		BoardBean articlecheck= boardDao.selectArticle(String.valueOf(article.getNum()));
		//System.out.println(articlecheck.getPasswd());
		response.setContentType("text/html; charset=UTF-8"); //한글처리
		PrintWriter writer = response.getWriter(); //연결다리
		System.out.println(article.getPasswd());
		if(articlecheck.getPasswd().equals(article.getPasswd())) {
			System.out.println(3);
			boardDao.updateArticle(article);
			mav.setViewName(getPage);
			return mav;
		} else {
			System.out.println(4);
			writer.println("<script type='text/javascript'> alert('비밀번호가 틀렸습니다.'); </script>");
			writer.flush();//방출해줘야함
			mav.addObject("pageNumber",pageNumber);
			mav.addObject("num",article.getNum());
			mav.setViewName(gotoPage);
			return mav;
		}
	}
}
