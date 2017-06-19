package ooad.DAO.interfaces;

import java.util.List;
import java.util.Map;

/**
 * Created by shenying on 17/3/3.
 */
public interface IBaseDAO<T> {
    T queryById(int id);
    List<T> queryAll();
    List<T> queryAll(String hql, Object[] args);
    Map queryUniqueMapByTypes(String hql, Object[] args, String[] types);
    List queryAllBySql(String sql, Object[] args);
    T insert(T t);
    void insertAll(List<T> list);
    void delete(T t);
    void delete(int id);
    void update(T t);
}
