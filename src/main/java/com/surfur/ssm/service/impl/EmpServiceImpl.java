package com.surfur.ssm.service.impl;

import com.surfur.ssm.domain.EmpEntity;
import com.surfur.ssm.mapper.EmpMapper;
import com.surfur.ssm.service.EmpService;
import org.springframework.stereotype.Service;

/**
 * @author Dev Surfer
 * @version 1.0.0
 * date 2024/12/26 23:18
 * description TODO
 */
@Service
public class EmpServiceImpl implements EmpService {

    private final EmpMapper empMapper;

    public EmpServiceImpl(EmpMapper empMapper) {
        this.empMapper = empMapper;
    }

    @Override
    public EmpEntity findEmpById(Integer id) {
        return empMapper.findEmpById(id);
    }
}
