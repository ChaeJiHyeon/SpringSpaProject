package com.project1.mybatis;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.project1.board.AttVo;
import com.project1.board.BoardPageVo;
import com.project1.board.BoardVo;




@Repository   //저장성(메모리에 저장)
@Mapper
public interface BoardMapper {
   public int totList(BoardPageVo pVo);
   public List<BoardVo> select(BoardPageVo pVo);
   public List<BoardVo> board10();
   //view
   public BoardVo view(int sno);
   public void hitUp(int sno);
   public List<AttVo> attList(int sno);
   //delete
   public int replCheck(BoardVo bVo);
   public int delete(BoardVo bVo);
   public List<String> delFileList(int sno);
   public int attDeleteAll(int sno);
   //insert
   public int insertR(BoardVo bVo);
   public int insertAttList(List<AttVo> attList);
   //update
   public int update(BoardVo bVo);
   public int attUpdate(BoardVo bVo);
   public int attDelete(String[] delFiles);
   
   public void seqUp(BoardVo bVo);
   public int replR(BoardVo bVo);
}