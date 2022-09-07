package board.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import board.model.BoardBean;
import board.model.BoardDao;

@Controller
public class BoardDeleteController {
	private final String command="delete.brd";
	private String gotoPage="boardDeleteForm";
	private String getPage="redirect:/list.brd";
	
	@Autowired
	BoardDao boardDao;
	@RequestMapping(value=command,method = RequestMethod.GET)
	public ModelAndView delete(@RequestParam("num") String num,
			@RequestParam(value="pageNumber",required = false) String pageNumber) {
		ModelAndView mav= new ModelAndView();

		mav.addObject("pageNumber",pageNumber);
		mav.addObject("num",num);
		mav.setViewName(gotoPage);
		return mav;
	}
	
	@RequestMapping(value=command,method = RequestMethod.POST)
	public ModelAndView deleteProc(@RequestParam("num") String num,
			@RequestParam("pageNumber") String pageNumber,
			@RequestParam("passwd") String passwd,
			HttpServletResponse response) throws IOException {
		ModelAndView mav= new ModelAndView();
		mav.addObject("pageNumber",pageNumber);
		BoardBean board=boardDao.selectArticle(num);
		response.setContentType("text/html; charset=UTF-8"); //�ѱ�ó��
		PrintWriter writer = response.getWriter(); //����ٸ�
		if(board.getPasswd().equals(passwd)) {
			boardDao.deleteArticle(num);
			mav.setViewName(getPage);
			return mav;
		} else {
			writer.println("<script type='text/javascript'> alert('��й�ȣ�� Ʋ�Ƚ��ϴ�.'); </script>");
			writer.flush();//�����������
			mav.addObject("pageNumber",pageNumber);
			mav.addObject("num",num);
			mav.setViewName(gotoPage);
			return mav;
		}
	}
}
