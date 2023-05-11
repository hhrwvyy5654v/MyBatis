package org.example.mybatis.test;

import org.example.mybatis.mapper.DynamicSQLMapper;
import org.example.mybatis.pojo.Emp;
import org.example.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @Project: MyBatis
 * @Editor: IntelliJ IDEA
 * @Author: HuangRongQuan
 * @Date: 2023/04/18
 * @Time: 17:03
 * @Email: rongquanhuang01@gmail.com
 * @Description: MyBatis的测试类，主要测试了动态SQL的使用
 */
public class DynamicSQLMapperTest {

    /*
     * 动态SQL：
     * 1、if：根据标签中test属性所对应的表达式决定标签中的内容是否需要拼接到SQL中
     * 2、where：
        * 当where标签中有内容时，会自动生成where关键字，并且将内容前多余的and或or去掉
        * 当where标签中没有内容时，此时where标签没有任何效果
     * 注意：where标签不能将其中内容后面多余的and或or去掉
     * 3、trim：
     * 若标签中有内容时：
        * prefix|suffix：将trim标签中内容前面或后面添加指定内容
        * suffixOverrides|prefixOverrides：将trim标签中内容前面或后面去掉指定内容
        * 若标签中没有内容时，trim标签也没有任何效果
     * 4、choose、when、otherwise，相当于if...else if...else
     * when至少要有一个，otherwise最多只能有一个
     * 5、foreach
        * collection:设置需要循环的数组或集合
        * item:表示数组或集合中的每一个数据
        * separator:循环体之间的分割符
        * open:foreach标签所循环的所有内容的开始符
        * close:foreach标签所循环的所有内容的结束符
     * 6、sql标签
     * 设置SQL片段：<sql id="empColumns">eid,emp_name,age,sex,email</sql>
     * 引用SQL片段：<include refid="empColumns"></include>
     */

    @Test
    public void testInsertMoreByList() {
        // 获取一个SqlSession对象
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        // 通过SqlSession对象获取DynamicSQLMapper接口的实例
        DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);
        // 创建了三个Emp对象并将它们放入一个List中
        Emp emp1 = new Emp(null, "a1", 23, "男", "100@qq.com", null);
        Emp emp2 = new Emp(null, "a2", 23, "男", "101@qq.com", null);
        Emp emp3 = new Emp(null, "a3", 23, "男", "102@qq.com", null);
        List<Emp> emps = Arrays.asList(emp1, emp2, emp3);
        // 输出插入的数据条数
        System.out.println(mapper.insertMoreByList(emps));
    }

    @Test
    public void testDeleteMoreByArray() {
        // 获取一个SqlSession对象
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        // 通过SqlSession对象获取DynamicSQLMapper接口中的实例
        DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);
        // 调用了DynamicSQLMapper接口中的deleteMoreByArray方法，传入了一个整型数组作为参数，数组中包含了要删除的记录的主键值
        int result = mapper.deleteMoreByArray(new Integer[]{6, 7, 8});
        // 输出删除的记录数
        System.out.println(result);
    }

    @Test
    public void testGetEmpByChoose() {
        // 获取一个SqlSession对象
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        // 通过SqlSession对象获取DynamicSQLMapper接口的实例
        DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);
        // 调用了DynamicSQLMapper对象的getEmpByChoose方法，并传入了一个Emp对象作为参数。这个Emp对象的属性值都为null或空字符串，这意味着getEmpByChoose方法将返回所有符合条件的Emp对象
        List<Emp> list = mapper.getEmpByChoose(new Emp(null, "", null, "", null, null));
        // 输出返回的Emp对象列表
        System.out.println(list);
    }

    @Test
    public void testGetEmpByCondition() {
        // 获取一个SqlSession对象
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        // 通过SqlSession对象获取DynamicSQLMapper接口的实例
        DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);
        // 调用该实例的getEmpByCondition方法，传入一个Emp对象作为参数，该对象的属性值为null或空字符串，表示查询条件不限制
        List<Emp> list = mapper.getEmpByCondition(new Emp(null, "", null, "", null, null));
        // 将查询结果打印输出
        System.out.println(list);
    }

}

