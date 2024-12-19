package com.example.onlineeducationplatform.mapper;

import com.example.onlineeducationplatform.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
    @Select("select * from users where username = #{username}")
    User getUserByName(String username);
}
