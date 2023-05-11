package org.example.mybatis.mapper;

import org.apache.ibatis.annotations.Param; //MyBatis框架中的注解,用于给Mapper接口中的参数命名
import org.example.mybatis.pojo.Emp; //自定义Java类,表示员工对象

/**
 * @Project: MyBatis
 * @Editor: IntelliJ IDEA
 * @Author: HuangRongQuan
 * @Date: 2023/04/18
 * @Time: 16:56
 * @Email: rongquanhuang01@gmail.com
 * @Description:
 */
public interface CacheMapper {
    // 接受一个名为eid的Integer类型参数并返回一个Emp对象
    Emp getEmpByEid(@Param("eid") Integer eid);
    // 接受一个Emp对象作为参数
    void insertEmp(Emp emp);
}
