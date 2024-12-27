package com.surfur.ssm.vo.req;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmpUpdateReq implements Serializable {

    @NotNull
    @Min(1)
    private Integer empId;

    @NotBlank
    @Max(128)
    private String empName;

    @Min(0)
    private Double empSalary;

}
