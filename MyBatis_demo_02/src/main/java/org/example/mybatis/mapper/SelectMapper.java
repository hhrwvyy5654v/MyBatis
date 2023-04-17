package org.example.mybatis.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.MapKey;
import org.example.mybatis.pojo.User;

import java.util.List;
import java.util.Map;

/**
 * @Project: MyBatis
 * @Editor: IntelliJ IDEA
 * @Author: HuangRongQuan
 * @Date: 2023/04/17
 * @Time: 15:53
 * @Email: rongquanhuang01@gmail.com
 * @Description:
 */
public interface SelectMapper {
    //根据id查询用户信息
    List<User> getUserById(@Param("id") Integer id);

    //查询所有用户信息
    List<User> getAllUser();

    //查询用户信息的总记录数
    Integer getCount();

    //根据id查询用户信息为一个map集合
    Map<String,Object> getUserByIdToMap(@Param("id") Integer id);

    //查询所有用户信息为map集合
    //List<Map<String,Object>> getAllUserToMap();
    @MapKey("id")
    Map<String,Object> getAllUserToMap();

}
