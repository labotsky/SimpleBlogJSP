package sample.my.mysql;

import sample.my.dao.NewsDao;
import sample.my.db.ConnectionManager;
import sample.my.entity.News;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Сергей on 20.03.14.
 */
public class NewsDaoImpl implements NewsDao {

    private final static String SQL_FIND_BY_ID = "SELECT * FROM news WHERE news.id = ?";
    private final static String SQL_FIND_ORDER_BY_DATE = "SELECT news.id, news.title, news.message, news.date FROM news ORDER BY date DESC";
    private final static String SQL_INSERT = "INSERT INTO news(title, message, date) VALUES (?, ?, NOW())";
    private final static String SQL_UPDATE = "UPDATE new SET title = ?, message = ?, WHERE news.id = ?";
    private final static String SQL_DELETE = "DELETE FROM news WHERE news.id = ?";

    private ConnectionManager connectionManager;

    public NewsDaoImpl(ConnectionManager connectionManager) {
        this.connectionManager = connectionManager;
    }

    @Override
    public News getByID(int id) throws SQLException {
        PreparedStatement theStatement = connectionManager.getConnection().prepareStatement(SQL_FIND_BY_ID);
        theStatement.setInt(1, id);
        ResultSet theResultSet = theStatement.executeQuery();
        News theNews = null;
        if(theResultSet.next()){
            theNews = new News();
            theNews.setId(theResultSet.getInt(1));
            theNews.setTitle(theResultSet.getString(2));
            theNews.setMessage(theResultSet.getString(3));
            theNews.setDate(theResultSet.getDate(4));
        }
        return theNews;
    }

    @Override
    public List<News> getNewsOrderByDate() throws SQLException {
        Statement theStatement = (Statement) connectionManager.getConnection().createStatement();
        ResultSet theResultSet = theStatement.executeQuery(SQL_FIND_ORDER_BY_DATE);
        List<News> newsList = new ArrayList<News>();
        while(theResultSet.next()){
            News theNews = new News();
            theNews.setId(theResultSet.getInt(1));
            theNews.setTitle(theResultSet.getString(2));
            theNews.setMessage(theResultSet.getString(3));
            theNews.setDate(theResultSet.getDate(4));
            newsList.add(theNews);
        }
        return newsList;
    }

    @Override
    public int saveNews(News news) throws SQLException {
        PreparedStatement theStatement = connectionManager.getConnection().prepareStatement(SQL_INSERT);
        theStatement.setString(1, news.getTitle());
        theStatement.setString(2, news.getMessage());
        int count = theStatement.executeUpdate();
        ResultSet theResultSet = theStatement.getGeneratedKeys();
        if(theResultSet.next()){
            int newsId = theResultSet.getInt(1);
            news.setId(newsId);
        }
        return count;
    }

    @Override
    public void updateNews(News news) throws SQLException {
        PreparedStatement theStatement = connectionManager.getConnection().prepareStatement(SQL_UPDATE);
        theStatement.setString(1, news.getTitle());
        theStatement.setString(2, news.getMessage());
        theStatement.setInt(3, news.getId());
        theStatement.executeQuery();
    }

    @Override
    public void deleteNews(int id) throws SQLException {
        PreparedStatement theStatement = connectionManager.getConnection().prepareStatement(SQL_DELETE);
        theStatement.setInt(1, id);
        theStatement.executeQuery();
    }
}
