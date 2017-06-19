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

    //初始化一个检查表和一个将要被发放的企业
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
    //测试园区发放流程。先调用handout发放，测试是否能正常存取数据。然后假设企业更新了自己的检查表，测试园区能否看到更新之后的数据。
    @Test
    public void testAdminChecklistService() {
        checklist.setFinishedTime(new Date());
        int id = checklistService.handoutCheckList(checklist, enterprise);
        checklist = checklistService.getChecklistById(id);
        Assert.assertEquals("equals", checklist.getState(), "doing");
        checklist.setState("finished");
        checklistService.updateChecklist(checklist);
        checklist = checklistService.getChecklistById(id);
        Assert.assertEquals("equals", checklist.getState(), "finished");
    }
    //测试企业更新流程。先假设园区调用handout发放，测试企业是否能得到这张表。然后企业更新了自己的检查表，测试企业能否看到更新之后的数据。
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