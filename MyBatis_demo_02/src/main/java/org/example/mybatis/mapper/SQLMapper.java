package org.example.mybatis.mapper;

import org.apache.ibatis.annotations.Param;
import org.example.mybatis.pojo.User;

import java.util.List;

/**
 * @Project: MyBatis
 * @Editor: IntelliJ IDEA
 * @Author: HuangRongQuan
 * @Date: 2023/04/17
 * @Time: 15:53
 * @Email: rongquanhuang01@gmail.com
 * @Description:
 */
public interface SQLMapper {
    //根据用户名模糊查询用户信息
    List<User> getUserByLike(@Param("username") String username);
    //批量删除
    int deleteMore(@Param("ids")String ids);
    //查询指定表中的数据
    List<User> getUserByTableName(@Param("tableName") String tableName);
    //添加用户信息
    void insertUser(User user);
}
