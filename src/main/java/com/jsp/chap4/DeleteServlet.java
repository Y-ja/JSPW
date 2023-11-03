package com.jsp.chap4;
import com.jsp.entity.Dancer;
import com.jsp.repository.DancerRepository;
import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/dancer/delete")
public class DeleteServlet extends HttpServlet {
    private DancerRepository dancerRepository = new DancerRepository();



    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name = req.getParameter("name");
        System.out.println("삭제요청 들어옴!" + name);
        dancerRepository.delete(name);

        List<Dancer> dancerList = dancerRepository.findAll();
        req.setAttribute("dl", dancerList);
        RequestDispatcher rd
                = req.getRequestDispatcher("/WEB_INF/chap04/dancer/list.jsp");
        rd.forward(req, resp);


    }
}