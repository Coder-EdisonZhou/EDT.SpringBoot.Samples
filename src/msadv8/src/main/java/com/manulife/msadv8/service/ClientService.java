package com.manulife.msadv8.service;

import com.manulife.msadv8.domain.User;
import javax.transaction.Transactional;

/*
 * 通常单元测试为了保证每个测试之间的数据独立，会使用@Rollback注解让每个单元测试都能在结束时回滚。
 * 而真正在开发业务逻辑时，通常在service层接口中使用@Transactional来对各个业务逻辑进行事务管理的配置
 */
public interface ClientService {
    @Transactional
    User login(String name, String password);

    // 指定不同的事务管理器
//    @Transactional(value = "transactionManagerPrimary")
//    User findUserByName(String name);
}
