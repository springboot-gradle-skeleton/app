package com.skeleton.infrastructure.persistent.dao.mapper;

import com.skeleton.infrastructure.persistent.dataobject.UserDto;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class UserMapperTest extends BaseMapperRepositoryTest {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void testSaveAndFindUser() {
        // 创建一个用户
        UserDto user = new UserDto();
        user.setUsername("john_doe");
        user.setEmail("john@example.com");

        // 保存用户
        userMapper.insert(user);

        List<UserDto> list = Lists.newArrayList(userMapper.selectList(null));
        assertThat(list).hasSize(1);

       // list = userMapper.findAll("john_doe");
       // assertThat(list).hasSize(1);

    }
}
