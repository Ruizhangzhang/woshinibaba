package com.iweb.Test;

import com.iweb.dao.StudentDAO;
import com.iweb.dao.StudentDAOImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Raxcl
 * @date 2024/7/23 11:02
 * 测试类 用于Dao测试接口
 * @Test  将指定方法标记为测试方法 可以不依赖于main方法直接运行
 * @Before 再所有测试方法运行之前调用指定的代码 一般用于环境的初始化
 * @After 在所有测试方法运行之后执行的代码 一般用于资源回收
 *
 */
public class TestStudentDao {
    private StudentDAO studentDAO;
    @Before
    public void init(){
        studentDAO = new StudentDAOImpl();
    }
    @Test
    public void testFindBysno(){
//        Assert.assertNotNull(studentDAO.findBysno(101));
//        Assert.assertNotNull(null);
        System.out.println(studentDAO.findBysno(101));

    }


    @Test
    public void testCount(){
//        System.out.println(studentDAO.count());
        Assert.assertEquals(10L, (long)studentDAO.count());
    }

    @Test
    public  void  testFindAll(){
        Assert.assertNotNull(studentDAO.findALl());
    }

    @Test
    public void testFindByNameLike(){
//        Assert.assertEquals(1L, (long)studentDAO.count());
//        Assert.assertArrayEquals(,studentDAO.findByNameLike("李军"));
        Assert.assertNotNull(studentDAO.findByNameLike("李军"));
    }

    @Test
    public void testFindByNameLikeWithLimit(){
        Assert.assertNotNull(studentDAO.findByNameLikeWithLimit("李军",0,1));
    }
}
