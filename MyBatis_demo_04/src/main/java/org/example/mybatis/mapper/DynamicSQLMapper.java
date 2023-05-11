package org.example.mybatis.mapper;

import org.apache.ibatis.annotations.Param;
import org.example.mybatis.pojo.Emp;

import java.util.List;

/**
 * @Project: MyBatis
 * @Package: org.example.mybatis.mapper
 * @ClassName: DynamicSQLMapper
 * @Datetime: 2023/05/11 20:22
 * @Author: HuangRongQuan
 * @Email: rongquanhuang01@gmail.com
 * @Description:
 */

public interface DynamicSQLMapper {
    /**
     * 多条件查询
     */
    List<Emp> getEmpByCondition(Emp emp);

    /**
     * 测试choose、when、otherwise
     */
    List<Emp> getEmpByChoose(Emp emp);

    /**
     * 通过数组实现批量删除
     */
    int deleteMoreByArray(@Param("eids")Integer[] eids);

    /**
     * 通过list集合实现批量添加
     */
    int insertMoreByList(@Param("emps") List<Emp> emps);

}
