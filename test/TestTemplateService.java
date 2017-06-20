import junit.framework.Assert;
import ooad.entity.Checkitems;
import ooad.entity.Template;
import ooad.service.CheckitemsService;
import ooad.service.TemplateService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class TestTemplateService extends BaseTestTemplate{
    @Autowired
    private TemplateService templateService;
    @Autowired
    private CheckitemsService checkitemsService;

    Checkitems checkitems1,checkitems2;
    int id1,id2;    
    @Before
    public void setUp() throws Exception {
        Checkitems checkitems1=new Checkitems();
        checkitems1.setItemName("aaa");
        checkitems1.setDescription("bbb");
        Checkitems checkitems2=new Checkitems();
        checkitems2.setItemName("ccc");
        checkitems2.setDescription("ddd");
        Template template=new Template();
        id1=checkitemsService.saveCheckitems(checkitems1);
        id2=checkitemsService.saveCheckitems(checkitems2);
        template.setTemplateName("eee");
        template.setDescription("fff");
    }
    //测试一个模板能否整除存取自己的信息
    @Test
    public void testTemplateService(){
    	templateService.addCheckitemsById(template,id1);
    	templateService.addCheckitemsById(template,id2);
    	int id=templateService.saveTemplate(template);
    	Template testTemplate=templateService.getTemplateById(id);
    	Assert.assertEquals("equals",template.getTemplateName(),testTemplate.getTemplateName());
		Assert.assertEquals("equals",template.getDescription(),testTemplate.getDescription());
    	Assert.assertEquals(template.getCheckItemsList(),testTemplate.getCheckItemsList());

    }
}