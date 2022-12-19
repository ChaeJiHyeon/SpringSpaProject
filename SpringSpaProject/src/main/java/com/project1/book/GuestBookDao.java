package com.project1.book;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import com.project1.mybatis.GuestBookMapper;


@Component
@Transactional
public class GuestBookDao {
   GuestPageVo gVo;
   
   @Autowired
   GuestBookMapper mapper;

   @Autowired
   PlatformTransactionManager manager;
   
   TransactionStatus status;
   
   public int getTotSize(GuestPageVo gVo) {
      int totSize = 0;
      totSize = mapper.totSize(gVo);
      System.out.println("totsize" + totSize);
      return totSize;
   }

   public List<GuestBookVo> select(GuestPageVo gVo){
      List<GuestBookVo> list = null;
      int totSize = getTotSize(gVo);
      gVo.setTotSize(totSize);
      this.gVo=gVo;
      list = mapper.list(gVo);
      return list;
   }
   
   public List<GuestBookVo> select10(){
	      List<GuestBookVo> list = null;
	      list = mapper.select10();
	      return list;
	   }

   public boolean insert(GuestBookVo vo) {
	   boolean b = false;
	   status = manager.getTransaction(new DefaultTransactionDefinition());
	   Object savePoint = status.createSavepoint();
	   
	   int cnt = mapper.insert(vo);
	   
	   if(cnt>0) {
		   b=true;
		   manager.commit(status);
	   }else {
		   status.rollbackToSavepoint(savePoint);
	   }
	   
	   return b;
   }
   
   public boolean update(GuestBookVo vo) {
	   boolean b = false;
	   status = manager.getTransaction(new DefaultTransactionDefinition());
	   Object savePoint = status.createSavepoint();
	   
	   int cnt=mapper.update(vo);
	   System.out.println("update중dao");
	   if(cnt>0) {
		   System.out.println("들어감");
		   b=true;
		   manager.commit(status);
	   }else {
		   System.out.println("안들어감");
		   status.rollbackToSavepoint(savePoint);
	   }
	   
	   return b;
   }
   
   public boolean delete(GuestBookVo vo) {
	   boolean b = false;
	   status = manager.getTransaction(new DefaultTransactionDefinition());
	   Object savePoint = status.createSavepoint();
	   
	   int cnt=mapper.delete(vo);
	   System.out.println("delete중 dao");
	   if(cnt>0) {
		   b=true;
		   manager.commit(status);
	   }else {
		   status.rollbackToSavepoint(savePoint);
	   }
	   
	   return b;
   }
   
   public GuestPageVo getgVo() {
      return gVo;
   }
   
   
}