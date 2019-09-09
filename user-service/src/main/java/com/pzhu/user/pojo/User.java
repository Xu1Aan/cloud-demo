package com.pzhu.user.pojo;

import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Data
@Table(name="user")
public class User {

    @Id
    @KeySql(useGeneratedKeys = true)
    private  String id;

    private  String username;

    private  String password;

    private  String name;

    //瞬时的，不会作为sql语句的字段
    @Transient
    private  String note;

}
