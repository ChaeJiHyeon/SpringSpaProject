package com.project1.mybatis;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.project1.book.GuestBookVo;
import com.project1.book.GuestPageVo;

@Repository
@Mapper
public interface GuestBookMapper{
   public int totSize(GuestPageVo vo);
   public List<GuestBookVo> list(GuestPageVo vo);
   public List<GuestBookVo> select10();
   public int insert(GuestBookVo vo);
   public int delete(GuestBookVo vo);
   public int update(GuestBookVo vo);
}