package com.surfur.ssm.vo.req;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmpQueryReq implements Serializable {

    private String keyWord;

    private Double minEmpSalary;

    private Double maxEmpSalary;

}
