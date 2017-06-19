package ooad.service;

import ooad.entity.Checklist;
import ooad.entity.Enterprise;

import java.util.List;

public interface ChecklistService {
    public Checklist getChecklistById(int id);
    public List<Checklist> getChecklistByTemplateId(int templateId);
    public List<Checklist> getChecklistByEnterpriseId(int enterpriseId);
    public List<Checklist> getAllChecklist();
    public int handoutCheckList(Checklist checklist, Enterprise enterprise);
    public void updateChecklist(Checklist checklist);
}