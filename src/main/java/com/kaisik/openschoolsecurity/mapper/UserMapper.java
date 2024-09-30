package com.kaisik.openschoolsecurity.mapper;

import com.kaisik.openschoolsecurity.dto.UserDto;
import com.kaisik.openschoolsecurity.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

/**
 * Маппер пользователя
 */
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {
    UserDto toDto(User user);
    User toEntity(UserDto userDto);
}