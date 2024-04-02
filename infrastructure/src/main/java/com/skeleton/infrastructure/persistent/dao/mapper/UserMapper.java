package com.skeleton.infrastructure.persistent.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.skeleton.infrastructure.persistent.dataobject.UserDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.jdbc.SQL;
import org.springframework.util.StringUtils;

import java.util.List;

@Mapper
public interface UserMapper extends BaseMapper<UserDto> {
    @Select("SELECT * FROM users WHERE user_name = #{userName}")
    List<UserDto> findAll(IPage<UserDto> page, @Param("userName")String userName);

    List<UserDto> findAllByMapper(IPage<UserDto> page, @Param("userName") String userName);

    @SelectProvider(type = UserMapperSelectProvider.class, method = "findAll")
    List<UserDto> findAllBySelectProvider(IPage<UserDto> page, @Param("userName") String userName);

    @Select("SELECT * FROM users WHERE user_name = #{userName}")
    List<UserDto> findAllByPageHelper(@Param("userName") String userName);

    class UserMapperSelectProvider {
        public static String findAll(IPage<UserDto> page, @Param("userName") String userName) {
            SQL sql = new SQL();
            sql.SELECT("*");
            sql.FROM("users a");
            if (StringUtils.hasText(userName)) {
                sql.WHERE("a.user_name = #{userName}");
            }
            return "<script>" + sql + "</script>";
        }
    }
}
