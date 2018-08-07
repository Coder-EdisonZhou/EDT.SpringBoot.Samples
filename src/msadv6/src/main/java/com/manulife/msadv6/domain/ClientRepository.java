package com.manulife.msadv6.domain;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface ClientRepository extends MongoRepository<Client, Long> {
    Client findByUserName(String userName);
}
