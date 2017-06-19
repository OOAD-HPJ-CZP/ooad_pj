import junit.framework.Assert;
import ooad.entity.Checkitems;
import ooad.service.CheckitemsService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;

public class TestCheckitemsService extends BaseTestTemplate{

    @Autowired
    private CheckitemsService checkitemsService;

    //测试检查项能否被正确存入数据库并正确读取。
    @Test
    public void testCheckitemsService(){
    	Checkitems checkitems=new Checkitems();
    	int id=checkitemsService.saveCheckitems(checkitems);
    	Checkitems testitems=checkitemsService.getCheckitemsById(id);
    	Assert.assertEquals("equals",checkitems.getItemName(),testitems.getItemName());
		Assert.assertEquals("equals",checkitems.getDescription(),testitems.getDescription());
    }
}