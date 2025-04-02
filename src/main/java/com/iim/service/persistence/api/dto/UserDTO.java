package com.iim.service.persistence.api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import static com.iim.service.persistence.api.constant.ValidationMessages.*;

@Data
public class UserDTO {

    @NotBlank(message = NO_FIRST_NAME_MESSAGE)
    private String firstName;

    private String secondName;

    @NotBlank(message = NO_FIRST_LAST_NAME_MESSAGE)
    private String firstLastName;

    @NotBlank(message = NO_SECOND_LAST_NAME_MESSAGE)
    private String secondLastName;

    private String role;
}
