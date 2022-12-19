package com.project1.board;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
@Controller
public class FileUploadController {
   
   static String path = "C:\\Users\\nhic0\\eclipse-workspace\\SpringSpaProject\\src\\main\\resources\\static\\upload\\";
   
   @Autowired
   BoardService service;
   
   @RequestMapping("/board/board_insertR")
   public synchronized String insertR(@RequestParam("attFile") List<MultipartFile> mul,    //insert페이지의 attFile태그를 매개변수로 받음
                   @ModelAttribute BoardVo vo) {   //insert페이지의 그외 나머지 태그들을 매개변수로 받음
      List<AttVo> attList = new ArrayList<AttVo>();
      
      try {
         System.out.println("id: "+vo.getId());
         System.out.println("subject: "+vo.getSubject());
         attList = fileupload(mul);
         vo.setAttList(attList);
         //본문 저장
         boolean flag = service.insertR(vo);
         if(!flag) return "저장 중 오류 발생";
         
         //업로드부분 메서드 호출
         
         service.insertAttList(attList);
         
      }catch(Exception e) {
         
      }
      
      return "redirect:/board/board_select";   //업로드하고 나서 다시 select로!
   }
   
   @RequestMapping("/board/board_updateR")
   public String updateR(@RequestParam("attFile") List<MultipartFile> mul,    //insert페이지의 attFile태그를 매개변수로 받음
          @ModelAttribute BoardVo bVo, @ModelAttribute BoardPageVo pVo,
          @RequestParam(name="delFile", required = false) String[] delFile) {
      String msg = "";
      
      try {
            List<AttVo> attList = fileupload(mul);
            bVo.setAttList(attList);                     
      }catch(Exception e) {
         e.printStackTrace();
      }
      
      boolean flag = service.updateR(bVo, delFile);
      
      if(!flag) msg = "수정 중 오류 발생";
      
      return "redirect:/board/board_select";
   }
   
   @RequestMapping("/board/board_replR")
   public String replR(@RequestParam("attFile") List<MultipartFile> mul,    //insert페이지의 attFile태그를 매개변수로 받음
          @ModelAttribute BoardVo bVo, @ModelAttribute BoardPageVo pVo,HttpServletResponse response) {
      
      try {
		List<AttVo> attList = new ArrayList<AttVo>();
		attList = fileupload(mul);
		bVo.setAttList(attList);
		boolean flag=service.replR(bVo);
		if(!flag) return "저장중오류발생";
		service.insertAttList(attList);
	      
      }catch(Exception e) {
         e.printStackTrace();
      }
      
      
      return "redirect:/board/board_select";
   }
   
   //file upload 공통부분(insertR, updateR, replR)
   public List<AttVo> fileupload(List<MultipartFile> mul) throws Exception{
      List<AttVo> attList = new ArrayList<AttVo>();
      
      for(MultipartFile m : mul) {
         if(m.isEmpty()) continue;
         
         //업로드파일 이름 재지정
         UUID uuid = UUID.randomUUID();   //랜덤 번호 생성
         String oriFile = m.getOriginalFilename();
         String sysFile = "";
         File temp = new File(path + oriFile);
         m.transferTo(temp);
         sysFile =(uuid.getLeastSignificantBits()*-1)+ "-" + oriFile;
         File f = new File(path + sysFile);
         temp.renameTo(f);
         
         AttVo attVo = new AttVo();
         attVo.setOriFile(oriFile);
         attVo.setSysFile(sysFile);
         
         attList.add(attVo);
         
         System.out.println(m.getOriginalFilename());
         System.out.println("uuid: "+uuid.getLeastSignificantBits());
         
      }
      
      return attList;
   }
}