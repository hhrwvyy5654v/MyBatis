package org.example.mybatis.mapper;

import org.apache.ibatis.annotations.Param;
import org.example.mybatis.pojo.Emp;

/**
 * @Project: MyBatis
 * @Package: org.example.mybatis.mapper
 * @ClassName: CacheMapper
 * @Datetime: 2023 05 11 20:21
 * @Author: HuangRongQuan
 * @Email: rongquanhuang01@gmail.com
 * @Description:
 */

public interface CacheMapper {
    Emp getEmpByEid(@Param("eid") Integer eid);
    void insertEmp(Emp emp);
}
