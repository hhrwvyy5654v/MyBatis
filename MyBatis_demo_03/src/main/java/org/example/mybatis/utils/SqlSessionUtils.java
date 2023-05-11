package org.example.mybatis.utils;

// 导入MyBatis框架所需的类
import org.apache.ibatis.io.Resources; //用于读取MyBatis配置文件
import org.apache.ibatis.session.SqlSession; //用于执行SQL语句
import org.apache.ibatis.session.SqlSessionFactory; //用于创建SqlSession实例
import org.apache.ibatis.session.SqlSessionFactoryBuilder; //用于构建SqlSessionFactory实例
//导入了一些Java IO相关的类，用于读取配置文件
import java.io.IOException;
import java.io.InputStream;

/**
 * @Project: MyBatis
 * @Editor: IntelliJ IDEA
 * @Author: HuangRongQuan
 * @Date: 2023/04/18
 * @Time: 17:01
 * @Email: rongquanhuang01@gmail.com
 * @Description:
 */
public class SqlSessionUtils {
    //功能:获取一个SqlSession对象，用于执行MyBatis的数据库操作
    public static SqlSession getSqlSession() {
        SqlSession sqlSession = null;
        try {
            //通过Resources.getResourceAsStream()方法获取mybatis-config.xml文件的输入流
            InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
            //通过SqlSessionFactoryBuilder().build()方法创建SqlSessionFactory对象
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
            //通过openSession()方法创建SqlSession对象并返回
            sqlSession = sqlSessionFactory.openSession(true);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sqlSession;
    }
}