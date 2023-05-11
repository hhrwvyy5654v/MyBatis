package org.example.mybatis.test;

import org.apache.ibatis.session.SqlSession;
import org.example.mybatis.mapper.DeptMapper;
import org.example.mybatis.mapper.EmpMapper;
import org.example.mybatis.pojo.Emp;
import org.example.mybatis.pojo.Dept;
import org.example.mybatis.utils.SqlSessionUtils;
import org.junit.Test;

import java.util.List;

/**
 * @Project: MyBatis
 * @Editor: IntelliJ IDEA
 * @Author: HuangRongQuan
 * @Date: 2023/04/18
 * @Time: 17:03
 * @Email: rongquanhuang01@gmail.com
 * @Description: MyBatis的测试类，主要用于测试MyBatis的Mapper接口
 */
public class ResultMapTest {
    @Test
    // 测试通过MyBatis的ResultMap实现一对一和一对多关联查询的功能
    public void testGetEmpAndDeptByStep(){
        // 获取一个SqlSession对象
        SqlSession sqlSession= SqlSessionUtils.getSqlSession();
        // 通过SqlSession对象获取EmpMapper接口的实例
        EmpMapper mapper=sqlSession.getMapper(EmpMapper.class);
        // 调用该实现类的getEmpAndDeptByStepOne方法，传入参数3，获取一个Emp对象
        Emp emp=mapper.getEmpAndDeptByStepOne(3);
        // 打印出该Emp对象的姓名和所在部门
        System.out.println(emp.getEmpName());
        System.out.println("+++++++++++++++++++++++++++++++++");
        System.out.println(emp.getDept());
    }

    @Test
    // 查询id为3的员工信息以及其所在部门的信息
    public void testGetEmpAndDept(){
        // 获取一个SqlSession对象
        SqlSession sqlSession=SqlSessionUtils.getSqlSession();
        // 通过SqlSession对象获取EmpMapper接口的实例
        EmpMapper mapper=sqlSession.getMapper(EmpMapper.class);
        // 调用该实现类的getEmpAndDept方法，传入参数3，获取一个Emp对象
        Emp emp=mapper.getEmpAndDept(3);
        // 将该对象打印输出
        System.out.println(emp);
    }

    @Test
    public void testGetAllEmp(){
        // 获取一个SqlSession对象
        SqlSession sqlSession=SqlSessionUtils.getSqlSession();
        // 通过SqlSession对象获取EmpMapper接口的实例
        EmpMapper mapper=sqlSession.getMapper(EmpMapper.class);
        // 调用该实现类的getAllEmp方法获取所有员工的信息
        List<Emp> list=mapper.getAllEmp();
        // 使用Lambda表达式遍历输出每个员工的信息
        list.forEach(emp->System.out.println(emp));
    }

    @Test
    // 查询id为1的部门信息以及该部门下的所有员工信息
    public void testGetDeptAndEmp(){
        // 获取一个SqlSession对象
        SqlSession sqlSession=SqlSessionUtils.getSqlSession();
        // 通过SqlSession对象获取EmpMapper接口的实例
        DeptMapper mapper=sqlSession.getMapper(DeptMapper.class);
        // 调用该实例的getDeptAndEmp方法，传入参数1，获取一个Dept对象
        Dept dept=mapper.getDeptAndEmp(1);
        // 将该对象打印输出
        System.out.println(dept);
    }

    @Test
    // 查询id为1的部门信息以及该部门下的员工信息
    public void testGetDeptAndEmpByStep(){
        // 获取一个SqlSession对象
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        // 通过SqlSession对象获取EmpMapper接口的实例
        DeptMapper mapper = sqlSession.getMapper(DeptMapper.class);
        // 调用了该实现类的getDeptAndEmpByStepOne方法,传入了一个参数1,该方法返回了一个Dept对象
        Dept dept = mapper.getDeptAndEmpByStepOne(1);
        // 打印输出该Dept对象的deptName属性
        System.out.println(dept.getDeptName());
    }

}
