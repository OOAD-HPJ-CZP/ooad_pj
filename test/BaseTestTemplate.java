import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import javax.transaction.Transactional;

/**
 * Created by admin on 2017/6/18.
 */
@RunWith(SpringJUnit4ClassRunner.class)  //使用junit4进行测试
@ContextConfiguration
        ({"classpath:/META-INF/applicationContext.xml","classpath:/META-INF/infrastructure.xml"} ) //加载配置文件
@TransactionConfiguration(transactionManager = "transactionManager",defaultRollback = true)
@Transactional
public class BaseTestTemplate {
}
