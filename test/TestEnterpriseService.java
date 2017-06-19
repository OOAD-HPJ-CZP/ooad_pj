import junit.framework.Assert;
import ooad.entity.Enterprise;
import ooad.service.EnterpriseService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestEnterpriseService extends BaseTestTemplate{
    @Autowired
    private EnterpriseService enterpriseService;

    private Enterprise enterprise;

    @Test
    public void testTestEnterpriseService(){
		Enterprise enterprise=new Enterprise();
		enterprise.setEnterpriseName("aaa");
    	enterprise.setState("bbb");
    	enterprise.setEnterpriseNumber("123456");
    	enterprise.setEnterprisecol("666");
    	enterprise.setTradeId(111);
    	enterprise.setBusinessClass("ccc");
    	enterprise.setContacts("asdfasd");
    	enterprise.setContactsPhone("654321");
		int id=enterpriseService.saveEnterprise(enterprise);
		Enterprise testEnterprise=enterpriseService.getEnterpriseById(id);
		Assert.assertEquals("equals",enterprise.getEnterpriseName(),testEnterprise.getEnterpriseName());
		Assert.assertEquals("equals",enterprise.getState(),testEnterprise.getState());
		Assert.assertEquals("equals",enterprise.getEnterpriseNumber(),testEnterprise.getEnterpriseNumber());
		Assert.assertEquals("equals",enterprise.getEnterprisecol(),testEnterprise.getEnterprisecol());
		Assert.assertEquals("equals",enterprise.getTradeId(),testEnterprise.getTradeId());
		Assert.assertEquals("equals",enterprise.getBusinessClass(),testEnterprise.getBusinessClass());
		Assert.assertEquals("equals",enterprise.getContacts(),testEnterprise.getContacts());
		Assert.assertEquals("equals",enterprise.getContactsPhone(),testEnterprise.getContactsPhone());
    }
   
}