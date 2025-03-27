package com.iim.service.persistency.api.service.mapper;

import com.iim.service.persistency.api.dto.UserDTO;
import com.iim.service.persistency.api.entity.User;
import com.iim.service.persistency.api.mapper.EntityMapper;
import com.iim.service.persistency.util.TestDataFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

public class EntityMapperTest {

    private final static EntityMapper mapper = Mappers.getMapper(EntityMapper.class);

    @Test
    public void mapToUserDtoToUser_WhenUserDtoIsComplete_ShouldMapJustGivenValues() {
        UserDTO userDto = TestDataFactory.buildUserDto();
        User user = mapper.mapUserDtoToUser(userDto);

        Assertions.assertNotNull(user);
        Assertions.assertNull(user.getId());
        Assertions.assertEquals(userDto.getFirstName(), user.getFirstName());
        Assertions.assertEquals(userDto.getSecondName(), user.getSecondName());
        Assertions.assertEquals(userDto.getFirstLastName(), user.getFirstLastName());
        Assertions.assertEquals(userDto.getSecondLastName(), user.getSecondLastName());
        Assertions.assertEquals(userDto.getRole(), user.getRole());
    }
}
