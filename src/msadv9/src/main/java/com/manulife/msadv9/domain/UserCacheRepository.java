package com.manulife.msadv9.domain;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;

/*
 * 使用了Cache注解的Repository
 * CacheConfig注解 : 主要用于配置该类中会用到的一些共用的缓存配置
 * Cacheable注解：配置了findByName函数的返回值将被加入缓存
 *               在查询时，会先从缓存中获取，若不存在才再发起对数据库的访问
 */
@CacheConfig(cacheNames = "users")
public interface UserCacheRepository extends JpaRepository<User, Long> {
    @Cacheable
    //下面的参数表示：
    // 只有当第一个参数的长度小于3时，才会被缓存 => 这样“AAA”就不会被缓存
    //@Cacheable(key = "#p0", condition = "#p0.length() < 3")
    User findByName(String name);
}
