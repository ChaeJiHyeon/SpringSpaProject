package com.project1.book;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class GuestBookController {
   
   @Autowired
   GuestBookDao dao;
   
   @RequestMapping("/book/book_select")
   public ModelAndView select(GuestPageVo gVo) {
      ModelAndView mv = new ModelAndView();
      //service or dao
      System.out.println(dao);
      
      //검색어에 다른 list 가져옴
      List<GuestBookVo> list = dao.select(gVo);
      //list를 mv에 추가
      System.out.println(gVo.getTotSize());
      System.out.println(gVo.getNowPage());
      
      gVo = dao.getgVo(); //새로 갱신된 페이지 정보
      
      mv.addObject("gVo", gVo);
      mv.addObject("list", list);
      mv.setViewName("book/book_select");
      return mv;
   }

   @RequestMapping("/book/book_select10")
   public ModelAndView select10(GuestPageVo gVo) {
      ModelAndView mv = new ModelAndView();
      //service or dao
      System.out.println(dao);
      
      //검색어에 다른 list 가져옴
      List<GuestBookVo> list = dao.select10();
      
      System.out.println(list);
      mv.addObject("list", list);
      mv.setViewName("book/book");
      return mv;
   }
   
   @RequestMapping("/book/book_insert")
   public void insert(GuestBookVo vo, HttpServletResponse resp) {
	   boolean b = dao.insert(vo);
	   try {
		PrintWriter out = resp.getWriter();
		if(!b) out.print("<script>alert('저장중 오류 발생')</script>");
	} catch (IOException e) {
		e.printStackTrace();
	}
//	   확인
	   System.out.println("id : "+vo.getId()+"doc: "+vo.getDoc() );
	   
   }
   @RequestMapping("/book/book_update")
   public void update(GuestBookVo vo, HttpServletResponse resp) {
	   boolean b = dao.update(vo);
	   try {
		PrintWriter out = resp.getWriter();
		if(!b) out.print("<script>alert('수정중 오류 발생')</script>");
	} catch (IOException e) {
		e.printStackTrace();
	}
//	   확인
	   System.out.println("update: id : "+vo.getId()+"doc: "+vo.getDoc() );
	   
   }

   @RequestMapping("/book/book_delete")
   public void delete(GuestBookVo vo, HttpServletResponse resp) {
	   boolean b = dao.delete(vo);
	   try {
		PrintWriter out = resp.getWriter();
		if(!b) out.print("<script>alert('삭제중 오류 발생')</script>");
	} catch (IOException e) {
		e.printStackTrace();
	}
//	   확인
	   System.out.println("delete: id : "+vo.getId()+"doc: "+vo.getDoc() );
	   
   }
}