package com.skeleton.infrastructure.persistent.dao.jdbc;

import com.skeleton.infrastructure.persistent.dataobject.UserDto;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface UserJDBCRepository extends PagingAndSortingRepository<UserDto, String> {
    @Query("SELECT * FROM users ORDER BY user_name")
    List<UserDto> findByPage();
}
