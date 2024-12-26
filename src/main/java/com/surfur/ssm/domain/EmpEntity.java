package com.surfur.ssm.domain;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

/**
 * @TableName emp
 */
@Data
public class EmpEntity implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private Integer empId;

    private String empName;

    private Double empSalary;

}
