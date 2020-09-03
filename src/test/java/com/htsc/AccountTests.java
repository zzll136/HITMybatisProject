package com.htsc;

import com.htsc.Dao.IAccountDao;
import com.htsc.model.AccountUser;
import com.htsc.model.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

/**
 * 说明:
 *
 * @author zhanglin/016873
 * @version: V1.0.0
 * @update 2020/9/2
 */
public class AccountTests {
    private IAccountDao accountDao;
    private InputStream in;
    private SqlSessionFactory factory;
    private SqlSession session;

    @Before
    public void setUp() throws Exception {
// 1.读取配置文件
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
// 2.创建构建者对象
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
// 3.创建SqlSession工厂对象
        factory = builder.build(in);
// 4.创建SqlSession对象
        session = factory.openSession(true);
// 5.创建Dao的代理对象
        accountDao = session.getMapper(IAccountDao.class);
    }


    @Test
    public void testFindAll1() {
//6.执行操作
        List<AccountUser> accountusers = accountDao.findAll1();
        for (AccountUser au : accountusers) {
            System.out.println(au);
        }
        assert accountusers.size() == 3;
    }

    @Test
    public void testFindAll2() {
        List<User> users = accountDao.findAll2();
        for (User au : users) {
            System.out.println(au);
        }
        assert users.size() == 9;
    }

    @After
    public void tearDown() throws Exception {
        //session.commit();
        //7.释放资源
        session.close();
        in.close();
    }

}
