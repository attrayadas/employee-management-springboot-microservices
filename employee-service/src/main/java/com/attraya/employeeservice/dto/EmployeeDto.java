package com.attraya.employeeservice.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Schema(
        description = "EmployeeDto Model Information"
)
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDto {
    private Long id;
    @Schema(
            description = "Employee's First Name"
    )
    private String firstName;
    @Schema(
            description = "Employee's Last Name"
    )
    private String lastName;
    @Schema(
            description = "Employee's Email"
    )
    private String email;
    @Schema(
            description = "Employee's Department Code"
    )
    private String departmentCode;
    @Schema(
            description = "Employee's Organization Code"
    )
    private String organizationCode;
}
