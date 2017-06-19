package ooad.service;

import ooad.DAO.interfaces.ICheckItemsDAO;
import ooad.entity.Checkitems;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public interface CheckitemsService {
    
    public Checkitems getCheckitemsById(int id);
    public int saveCheckitems(Checkitems checkitems);
}