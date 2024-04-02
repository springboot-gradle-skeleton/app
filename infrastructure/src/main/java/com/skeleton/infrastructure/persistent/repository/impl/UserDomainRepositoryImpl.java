package com.skeleton.infrastructure.persistent.repository.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.pagehelper.PageHelper;
import com.skeleton.domain.aggregate.User;
import com.skeleton.domain.repository.UserDomainRepository;
import com.skeleton.infrastructure.persistent.converter.UserDtoConverter;
import com.skeleton.infrastructure.persistent.dao.jdbc.UserJDBCRepository;
import com.skeleton.infrastructure.persistent.dao.mapper.UserMapper;
import com.skeleton.infrastructure.persistent.dataobject.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class UserDomainRepositoryImpl implements UserDomainRepository {
    private final UserJDBCRepository userJDBCRepository;
    private final UserMapper userMapper;
    @Override
    public List<User> saveAll(List<User> users) {

        List<UserDto> userDtos = UserDtoConverter.INSTANCE.toDtoList(users);

        return UserDtoConverter.INSTANCE.toDomainList(userJDBCRepository.saveAll(userDtos));
    }

    @Override
    public List<User> findByPage() {
        Page<UserDto> page = Page.of(1, 10);

       // var list = userMapper.findAll(page, "un");
       // var list = userMapper.findAllBySelectProvider(page, "un");
        PageHelper.startPage(1, 10)
                .doSelectPage(() -> userMapper.findAllByPageHelper("un"));
        return null;
    }

}
