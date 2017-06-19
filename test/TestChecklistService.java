import junit.framework.Assert;
import ooad.entity.Checklist;
import ooad.entity.Enterprise;
import ooad.service.ChecklistService;
import ooad.service.EnterpriseService;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

public class TestChecklistService extends BaseTestTemplate {
    @Autowired
    private ChecklistService checklistService;
    private EnterpriseService enterpriseService;
    private Checklist checklist;
    private Enterprise enterprise;

    @Before
    public void setUp() throws Exception {
        checklist = new Checklist();
        checklist.setEnterpriseId(0);
        checklist.setStartTime(new Date());
        checklist.setEndTime(new Date());
        checklist.setState("doing");
        checklist.setTemplateId(111);
        enterprise = new Enterprise();
        enterprise.setEnterpriseName("AAA");
        enterprise.setState("BBB");
        enterprise.setEnterpriseNumber("123");
        enterprise.setEnterprisecol("666");
        enterprise.setTradeId(111);
        enterprise.setBusinessClass("ccc");
        enterprise.setContacts("asdfasd");
        enterprise.setContactsPhone("654321");

    }

    @Test
    public void testAdminChecklistService() {
        checklist.setFinishedTime(new Date());
        int id = checklistService.handoutCheckList(checklist, enterprise);
        checklist = checklistService.getChecklistById(id);
        Assert.assertEquals("equals", checklist.getState(), "doing");
        checklist.setState("check");
        checklistService.updateChecklist(checklist);
        checklist = checklistService.getChecklistById(id);
        Assert.assertEquals("equals", checklist.getState(), "check");
    }

    @Test
    public void testEnterpriseChecklistService() {
        checklist.setFinishedTime(new Date());
        checklistService.handoutCheckList(checklist, enterprise);
        List<Checklist> checklists = checklistService.getChecklistByEnterpriseId(enterprise.getId());
        Checklist checklist = checklists.get(0);
        Assert.assertEquals("equals", checklist.getState(), "doing");
        int id = checklist.getId();
        checklist.setState("finished");
        checklistService.updateChecklist(checklist);
        checklist = checklistService.getChecklistById(id);
        Assert.assertEquals("equals", checklist.getState(), "finished");
    }

}