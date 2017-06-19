package ooad.service;

import ooad.DAO.interfaces.IChecklistDAO;
import ooad.entity.Checklist;
import ooad.entity.Enterprise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ChecklistServiceImpl implements ChecklistService{

    @Autowired
    private IChecklistDAO checklistDAO;
    private Checklist checklist;

    public Checklist getChecklistById(int id){
	return checklistDAO.queryById(id);
    }
    public List<Checklist> getChecklistByTemplateId(int templateId){
	return checklistDAO.queryAll().stream().filter(
                checklist -> checklist.getTemplateId() == templateId
        ).collect(Collectors.toList());
    }
    public List<Checklist> getChecklistByEnterpriseId(int enterpriseId){
	return checklistDAO.queryAll().stream().filter(
                checklist -> checklist.getEnterpriseId() == enterpriseId
        ).collect(Collectors.toList());
    }
    public List<Checklist> getAllChecklist(){
	return checklistDAO.queryAll();
    }
    public int handoutCheckList(Checklist checklist,Enterprise enterprise){
        checklist.setEnterpriseId(enterprise.getId());
        return  checklistDAO.insert(checklist).getId();
    }
    public void updateChecklist(Checklist checklist){
	checklistDAO.update(checklist);
    }
}