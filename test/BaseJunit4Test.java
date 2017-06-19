

import ooad.DAO.UserDAO;
import ooad.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import javax.annotation.Resource;
import javax.transaction.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)  //使用junit4进行测试
@ContextConfiguration
        ({"classpath:/META-INF/applicationContext.xml","classpath:/META-INF/infrastructure.xml"} ) //加载配置文件
@TransactionConfiguration(transactionManager = "transactionManager",defaultRollback = true)
//------------如果加入以下代码，所有继承该类的测试类都会遵循该配置，也可以不加，在测试类的方法上///控制事务，参见下一个实例
//这个非常关键，如果不加入这个注解配置，事务控制就会完全失效！
//@Transactional
//这里的事务关联到配置文件中的事务控制器（transactionManager = "transactionManager"），同时//指定自动回滚（defaultRollback = true）。这样做操作的数据才不会污染数据库！
//@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
//------------
@Transactional
public class BaseJunit4Test {
    @Resource
    private UserDAO userDao;

    @Test
    public void saveTest() {

        User user1 = new User();
        user1.setUsername("tom");

//        user1.setPassword("123456");
//        user1.setNickName("tom");
//        user1.setEmail("tom@gmail.com");

        User user2 = new User();
        user2.setUsername("admin");
//        user2.setPassword("123456");
//        user2.setNickName("admin");
//        user2.setEmail("admin@admin.com");

        User user3 = new User();
        user3.setUsername("feihong");
//        user3.setPassword("123456");
//        user3.setNickName("phj");
//        user3.setEmail("test@gmail.com");

        userDao.save(user1);
        userDao.save(user2);
        userDao.save(user3);
    }
}