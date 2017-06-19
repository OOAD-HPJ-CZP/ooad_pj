package ooad.service;

import ooad.DAO.EnterpriseDAO;
import ooad.DAO.interfaces.IEnterpriseDAO;
import ooad.entity.Enterprise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EnterpriseServiceImpl implements EnterpriseService{
    @Autowired
    private IEnterpriseDAO enterpriseDAO;
    
    public Enterprise getEnterpriseById(int id){
        return enterpriseDAO.queryById(id);
    }
    public int saveEnterprise(Enterprise enterprise){
    	return enterpriseDAO.insert(enterprise).getId();
    }
}