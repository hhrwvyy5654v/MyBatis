package org.example.mybatis.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @Project: MyBatis
 * @Package: org.example.mybatis.utils
 * @ClassName: SqlSessionUtils
 * @Datetime: 2023/05/11 21:17
 * @Author: HuangRongQuan
 * @Email: rongquanhuang01@gmail.com
 * @Description:
 */

public class SqlSessionUtils {

    public static SqlSession getSqlSession() {
        SqlSession sqlSession = null;
        try {
            InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
            sqlSession = sqlSessionFactory.openSession(true);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sqlSession;
    }

}