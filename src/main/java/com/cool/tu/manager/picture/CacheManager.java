package com.cool.tu.manager.picture;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class CacheManager {
    /**
     * 本地缓存
     */
    private
    final Cache<String, String> LOCAL_CACHE =
            Caffeine.newBuilder().initialCapacity(1024)
                    .maximumSize(10000L)
                    // 缓存 5 分钟移除
                    .expireAfterWrite(5L, TimeUnit.MINUTES)
                    .build();

    public String getLocalCache(String key) {
        return LOCAL_CACHE.getIfPresent(key);
    }

    public void setLocalCache(String key, String value) {
        LOCAL_CACHE.put(key, value);
    }

    public void removeLocalCache(String key) {
        LOCAL_CACHE.invalidate(key);
    }

}