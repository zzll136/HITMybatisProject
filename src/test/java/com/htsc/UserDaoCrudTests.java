package com.htsc;

import com.htsc.Dao.IUserDao;
import com.htsc.model.QueryVo;
import com.htsc.model.QueryVoIds;
import com.htsc.model.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 说明:
 *
 * @author zhanglin/016873
 * @version: V1.0.0
 * @update 2020/9/2
 */
public class UserDaoCrudTests {
    private InputStream in;
    private SqlSessionFactory factory;
    private SqlSession session;
    private IUserDao userDao;

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
        userDao = session.getMapper(IUserDao.class);
    }

    @Test
    public void testFindOne() {
// 6.执行操作
        User user = userDao.findById(41);
        System.out.println(user);
        Assert.assertEquals("张三", user.getUserName());
    }


    @Test
    public void testSave() {
        User user = new User();
        user.setUserName("华泰");
        user.setUserAddress("南京市建邺区");
        user.setUserSex("男");
        user.setUserBirthday(new Date());
        // 1.执行保存方法
        int id = userDao.saveUser(user);
        Assert.assertEquals(1, id);
        // 2. 验证保存结果
        User savedUser = userDao.findById(user.getUserId());
        Assert.assertEquals("华泰", savedUser.getUserName());
        //验证删除功能
        int res = userDao.deleteUser(user.getUserId());
        assert res == 1;
    }

    @Test
    public void testUpdateUser() {
        int id = 48;
//1.根据id查询
        User user = userDao.findById(id);
//2.更新操作
        user.setUserAddress("北京市顺义区");
        int res = userDao.updateUser(user);
// 3. 验证保存结果
        User savedUser = userDao.findById(id);
        Assert.assertEquals("北京市顺义区", savedUser.getUserAddress());
    }

//    @Test
//    public void testDeleteUser() {
//// 1.执行操作
//        int res = userDao.deleteUser(61);
//        assert res == 1;
//    }

    @Test
    public void testFindByName() {
// 1.执行查询一个方法
        List<User> users = userDao.findByName("%王%");
        Assert.assertEquals(2,users.size());
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void testFindByNameNew() {
// 1.执行查询一个方法
        List<User> users = userDao.findByNameNew("王");
        assert users.size() == 2;
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void testCount() {
        int res = userDao.count();
        assert res == 14;
    }

    @Test
    public void testFindAll() {
        List<User> users = userDao.findAll();
        for (User user : users) {
            System.out.println(user.toString());
        }
    }

    @Test
    public void testFindByVo() {
        QueryVo queryVo = new QueryVo();
        queryVo.setAddress("%南京%");
        queryVo.setName("%王%");
        List<User> users = userDao.findByVo(queryVo);
        Assert.assertEquals(1, users.size());
    }

    @Test
    public void testQueryByVo1() {
        QueryVo vo = new QueryVo();
        vo.setName("%王%");
        vo.setAddress("%南京%");
        List<User> users = userDao.QueryByVo1(vo);
        assert users.size() == 1;
    }

    @Test
    public void testQueryByVo_withoutAddress1() {
        QueryVo vo = new QueryVo();
        vo.setName("%王%");
        vo.setAddress(null);
        List<User> users = userDao.QueryByVo1(vo);
        assert users.size() == 2;
    }

    @Test
    public void testQueryByVo2() {
        QueryVo vo = new QueryVo();
        vo.setName("%王%");
        vo.setAddress("%南京%");
        List<User> users = userDao.QueryByVo2(vo);
        assert users.size() == 1;
    }

    @Test
    public void testQueryByVo_withoutAddress2() {
        QueryVo vo = new QueryVo();
        vo.setName("%王%");
        vo.setAddress(null);
        List<User> users = userDao.QueryByVo2(vo);
        assert users.size() == 2;
    }


    @Test
    public void testFindInIds() {
        QueryVoIds voIds = new QueryVoIds();
        List<Integer> ids = new ArrayList<Integer>();
        ids.add(41);
        ids.add(42);
        ids.add(45);
        ids.add(48);
        voIds.setIds(ids);
        List<User> users = userDao.findInIds(voIds);
        assert users.size() == 4;
    }


    @After
    public void tearDown() throws Exception {
        //session.commit();
        //7.释放资源
        session.close();
        in.close();
    }

}
