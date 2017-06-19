package ooad.service;

import ooad.DAO.interfaces.ICheckItemsDAO;
import ooad.entity.Checkitems;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by admin on 2017/6/19.
 */
@Service("checkitemsService")
public class CheckitemsServiceImpl implements CheckitemsService{
    @Autowired
    private ICheckItemsDAO checkitemsDAO;

    public Checkitems getCheckitemsById(int id){
        return checkitemsDAO.queryById(id);
    }
    public int saveCheckitems(Checkitems checkitems){
        Checkitems tmp = checkitemsDAO.insert(checkitems);
        System.out.println("Service:"+tmp.getId());
        return tmp.getId();
    }
}
