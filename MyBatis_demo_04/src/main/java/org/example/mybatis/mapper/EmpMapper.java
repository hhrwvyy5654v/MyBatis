package org.example.mybatis.mapper;

import org.apache.ibatis.annotations.Param;
import org.example.mybatis.pojo.Emp;

import java.util.List;

/**
 * @Project: MyBatis
 * @Package: org.example.mybatis.mapper
 * @ClassName: EmpMapper
 * @Datetime: 2023/05/11 20:22
 * @Author: HuangRongQuan
 * @Email: rongquanhuang01@gmail.com
 * @Description:
 */

public interface EmpMapper {
    /**
     * 查询所有的员工信息
     */
    List<Emp>getAllEmp();

    /**
     * 查询员工以及员工所对应的部门信息
     */
    Emp getEmpAndDept(@Param("eid")Integer eid);

    /**
     * 通过分布查查询员工以及员工所对应的部门信息
     * 分布查询第一步：查询员工信息
     */
    Emp getEmpAndDeptByStepOne(@Param("eid") Integer eid);

    /**
     * 通过分布查询查询部门以及部门中以及员工信息
     * 分布查询第二步：根据did查询员工信息
     */
    List<Emp> getDeptAndByStepTwo(@Param("did") Integer did);
}
