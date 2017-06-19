package ooad.service;

import ooad.DAO.TemplateDAO;
import ooad.entity.Template;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TemplateServiceImpl implements TemplateService{
    @Autowired
    private TemplateDAO templateDAO;
    private Template template;
     
    public Template getTemplateById(int id){
        return templateDAO.queryById(id);
    }
    public int saveTemplate(Template template){
    	return templateDAO.insert(template).getId();
    }
    
    public void addCheckitemsById(Template template,int checkitemsId){
      	template.addCheckItemsById(checkitemsId);
    }
}