package by.itacademy.servlet;


import by.itacademy.dao.DebitorsDao;
import by.itacademy.dao.UserDao;
import by.itacademy.model.Debitors;
import by.itacademy.model.SystemUser;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet("/user")
public class UserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Debitors> debitorsList = DebitorsDao.getInstance().findAll();
        req.setAttribute("debitorsList", debitorsList);

        getServletContext()
                .getRequestDispatcher("/WEB-INF/jsp/user.jsp")
                .forward(req, resp);
    }
}
