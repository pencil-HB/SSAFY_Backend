package com.mvc.front;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

import com.mvc.vo.Board;

@WebServlet("/board")
public class BoardFrontController extends HttpServlet {
	
	BoardController con;
	
    public BoardFrontController() {
        con = new BoardController();
    }

    //클라이언트에 응답을 만들어주는 서비스 메서드(요청 방식과는 무관)
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		process(request, response);
	}

	private void process(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String act = request.getParameter("act");
		System.out.println(act);
		
		if(act.equals("list")) {
			con.list(request, response);
		}else if(act.equals("read")) {
			con.read(request, response);
		}else if(act.equals("insertForm")) {
			con.insertForm(request, response);
		}else if(act.equals("insertProcess")) {
			con.insertProcess(request, response);
		}else if(act.equals("delete")) {
			
		}
	}

}
