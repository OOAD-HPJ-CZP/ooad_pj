package ooad.DAO;


import ooad.DAO.interfaces.IBaseDAO;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.lang.reflect.ParameterizedType;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Created by shenying on 17/3/3.
 */
@Repository("baseDAO")
public class BaseDAO<T> implements IBaseDAO<T> {

    protected Class<T> clazz;

    private SessionFactory sessionFactory;

//    @SuppressWarnings("unchecked")
//    public BaseDAO(){
//        ParameterizedType type = (ParameterizedType) this.getClass()
//                .getGenericSuperclass();
//        this.clazz = (Class) type.getActualTypeArguments()[0];
//    }
//
    private Class<T> getClazz(){
        if(clazz == null){
            clazz = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        }
        return clazz;
    }

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    @SuppressWarnings("unchecked")
    public T queryById(int id) {
        return (T) this.getCurrentSession().get(getClazz(), id);
    }

    @SuppressWarnings("unchecked")
    public List<T> queryAll() {
        return this.getCurrentSession().createQuery("from " + getClazz().getSimpleName()).list();
    }

    @SuppressWarnings("unchecked")
    public List<T> queryAll(String hql, Object[] args) {
        Query q = this.getCurrentSession().createQuery(hql);
        if (args != null && args.length > 0) {
            for (int i = 0; i < args.length; i++) {
                q.setParameter(i, args[i]);
            }
        }
        return q.list();
    }

    public Map queryUniqueMapByTypes(String hql, Object[] args, String[] types) {
        Map<String, Integer> map = new HashMap();
        for (String type: types){
            Object[] newArgs;
            if (args == null){
                newArgs = new Object[]{type};
            } else {
                newArgs = new Object[args.length+1];
                for (int i = 0; i < args.length; i++){
                    newArgs[i] = args[i];
                }
                newArgs[args.length] = type;
            }
            List ent = queryAll(hql, newArgs);
            Long aggregate = (Long) ent.get(0);
            if (aggregate != null){
                map.put(type, Integer.parseInt(aggregate+""));
            } else {
                map.put(type, 0);
            }

        }
        return map;
    }

    public List queryAllBySql(String sql, Object[] args) {
        Query q = this.getCurrentSession().createSQLQuery(sql);
        if (args != null && args.length > 0) {
            for (int i = 0; i < args.length; i++) {
                q.setParameter(i, args[i]);
            }
        }
        return q.list();
    }

    public T insert(T t) {
        this.getCurrentSession().save(t);
        return t;
    }

    public void insertAll(List<T> list) {
        for (T aList : list) {
            insert(aList);
        }
    }

    public void delete(T t) {
        this.getCurrentSession().delete(t);
    }

    public void delete(int id) {
        this.getCurrentSession().delete(this.queryById(id));
    }

    public void update(T t) {
        this.getCurrentSession().update(t);
    }
}
