package sample.my.servlet;

import sample.my.constant.Attributes;
import sample.my.constant.Links;
import sample.my.dao.NewsDao;
import sample.my.db.ConnectionManager;
import sample.my.entity.News;
import sample.my.mysql.NewsDaoImpl;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Сергей on 20.03.14.
 */
public class Main extends HttpServlet {
    private NewsDao newsDao;
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        ConnectionManager manager = (ConnectionManager) config.getServletContext().getAttribute(Attributes.CONNECTION_MANAGER);
        newsDao = new NewsDaoImpl(manager);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            List<News> theNewList = newsDao.getNewsOrderByDate();
            req.setAttribute("newsList", theNewList);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        req.getRequestDispatcher(Links.MAIN_JSP).forward(req, resp);
    }
}

