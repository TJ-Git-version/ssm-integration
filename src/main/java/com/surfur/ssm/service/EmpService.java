package com.surfur.ssm.service;

import com.surfur.ssm.common.PageBean;
import com.surfur.ssm.domain.EmpEntity;
import com.surfur.ssm.vo.req.EmpInsertReq;
import com.surfur.ssm.vo.req.EmpQueryReq;
import com.surfur.ssm.vo.req.EmpUpdateReq;

/**
 * @author Dev Surfer
 * @version 1.0.0
 * date 2024/12/26 23:17
 * description TODO
 */
public interface EmpService {
    EmpEntity findEmpById(Integer id);

    PageBean<EmpEntity> findListPage(Integer currentPage, Integer pageSize, EmpQueryReq empQueryReq);

    void insertEmp(EmpInsertReq empInsertReq);

    void updateEmp(EmpUpdateReq empUpdateReq);

    void deleteEmp(Integer empId);
}
