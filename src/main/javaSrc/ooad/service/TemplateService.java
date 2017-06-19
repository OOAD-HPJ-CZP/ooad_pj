package ooad.service;

import ooad.entity.Template;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

public interface TemplateService {

    public Template getTemplateById(int id);
    public int saveTemplate(Template template);

    public void addCheckitemsById(Template template,int checkitemsId);
}