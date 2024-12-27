package com.surfur.ssm.vo.req;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmpInsertReq implements Serializable {

    private String empName;

    private Double empSalary;

}
