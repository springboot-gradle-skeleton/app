package com.skeleton.infrastructure.persistent.dao.jdbc;

import com.skeleton.infrastructure.persistent.dataobject.UserDto;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;


class UserJDBCRepositoryTest extends BaseJDBCRepositoryTest {
    @Autowired
    private UserJDBCRepository userJDBCRepository;

    @Test
    public void testSaveAndFindUser() {
        // 创建一个用户
        UserDto user = new UserDto();
        user.setUsername("john_doe");
        user.setEmail("john@example.com");

        // 保存用户
        userJDBCRepository.save(user);

        var list = Lists.newArrayList(userJDBCRepository.findAll());
        assertThat(list).hasSize(1);

    }
}