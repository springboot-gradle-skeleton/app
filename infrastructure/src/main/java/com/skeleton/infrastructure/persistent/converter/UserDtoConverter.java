package com.skeleton.infrastructure.persistent.converter;

import com.skeleton.domain.aggregate.User;
import com.skeleton.infrastructure.persistent.dataobject.UserDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserDtoConverter {
    UserDtoConverter INSTANCE = Mappers.getMapper(UserDtoConverter.class);

    UserDto toDto(User user);

    List<UserDto> toDtoList(List<User> users);

    User toDomain(UserDto userDto);

    List<User> toDomainList(Iterable<UserDto> userDtos);
}
