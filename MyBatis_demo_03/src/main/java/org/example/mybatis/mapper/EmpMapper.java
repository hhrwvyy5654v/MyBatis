package org.example.mybatis.mapper;

import org.apache.ibatis.annotations.Param;
import org.example.mybatis.pojo.Emp;

import java.util.List;

/**
 * @Project: MyBatis
 * @Editor: IntelliJ IDEA
 * @Author: HuangRongQuan
 * @Date: 2023/04/18
 * @Time: 16:58
 * @Email: rongquanhuang01@gmail.com
 * @Description:
 */
public interface EmpMapper {
    //查询所有的员工信息
    List<Emp> getAllEmp();
    //查询员工以及员工所对应的部门信息
    Emp getEmpAndDept(@Param("eid")Integer eid);
    //通过分步查询查询员工以及员工所对应的部门信息
    //分步查询第一步:查询员工信息
    Emp getEmpAndDeptByStepOne(@Param("eid")Integer eid);
    //通过分步查询查询部门以及部门中所有的员工信息
    //分步查询第二步:根据didi查询员工信息
    List<Emp> getDeptAndEmpByStepTwo(@Param("did")Integer did);
}
