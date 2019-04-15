package com.example.springbootjetcache.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @author 马秀成
 * @date 2019/4/10
 * @jdk.version 1.8
 * @desc
 */
@Data
public class User implements Serializable {

    private Long userId;

    private String userName;

}
