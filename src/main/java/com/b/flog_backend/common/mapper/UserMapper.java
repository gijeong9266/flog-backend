package com.b.flog_backend.common.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.b.flog_backend.common.model.User;

import java.util.List;

@Mapper
public interface UserMapper {
    void insertUser(User user);
    User findByAccountName(@Param("accountName") String accountName);
    User findById(@Param("id") Integer id);
    List<User> findAll();
}
