package org.example.mybatis.mapper;

import org.apache.ibatis.annotations.Param; //MyBatis框架中的注解,用于给Mapper接口中的参数命名
import org.example.mybatis.pojo.Dept;

/**
 * @Project: MyBatis
 * @Editor: IntelliJ IDEA
 * @Author: HuangRongQuan
 * @Date: 2023/04/18
 * @Time: 16:58
 * @Email: rongquanhuang01@gmail.com
 * @Description:
 */
public interface DeptMapper {
    /*
    * 通过分步查询查询员工以及员工所对应的部门信息
    * 分布查询第二步：通过did查询员工对应的部门
    */
    Dept getEmpAndDeptBySteptTwo(@Param("did") Integer did);

    /*
    * 获取部门以及部门中所有员工信息
    */
    Dept getDeptAndEmp(@Param("did") Integer did);

    /*
    *通过分布查询查询部门以及部门中所有的员工信息
    * 分布查询第一步：查询部门信息
    */
    Dept getDeptAndEmptByStepOne(@Param("did") Integer did);

    Dept getDeptAndEmpByStepOne(int i);
}
