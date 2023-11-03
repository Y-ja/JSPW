package com.jsp.chap4;

import com.jsp.entity.Dancer;
import com.jsp.repository.DancerRepository;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/mvc.process")
public class ProcessServlet extends HttpServlet {
    //데이터 베이스 처리
    private DancerRepository dancerRepository = new DancerRepository();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       //서블릿 <---> 컨트롤러
       //틀라이언트 의 요청을 처리하고 보델에게 로직을 위임
       // 뷰에게 응답
        // form에서 넘어온 데이터 읽기 (클라이언트 데이터 처리 : controller)
        //form에서 전송한데이터 한글처리
        req.setCharacterEncoding("UTF-8");

        // DancerRegisterViewServlet에서 전달된 파라미터 읽기
        String name = req.getParameter("name");
        String crewName = req.getParameter("crewName");
        String danceLevel = req.getParameter("danceLevel");
        String[] genresArray = req.getParameterValues("genres");


        // Dancer객체를 생성, 입력값 세팅 (business logic : model(자바객체))
        // 데이터베이스에 저장 (business logic : model(자바객체)) -> 위임
        dancerRepository.save(name, crewName, danceLevel, genresArray);

        //결과 화면을 데이터를 전달

        //데이터 조회
        List<Dancer> dancerList = dancerRepository.findAll();
        //jsp에게 자바 데이터를 보내는 방법
         req.setAttribute("dl",dancerList);

        //결과
        // 결과 화면 처리
        RequestDispatcher rd
                = req.getRequestDispatcher("/WEB_INF/chap04/dancer/list.jsp");
        rd.forward(req, resp);

    }
}
