package com.mvc.dao;

import java.util.ArrayList;

import com.mvc.vo.Board;

//Controller를 위한 인터페이스
public interface BoardDAO {
	public ArrayList<Board> selectAll();//모든 글정보
	public Board selectOne(String num);//해당 번호의 글 하나
	public void countUp(String num);
	public boolean insert(Board b);//새글 등록
	public boolean delete(String num);//글 삭제
}
