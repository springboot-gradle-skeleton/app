package com.skeleton.domain.repository;

import com.skeleton.domain.aggregate.User;

import java.util.List;

public interface UserDomainRepository {
    List<User> saveAll(List<User> users);

    List<User> findByPage();
}
