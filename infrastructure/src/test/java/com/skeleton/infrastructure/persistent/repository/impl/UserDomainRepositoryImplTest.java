package com.skeleton.infrastructure.persistent.repository.impl;

import com.skeleton.domain.aggregate.User;
import com.skeleton.infrastructure.persistent.dao.jdbc.UserJDBCRepository;
import com.skeleton.infrastructure.persistent.dao.mapper.UserMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@Import(UserDomainRepositoryImpl.class)
class UserDomainRepositoryImplTest extends BaseRepositoryTest {

    @Autowired
    private UserJDBCRepository userJDBCRepository;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserDomainRepositoryImpl userDomainRepository;

    @BeforeEach
    void setUp() {
        // BeforeEach中删除数据与@Sql会冲突，建议只采用一种方式
//        userJDBCRepository.deleteAll();
//        userMapper.delete(null);
    }

    @Test
    @Sql(statements = "TRUNCATE users")
    void saveAll_should_success() {
        User user = User.builder()
                .username("un")
                .email("e")
                .build();
        user = userDomainRepository.saveAll(List.of(user)).get(0);
        assertThat(user.getId()).isNotNull();
    }

    @Test
    @Sql(statements =  {
            "INSERT INTO users (id, user_name, email) values (1,'un', 'test')"
    })
    void  findByPage_should_success() {

//        var list1 = userMapper.findAll("un");
//        var list2 = userJDBCRepository.findAll();
        var list = userDomainRepository.findByPage();
    }
}