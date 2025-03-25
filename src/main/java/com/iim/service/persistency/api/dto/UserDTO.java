package com.iim.service.persistency.api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import static com.iim.service.persistency.api.constant.ValidationMessages.*;

@Data
public class UserDTO {

    @NotNull
    @NotBlank(message = NO_FIRST_NAME_MESSAGE)
    private String firstName;

    private String secondName;

    @NotNull
    @NotBlank(message = NO_FIRST_LAST_NAME_MESSAGE)
    private String firstLastName;

    @NotNull
    @NotBlank(message = NO_SECOND_LAST_NAME_MESSAGE)
    private String secondLastName;

    private String role;
}
