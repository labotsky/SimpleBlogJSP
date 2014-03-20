package sample.my.dao;

import sample.my.entity.News;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Сергей on 20.03.14.
 */
public interface NewsDao{
    /**
     * Return News by id
     * @param id
     * @return
     * @throws SQLException
     */
    News getByID(int id) throws SQLException;

    /**
     * Return all news order by date
     * @return
     * @throws SQLException
     */
    List<News> getNewsOrderByDate() throws SQLException;

    /**
     * Save news to DB. If News save return true else false
     * @param news
     * @return
     * @throws SQLException
     */
    int saveNews(News news) throws SQLException;

    /**
     * Update News and return boolean value
     * @param news
     * @return
     * @throws SQLException
     */
    void updateNews(News news) throws SQLException;

    /**
     * Delete News by id
     * @param id
     * @return
     * @throws SQLException
     */
    void deleteNews(int id) throws SQLException;
}
