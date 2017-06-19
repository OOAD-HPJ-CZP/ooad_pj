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

    @Test
    public void testTemplateService(){
    	Checkitems checkitems1=new Checkitems();
    	checkitems1.setItemName("aaa");
    	checkitems1.setDescription("bbb");
    	int id1=checkitemsService.saveCheckitems(checkitems1);
    	Checkitems checkitems2=new Checkitems();
    	checkitems2.setItemName("ccc");
    	checkitems2.setDescription("ddd");
    	int id2=checkitemsService.saveCheckitems(checkitems2);
    	Template template=new Template();
    	template.setTemplateName("eee");
    	template.setDescription("fff");
    	templateService.addCheckitemsById(template,id1);
    	templateService.addCheckitemsById(template,id2);
    	int id=templateService.saveTemplate(template);
    	Template testTemplate=templateService.getTemplateById(id);
    	Assert.assertEquals("equals",template.getTemplateName(),testTemplate.getTemplateName());
		Assert.assertEquals("equals",template.getDescription(),testTemplate.getDescription());
    	Assert.assertEquals(template.getCheckItemsList(),testTemplate.getCheckItemsList());

    }
}