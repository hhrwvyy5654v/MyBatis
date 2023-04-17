package org.example.mybatis.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @Project: MyBatis
 * @Editor: IntelliJ IDEA
 * @Author: HuangRongQuan
 * @Date: 2023/04/17
 * @Time: 16:25
 * @Email: rongquanhuang01@gmail.com
 * @Description:
 */
public class SqlSessionUtils {
    public static SqlSession getSqlSession(){
        SqlSession sqlSession=null;
        try{
            InputStream is= Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(is);
            sqlSession=sqlSessionFactory.openSession(true);
        }catch(IOException e){
            e.printStackTrace();
        }
        return sqlSession;
    }
}
