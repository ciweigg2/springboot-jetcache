package com.example.springbootjetcache.service;

import com.alicp.jetcache.anno.CacheInvalidate;
import com.alicp.jetcache.anno.CacheUpdate;
import com.alicp.jetcache.anno.Cached;
import com.example.springbootjetcache.model.User;

/**
 * @author 马秀成
 * @date 2019/4/10
 * @jdk.version 1.8
 * @desc
 */
public interface JetCacheService {

    User createCache(Long id);

    User cached(Long id);

    @Cached(name="userCache-", key="#userId", expire = 3600)
    User getUserById(long userId);

    @CacheUpdate(name="userCache-", key="#user.userId", value="#user")
    void updateUser(User user);

    @CacheInvalidate(name="userCache-", key="#userId")
    void deleteUser(long userId);

}
