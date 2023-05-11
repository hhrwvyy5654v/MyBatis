package org.example.mybatis.test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.example.mybatis.mapper.CacheMapper;
import org.example.mybatis.pojo.Emp;
import org.example.mybatis.utils.SqlSessionUtils;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * @Project: MyBatis
 * @Editor: IntelliJ IDEA
 * @Author: HuangRongQuan
 * @Date: 2023/04/18
 * @Time: 17:03
 * @Email: rongquanhuang01@gmail.com
 * @Description: MyBatis的测试类，主要用于测试缓存功能
 */

public class CacheMapperTest {
    @Test
    public void testOneCache() {
        // 首先获取一个SqlSession对象
        SqlSession sqlSession1 = SqlSessionUtils.getSqlSession();
        // 通过SqlSession对象获取一个CacheMapper对象
        CacheMapper mapper1 = sqlSession1.getMapper(CacheMapper.class);
        // 使用mapper1对象调用getEmpByEid方法获取一个Emp对象
        Emp emp1 = mapper1.getEmpByEid(1);
        System.out.println(emp1);
        // mapper1.insertEmp(new Emp(null,"abc",23,"男","123@qq.com"));
        sqlSession1.clearCache(); // 清空SqlSession的缓存
        Emp emp2 = mapper1.getEmpByEid(1);
        System.out.println(emp2);

        // SqlSession sqlSession2=SqlSessionUtils.getSqlSession();
        // CacheMapper mapper2=sqlSession2.getMapper(CacheMapper.class);
        // Emp emp2=mapper2.getEmpByEid(1);
        // System.out.println(emp2);
    }

    @Test
    public void testTwoCache() {
        try {
            // 通过Resources.getResourceAsStream()方法获取mybatis-config.xml配置文件的输入流
            InputStream is = Resources.getResourceAsStream("mybatis-config.cml");
            // 使用SqlSessionFactoryBuilder().build()方法创建SqlSessionFactory对象,该对象是MyBatis框架的核心对象，用于创建SqlSession对象
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
            // 使用SqlSessionFactory对象的openSession()方法创建SqlSession对象，该对象用于执行SQL语句
            SqlSession sqlSession1 = sqlSessionFactory.openSession(true);
            // 通过SqlSession对象的getMapper()方法获取CacheMapper接口的实现类
            CacheMapper mapper1 = sqlSession1.getMapper(CacheMapper.class);
            // 调用该实现类的getEmpByEid()方法查询数据库中id为1的员工信息，并将结果输出到控制台
            System.out.println(mapper1.getEmpByEid(1));
            // 关闭SqlSession对象
            sqlSession1.close();
            // 第一次查询后关闭了SqlSession对象，第二次查询时重新打开了SqlSession对象，但由于开启了缓存，第二次查询直接从缓存中获取了结果，而不是再次查询数据库
            SqlSession sqlSession2 = sqlSessionFactory.openSession(true);
            CacheMapper mapper2 = sqlSession2.getMapper(CacheMapper.class);
            System.out.println(mapper2.getEmpByEid(1));
            sqlSession2.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
