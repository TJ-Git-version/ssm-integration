package com.surfur.ssm.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.surfur.ssm.common.PageBean;
import com.surfur.ssm.domain.EmpEntity;
import com.surfur.ssm.mapper.EmpMapper;
import com.surfur.ssm.service.EmpService;
import com.surfur.ssm.vo.req.EmpInsertReq;
import com.surfur.ssm.vo.req.EmpQueryReq;
import com.surfur.ssm.vo.req.EmpUpdateReq;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

    @Override
    public PageBean<EmpEntity> findListPage(Integer currentPage, Integer pageSize, EmpQueryReq empQueryReq) {
        Page<EmpEntity> page = PageHelper.startPage(currentPage, pageSize);
        List<EmpEntity> empList = empMapper.findEmpList(empQueryReq);
        return PageBean.build(currentPage, pageSize, page.getTotal(), empList);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void insertEmp(EmpInsertReq empInsertReq) {
        empMapper.insertEmp(empInsertReq);
        int i = 10 / 0;
        empInsertReq.setEmpName("emp2");
        empInsertReq.setEmpSalary(100.0);
        empMapper.insertEmp(empInsertReq);
    }

    @Override
    public void updateEmp(EmpUpdateReq empUpdateReq) {
        empMapper.updateEmp(empUpdateReq);
    }

    @Override
    public void deleteEmp(Integer empId) {
        empMapper.deleteEmp(empId);
    }

}
