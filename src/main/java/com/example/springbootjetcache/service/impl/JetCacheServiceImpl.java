package com.example.springbootjetcache.service.impl;

import com.alicp.jetcache.Cache;
import com.alicp.jetcache.anno.CacheType;
import com.alicp.jetcache.anno.Cached;
import com.alicp.jetcache.anno.CreateCache;
import com.example.springbootjetcache.model.User;
import com.example.springbootjetcache.service.JetCacheService;
import org.springframework.stereotype.Service;

/**
 * @author 马秀成
 * @date 2019/4/10
 * @jdk.version 1.8
 * @desc
 */
@Service
public class JetCacheServiceImpl implements JetCacheService {

    @CreateCache(name = "userCache-", expire = 100)
    private Cache<Long, User> userCache;

    @Override
    public User createCache(Long id) {
        User user = new User();
        user.setUserId(id);
        user.setUserName("ciwei");
        // 新增缓存
        userCache.put(id, user);
        // 删除缓存
//        userCache.remove(1L);
        return user;
    }

    @Cached(name = "getUser.", key = "#id", expire = 60, cacheType = CacheType.REMOTE)
    @Override
    public User cached(Long id) {
        User user = new User();
        user.setUserId(id);
        user.setUserName("ciwei");
        return user;
    }

    @Override
    public User getUserById(long userId) {
        return null;
    }

    @Override
    public void updateUser(User user) {

    }

    @Override
    public void deleteUser(long userId) {

    }

}
