package com.project1.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.project1.mybatis.GuestBookMapper;

@Service
public class GuestBookService {
	@Autowired
	GuestBookMapper mapper;
	
//	public List<BoardVo> select(String findStr){
//		List<BoardVo> list = mapper.select(findStr); //board.xml
//		return list;
//	}
}
