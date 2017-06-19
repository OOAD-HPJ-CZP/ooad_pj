package ooad.service;

import ooad.entity.Enterprise;

public interface EnterpriseService{
    
    public Enterprise getEnterpriseById(int id);
    public int saveEnterprise(Enterprise enterprise);
    
}